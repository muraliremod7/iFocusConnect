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

public class Enquries_activity extends Activity {
	
	
	Button general_enq,bld_enq,bus_enq;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enqury);
		
		general_enq=(Button)findViewById(R.id.general_enq);
		bld_enq=(Button)findViewById(R.id.bld_enq);
		bus_enq=(Button)findViewById(R.id.bus_enq);
		
		ImageView btn_back=(ImageView)findViewById(R.id.btn_back);
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		
		general_enq.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent i= new Intent(getApplicationContext(), Generalenquiriy.class);
			 startActivity(i);
				
			}
		});
		
		
		bld_enq.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent i= new Intent(getApplicationContext(), Enquries_activity.class);
			 //startActivity(i);
				
				Toast.makeText(getApplicationContext(), "Blood Enquiry Coming Soon", Toast.LENGTH_LONG).show();
			}
		});
		
	
		bus_enq.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i= new Intent(getApplicationContext(), Business_enquiriy.class);
		 startActivity(i);
			
		}
	});
	
		
	}

}
