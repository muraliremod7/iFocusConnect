package com.app.ifocusmission;

import com.app.ifcousmission.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Event_Updates extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.events_updates);
	Button image_ramchanderrao=(Button)findViewById(R.id.image_ramchanderrao);
	Button	image_pvrk=(Button)findViewById(R.id.image_pvrk);
		
		ImageView btn_back=(ImageView)findViewById(R.id.btn_back);
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		image_pvrk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(), events_updates_innerpage.class);
			 startActivity(i);
				
			}
		});
		
		

		image_ramchanderrao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(), event_update_innerpage2.class);
			 startActivity(i);
				
			}
		});
		
	}
		
	

}
