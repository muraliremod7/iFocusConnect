package com.app.ifocusmission;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.ifcousmission.R;

public class Business_enquiriy extends Activity{
	
	Button submit;
	
	EditText edt_name_bus,edt_mbl_bus,edt_email_bus,edt_equry_bus;
	
	String name_business, mbl_business,email_business,query_business;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.busniess_enq);
		submit=(Button)findViewById(R.id.submit);
		
		edt_name_bus=(EditText)findViewById(R.id.edt_name_bus);
		edt_mbl_bus=(EditText)findViewById(R.id.edt_mbl_bus);
		edt_email_bus=(EditText)findViewById(R.id.edt_email_bus);
		edt_equry_bus=(EditText)findViewById(R.id.edt_equry_bus);
		
		ImageView btn_back=(ImageView)findViewById(R.id.btn_back);
		btn_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				 trigger_calling();
					}
		});
		
	}
	
	
	protected void trigger_calling() {
		// TODO Auto-generated method stub
		name_business=edt_name_bus.getText().toString();
		mbl_business=edt_mbl_bus.getText().toString();
		query_business=edt_equry_bus.getText().toString();
		email_business=edt_email_bus.getText().toString();
		
		
		
		
	if(name_business.contains(" ")||mbl_business.contains(" ") ||query_business.contains(" ") ||email_business.contains(" ")){
			
			//Toast.makeText(getApplicationContext(), "Please enter valid credentionals", Toast.LENGTH_SHORT).show();
		
		
		 new AlertDialog.Builder(Business_enquiriy.this)
         .setTitle("Alert")
         .setMessage("Please Enter Name")
         .show();
		
		
			}	
		
		
		
	
			
		 else if (name_business.length() <= 0) {
			  new AlertDialog.Builder(Business_enquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter Name")
	          .show();
		}

		else if (mbl_business.length() <= 0) {
			 new AlertDialog.Builder(Business_enquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter Phone Number")
	          .show();
		}
		
		else if (query_business.length() <= 0) {
			 new AlertDialog.Builder(Business_enquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter Query")
	          .show();
		}
		
		
		else if (email_business.length() <= 0) {
			 new AlertDialog.Builder(Business_enquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter E-Mail")
	          .show();
		}
		
		
		
		else if (!isEmailValid(email_business)) {
			 new AlertDialog.Builder(Business_enquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter Valid E-mail")
	          .show();
		}
		else {
			
			  
		//	new user_reg_web_calling().execute();
			
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/html");
			intent.putExtra(Intent.EXTRA_EMAIL, "teamifocus@gmail.com");
			intent.putExtra(Intent.EXTRA_SUBJECT, "Query");
			intent.putExtra(Intent.EXTRA_TEXT, name_business);
			intent.putExtra(Intent.EXTRA_TEXT, mbl_business);
			intent.putExtra(Intent.EXTRA_TEXT, query_business);
			intent.putExtra(Intent.EXTRA_TEXT, email_business);

			startActivity(Intent.createChooser(intent, "Send Email"));
			Toast.makeText(getApplicationContext(), "User Details are trigged to this mail : info@ifocusmission.org ", Toast.LENGTH_SHORT).show();
			
			
		     }
		
		
		
		
		
		
	}
	
	

	  public static boolean isEmailValid(String email) { 
      boolean isValid = false;
      String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
      CharSequence inputStr = email;
      Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
      Matcher matcher = pattern.matcher(inputStr);
      if (matcher.matches()) {
             isValid = true;
      }
      return isValid;
}


}
