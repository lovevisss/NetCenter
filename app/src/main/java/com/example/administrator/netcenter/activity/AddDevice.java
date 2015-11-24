package com.example.administrator.netcenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.netcenter.R;
import com.example.administrator.netcenter.activity.AddActivity.AccountPwd;
import com.example.administrator.netcenter.activity.AddActivity.Descripiton;
import com.example.administrator.netcenter.activity.AddActivity.DeviceType;
import com.example.administrator.netcenter.activity.AddActivity.IP_address;
import com.example.administrator.netcenter.activity.AddActivity.Operating_System;
import com.example.administrator.netcenter.activity.AddActivity.Operating_System_;
import com.example.administrator.netcenter.activity.AddActivity.Position;
import com.example.administrator.netcenter.activity.AddActivity.Position_;
import com.example.administrator.netcenter.activity.AddActivity.Unit;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_add_device)
public class AddDevice extends AppCompatActivity {

    @ViewById(R.id.desc_tv)
    TextView desc_tv;
    @ViewById
    TextView ip_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_add_device);

    }

    @AfterViews
    void init()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.in_from_right, R.anim.out_of_left);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Click({R.id.Ltype,R.id.Ldesc,R.id.LAccount,R.id.LIP,R.id.LOp,R.id.LPosition,R.id.LUnit})
    void openActivity(View bn)
    {
        Intent i;
        switch (bn.getId())
        {
            case R.id.Ltype:
                i = new Intent(this, DeviceType.class);
                break;
            case R.id.Ldesc:
                i = new Intent(this, Descripiton.class);
                break;
            case R.id.LPosition:
                i = new Intent(this, Position_.class);
                break;
            case R.id.LAccount:
                i = new Intent(this, AccountPwd.class);
                break;
            case R.id.LIP:
                i = new Intent(this, IP_address.class);
                break;
            case R.id.LUnit:
                i = new Intent(this, Unit.class);
                break;
            case R.id.LOp:
                i = new Intent(this, Operating_System_.class);
                break;
            default:
                i = new Intent(this, DeviceType.class);
                break;

        }

        setIntentExtra(i);
        startActivityForResult(i, 1);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_of_left);
    }

    private void setIntentExtra(Intent i) {
        i.putExtra("desc",desc_tv.getText());
        i.putExtra("IP",ip_tv.getText());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

//        String result = data.getExtras().getString("result");
        String desc,ip;
//        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode)
        {
            case 1://描述
                desc = data.getExtras().getString("desc");
//                Log.e("desc+return",desc);
                desc_tv.setText(desc);
                break;
            case 2://ip地址
                ip = data.getExtras().getString("IP");
                ip_tv.setText(ip);

        }
    }
}
