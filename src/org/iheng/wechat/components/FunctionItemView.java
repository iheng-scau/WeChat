package org.iheng.wechat.components;

import org.iheng.wechat.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FunctionItemView extends LinearLayout {

	private ImageView item_icon;
	private TextView item_label;
	
	public FunctionItemView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public FunctionItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v=inflater.inflate(R.layout.function_item, this);
		item_icon=(ImageView)v.findViewById(R.id.function_item_icon);
		item_label=(TextView)v.findViewById(R.id.function_item_label);
	}

	public void setItemIconResource(int resId){
		item_icon.setImageResource(resId);
	}
	public void setItemLabelResource(int resId){
		item_label.setText(resId);
	}
	
}
