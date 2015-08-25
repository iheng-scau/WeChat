package org.iheng.wechat.components;

import org.iheng.wechat.R;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class PlusActionProvider extends ActionProvider {

	private Context context;
	public PlusActionProvider(Context context) {
		super(context);
		this.context=context;
	}

	@Override
	public View onCreateActionView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onPrepareSubMenu(SubMenu subMenu) {
		// TODO Auto-generated method stub
		subMenu.clear();
		
		subMenu.add(context.getString(R.string.plus_group_chat))
			.setIcon(R.drawable.ofm_group_chat_icon)
			.setOnMenuItemClickListener(new OnMenuItemClickListener() {
				
				@Override
				public boolean onMenuItemClick(MenuItem item) {
					// TODO Auto-generated method stub
					return true;
				}
			});
		
		subMenu.add(context.getString(R.string.plus_add_friend))
			.setIcon(R.drawable.ofm_add_icon)
			.setOnMenuItemClickListener(new OnMenuItemClickListener() {
				
				@Override
				public boolean onMenuItemClick(MenuItem item) {
					// TODO Auto-generated method stub
					return true;
				}
			});
		
	}

	@Override
	public boolean hasSubMenu() {
		// TODO Auto-generated method stub
		return true;
	}

	
}
