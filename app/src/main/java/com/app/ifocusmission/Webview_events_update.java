package com.app.ifocusmission;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.ifcousmission.R;

public class Webview_events_update extends Activity {
	


	   
	   private WebView wv1;
	   TextView about_us;
	   
	   String url_about="http://ifocusmission.net/SocialProject/api/event_updates/0";
	  
	   
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.webview);
	      
	     
	      wv1=(WebView)findViewById(R.id.webview);
	      
	      about_us=(TextView)findViewById(R.id.about_us);
	      
	      about_us.setText("Events Update");
	      
	      
	      ImageView btn_back=(ImageView)findViewById(R.id.btn_back);
			btn_back.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
			
	      
	      wv1.setWebViewClient(new MyBrowser());
	      wv1.setWebViewClient(new MyBrowser());
	      wv1.getSettings().setJavaScriptEnabled(true);
	    
	      wv1.loadUrl(url_about);
	      
	      
	    
	      
	    
	   }
	   
	   private class MyBrowser extends WebViewClient {
		      @Override
		      public boolean shouldOverrideUrlLoading(WebView view, String url) {
		         view.loadUrl(url);
		         return true;
		      }
		   }

}
