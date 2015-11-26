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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server_type extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView serverlist;
    private String[][] typeAll = {{"R720"},{"DL380G8,DL388G7"},{"x3650,x3650M3,xServies346,x240,x340"},{"C220M3"}};
    private String[] typeSpe;
    private List<Map<String,Object>> datalist;
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_type);
        int i = Integer.parseInt(getIntent().getExtras().getString("index"));
        typeSpe = typeAll[i];
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

        serverlist = (ListView) findViewById(R.id.ServerList_lv);
        datalist = new ArrayList<Map<String, Object>>();
        adapter = new SimpleAdapter(this,datalist,R.layout.additem_layout,new String[]{"image","text"},new int[]{R.id.addIV,R.id.addTV});
        serverlist.setAdapter(adapter);
        serverlist.setOnItemClickListener(this);
        getData();


    }
    private List<Map<String,Object>> getData() {
        for(int i = 0 ; i < typeSpe.length; i++)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("image", R.drawable.settings);
            map.put("text", typeSpe[i]);
            datalist.add(map);
        }
        return datalist;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("click", "ed");
        Intent i = new Intent();
        String detail;
        switch (position)
        {
            case 0://PC
                Log.e("e","24");
                detail = typeSpe[0];
                break;
            case 1: //交换机
                Log.e("e","48");
                detail = typeSpe[1];
                break;
            case 2://server
                Log.e("e","48poe");
                detail = typeSpe[2];
                break;
            default:
                detail = typeSpe[2];
                break;
        }
        i.putExtra("typedetail",detail);
        Server_type.this.setResult(1, i);
        Server_type.this.finish();
    }
}
