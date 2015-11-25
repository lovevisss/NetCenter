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

public class Unit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText unit_et = (EditText) findViewById(R.id.unit_EditView);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unit = unit_et.getText().toString();
                if(unit != "")
                {
                    Intent i = new Intent();
                    i.putExtra("unit",unit);
                    Unit.this.setResult(6, i);
                    Unit.this.finish();
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
