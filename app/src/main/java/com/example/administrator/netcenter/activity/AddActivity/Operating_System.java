package com.example.administrator.netcenter.activity.AddActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.administrator.netcenter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
@EActivity(R.layout.activity_operating__system)
public class Operating_System extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private List<String> list;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_operating__system);

    }
    @ViewById(R.id.optype_spinner)
    Spinner spinner;

    @AfterViews
    void init()
    {
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list = new ArrayList<String>();
        list.add("Windows 2003");
        list.add("Windows 2008");
        list.add("centOS");
        list.add("Windows XP");
        list.add("Windows 7");
        list.add("Windows 8");
        list.add("Windows 10");
        list.add("RedHat");
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String os = list.get(position);
        Intent i = new Intent();
        i.putExtra("os", os);
        Operating_System.this.setResult(5, i);
        Operating_System.this.finish();

    }
}
