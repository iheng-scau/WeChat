package org.iheng.wechat.fragments;

import android.os.Bundle;
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

public class ContactsFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		FrameLayout f=new FrameLayout(getActivity());
		f.setLayoutParams(params);
		DisplayMetrics dm = getResources().getDisplayMetrics();   
        TextView v = new TextView(getActivity());   
        v.setLayoutParams(params);  
        v.setLayoutParams(params);  
        v.setGravity(Gravity.CENTER);  
        v.setText("通讯录界面");  
        v.setTextSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, dm));  
        f.addView(v);  
        return f;  
	}
}
