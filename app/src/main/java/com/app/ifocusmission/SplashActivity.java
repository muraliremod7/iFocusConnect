package com.app.ifocusmission;


import com.app.ifcousmission.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;

public class SplashActivity extends Activity {

	String registrationStatus, user_type;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.splash);

		SharedPreferences settings_prefs = getSharedPreferences(
				"login_info_new", MODE_PRIVATE);
		registrationStatus = settings_prefs.getString(
				"is_registration_done", "no");
		
		final int welcomeScreenDisplay = 2000;
		/** create a thread to show splash up to splash time */
		Thread welcomeThread = new Thread() {
			int wait = 0;

			@Override
			public void run() {
				try {
					super.run();
					/**
					 * use while to get the splash time. Use sleep() to increase
					 * the wait variable for every 100L.
					 */
					while (wait < welcomeScreenDisplay) {
						sleep(100);
						wait += 100;
					}
				} catch (Exception e) {
					System.out.println("EXc=" + e);
				} finally {
					
					if (registrationStatus.equalsIgnoreCase("yes")) {
						Intent user_details_intent = new Intent(
								getApplicationContext(), HomeActivity.class);
						startActivity(user_details_intent);
						finish();
					}  else {
						Intent login_intent = new Intent(
								getApplicationContext(), Registration_class.class);
						startActivity(login_intent);
						finish();
					}
					
				}
			}
		};
		welcomeThread.start();

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}
