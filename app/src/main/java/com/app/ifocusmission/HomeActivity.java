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
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;

import com.app.ifcousmission.R;
import com.app.ifocusmission.navigation.ExapandableListAdapter;
import com.app.ifocusmission.navigation.ExpandedMenuModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private WebView wv1;
    DrawerLayout drawer;
    ExapandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;

    String url_about="http://ifocusmission.net/SocialProject/api/success_stories/0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.hometoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
//        if (navigationView != null) {
//            setupDrawerContent(navigationView);
//        }


        wv1=(WebView)findViewById(R.id.webview);

        wv1.setWebViewClient(new MyBrowser());
        wv1.setWebViewClient(new MyBrowser());
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.loadUrl(url_about);

//        expandableList = (ExpandableListView) findViewById(R.id.navigationmenu);

//        prepareListData();
//        mMenuAdapter = new ExapandableListAdapter(this, listDataHeader, listDataChild, expandableList);
//
//        expandableList.setAdapter(mMenuAdapter);
//
//        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
//                //Log.d("DEBUG", "submenu item clicked");
//
//                final String selected = (String) mMenuAdapter.getChild(groupPosition,childPosition);
//
//                Intent intent;
//
//                switch (selected){
//                    case "About Mission":
//                        intent = new Intent(HomeActivity.this,About_Ifocus.class);
//                        startActivity(intent);
//                        break;
//                    case "Events":
//                        intent = new Intent(HomeActivity.this,Event_Updates.class);
//                        startActivity(intent);
//                        break;
//                    case "General Enquiry":
//                        intent = new Intent(HomeActivity.this,Generalenquiriy.class);
//                        startActivity(intent);
//                        break;
//                    case "Business Enquiry":
//                        intent = new Intent(HomeActivity.this,Business_enquiriy.class);
//                        startActivity(intent);
//                        break;
//                }
//                return false;
//            }
//        });
//        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPosition, long l) {
//                //Log.d("DEBUG", "heading clicked");
//
//                switch (groupPosition){
//                    case 1:
//                        Intent pledge = new Intent(HomeActivity.this,Pldge_Declaration.class);
//                       startActivity(pledge);
//                        break;
//                    case 2:
//                        Intent ourstructure = new Intent(HomeActivity.this,Structure.class);
//                        startActivity(ourstructure);
//                        break;
//                    case 3:
//                        Intent sanjiwani = new Intent(HomeActivity.this,Sanjiwani_Club.class);
//                        startActivity(sanjiwani);
//                        break;
//                    case 4:
//                        Intent faq = new Intent(HomeActivity.this,FAQ_activity.class);
//                        startActivity(faq);
//                        break;
//                    case 5:
//                        Intent contact = new Intent(HomeActivity.this,Contact_info.class);
//                        startActivity(contact);
//                        break;
//                }
//                return false;
//            }
//        });
    }
//    private void prepareListData() {
//        listDataHeader = new ArrayList<ExpandedMenuModel>();
//        listDataChild = new HashMap<ExpandedMenuModel, List<String>>();
//
//        ExpandedMenuModel item1 = new ExpandedMenuModel();
//        item1.setIconName("About iFocus");
//        item1.setIconImg(R.drawable.app_icon);
//        // Adding data header
//        listDataHeader.add(item1);
//
//        ExpandedMenuModel item2 = new ExpandedMenuModel();
//        item2.setIconName("Pledge Declaration");
//        item2.setIconImg(R.drawable.app_icon);
//        listDataHeader.add(item2);
//
//        ExpandedMenuModel item3 = new ExpandedMenuModel();
//        item3.setIconName("Our Structure");
//        item3.setIconImg(R.drawable.app_icon);
//        listDataHeader.add(item3);
//
//        ExpandedMenuModel item4 = new ExpandedMenuModel();
//        item4.setIconName("Sanjiwani Club");
//        item4.setIconImg(R.drawable.app_icon);
//        listDataHeader.add(item4);
//
//        ExpandedMenuModel item5 = new ExpandedMenuModel();
//        item5.setIconName("FAQ's");
//        item5.setIconImg(R.drawable.app_icon);
//        listDataHeader.add(item5);
//
//        ExpandedMenuModel item6 = new ExpandedMenuModel();
//        item6.setIconName("Contact");
//        item6.setIconImg(R.drawable.app_icon);
//        listDataHeader.add(item6);
//
//        ExpandedMenuModel item7 = new ExpandedMenuModel();
//        item7.setIconName("Send Enquiry");
//        item7.setIconImg(R.drawable.app_icon);
//        listDataHeader.add(item7);
//
//
//        // Adding child data
//        List<String> aboutifocus = new ArrayList<String>();
//        aboutifocus.add("About Mission");
//        aboutifocus.add("Events");
//
//        List<String> pledge = new ArrayList<String>();
//
//        List<String> structure = new ArrayList<String>();
//
//        List<String> sanjiwani = new ArrayList<String>();
//
//        List<String> fqas = new ArrayList<String>();
//
//        List<String> contact = new ArrayList<String>();
//
//        List<String> sendenq = new ArrayList<String>();
//        sendenq.add("General Enquiry");
//        sendenq.add("Business Enquiry");
//
//        listDataChild.put(listDataHeader.get(0), aboutifocus);// Header, Child data
//        listDataChild.put(listDataHeader.get(1), pledge);
//        listDataChild.put(listDataHeader.get(2), structure);
//        listDataChild.put(listDataHeader.get(3), sanjiwani);
//        listDataChild.put(listDataHeader.get(4), fqas);
//        listDataChild.put(listDataHeader.get(5), contact);
//        listDataChild.put(listDataHeader.get(6), sendenq);
//
//    }

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
