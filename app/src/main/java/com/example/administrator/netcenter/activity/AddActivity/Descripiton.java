package com.example.administrator.netcenter.activity.AddActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.netcenter.R;

public class Descripiton extends AppCompatActivity {
    private EditText ev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripiton);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ev = (EditText) findViewById(R.id.desc_ev);
        Intent i =getIntent();
        ev.setText(i.getExtras().getString("desc"));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_desc);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String desc = ev.getText().toString();
                if(desc == "")
                {
                    Toast.makeText(getApplicationContext(),"内容不能为空",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra("desc",desc);
                    Descripiton.this.setResult(1, intent);
                    Descripiton.this.finish();
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

}
