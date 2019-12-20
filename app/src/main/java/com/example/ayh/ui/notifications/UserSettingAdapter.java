package com.example.ayh.ui.notifications;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ayh.R;

import java.util.List;

public class UserSettingAdapter extends ArrayAdapter<UserSettingList> {

    private int resourceId;
    private Context mContex;

    public UserSettingAdapter(Context context, int textViewResourceId,
                              List<UserSettingList> objects) {
        super(context, textViewResourceId, objects);

        mContex = context;

        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        UserSettingList usl = getItem(position);

        View view;
        if( convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        } else {
            view = convertView;
        }

        ImageView iconImage = view.findViewById(R.id.icon_ImageView);
        TextView text = view.findViewById(R.id.TextView);
        TextView text2 = view.findViewById(R.id.pic_TextView);
        ImageView headerImage = view.findViewById(R.id.headerImg);
        iconImage.setImageResource(usl.getIconId());

        //headerImage.setImageResource(usl.getHeader());

        text.setText(usl.getName());
        text2.setText(usl.getInfo());

        if(usl.getInfo() != null && usl.getInfo().equals("未绑定 >")) {
            text2.setTextColor(mContex.getResources().getColor(R.color.blue));
        }


        return view;
    }




}
