package com.example.ayh.ui.dashboard;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayh.R;

import java.util.List;

public class KeyValue2Adapter extends RecyclerView.Adapter<KeyValue2Adapter.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;




    private Context mContext;
    private int resourceId;
    private List<KeyValue_item> dataList;




    public KeyValue2Adapter(Context context, int resourceId,List<KeyValue_item> dataList) {
        this.mContext = context;
        this.resourceId = resourceId;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(mContext).inflate(resourceId,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KeyValue_item kvi= dataList.get(position);

        if(position == 0) {
            TextPaint tp = holder.key.getPaint();
            tp.setFakeBoldText(true);
            holder.key.setTextSize(12);
        }
        holder.key.setText(kvi.getKey());
        holder.value.setText(kvi.getValue());

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView key;
        TextView value;


        public ViewHolder(View itemView) {
            super(itemView);

            key = itemView.findViewById(R.id.key_Text2);
            value = itemView.findViewById(R.id.value_Text2);


        }
    }

}
