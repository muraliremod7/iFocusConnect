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

public class AboutPage extends Activity {
	
	Button about_ifocus,about_mission_clb,about_structure,about_contact,btn_back,faq,about_pledge;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);
		
		about_ifocus=(Button)findViewById(R.id.about_ifocus);
		about_mission_clb=(Button)findViewById(R.id.about_mission_clb);
		about_structure=(Button)findViewById(R.id.about_structure);
		about_contact=(Button)findViewById(R.id.about_contact);
		
		about_pledge=(Button)findViewById(R.id.about_pledge);
		
		
		about_pledge.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(), Pldge_Declaration.class);
				 startActivity(i);
				
			}
		});
		
		faq=(Button)findViewById(R.id.about_faq);
		
		faq.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(), FAQ_activity.class);
				 startActivity(i);
				
			}
		});
		
		
		about_mission_clb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(), Sanjiwani_Club.class);
				 startActivity(i);
				
			}
		});
		
		
		ImageView btn_back=(ImageView)findViewById(R.id.btn_back);
		
		btn_back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
		about_contact.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i= new Intent(getApplicationContext(), Contact_info.class);
				 startActivity(i);
				
			}
		});
		
		
		about_ifocus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i= new Intent(getApplicationContext(), About_Ifocus.class);
				 startActivity(i);
				
			}
		});
		
		
		/*about_mission.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i= new Intent(getApplicationContext(), Mission_Vision.class);
				 startActivity(i);
				
			}
		});*/
		
		
		about_structure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i= new Intent(getApplicationContext(), Structure.class);
				 startActivity(i);
				
				
			}
		});
		
		
	}

}
