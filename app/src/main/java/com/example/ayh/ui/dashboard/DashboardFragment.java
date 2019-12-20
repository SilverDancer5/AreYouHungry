package com.example.ayh.ui.dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ayh.R;
import com.example.ayh.ui.home.Bill;
import com.example.ayh.ui.home.Database;
import com.example.ayh.ui.home.MyMenu;
import com.example.ayh.ui.home.Shoper;
import com.example.ayh.ui.home.ShoperAdapter;
import com.example.ayh.ui.notifications.Collection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DashboardFragment extends Fragment implements AdapterView.OnItemClickListener, OrderCardAdapter.CallBack {


    TextView showMoreOrder;
    Boolean isScrollable = true;


    String goodName_1;
    String shopName_1;
    String totalPrice_1;

    private List<OrderCardItem> orderList = new ArrayList<>();
    private Database database;

    List<Bill> billList = new ArrayList<>();


    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        database = new Database(root.getContext(), "SHOP.DB", null, 1);

        root.setBackgroundColor(root.getResources().getColor(R.color.whitegray));
        this.getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.whitegray));

        initOrderList();
        final OrderCardAdapter adapter = new OrderCardAdapter(this.getActivity(), R.layout.cardview, orderList, this);




        ListView listView = root.findViewById(R.id.orderList_ListView);


        TextView tv1 = new TextView(root.getContext());
        tv1.setText("我的订单");
        tv1.setTextColor(root.getResources().getColor(R.color.black));
        tv1.setTextSize(20);
        tv1.setPadding(50, 2, 0, 2);
        listView.addHeaderView(tv1);
        listView.setAdapter(adapter);

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return isScrollable;
                //return true;
            }
        });

//        listView.setOnItemClickListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("item", "listview中" + position);
            }
        });


        showMoreOrder = root.findViewById(R.id.showMoreOrder_Text);
        showMoreOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /**
                 * hym
                 */

                //TODO !!!!
                isScrollable = false;

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
                Date date = new Date(System.currentTimeMillis());


                int orderNum = database.selectBill().size();
                if(orderNum > 1) {
                    OrderCardItem tmp = new OrderCardItem(R.drawable.clock, "3点点", simpleDateFormat.format(date) + "", "已送达", "香辣火锅", "$10.2");

                    for(int i = 1; i < orderNum; i++) {
                        getFoodList(i);
                        String goodNameTmp = getGoodsName();
                        String shopNameTmp= getShopName();
                        String totalPriceTmp = getTotalMoney();
                        tmp = new OrderCardItem(R.drawable.clock, shopNameTmp+"", simpleDateFormat.format(date) + "", "已送达", goodNameTmp+"", "￥"+ totalPriceTmp);
                        orderList.add(tmp);
                    }
//                    Collections.reverse(orderList);
                    adapter.notifyDataSetChanged();
                    showMoreOrder.setVisibility(root.INVISIBLE);
                } else {
                    Toast.makeText(root.getContext(), "没有其他订单了", Toast.LENGTH_SHORT).show();
                }






            }
        });


        return root;
    }


    private void initOrderList() {


        getFoodList(0);
        goodName_1 = getGoodsName();
        shopName_1 = getShopName();
        totalPrice_1 = getTotalMoney();


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        OrderCardItem oci1 = new OrderCardItem(R.drawable.clock, shopName_1+"", simpleDateFormat.format(date) + "", "已送达", goodName_1+"", "￥"+ totalPrice_1);

        orderList.add(oci1);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void click(View v) {
        Log.i("ListView的Item", "被点击");
    }

    @Override
    public void clickWithPosition(View v, int position) {
        Log.i("item", "listview中" + position);

        getFoodList(position);
        String goodsName = getGoodsName();
        String shopName = getShopName();
        String totalPrice = getTotalMoney();

        Log.i("goodsName", shopName + goodsName + totalPrice);

        Intent intent = new Intent(getActivity(), OneMoreOrderActivity.class);
        intent.putExtra("goodsName", goodsName);
        intent.putExtra("shopName", shopName);
        intent.putExtra("totalPrice", totalPrice);
        startActivity(intent);
    }




    public void getFoodList(int position) {
//        List<Bill> billList = new ArrayList<>();
        billList = new ArrayList<>();
        Bill bill = database.selectBill().get(position);
        int[] foodNumber = {bill.getFoodNumber1(), bill.getFoodNumber2(),
                bill.getFoodNumber3(), bill.getFoodNumber4(), bill.getFoodNumber5()};
        Shoper shoper = database.selectById(bill.getShopID()).get(0);
        int[] foodId = {shoper.getFood1(), shoper.getFood2(),
                shoper.getFood3(), shoper.getFood4(), shoper.getFood5()};
        for (int i = 0; i < 5; i++) {
            if (foodNumber[i] > 0) {
                MyMenu myMenu = database.selectMenuItem(foodId[i]);
                Bill bill1 = new Bill(myMenu.getImage(), myMenu.getName(), foodNumber[i], Float.parseFloat(myMenu.getPrice()) * foodNumber[i],shoper.getShopName());
                billList.add(bill1);
            }
        }
    }

    public String getGoodsName() {

        String goodsName = "";
        for (int i = 0; i < billList.size(); i++) {
            goodsName += billList.get(i).getFoodName();
            if(i < billList.size() - 1)  goodsName += "+";
        }
        return goodsName;
    }

    public String getShopName() {
        String shopName = "";
        shopName = billList.get(0).getShoperName();
        return shopName;
    }

    public String getTotalMoney() {
        Float totalPrice = billList.get(0).getFoodTotalMoney();

        for(int i = 1; i < billList.size(); i++) {
            totalPrice += billList.get(i).getFoodTotalMoney();
        }

        String price = totalPrice.toString();
        return price;
    }



}