package org.iheng.wechat.nio.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.iheng.wechat.entities.WeChatMessage;
import org.iheng.wechat.utils.Serializer;

import android.util.Log;

/**
 * 消息服务线程类
 * 本线程在MainActivity启动时进行启动，进行消息的收发
 * @author iheng
 *
 */
public class MsgServiceClientDaemon implements Runnable{
	private static ByteBuffer sBuffer=ByteBuffer.allocate(1024);
	private static ByteBuffer rBuffer=ByteBuffer.allocate(1024);
	
	private InetSocketAddress server;
	private static Selector selector;
	private static SocketChannel client;
	private static String rContent;
	private static String sContent;
	private static int count=0;
	
	public static BlockingQueue<WeChatMessage> sQueue=new ArrayBlockingQueue<WeChatMessage>(50);
	public static BlockingQueue<WeChatMessage> rQueue=new ArrayBlockingQueue<WeChatMessage>(100);
	
	private static String TAG="Client";
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				selector.select();
				Set<SelectionKey> keySet=selector.selectedKeys();
				for(SelectionKey key:keySet){
					handleKey(key);
				}
				keySet.clear();
			}catch(Exception e){
				e.printStackTrace();
				Log.e(TAG, e.toString());
			}
		}
	}
	
	public MsgServiceClientDaemon(int port){
		server=new InetSocketAddress("192.168.50.2",port);
		init();
	}
	
	private void init(){
		try{
			SocketChannel socketChannel=SocketChannel.open();
			socketChannel.configureBlocking(false);
			selector=Selector.open();
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			socketChannel.connect(server);
		}catch(Exception e){
			e.printStackTrace();
			Log.e(TAG, e.toString());
		}
	}
	
	private void handleKey(SelectionKey key) throws IOException{
		if(key.isConnectable()){
			client=(SocketChannel)key.channel();
			if(client.isConnectionPending()){
				if(client.finishConnect()){
					Log.d(TAG, "connect finish");
					sBuffer.clear();
					WeChatMessage msg=new WeChatMessage();
					msg.setMsgContent(new Date().toString()+" connected");
					byte[] bytes=Serializer.serialize(msg);
					sBuffer.put(bytes);
					sBuffer.flip();
					client.write(sBuffer);
					new Thread(){
						@Override
						public void run(){
							while(true){
								try{
									sBuffer.clear();
									WeChatMessage msg=sQueue.take();
									byte[] bytes=Serializer.serialize(msg);
									sBuffer.put(bytes);
									sBuffer.flip();
									client.write(sBuffer);
								}catch(Exception e){
									e.printStackTrace();
								}
							}
						}
					}.run();
				}
			}else if(key.isReadable()){
				client=(SocketChannel)key.channel();
				rBuffer.clear();
				count=client.read(rBuffer);
				if(count>0){
					rContent=new String(rBuffer.array(),0,count);
					Log.d(TAG, rContent);
					client.register(selector, SelectionKey.OP_READ);
				}
			}
		}
	}
}
