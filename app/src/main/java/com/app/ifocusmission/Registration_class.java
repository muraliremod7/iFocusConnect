package com.app.ifocusmission;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.ifcousmission.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONException;
import org.json.JSONObject;

public class Registration_class extends Activity {

    EditText edt_name, edt_phne, edt_email, edt_profission, edt_address, edt_location, edt_city, edt_hometown, edt_surname;
    Button btn_save;
    String name, phne, email, profession, address, location, city, home_town, surname;
    ProgressDialog progressDialog;
    private WebServiceCalling mconnection = new WebServiceCalling();
    private GCMHandler gcmHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);
        gcmHandler = new GCMHandler(this);
        gcmHandler.registerOnGCM();

        edt_name = (EditText) findViewById(R.id.fullName);
        edt_phne = (EditText) findViewById(R.id.phoneNumber);
        edt_email = (EditText) findViewById(R.id.email);
        edt_profission = (EditText) findViewById(R.id.profession);
        edt_address = (EditText) findViewById(R.id.city);
        edt_location = (EditText) findViewById(R.id.location);
        edt_city = (EditText) findViewById(R.id.city);
        edt_hometown = (EditText) findViewById(R.id.homeTown);
        edt_surname = (EditText) findViewById(R.id.surName);
        btn_save = (Button) findViewById(R.id.register);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        btn_save.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                user_registration();
                //Intent i = new Intent(getApplicationContext(), Homepage.class);
                //startActivity(i);
            }
        });

    }

    private void user_registration() {
        // TODO Auto-generated method stub
        Log.i("===Reg Id::", "===" + gcmHandler.registrationID);
        name = edt_name.getText().toString();
        phne = edt_phne.getText().toString();
        email = edt_email.getText().toString();
        profession = edt_profission.getText().toString();
        address = edt_address.getText().toString();
        location = edt_location.getText().toString();
        city = edt_city.getText().toString();
        home_town = edt_hometown.getText().toString();

        surname = edt_surname.getText().toString();

		
	/*	
		if(name.contains(" ")||phne.contains(" ") ||email.contains(" ") ||profession.contains(" ")||home_town.contains(" ")||address.contains(" ")||location.contains(" ")||city.contains(" ")||surname.contains(" ")){
			
			Toast.makeText(getApplicationContext(), "Please enter valid credentionals", Toast.LENGTH_SHORT).show();
			}	
		
		*/


        if (name.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter Name")
                    .show();
        } else if (phne.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter Phone Number")
                    .show();
        } else if (surname.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter Surname")
                    .show();
        } else if (home_town.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter Home-town ")
                    .show();
        } else if (city.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter City")
                    .show();
        } else if (location.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter Location")
                    .show();
        } else if (address.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter Addrress")
                    .show();
        } else if (profession.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter profession")
                    .show();
        } else if (email.length() <= 0) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter E-mail")
                    .show();
        } else if (!isEmailValid(email)) {
            new AlertDialog.Builder(Registration_class.this)
                    .setTitle("Alert")
                    .setMessage("Please Enter Valid E-mail")
                    .show();
        } else {


            new user_reg_web_calling().execute();

        }


    }


    private class user_reg_web_calling extends AsyncTask<String, String, String> {
        Dialog dialog;
        @Override
        protected void onPreExecute() {
            //progressDialog = ProgressDialog.show(getApplicationContext(),"Please wait.", "Loading�", true);
            dialog = getProgressDialog();

        }

        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub

            //String url="http://ifocusmission.net/SocialProject/api/register?Name="+name+"Surname="+surname+"Mobile="+phne+"Email="+email+"Profession="+profession+"Current Address="+address+"Location="+location+"City="+city+"Hometown="+home_town;
            JSONObject jsonObject = new JSONObject();
            String response = null;
            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
             //   nameValuePairs.a


                nameValuePairs.add(new BasicNameValuePair("reg_id", gcmHandler.registrationID));
                nameValuePairs.add(new BasicNameValuePair("name", name));
                nameValuePairs.add(new BasicNameValuePair("surname", surname));
                nameValuePairs.add(new BasicNameValuePair("mobile_number", phne));
                nameValuePairs.add(new BasicNameValuePair("email", email));
                nameValuePairs.add(new BasicNameValuePair("profession", profession));
                nameValuePairs.add(new BasicNameValuePair("current_address", address));
                nameValuePairs.add(new BasicNameValuePair("location", location));
                nameValuePairs.add(new BasicNameValuePair("city", city));
                nameValuePairs.add(new BasicNameValuePair("hometown", home_town));

            //    String url = "http://ifocusmission.net/SocialProject/api/register_mobile";
                //String response = sendJsonTOServer(url, jsonObject);
             //   response = sendJsonTOServer(url, nameValuePairs);
                jsonObject.put("reg_id", gcmHandler.registrationID);
                jsonObject.put("name", name);
                jsonObject.put("surname", surname);
                jsonObject.put("mobile_number", phne);
                jsonObject.put("email", email);
                jsonObject.put("profession", profession);
                jsonObject.put("current_address", address);
                jsonObject.put("location", location);
                jsonObject.put("city", city);
                jsonObject.put("hometown", home_town);
            } catch (JSONException e) {
                e.printStackTrace();
            }
           /* String mbody = "user="
					+ name
					+ "&surname=" + surname
					+ "&mobile=" + phne
					+ "&email=" + email
					+ "&profession=" + profession
					+ "&current_address=" + address
					+ "&location=" + location
					+ "&location=" + city
					+ "&hometown=" + home_town;
			Log.e("resultttt", mbody);

		//	http://ifocusmission.net/SocialProject/api/register
			
			String response = mconnection.setUpHttpPost(
					"http://ifocusmission.net/SocialProject/api/register?", mbody);
			System.out.println("response"+response);
			Log.e("ressss", response);

				*/
            String url = "http://ifocusmission.net/SocialProject/api/register_mobile";
            response = sendJsonTOServer(url, jsonObject);
            //String response = sendJsonTOServer(url, na);


            return response;
        }

        public String sendJsonTOServer(String url, JSONObject object) {

            String json = null;
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpContext httpContext = new BasicHttpContext();
                HttpPost httpPost = new HttpPost(url);
                HttpEntity httpEntity;
                String str = object.toString();
                StringEntity strEntity = new StringEntity(str);
                strEntity.setContentType("application/json");

                httpEntity = strEntity;
                httpPost.setEntity(httpEntity);

                HttpResponse response = httpClient.execute(httpPost, httpContext);
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent(), "UTF-8"));
                json = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }
       /* public String sendJsonTOServer(String url, List<NameValuePair> object) {

            String json = null;
            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpContext httpContext = new BasicHttpContext();
                HttpPost httpPost = new HttpPost(url);
                HttpEntity httpEntity;
                String str = object.toString();
                StringEntity strEntity = new StringEntity(str);
              //  strEntity.setContentType("application/json");

                httpEntity = strEntity;
                //httpPost.setEntity(httpEntity);
                httpPost.setEntity(new UrlEncodedFormEntity(object));

                HttpResponse response = httpClient.execute(httpPost, httpContext);
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        response.getEntity().getContent(), "UTF-8"));
                json = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return json;
        }*/

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dialog.dismiss();
            Log.i("===Response:::", "===" + result);
            if(result != null){
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if(jsonObject.optBoolean("status")){
                        SharedPreferences settings_prefs = getSharedPreferences(
                                "login_info_new", MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings_prefs.edit();
                        editor.putString("is_registration_done","yes");
                        editor.commit();
                        Toast.makeText(Registration_class.this, jsonObject.optString("message"), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(Registration_class.this, jsonObject.optString("message"), Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Registration_class.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
                Log.i("===Response:::", "===" + result);
            }

			
			/*
		
			if (result != null) {
				
				
				
			} else {
				
				
				//Log.e(TAG, "Couldn't get any data from the url");
			}*/

/*
			if(progressDialog!=null)
			{
				progressDialog.dismiss();
			}	
*/
            //Toast.makeText(getApplicationContext(), uniqueId+userPhone+userEmail, Toast.LENGTH_LONG).show();


        }
    }
    public Dialog getProgressDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.progress_dialog);
        //TextView tv = (TextView) dialog.findViewById(R.id.dialog_text);
     //   tv.setText(message);
        dialog.setCancelable(false);
        dialog.show();
        return dialog;
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
