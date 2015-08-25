package org.iheng.wechat.activities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.iheng.wechat.R;
import org.iheng.wechat.entities.WeChatMessage;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ChatActivity extends Activity {

	private Button btn_send;
	private EditText et_msg;
	private ListView list_conversation;
	private ConversationListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_chat);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeAsUpIndicator(R.drawable.arrow_r_icon);
		getActionBar().setDisplayShowHomeEnabled(false);
		
		super.onCreate(savedInstanceState);
		
		btn_send=(Button)findViewById(R.id.btn_send);
		et_msg=(EditText)findViewById(R.id.txt_send);
		list_conversation=(ListView)findViewById(R.id.list_conversation);
		list_conversation.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		
		adapter=new ConversationListAdapter();
		list_conversation.setAdapter(adapter);
		init();
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.chat_activity_menu, menu);
		return true;
	}

	
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId()==android.R.id.home){
			finish();
			return true;
		}
		return true;
	}



	private void init(){
		btn_send.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String msg_txt=et_msg.getText().toString();
				
				if(msg_txt.trim().equals("")){
					Toast.makeText(getApplicationContext(), "发送内容不能为空", Toast.LENGTH_SHORT).show();
					return;
				}
				
				et_msg.setText("");
				Date date=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日  HH:mm");
				String str_timestamp=format.format(date);
				
				WeChatMessage message=new WeChatMessage(str_timestamp,"iheng",msg_txt);
				adapter.msg_list.add(message);
				adapter.notifyDataSetChanged();
			}
		});
	}
	
	
	class ConversationListAdapter extends BaseAdapter{
		
		ArrayList<WeChatMessage> msg_list=new ArrayList<WeChatMessage>();
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return msg_list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return msg_list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			convertView=LayoutInflater.from(getApplication()).inflate(R.layout.chat_msg_item_r, null);
			
			TextView tv_timestamp=(TextView)convertView.findViewById(R.id.tv_msg_timestamp);
			TextView tv_usr_name=(TextView)convertView.findViewById(R.id.tv_usr_name);
			TextView tv_msg_content=(TextView)convertView.findViewById(R.id.tv_msg_content);
			
			WeChatMessage msg=(WeChatMessage)getItem(position);
			tv_timestamp.setText(msg.getTimestamp());
			tv_usr_name.setText(msg.getUsr_name());
			tv_msg_content.setText(msg.getMsg_content());
			
			return convertView;
		}
		
	}
}
