package com.app.ifocusmission;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.app.ifcousmission.R;



public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public WebView wv1;
    DrawerLayout drawer;

    String url_about="http://ifocusmission.net/SocialProject/api/event_updates/0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Event Updates");

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        wv1=(WebView)findViewById(R.id.webview);

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            // Handle the camera action
            Intent intent = new Intent(HomeActivity.this,About_Ifocus.class);
            startActivity(intent);

        } else
            if (id == R.id.nav_pledge) {

            Intent intent = new Intent(HomeActivity.this,Pldge_Declaration.class);
            startActivity(intent);

        } else if (id == R.id.nav_structure) {

            Intent intent = new Intent(HomeActivity.this,Structure.class);
            startActivity(intent);


        } else if (id == R.id.nav_sanjiwani) {

            Intent intent = new Intent(HomeActivity.this,Sanjiwani_Club.class);
            startActivity(intent);

        } else if (id == R.id.nav_FAQs) {

            Intent intent = new Intent(HomeActivity.this,FAQ_activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_contact) {

            Intent intent = new Intent(HomeActivity.this,Contact_info.class);
            startActivity(intent);

        } else if(id == R.id.nav_sendEnquiry){

            Intent intent = new Intent(HomeActivity.this,Generalenquiriy.class);
            startActivity(intent);

        }
            else if(id == R.id.nav_bsspasses){

                Intent intent = new Intent(HomeActivity.this,BookEventPassess.class);
                startActivity(intent);

            }
            else if(id == R.id.nav_contributeifund){

                Intent intent = new Intent(HomeActivity.this,ContributeiFund.class);
                startActivity(intent);

            }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupDrawerContent(NavigationView navigationView) {
        //revision: this don't works, use setOnChildClickListener() and setOnGroupClickListener() above instead
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawer.closeDrawers();
                        return true;
                    }
                });
    }
}



