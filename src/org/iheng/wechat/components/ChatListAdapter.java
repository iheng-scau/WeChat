package org.iheng.wechat.components;

import java.util.ArrayList;
import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatListAdapter extends BaseAdapter {
	
	private ArrayList<String> recent_chat_list;
	private Context context;

	public ChatListAdapter(ArrayList<String> recent_chat_list,Context context){
		this.recent_chat_list=recent_chat_list;
		this.context=context;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return this.getRecent_chat_list()==null?0:recent_chat_list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if(recent_chat_list!=null)
			return recent_chat_list.get(position);
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=LayoutInflater.from(context);
		View view=inflater.inflate(org.iheng.wechat.R.layout.chat_list_item, null);
		
		ImageView portrait_view=(ImageView)view.findViewById(org.iheng.wechat.R.id.portrait_view);
		TextView name_tv=(TextView)view.findViewById(org.iheng.wechat.R.id.name);
		name_tv.setText(recent_chat_list.get(position));
		return view;
	}

	//getters and setters
	public ArrayList getRecent_chat_list() {
		return recent_chat_list;
	}

	public void setRecent_chat_list(ArrayList recent_chat_list) {
		this.recent_chat_list = recent_chat_list;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
}
