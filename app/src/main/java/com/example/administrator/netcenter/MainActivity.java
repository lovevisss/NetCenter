package com.example.administrator.netcenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;
import com.example.administrator.netcenter.activity.GridActivity_;
import com.example.administrator.netcenter.activity.ServerList_;
import com.example.administrator.netcenter.utility.pinghost;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String[] brandName = {"Dell","Hp","IBM","Cisco"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AVOSCloud.initialize(this, "hB7FtkSMGhmKERlUA20C9VHW", "CpLSC6509RSaA0Nq5Fc1lpPc");
        AVAnalytics.trackAppOpened(getIntent());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camara) {
            Intent i = new Intent(this, ServerList_.class);
            startActivity(i);
            overridePendingTransition(R.anim.in_from_right, 0);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(this, GridActivity_.class);
            startActivity(i);
            overridePendingTransition(R.anim.in_from_right, 0);

        } else if (id == R.id.nav_slideshow) {

            String re = pinghost.pingHost("10.4.80.2");
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {  //添加设备
            Intent i = new Intent(this, GridActivity_.class);
            startActivity(i);
            overridePendingTransition(R.anim.in_from_right, 0);



        } else if (id == R.id.nav_send) {
//            testAvO();
//            readAvo();
//            changeAv0();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void testAvO() {
        Log.e("foo", "bar");
        AVObject testObj = new AVObject("Device");
        testObj.put("brand",brandName);
        testObj.saveInBackground();
    }

    private void readAvo(){
        Log.e("foo", "bar");
        AVQuery<AVObject> query = new AVQuery<AVObject>("Server_brand");
        query.whereExists("brand");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if(e == null)
                {
                    ArrayList<String> s = (ArrayList<String>) list.get(0).get("brand");
                    Log.d("success",s.get(0));
                }
                else
                {
                    Log.d("fail","exists");
                }
            }
        });
    }


    private void changeAv0()
    {
        Log.e("foo", "bar");
        AVQuery<AVObject> query = new AVQuery<AVObject>("Server_brand");
        AVObject brand;
        query.getInBackground("5656ab1e00b0ec3faa41044c", new GetCallback<AVObject>() {
            public void done(AVObject brand, AVException e) {
                if (e == null) {
                    ArrayList<String> s = (ArrayList<String>) brand.get("brand");
                    s.add("Sangfor");
                    brand.put("brand", s);
                    brand.saveInBackground();
                } else {
                    Log.e("获取微博", "错误: " + e.getMessage());
                }
            }
        });


    }

}
