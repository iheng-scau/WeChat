package org.iheng.wechat.activities;

import java.lang.reflect.Method;

import org.iheng.wechat.R;
import org.iheng.wechat.fragments.ChatFragment;
import org.iheng.wechat.fragments.ContactsFragment;
import org.iheng.wechat.fragments.FoundFragment;
import org.iheng.wechat.fragments.SettingsFragment;

import com.astuetz.PagerSlidingTabStrip;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;


public class MainActivity extends FragmentActivity {
	
	private ChatFragment chatFragment;
	private FoundFragment foundFragment;
	private ContactsFragment contactsFragment;
	private SettingsFragment settingsFragment;
	private PagerSlidingTabStrip tabs;
	private DisplayMetrics dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		setOverflowShowingAlways();
		dm = getResources().getDisplayMetrics();
		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
		pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		tabs.setViewPager(pager);
		setTabsValue();
    }

    
    public class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		private final String[] titles = { "����", "����", "ͨѶ¼","����"};

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

		@Override
		public int getCount() {
			return titles.length;
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				if (chatFragment == null) {
					chatFragment = new ChatFragment();
				}
				return chatFragment;
			case 1:
				if (foundFragment == null) {
					foundFragment = new FoundFragment();
				}
				return foundFragment;
			case 2:
				if (contactsFragment == null) {
					contactsFragment = new ContactsFragment();
				}
				return contactsFragment;
			case 3:
				if(settingsFragment==null){
					settingsFragment=new SettingsFragment();
				}
				return settingsFragment;
			default:
				return null;
			}
		}

	}
    
    private void setTabsValue(){
    	// ����Tab���Զ��������Ļ��
		tabs.setShouldExpand(true);
		// ����Tab�ķָ�����͸����
		tabs.setDividerColor(Color.TRANSPARENT);
		// ����Tab�ײ��ߵĸ߶�
		tabs.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// ����Tab Indicator�ĸ߶�
		tabs.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// ����Tab�������ֵĴ�С
		tabs.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// ����Tab Indicator����ɫ
		tabs.setIndicatorColor(Color.parseColor("#45c01a"));
		// ȡ�����Tabʱ�ı���ɫ
		tabs.setTabBackground(0);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * �˷������ڽ����ز˵����ͼ����ʾ
     */
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		if(featureId==Window.FEATURE_ACTION_BAR&&menu!=null){
			if(menu.getClass().getSimpleName().equals("MenuBuilder")){
				try{
					Method m=menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
					m.setAccessible(true);
					m.invoke(menu, true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		return super.onMenuOpened(featureId, menu);
	}
    
}
