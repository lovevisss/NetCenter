package com.example.administrator.netcenter.activity.AddActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.netcenter.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Switch extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listview;

    private ArrayList<Map<String, Object>> switch_list;
    private SimpleAdapter simpleAdapter;
    private String[] type = {"24口交换机","48口交换机","48口POE交换机"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
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
        listview = (ListView) findViewById(R.id.switch_lv);
        switch_list = new ArrayList<Map<String, Object>>();
        getData();
        simpleAdapter = new SimpleAdapter(this,switch_list,R.layout.additem_layout,new String[]{"image","text"},new int[]{R.id.addIV,R.id.addTV});
        listview.setAdapter(simpleAdapter);
        listview.setOnItemClickListener(this);
    }

    private List<Map<String,Object>> getData() {
        for(int i = 0 ; i < type.length; i++)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("image", R.drawable.settings);
            map.put("text", type[i]);
            switch_list.add(map);
        }
        return switch_list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Log.e("click", "ed");
        Intent i = new Intent();
        String detail;
        switch (position)
        {
            case 0://PC
                Log.e("e","24");
                detail = type[0];
                break;
            case 1: //交换机
                Log.e("e","48");
                detail = type[1];
                break;
            case 2://server
                Log.e("e","48poe");
                detail = type[2];
                break;
            default:
                detail = type[2];
                break;
        }
        i.putExtra("typedetail",detail);
        Switch.this.setResult(1, i);
        Switch.this.finish();


    }
}
