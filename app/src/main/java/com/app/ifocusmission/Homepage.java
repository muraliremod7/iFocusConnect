package com.app.ifocusmission;

import com.app.ifcousmission.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Homepage extends Activity {
	
	Button ifocus_mission1,btn_about,announcements,btn_enquires;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
	TextView ifocus_mission=(TextView)findViewById(R.id.ifocus_mission);
		
		btn_about=(Button)findViewById(R.id.abt_ifocus);
		announcements=(Button)findViewById(R.id.announcements);
		btn_enquires=(Button)findViewById(R.id.enquires);
		
		 SharedPreferences.Editor editor = getSharedPreferences(
					"login_info", MODE_PRIVATE).edit();
			editor.putString("is_registration_done", "yes");
			editor.commit();
		  
		
		ifocus_mission.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	Intent i= new Intent(getApplicationContext(), Ifocus_Mission.class);
				// startActivity(i);
			}
		});
		
btn_about.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(), AboutPage.class);
				 startActivity(i);
			}
		});


announcements.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		//Toast.makeText(getApplicationContext(), "Updates Coming Soon", Toast.LENGTH_LONG).show();
		Intent i= new Intent(getApplicationContext(), Notification.class);
		 startActivity(i);
	}
});

btn_enquires.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i= new Intent(getApplicationContext(), Enquries_activity.class);
	 startActivity(i);
		
		//Toast.makeText(getApplicationContext(), "Enquries Coming Soon", Toast.LENGTH_LONG).show();
	}
});
		
		
		
		
	}

}
