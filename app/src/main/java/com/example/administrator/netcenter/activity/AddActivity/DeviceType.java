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

public class DeviceType extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private int[] icon = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera,R.drawable.games_control};
    private String[] iconName = {"PC","交换机","服务器","无线AP"};
    private List<Map<String,Object>> datalist;
    private SimpleAdapter adapter;
    private ListView listview;
    private String type,typedetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_type);
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
        listview = (ListView) findViewById(R.id.devtype_lv);
        datalist = new ArrayList<Map<String,Object>>();
        adapter = new SimpleAdapter(this,datalist,R.layout.additem_layout,new String[]{"image","text"},new int[]{R.id.addIV,R.id.addTV});
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        getData();
    }

    private List<Map<String,Object>> getData() {
        for(int i = 0 ; i < icon.length; i++)
        {
            Map<String,Object> map = new HashMap<>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            datalist.add(map);
        }
        return datalist;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("click","ed");
        Intent i;
        switch (position)
        {
            case 0://PC
                i = new Intent(getApplication(),PC.class);
                type = "PC";
                break;
            case 1: //交换机
                i = new Intent(getApplication(),Switch.class);
                type = "交换机";
                break;
            case 2://server
                i = new Intent(getApplication(),Server_brand.class);
                type = "服务器";
                break;
            case 3://无线ap
                i = new Intent(getApplication(), AP.class);
                type = "无线ap";
                break;
            default:
                i = new Intent(getApplication(),Switch.class);
                break;
        }
        startActivityForResult(i,1);
        overridePendingTransition(R.anim.in_from_right, R.anim.out_of_left);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (resultCode)
        {
            case 1:
                typedetail = data.getExtras().getString("typedetail");
                break;
        }

        Intent i = new Intent();
        i.putExtra("typedetail",typedetail);
        i.putExtra("type",type);
        DeviceType.this.setResult(0, i);
        DeviceType.this.finish();
    }
}
