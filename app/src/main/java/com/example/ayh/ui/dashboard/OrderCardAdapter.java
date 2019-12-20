package com.example.ayh.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ayh.R;
import com.example.ayh.ui.home.Bill;

import java.util.List;

public class OrderCardAdapter extends ArrayAdapter<OrderCardItem> implements View.OnClickListener {

    Context mContex;
    private int resourceId;
    private CallBack mCallBack;


    public interface CallBack {
        public void click(View v);
        public void clickWithPosition(View v, int position);
    }

    public OrderCardAdapter(Context context, int textViewResourceId,
                              List<OrderCardItem> objects, CallBack callback) {
        super(context, textViewResourceId, objects);

        mContex = context;
        resourceId = textViewResourceId;
        mCallBack = callback;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int mPostion = position;

        OrderCardItem oci = getItem(position);

        View view;
        if( convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        } else {
            view = convertView;
        }


        ImageView shopImg = view.findViewById(R.id.shop_Img);
        TextView shopName = view.findViewById(R.id.shopName_Text);
        TextView orderTime = view.findViewById(R.id.orderTime_Text);
        TextView orderHasGet = view.findViewById(R.id.orderHasGet_Text);
        TextView goodsNmae = view.findViewById(R.id.goodName_Text);
        TextView price = view.findViewById(R.id.price_Text);

        LinearLayout linearLayout = view.findViewById(R.id.LinearLayout_1);

        shopImg.setImageResource(oci.getShopImgId());
        shopName.setText(oci.getShopName());
        orderTime.setText(oci.getOrderTime() + "");
        orderHasGet.setText(oci.getHasGet());
        goodsNmae.setText(oci.getGoods());
        price.setText(oci.getPrice());


        Button oneMoreBtn = view.findViewById(R.id.oneMore_btn);
        linearLayout.setOnClickListener(this);



        oneMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.clickWithPosition(v,mPostion);
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        mCallBack.click(v);
    }
}
