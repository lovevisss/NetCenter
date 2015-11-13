package com.example.administrator.netcenter.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.netcenter.R;
import com.example.administrator.netcenter.data.ServerAdapter;
import com.example.administrator.netcenter.data.ServerData;
import com.example.administrator.netcenter.utility.ReFreshListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;

@EActivity(R.layout.activity_server_list)
public class ServerList extends AppCompatActivity implements ReFreshListView.IReflashListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    ArrayList<ServerData> server_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_server_list);

    }

    @AfterViews
    void initServerlist(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.serverList);   //not working
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
        setData();
        showList(server_list);
    }

    ServerAdapter adapter;
    ReFreshListView listview;
    private void showList(ArrayList<ServerData> server_list) {

        if (adapter == null) {
            listview = (ReFreshListView) findViewById(R.id.ServerList_lv);
            listview.setInterface(this);
            adapter = new ServerAdapter(this, server_list);
            listview.setAdapter(adapter);
            listview.setOnItemClickListener(this);
            listview.setOnScrollListener(this);
        } else {
            adapter.onDateChange(server_list);
        }
    }

    private void setData() {
        server_list = new ArrayList<ServerData>();
        for (int i = 0; i < 10; i++) {
            ServerData entity = new ServerData();
            entity.setDesc("大金融实验室");
            int[] ip = {10,1,16,23};
            entity.setIp(ip);
            entity.setOptype(1);
            entity.setPosition("B-2-1");
            entity.setUnit("金融分院");
            server_list.add(entity);
        }

    }


    @Override
    public void onReflash() {
        Log.e("reflash called", "");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                //获取最新数据
                setReflashData();
                //通知界面显示
                showList(server_list);
                //通知listview 刷新数据完毕；
                listview.reflashComplete();
            }
        }, 2000);
    }

    private void setReflashData() {
        for (int i = 0; i < 2; i++) {
            ServerData entity = new ServerData();
            entity.setDesc("大金融实验室");
            int[] ip = {10,1,16,23};
            entity.setIp(ip);
            entity.setOptype(1);
            entity.setPosition("B-2-1");
            entity.setUnit("金融分院");
            server_list.add(entity);
        }
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = listview.getItemAtPosition(position)+ "";
        Toast.makeText(this, "position:" + position + "text:" + text,Toast.LENGTH_SHORT).show();
    }
}
