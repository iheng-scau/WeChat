package org.iheng.wechat.fragments;


import java.util.ArrayList;

import org.iheng.wechat.R;
import org.iheng.wechat.activities.ChatActivity;
import org.iheng.wechat.components.ChatListAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ChatFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_chat, null);
		ListView chat_list=(ListView)view.findViewById(R.id.chat_list);
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<50;i++){list.add(""+i);}
		ChatListAdapter adapter=new ChatListAdapter(list,getActivity());
		chat_list.setAdapter(adapter);
		chat_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(getActivity(), ChatActivity.class);
				startActivity(intent);
			}	
		});
		return view;
	}
}
