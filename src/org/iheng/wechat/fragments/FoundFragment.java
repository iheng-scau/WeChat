package org.iheng.wechat.fragments;


import org.iheng.wechat.R;
import org.iheng.wechat.R.id;
import org.iheng.wechat.components.FunctionItemView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;

public class FoundFragment extends Fragment {
	
	private FunctionItemView circle_view;
	private FunctionItemView scan_view;
	private FunctionItemView shake_view;
	private FunctionItemView neighbor_view;
	private FunctionItemView shopping_view;
	private FunctionItemView games_view;
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v=inflater.inflate(R.layout.fragment_found, null);
		init(v);
		return v;
	}
	
	private void init(View v){
		circle_view=(FunctionItemView)v.findViewById(R.id.circle);
		circle_view.setItemIconResource(R.drawable.circle_icon);
		circle_view.setItemLabelResource(R.string.circle);
		scan_view=(FunctionItemView)v.findViewById(R.id.scan);
		scan_view.setItemIconResource(R.drawable.scan_icon);
		scan_view.setItemLabelResource(R.string.scan);
		shake_view=(FunctionItemView)v.findViewById(R.id.shake);
		shake_view.setItemIconResource(R.drawable.shake_icon);
		shake_view.setItemLabelResource(R.string.shake);
		neighbor_view=(FunctionItemView)v.findViewById(R.id.neighbor);
		neighbor_view.setItemIconResource(R.drawable.neighbor_icon);
		neighbor_view.setItemLabelResource(R.string.neighbor);
		shopping_view=(FunctionItemView)v.findViewById(R.id.shopping);
		shopping_view.setItemIconResource(R.drawable.shopping_icon);
		shopping_view.setItemLabelResource(R.string.shopping);
		games_view=(FunctionItemView)v.findViewById(R.id.games);
		games_view.setItemIconResource(R.drawable.games_icon);
		games_view.setItemLabelResource(R.string.games);
	}
}
