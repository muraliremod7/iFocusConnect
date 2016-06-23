package com.app.ifocusmission;

import com.app.ifcousmission.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Notification extends Activity {
	
	
	Button alert,suc_stores,event_update;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notifications);
		alert=(Button)findViewById(R.id.alert);
		suc_stores=(Button)findViewById(R.id.suc_stores);
		
		event_update=(Button)findViewById(R.id.event_updates);
		
		ImageView btn_back=(ImageView)findViewById(R.id.btn_back);
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
		
		alert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent i= new Intent(getApplicationContext(), Enquries_activity.class);
			 //startActivity(i);
				
				Toast.makeText(getApplicationContext(), "Alerts Coming Soon", Toast.LENGTH_LONG).show();
			}
		});

		suc_stores.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i= new Intent(getApplicationContext(), Webview.class);
	 startActivity(i);
		
	}
});
		
   event_update.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 Intent i= new Intent(getApplicationContext(), Webview_events_update.class);
			     startActivity(i);
				
				//Toast.makeText(getApplicationContext(), "Events Updates are Coming Soon", Toast.LENGTH_LONG).show();
			}
		});

		
	}

}
