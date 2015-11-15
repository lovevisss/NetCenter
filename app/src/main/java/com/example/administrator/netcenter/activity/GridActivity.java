package com.example.administrator.netcenter.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.administrator.netcenter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@EActivity(R.layout.activity_grid)
public class GridActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_grid);

    }

    @ViewById(R.id.gridView)
    GridView gridView;
    private List<Map<String,Object>> datalist;
    private int[] icon = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera,R.drawable.clock,R.drawable.world,R.drawable.messenger,R.drawable.ringtone,R.drawable.settings,R.drawable.weather,R.drawable.youtube,R.drawable.speech_balloon,R.drawable.games_control};
    private String[] iconName = {"通讯录","日历","照相机","时钟","浏览器","短信","铃声","设置","天气","视频","语音","游戏"};
    private SimpleAdapter adapter;
    @AfterViews
    void init()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle(R.string.serverList);
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
        
        datalist = new ArrayList<Map<String,Object>>();
        getData();
        adapter = new SimpleAdapter(this,datalist,R.layout.griditem,new String[]{"image","text"},new int[]{R.id.gridItem_image,R.id.gridItem_txt});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
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
        Toast.makeText(this, "this is " + iconName[position],Toast.LENGTH_SHORT).show();
    }
}
