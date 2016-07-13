package com.app.ifocusmission;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.app.ifcousmission.R;

public class Webview extends Activity {

	   private WebView wv1;
	   
	   String url_about="http://ifocusmission.net/SocialProject/api/success_stories/0";
	  
	   
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.webview);
	      
	     
	      wv1=(WebView)findViewById(R.id.webview);
	      
	      wv1.setWebViewClient(new MyBrowser());
	      wv1.setWebViewClient(new MyBrowser());
	      wv1.getSettings().setJavaScriptEnabled(true);
	      
	      
	      ImageView btn_back=(ImageView)findViewById(R.id.btn_back);
			btn_back.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
	    
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
