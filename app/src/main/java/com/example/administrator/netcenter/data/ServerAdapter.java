package com.example.administrator.netcenter.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.netcenter.R;

import java.util.ArrayList;

public class ServerAdapter extends BaseAdapter {
	ArrayList<ServerData> serverDatas_list;
	LayoutInflater inflater;

	public ServerAdapter(Context context, ArrayList<ServerData> serverDatas_list) {
		this.serverDatas_list = serverDatas_list;
		this.inflater = LayoutInflater.from(context);
	}

	public void onDateChange(ArrayList<ServerData> apk_list) {
		this.serverDatas_list = apk_list;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return serverDatas_list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return serverDatas_list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ServerData entity = serverDatas_list.get(position);
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.item_layout, null);
			holder.ip_tv = (TextView) convertView
					.findViewById(R.id.item3_ipaddr);
			holder.des_tv = (TextView) convertView
					.findViewById(R.id.item3_desc);
			holder.optype_tv = (TextView) convertView
					.findViewById(R.id.item3_optype);
			holder.pos_tv = (TextView) convertView.findViewById(R.id.item3_position);
			holder.unit_tv = (TextView) convertView.findViewById(R.id.item3_unit);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		int[] i = entity.getIp();
		String s = i[0]+ "."+ i[1]+"."+i[2]+"."+i[3];
		holder.ip_tv.setText(s);
		holder.des_tv.setText(entity.getDesc());
		String temp="centOS";
		holder.optype_tv.setText(temp);
		holder.pos_tv.setText(entity.getPosition());
		holder.unit_tv.setText(entity.getUnit());
		return convertView;
	}

	class ViewHolder {
		TextView ip_tv;
		TextView des_tv;
		TextView optype_tv;
		TextView pos_tv;
		TextView unit_tv;
	}
}
