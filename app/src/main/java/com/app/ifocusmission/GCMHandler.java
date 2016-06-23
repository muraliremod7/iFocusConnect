package com.app.ifocusmission;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.app.ifcousmission.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * Created by sandeep on 11/21/2015.
 */
public class GCMHandler {
    private Activity ctx;
    //GCM
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private GoogleCloudMessaging gcm;
    public String registrationID = "";
    private SharedPreferences notifications_prefs;

    /**
     * Class Constructor
     *
     * @param ctx activity context object
     */
    public GCMHandler(Activity ctx) {
        this.ctx = ctx;
    }

    /**
     * Registers the app for GCM.
     */
    public void registerOnGCM() {
        notifications_prefs  = ctx.getSharedPreferences("gcm_info", ctx.MODE_PRIVATE);
        if (checkGooglePlayServices(ctx)) {
            try {
                gcm = GoogleCloudMessaging.getInstance(ctx);
                registrationID = getRegistrationID(ctx);
                if (registrationID.equals("") || (notifications_prefs.getInt(ctx.getString(R.string.key_app_version_number), 1) != getAppVersion(ctx))) {
                    registerInBackground();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(ctx, ctx.getString(R.string.device_not_supported), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Fetches the Registration ID
     *
     * @param context activity context object
     * @return Registration ID String.
     */
    private String getRegistrationID(Activity context) {
        String registration_id = notifications_prefs.getString(context.getString(R.string.key_registration_id), "");

        if (registration_id.equals("")) {
            return "";
        } else {
            registrationID = registration_id;
        }
        Log.i("====Registration Id==", "===Registration id" + registration_id);
        return registrationID;
    }

    /**
     * Registers the app with a projects ID to receive notifications.
     */
    private void registerInBackground() {
        new AsyncTask<Object, Object, Object>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Object result) {
                super.onPostExecute(result);
                //dialog.dismiss();
            }

            @Override
            protected Object doInBackground(Object... params) {
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(ctx);
                    }
                    SharedPreferences.Editor editor = notifications_prefs.edit();
                    registrationID = gcm.register(ctx.getString(R.string.project_id));
                    Log.i("====Registration Id==", "===Registration id" + registrationID);
                    editor.putInt( ctx.getString(R.string.key_app_version_number), getAppVersion(ctx));
                    editor.putString(ctx.getString(R.string.key_registration_id), registrationID);
                    editor.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute(null, null, null);

    }

    /**
     * Returns the Application Version.
     *
     * @param context activity context object
     * @return Application version
     */
    public int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    /**
     * This methods checks whether Google Play Services is available on the device.
     *
     * @param ctx activity context object
     * @return True, if Google play service is available or false otherwise.
     */
    public boolean checkGooglePlayServices(Activity ctx) {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(ctx);
        if (resultCode == ConnectionResult.SUCCESS) {
            return true;
        } else if (resultCode == ConnectionResult.SERVICE_MISSING ||
                resultCode == ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED ||
                resultCode == ConnectionResult.SERVICE_DISABLED) {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resultCode, ctx, 1);
            dialog.show();
        }
        return false;
    }
}
