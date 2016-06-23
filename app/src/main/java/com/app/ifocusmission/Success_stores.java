package com.app.ifocusmission;

import com.app.ifcousmission.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Success_stores extends Activity {
	
	
	Button image_ramaprabha, image_ayanjun;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success_stores);
		image_ramaprabha=(Button)findViewById(R.id.image_ramaprabha);
		image_ayanjun=(Button)findViewById(R.id.image_ayanjun);
		
		ImageView btn_back=(ImageView)findViewById(R.id.btn_back);
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		image_ramaprabha.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(), Success_stores_innerpage.class);
			 startActivity(i);
				
			}
		});
		
		

		image_ayanjun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i= new Intent(getApplicationContext(), Success_stores_innerpage2.class);
			 startActivity(i);
				
			}
		});
		
	}

}
