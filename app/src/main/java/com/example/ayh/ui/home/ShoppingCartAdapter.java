package com.example.ayh.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.ayh.R;

import java.util.List;

public class ShoppingCartAdapter extends BaseAdapter {
    private List<MyMenu> myMenuList;
    private Context context;
    TextView textView2;
    ImageView imageView_subtract;

    public ShoppingCartAdapter(List<MyMenu> myMenuList, Context context) {
        this.myMenuList = myMenuList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return myMenuList.size();
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
        final int i = position;
        convertView = LayoutInflater.from(context).inflate(R.layout.shopping_cart_layout, null);
        TextView textView = convertView.findViewById(R.id.tv_menuName);
        TextView textView1 = convertView.findViewById(R.id.tv_menuTotalPrice);
        textView2 = convertView.findViewById(R.id.tv_number);
        ImageView imageView_add = convertView.findViewById(R.id.iv_add);
        imageView_subtract = convertView.findViewById(R.id.iv_subtract);

        textView.setText(myMenuList.get(position).getName());
        textView1.setText(String.format("%-7.2f", Float.parseFloat(myMenuList.get(position).getPrice()) * Integer.parseInt(myMenuList.get(i).getNumber())) + "");
        textView2.setText(myMenuList.get(position).getNumber());

        if ((myMenuList.get(position).getNumber()).equals("0")) {
            textView2.setText("");
        } else {
            textView2.setText(myMenuList.get(position).getNumber());
        }
        if ((myMenuList.get(position).getIfNeedSubtract()) == 1) {
            imageView_subtract.setImageResource(R.drawable.icon_substarct);
        }

        imageView_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myMenuList.get(i).setNumber(Integer.parseInt(myMenuList.get(i).getNumber()) + 1 + "");
                myMenuList.get(i).setIfNeedSubtract(1);
                notifyDataSetChanged();
                if (total(myMenuList) > 0) {
                    if (total(myMenuList) >= Float.parseFloat(ShoperActivity.startSendPrice)) {
                        ShoperActivity.tv_pay.setText("去结算");
                        ShoperActivity.tv_pay.setBackground(v.getResources().getDrawable(R.drawable.background9));
                        ShoperActivity.tv_pay.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor4));
                    } else {
                        ShoperActivity.tv_pay.setText("还差" + String.format("%-5.2f", (Float.parseFloat(ShoperActivity.startSendPrice) - total(myMenuList))) + "起送");
                    }
                    ShoperActivity.tv_needMoney.setText("¥" + String.format("%-7.2f", total(myMenuList)));
                    ShoperActivity.tv_needMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                    ShoperActivity.iv_pay.setImageDrawable(v.getResources().getDrawable(R.drawable.icon_shoped));
                    ShoperActivity.tv_title_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                    ShoperActivity.tv_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                }
                ShoperActivity.mymenuAdapyer.notifyDataSetChanged();
            }
        });
        imageView_subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(myMenuList.get(i).getNumber()) > 0) {
                    myMenuList.get(i).setNumber(Integer.parseInt(myMenuList.get(i).getNumber()) - 1 + "");
                    if ((myMenuList.get(i).getNumber()).equals("0")) {
                        imageView_subtract.setImageResource(R.drawable.icon_blank);
                        myMenuList.get(i).setIfNeedSubtract(0);
                    } else {
                        myMenuList.get(i).setIfNeedSubtract(1);
                    }
                    if (total(myMenuList) > 0 && total(myMenuList) < Float.parseFloat(ShoperActivity.startSendPrice)) {
                        ShoperActivity.tv_needMoney.setText("¥" + String.format("%-7.2f", total(myMenuList)));
                        ShoperActivity.tv_needMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                        ShoperActivity.iv_pay.setImageDrawable(v.getResources().getDrawable(R.drawable.icon_shoped));
                        ShoperActivity.tv_pay.setText("还差" + String.format("%-5.2f", (Float.parseFloat(ShoperActivity.startSendPrice) - total(myMenuList))) + "起送");
                        ShoperActivity.tv_pay.setBackground(v.getResources().getDrawable(R.drawable.background18));
                        ShoperActivity.tv_pay.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor5));
                        ShoperActivity.tv_title_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                        ShoperActivity.tv_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                    }
                    if (total(myMenuList) >= Float.parseFloat(ShoperActivity.startSendPrice)) {
                        ShoperActivity.tv_needMoney.setText("¥" + String.format("%-7.2f", total(myMenuList)));
                        ShoperActivity.tv_needMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                        ShoperActivity.iv_pay.setImageDrawable(v.getResources().getDrawable(R.drawable.icon_shoped));
                        ShoperActivity.tv_pay.setText("去结算");
                        ShoperActivity.tv_pay.setBackground(v.getResources().getDrawable(R.drawable.background9));
                        ShoperActivity.tv_pay.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor4));
                        ShoperActivity.tv_title_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                        ShoperActivity.tv_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background10));
                    }
                    if (total(myMenuList) == 0) {
                        ShoperActivity.tv_needMoney.setText("未选购商品");
                        ShoperActivity.tv_needMoney.setBackground(v.getResources().getDrawable(R.drawable.background11));
                        ShoperActivity.iv_pay.setImageDrawable(v.getResources().getDrawable(R.drawable.icon_unshop));
                        ShoperActivity.tv_pay.setText("¥" + ShoperActivity.startSendPrice + "起送");
                        ShoperActivity.tv_pay.setBackground(v.getResources().getDrawable(R.drawable.background18));
                        ShoperActivity.tv_pay.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor5));
                        ShoperActivity.tv_title_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background11));
                        ShoperActivity.tv_needSendMoney.setBackground(v.getResources().getDrawable(R.drawable.background11));
                    }
                    notifyDataSetChanged();
                }
                ShoperActivity.mymenuAdapyer.notifyDataSetChanged();
                ShoperActivity.myMenuList2.clear();
                for (MyMenu item : ShoperActivity.myMenuList) {
                    if (Integer.parseInt(item.getNumber()) != 0) {
                        ShoperActivity.myMenuList2.add(item);
                    }
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

    public float total(List<MyMenu> myMenuList) {
        float sum = 0;
        for (int i = 0; i < myMenuList.size(); i++) {
            sum += Float.parseFloat(myMenuList.get(i).getNumber()) * Float.parseFloat(myMenuList.get(i).getPrice());
        }
        return sum;
    }
}
