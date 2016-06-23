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

public class Generalenquiriy extends Activity{
	
	Button submit;
	EditText edt_name_general,edt_mbl_general,edt_email_general,edt_equry_general;
	
	String name_general, mbl_general,email_general,query_general;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.general_enq);
		submit=(Button)findViewById(R.id.submit);
		
		edt_name_general=(EditText)findViewById(R.id.edt_name_general);
		edt_mbl_general=(EditText)findViewById(R.id.edt_mbl_general);
		edt_email_general=(EditText)findViewById(R.id.edt_email_general);
		edt_equry_general=(EditText)findViewById(R.id.edt_equry_general);
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
				Toast.makeText(getApplicationContext(), "User Details are trigged to this mail : info@ifocusmission.org ", Toast.LENGTH_SHORT).show();
			}
		});
		
	}
	

	
	protected void trigger_calling() {
		// TODO Auto-generated method stub
		name_general=edt_name_general.getText().toString();
		mbl_general=edt_mbl_general.getText().toString();
		query_general=edt_equry_general.getText().toString();
		email_general=edt_email_general.getText().toString();
		
		
		
		
		
if(name_general.contains(" ")||mbl_general.contains(" ") ||query_general.contains(" ") ||email_general.contains(" ")){
			
			//Toast.makeText(getApplicationContext(), "Please enter valid credentionals", Toast.LENGTH_SHORT).show();
		
		
		 new AlertDialog.Builder(Generalenquiriy.this)
         .setTitle("Alert")
         .setMessage("Please Enter Name")
         .show();
		
		
			}	
		
		
		
	
			
		 else if (name_general.length() <= 0) {
			  new AlertDialog.Builder(Generalenquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter Name")
	          .show();
		}

		else if (mbl_general.length() <= 0) {
			 new AlertDialog.Builder(Generalenquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter Phone Number")
	          .show();
		}
		
		else if (query_general.length() <= 0) {
			 new AlertDialog.Builder(Generalenquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter Query")
	          .show();
		}
		
		
		else if (email_general.length() <= 0) {
			 new AlertDialog.Builder(Generalenquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter E-Mail")
	          .show();
		}
		
		
		
		else if (!isEmailValid(email_general)) {
			 new AlertDialog.Builder(Generalenquiriy.this)
	          .setTitle("Alert")
	          .setMessage("Please Enter Valid E-mail")
	          .show();
		}
		else {
			
			  

			
			Intent intent = new Intent(Intent.ACTION_SEND);
			intent.setType("text/html");
			intent.putExtra(Intent.EXTRA_EMAIL, "teamifocus@gmail.com");
			intent.putExtra(Intent.EXTRA_SUBJECT, "Query");
			intent.putExtra(Intent.EXTRA_TEXT, name_general);
			intent.putExtra(Intent.EXTRA_TEXT, mbl_general);
			intent.putExtra(Intent.EXTRA_TEXT, query_general);
			intent.putExtra(Intent.EXTRA_TEXT, email_general);


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
