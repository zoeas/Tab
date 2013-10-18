package com.example.fragment2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Frag2 extends ListFragment{

	public interface OnListFragListener{
		public void onListFragmentItemClick(String text);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String to = ((TextView)v).getText().toString();
		OnListFragListener oninterface = (OnListFragListener) getActivity();
		oninterface.onListFragmentItemClick(to);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		setListAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.list, android.R.layout.simple_list_item_1));
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		OnListFragListener oninterface = (OnListFragListener) activity;
	}
}
