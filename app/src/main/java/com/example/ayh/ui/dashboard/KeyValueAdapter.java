package com.example.ayh.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ayh.R;

import java.util.List;


public class KeyValueAdapter extends ArrayAdapter<KeyValue_item> {

    Context mContext;
    private int resourceId;


    public KeyValueAdapter(Context context, int textViewResourceId, List<KeyValue_item> objects) {
        super(context, textViewResourceId, objects);
        mContext = context;
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        KeyValue_item kvi = getItem(position);

        View view;
        if( convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        } else {
            view = convertView;
        }


        ImageView imgView = view.findViewById(R.id.header_Img);
        TextView key = view.findViewById(R.id.key_Text);
        TextView num = view.findViewById(R.id.num_Text);
        TextView value = view.findViewById(R.id.value_Text);

        imgView.setImageResource(kvi.getImgId());
        key.setText(kvi.getKey());
        num.setText(kvi.getNum());
        value.setText(kvi.getValue());

        return view;
    }
}
