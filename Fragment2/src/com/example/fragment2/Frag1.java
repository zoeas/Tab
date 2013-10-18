package com.example.fragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Frag1 extends Fragment{
	
	private TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_layout, container, false);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		tv = (TextView)(getView().findViewById(R.id.text));
	}
	
	public void setTv(String text){
		tv.setText(text);
	}
	

	
}
