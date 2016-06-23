package com.app.ifocusmission;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class WebServiceCalling {

	private DefaultHttpClient httpclient;
	private HttpPost httppost;
	
	HttpGet getRequest;
	InputStream iStream;
	String response = null;
	public static String TAG = "WebServiceCalling";
	private static final int TIME_OUT_CONNECTION = 10000;
	private static final int TIME_OUT_SOCKET = 30000;

	public String setUpHttpPost(String url, String string) {

		try {
			HttpParams httpParameters = new BasicHttpParams();
			// established.
			
			System.out.println("post"+url);
			// The default value is zero, that means the timeout is not used.
			int timeoutConnection = TIME_OUT_CONNECTION;
			HttpConnectionParams.setConnectionTimeout(httpParameters,
					timeoutConnection);
			// Set the default socket timeout (SO_TIMEOUT)
			// in milliseconds which is the timeout for waiting for data.
			int timeoutSocket = TIME_OUT_SOCKET;
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
			// Log.v("TAG", "TIMe OUT   1");
			httpclient = new DefaultHttpClient(httpParameters);
			httppost = new HttpPost(url);

			httppost.setHeader("Content-type",
					"application/x-www-form-urlencoded");

			httppost.setEntity(new StringEntity(string));
			
			HttpResponse httpResponse = httpclient.execute(httppost);
			System.out.println("httpResponse"+httpResponse);

			httpResponse.getStatusLine().getStatusCode();

			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				System.out.println("200ok");
				
				response = EntityUtils.toString(httpResponse.getEntity());
			  System.out.println("<<in post" + response);
			} 
		} catch (HttpHostConnectException e) {
			e.printStackTrace();
			Log.e(TAG, "network connection Exception");
			response = "neterror";

		} catch (SocketTimeoutException socketExaception) {
			Log.e(TAG, "Socket Exception");
			socketExaception.printStackTrace();
			response = "serverDown";
			// res = "CarTrade server is in down. please try after some time";
		} catch (ConnectTimeoutException connectionTimeOut) {
			Log.e(TAG, "connectin timeout");
			connectionTimeOut.printStackTrace();
			response = "connectinTimeOut";
			// res = "CarTrade server is in down. please try after some time";
		} catch (UnknownHostException e) {
			e.printStackTrace();
			response = "neterror";
			Log.e(TAG, "UnknownHostException");
		} catch (ClientProtocolException e) {
			Log.e(TAG, "ClientProtocolException in valid  responce");
			e.printStackTrace();
		} catch (IOException e) {
			Log.e(TAG, "IOException");
			e.printStackTrace();
		} catch (Exception e) {
			// Log.e(TAG, res);
			// Log.e("Buffer Error", "Error converting result " + e.toString());
			e.printStackTrace();
			response = "serverIssue";
			// res = e.getClass().toString();

		}

		// Log.e("responce from server", res);
		return response;
		
	}

	public String makeGetRequestgetJSONResponse(String uri) {

		try {
			
			HttpParams httpParameters = new BasicHttpParams();
			// Set the timeout in milliseconds until a connection is
			// established.
			// The default value is zero, that means the timeout is not used.
			int timeoutConnection = TIME_OUT_CONNECTION;
			HttpConnectionParams.setConnectionTimeout(httpParameters,
					timeoutConnection);
			// Set the default socket timeout (SO_TIMEOUT)
			// in milliseconds which is the timeout for waiting for data.
			int timeoutSocket = TIME_OUT_SOCKET;
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
			// Log.v("TAG", "TIMe OUT   1");
			// Log.v("POSTURL", uri);
			httpclient = new DefaultHttpClient(httpParameters);

			getRequest = new HttpGet(uri);

			HttpResponse httpResponse = httpclient.execute(getRequest);

			response = EntityUtils.toString(httpResponse.getEntity());
			//System.out.println("<<<<<<<" + response);
			
		} catch (HttpHostConnectException e) {
			e.printStackTrace();
			Log.e(TAG, "network connection Exception");
			response = "neterror";

		} catch (SocketTimeoutException socketExaception) {
			Log.e(TAG, "Socket Exception");
			socketExaception.printStackTrace();
			response = "serverDown";
			// res = "CarTrade server is in down. please try after some time";
		} catch (ConnectTimeoutException connectionTimeOut) {
			Log.e(TAG, "connectin timeout");
			connectionTimeOut.printStackTrace();
			response = "connectinTimeOut";
			// res = "CarTrade server is in down. please try after some time";
		} catch (UnknownHostException e) {
			e.printStackTrace();
			response = "neterror";
			Log.e(TAG, "UnknownHostException");
		} catch (ClientProtocolException e) {
			Log.e(TAG, "ClientProtocolException in valid  responce");
			e.printStackTrace();
		} catch (IOException e) {
			Log.e(TAG, "IOException");
			e.printStackTrace();
		} catch (Exception e) {
			// Log.e(TAG, res);
			// Log.e("Buffer Error", "Error converting result " + e.toString());
			e.printStackTrace();
			response = "serverIssue";
			// res = e.getClass().toString();

		}

		// Log.e("responce from server", res);
		return response;
		}
	}


