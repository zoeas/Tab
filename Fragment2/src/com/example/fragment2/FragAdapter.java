package com.example.fragment2;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class FragAdapter extends FragmentPagerAdapter{

	ArrayList<Fragment> fragmentList;
	
	public FragAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
		super(fm);
		this.fragmentList = fragmentList;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
	}

	@Override
	public Fragment getItem(int postion) {
		return fragmentList.get(postion);
	}

	@Override
	public int getCount() {
		return fragmentList.size();
	}
	
	

}
