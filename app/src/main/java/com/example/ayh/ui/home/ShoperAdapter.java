package com.example.ayh.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.ayh.R;

import java.util.List;

public class ShoperAdapter extends BaseAdapter {
    List<Shoper> shoperList;
    Context context;

    public ShoperAdapter(List<Shoper> shoperList, Context context) {
        this.shoperList = shoperList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return shoperList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.shoper_style1_layout, null);
        ImageView iv_shoper_image = convertView.findViewById(R.id.iv_shoper_image);
        TextView tv_shoper_shopName = convertView.findViewById(R.id.tv_shoper_shopName);
        TextView tv_shoper_remark = convertView.findViewById(R.id.tv_shoper_remark);
        TextView tv_shoper_sellnumber = convertView.findViewById(R.id.tv_shoper_sellnumber);
        TextView tv_shoper_startSendPrice = convertView.findViewById(R.id.tv_shoper_startSendPrice);
        TextView tv_shoper_sendPrice = convertView.findViewById(R.id.tv_shoper_sendPrice);
        TextView tv_shoper_distance = convertView.findViewById(R.id.tv_shoper_distance);
        TextView tv_shoper_time = convertView.findViewById(R.id.tv_shoper_time);
        TextView tv_shoper_personalizadSignature = convertView.findViewById(R.id.tv_shoper_personalizadSignature);
        TextView tv_shoper_label1 = convertView.findViewById(R.id.tv_shoper_label1);
        TextView tv_shoper_label2 = convertView.findViewById(R.id.tv_shoper_label2);
        TextView tv_shoper_label3 = convertView.findViewById(R.id.tv_shoper_label3);
        TextView tv_shoper_label4 = convertView.findViewById(R.id.tv_shoper_label4);
        TextView tv_shoper_label5 = convertView.findViewById(R.id.tv_shoper_label5);
        iv_shoper_image.setImageResource(shoperList.get(position).getImage());
        tv_shoper_shopName.setText(shoperList.get(position).getShopName());
        tv_shoper_remark.setText(shoperList.get(position).getRemark());
        tv_shoper_sellnumber.setText(shoperList.get(position).getSellNumber());
        tv_shoper_startSendPrice.setText(shoperList.get(position).getStartSendPrice());
        tv_shoper_sendPrice.setText(shoperList.get(position).getSendPrice());
        tv_shoper_distance.setText(shoperList.get(position).getDistance());
        tv_shoper_time.setText(shoperList.get(position).getNeedTime());
        tv_shoper_personalizadSignature.setText(shoperList.get(position).getPersonalizadSignature());
        tv_shoper_label1.setText(shoperList.get(position).getLabel1());
        tv_shoper_label2.setText(shoperList.get(position).getLabel2());
        tv_shoper_label3.setText(shoperList.get(position).getLabel3());
        tv_shoper_label4.setText(shoperList.get(position).getLabel4());
        tv_shoper_label5.setText(shoperList.get(position).getLabel5());
        return convertView;
    }
}
