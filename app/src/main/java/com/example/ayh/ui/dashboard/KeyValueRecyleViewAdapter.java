package com.example.ayh.ui.dashboard;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayh.R;

import java.util.List;

public class KeyValueRecyleViewAdapter extends RecyclerView.Adapter<KeyValueRecyleViewAdapter.ViewHolder> {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;


    private View myHeaderView;


    private Context mContext;
    private int resourceId;
    private List<KeyValue_item> dataList;


    public void setHeaderView(View myHeaderView) {
        this.myHeaderView = myHeaderView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return myHeaderView;
    }

    public int getItemViewType(int position) {
        if(myHeaderView == null) return TYPE_NORMAL;
        if(position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }


    public KeyValueRecyleViewAdapter(Context context, int resourceId,List<KeyValue_item> dataList) {
        this.mContext = context;
        this.resourceId = resourceId;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(myHeaderView != null && viewType == TYPE_HEADER) return new ViewHolder(myHeaderView);

        View view = LayoutInflater.from(mContext).inflate(resourceId,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KeyValue_item kvi= dataList.get(position);

        if(position > 1) {
            holder.value.setTextColor(Color.parseColor("#EB5941"));
        }
        holder.imgView.setImageResource(kvi.getImgId());
        holder.key.setText(kvi.getKey());
        holder.num.setText(kvi.getNum());
        holder.value.setText(kvi.getValue());

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgView;
        TextView key;
        TextView num;
        TextView value;


        public ViewHolder(View itemView) {
            super(itemView);
            if (itemView == myHeaderView) return;

            imgView = itemView.findViewById(R.id.header_Img);
            key = itemView.findViewById(R.id.key_Text);
            num = itemView.findViewById(R.id.num_Text);
            value = itemView.findViewById(R.id.value_Text);


        }
    }

}
