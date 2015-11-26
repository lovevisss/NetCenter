package com.example.administrator.netcenter.activity.AddActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.netcenter.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server_brand extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView brandlist;
    private String[] brandName = {"Dell","Hp","IBM","Cisco"};
    private List<Map<String,Object>> datalist;
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_1);
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
        brandlist = (ListView) findViewById(R.id.brand_lv);
        datalist = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(this,datalist,R.layout.additem_layout,new String[]{"image","text"},new int[]{R.id.addIV,R.id.addTV});
        brandlist.setAdapter(adapter);
        brandlist.setOnItemClickListener(this);
        getData();
        
    }

    private void getData() {
        for(int i = 0 ; i < brandName.length; i++)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("image", R.drawable.clock);
            map.put("text", brandName[i]);
            datalist.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getApplication(),Server_type.class);
        i.putExtra("index",position);
        startActivityForResult(i,position);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_of_left);
    }
}
