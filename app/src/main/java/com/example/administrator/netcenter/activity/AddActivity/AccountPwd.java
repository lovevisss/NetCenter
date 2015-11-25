package com.example.administrator.netcenter.activity.AddActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.administrator.netcenter.R;

public class AccountPwd extends AppCompatActivity {
    private EditText account_tv,pwd_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_pwd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        account_tv = (EditText) findViewById(R.id.account_EditView);
        pwd_tv = (EditText) findViewById(R.id.pwd_EditView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account,pwd;
                account = account_tv.getText().toString();
                pwd = pwd_tv.getText().toString();
                if(account!=null && pwd != null)
                {
                    Intent i = new Intent();
                    i.putExtra("account", account);
                    i.putExtra("pwd",pwd);
                    AccountPwd.this.setResult(3, i);
                    AccountPwd.this.finish();
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
