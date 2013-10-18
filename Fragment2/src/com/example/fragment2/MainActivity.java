package com.example.fragment2;

import java.util.ArrayList;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements TabListener, Frag2.OnListFragListener{

	ArrayList<Fragment> fragmentList;
	FragmentPagerAdapter FragPagerAdapter;
	ViewPager mpager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		Tab tab = actionbar.newTab().setText("tab1").setIcon(android.R.drawable.ic_menu_manage).setTabListener(this);
		Tab tab2 = actionbar.newTab().setText("tab2").setIcon(android.R.drawable.ic_menu_add).setTabListener(this);
		Tab tab3 = actionbar.newTab().setText("tab3").setIcon(android.R.drawable.ic_menu_add).setTabListener(this);
		
		actionbar.setDisplayUseLogoEnabled(false);
		
		fragmentList = new ArrayList<Fragment>();
		fragmentList.add(new Frag2());
		fragmentList.add(new Frag1());
		fragmentList.add(new Frag1());
		
		mpager = (ViewPager)findViewById(R.id.pager);
		mpager.setAdapter(new FragAdapter(getSupportFragmentManager(),fragmentList));
		mpager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionbar.setSelectedNavigationItem(position);
			}
			
			@Override
			public void onPageScrolled(int position, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int position) {
			}
		});
		
		actionbar.addTab(tab);
		actionbar.addTab(tab2);
		actionbar.addTab(tab3);
		
		actionbar.setCustomView(R.layout.frag_layout);
		actionbar.setDisplayShowCustomEnabled(true);
		
		// 허니콤이하 버전이면 android.support.v7.appcompat.R.id.home.. v7에 있는 home 아이콘을 가져오고 
		// 허니콤 이상이면 android.R.id.home 
		// 그것의 부모view를 찾아서 레이아웃채로 날려버림
		View homeIcon = findViewById(
				Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ? android.R.id.home :
					android.support.v7.appcompat.R.id.home);
		((View)homeIcon.getParent()).setVisibility(View.GONE);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onGroupItemClick(MenuItem menu){
		Toast.makeText(this, "on", 0).show();
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		mpager.setCurrentItem(tab.getPosition(), true);
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onListFragmentItemClick(String text) {
		Frag1 fragView = (Frag1)fragmentList.get(1);
		fragView.setTv(text);
	}

}
