package org.iheng.wechat.entities;

import java.io.Serializable;

/**
 * 
 * @author iheng
 *
 */

/**
 * 消息类 
 * 定义了客户端与服务器的消息实体
 * @author iheng
 *
 */
public class WeChatMessage implements Serializable{
	/*时间戳*/
	private String timestamp;
	/*发送方*/
	private String fromUser;
	/*接收方*/
	private String toUser;
	/*消息内容*/
	private String msgContent;
	/*消息类型*/
	private int msgType;
	
	public WeChatMessage(){
		//empty constructor
	}
	
	public WeChatMessage(String timestamp,String fromUser,String msgContent){
		this.timestamp=timestamp;
		this.fromUser=fromUser;
		this.msgContent=msgContent;
	}
	public WeChatMessage(String timestamp,String fromUser,String toUser,String msgContent,int msgType){
		this.timestamp=timestamp;
		this.fromUser=fromUser;
		this.toUser=toUser;
		this.msgContent=msgContent;
		this.msgType=msgType;
	}
	
	/*getters and setters*/
	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getFormUser() {
		return fromUser;
	}

	public void setFormUser(String formUser) {
		this.fromUser = formUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
}
