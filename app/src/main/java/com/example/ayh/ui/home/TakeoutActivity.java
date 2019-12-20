package com.example.ayh.ui.home;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ayh.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TakeoutActivity extends Fragment implements MyScrollView.MyScrollViewListener, View.OnClickListener{



    private TextView tv_ifDouble12League, tv_ifBenefitLeague, tv_ifHaveDiscount, tv_ifFreeSendPrice;
    private TextView tv_ifDouble12League2, tv_ifBenefitLeague2, tv_ifHaveDiscount2, tv_ifFreeSendPrice2;
    private TextView tv_remark, tv_sellNumber, tv_distance, tv_time, tv_startPrice, tv_sendPrice;
    private TextView tv_remark2, tv_sellNumber2, tv_distance2, tv_time2, tv_startPrice2, tv_sendPrice2;
    private static int flag1 = -1, flag2 = -1, flag3 = -1, flag4 = -1, flag5 = 1, flag6 = 0, flag7 = 0, flag8 = 0, flag9 = 0, flag10 = 0;
    private EditText editText;
    private int height;
    private LinearLayout linearlayout1, linearlayout2, linearlayout_upper;
    private LinearLayout daodianziqu1, daodianziqu2, daodianziqu3;
    private MyScrollView myScrollView;
    private RelativeLayout relativeLayout_toFreeSendActivity, relativeLayout_toFreeSendActivity2, relativeLayout_toFreeSendActivity3, relativeLayout_toFreeSendActivity4;
    private LinearLayout linearlayout_1, linearlayout_2, linearlayout_3, linearlayout_4;
    private MyListView myListView;
    private Database database;
    private ShoperAdapter shoperAdapter;
    private List<Shoper> shoperList;
    private ImageView imageView_picture, imageView_picture1, imageView_picture3;
    private ImageView icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10;
    private ImageView imageView_food1, imageView_food2, imageView_food3, imageView_food4;
    private ImageView image_icon13, image_icon14, image_icon15, image_icon16;
    private int[] pictures1 = {R.drawable.picture1, R.drawable.picture2,
            R.drawable.picture3, R.drawable.picture4,
            R.drawable.picture5, R.drawable.picture6};
    private static String[] key = {"", "", "", ""};
    private int position1 = 0;
    private Timer timer;
    private TimerTask task;




    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                try {
                    imageView_picture1.setImageDrawable(getResources().getDrawable(pictures1[position1]));
                    imageView_picture3.setImageDrawable(getResources().getDrawable(pictures1[position1]));
                } catch (Exception e) {
                    timer.cancel();
                }
            } else {
                imageView_picture1.setImageDrawable(getResources().getDrawable(R.drawable.picture1));
            }
        }
    };



    private void getHetght() {

        ViewTreeObserver vto = linearlayout_upper.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                height = linearlayout_upper.getHeight();
                myScrollView.setScrollViewListener(TakeoutActivity.this);
            }
        });
    }

    @Override
    public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= height) {
            linearlayout2.setVisibility(View.INVISIBLE);
        } else {
            linearlayout2.setVisibility(View.VISIBLE);
        }
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.takeout_layout, null);


//        this.getActivity().getWindow().setStatusBarColor(Color.parseColor("#buttoncolor1"));


        database = new Database(view.getContext(), "SHOP.DB", null, 1);
        imageView_picture1 = view.findViewById(R.id.imageview_pic1);
        imageView_picture = view.findViewById(R.id.imageview_pic);
        imageView_picture3 = view.findViewById(R.id.imageview_pic3);
        linearlayout1 = view.findViewById(R.id.linearlayout1);
        linearlayout2 = view.findViewById(R.id.linearlaout2);
        daodianziqu1 = view.findViewById(R.id.daodianziqu1);
        daodianziqu2 = view.findViewById(R.id.daodianziqu2);
        daodianziqu3 = view.findViewById(R.id.daodianziqu3);
        linearlayout2.setOnClickListener(this);
        daodianziqu1.setOnClickListener(this);
        daodianziqu2.setOnClickListener(this);
        daodianziqu3.setOnClickListener(this);
        linearlayout_upper = view.findViewById(R.id.linearlayout_upper);
        myScrollView = view.findViewById(R.id.myscrollview);
        getHetght();

        icon1 = view.findViewById(R.id.icon1);
        icon2 = view.findViewById(R.id.icon2);
        icon3 = view.findViewById(R.id.icon3);
        icon4 = view.findViewById(R.id.icon4);
        icon5 = view.findViewById(R.id.icon5);
        icon6 = view.findViewById(R.id.icon6);
        icon7 = view.findViewById(R.id.icon7);
        icon8 = view.findViewById(R.id.icon8);
        icon9 = view.findViewById(R.id.icon9);
        icon10 = view.findViewById(R.id.icon10);
        imageView_picture1.setOnClickListener(this);
        imageView_picture.setOnClickListener(this);
        imageView_picture3.setOnClickListener(this);
        icon1.setOnClickListener(this);
        icon2.setOnClickListener(this);
        icon3.setOnClickListener(this);
        icon4.setOnClickListener(this);
        icon5.setOnClickListener(this);
        icon6.setOnClickListener(this);
        icon7.setOnClickListener(this);
        icon8.setOnClickListener(this);
        icon9.setOnClickListener(this);
        icon10.setOnClickListener(this);
        editText = view.findViewById(R.id.ed_search);
        editText.setOnClickListener(this);
        relativeLayout_toFreeSendActivity = view.findViewById(R.id.layout_toFreeSendActivity);
        relativeLayout_toFreeSendActivity2 = view.findViewById(R.id.layout_toFreeSendActivity2);
        relativeLayout_toFreeSendActivity3 = view.findViewById(R.id.layout_toFreeSendActivity3);
        relativeLayout_toFreeSendActivity4 = view.findViewById(R.id.layout_toFreeSendActivity4);
        linearlayout_1 = view.findViewById(R.id.linearlayout_1);
        linearlayout_2 = view.findViewById(R.id.linearlayout_2);
        linearlayout_3 = view.findViewById(R.id.linearlayout_3);
        linearlayout_4 = view.findViewById(R.id.linearlayout_4);
        relativeLayout_toFreeSendActivity.setOnClickListener(this);
        relativeLayout_toFreeSendActivity2.setOnClickListener(this);
        relativeLayout_toFreeSendActivity3.setOnClickListener(this);
        relativeLayout_toFreeSendActivity4.setOnClickListener(this);
        linearlayout_1.setOnClickListener(this);
        linearlayout_2.setOnClickListener(this);
        linearlayout_3.setOnClickListener(this);
        linearlayout_4.setOnClickListener(this);

        tv_ifDouble12League = view.findViewById(R.id.tv_ifDouble12League);
        tv_ifDouble12League.setOnClickListener(this);
        tv_ifBenefitLeague = view.findViewById(R.id.tv_ifBenefitLeague);
        tv_ifBenefitLeague.setOnClickListener(this);
        tv_ifHaveDiscount = view.findViewById(R.id.tv_ifHaveDiscount);
        tv_ifHaveDiscount.setOnClickListener(this);
        tv_ifFreeSendPrice = view.findViewById(R.id.tv_ifFreeSendPrice);
        tv_ifFreeSendPrice.setOnClickListener(this);
        tv_remark = view.findViewById(R.id.tv_remark);
        tv_remark.setTextColor(ContextCompat.getColor(view.getContext(), R.color.textcolor3));
        tv_remark.setOnClickListener(this);
        tv_sellNumber = view.findViewById(R.id.tv_sellNumber);
        tv_sellNumber.setOnClickListener(this);
        tv_distance = view.findViewById(R.id.tv_distance);
        tv_distance.setOnClickListener(this);
        tv_time = view.findViewById(R.id.tv_time);
        tv_time.setOnClickListener(this);
        tv_startPrice = view.findViewById(R.id.tv_startPrice);
        tv_startPrice.setOnClickListener(this);
        tv_sendPrice = view.findViewById(R.id.tv_sendPrice);
        tv_sendPrice.setOnClickListener(this);

        tv_ifDouble12League2 = view.findViewById(R.id.tv_ifDouble12League2);
        tv_ifDouble12League2.setOnClickListener(this);
        tv_ifBenefitLeague2 = view.findViewById(R.id.tv_ifBenefitLeague2);
        tv_ifBenefitLeague2.setOnClickListener(this);
        tv_ifHaveDiscount2 = view.findViewById(R.id.tv_ifHaveDiscount2);
        tv_ifHaveDiscount2.setOnClickListener(this);
        tv_ifFreeSendPrice2 = view.findViewById(R.id.tv_ifFreeSendPrice2);
        tv_ifFreeSendPrice2.setOnClickListener(this);
        tv_remark2 = view.findViewById(R.id.tv_remark2);
        tv_remark2.setTextColor(ContextCompat.getColor(view.getContext(), R.color.textcolor3));
        tv_remark2.setOnClickListener(this);
        tv_sellNumber2 = view.findViewById(R.id.tv_sellNumber2);
        tv_sellNumber2.setOnClickListener(this);
        tv_distance2 = view.findViewById(R.id.tv_distance2);
        tv_distance2.setOnClickListener(this);
        tv_time2 = view.findViewById(R.id.tv_time2);
        tv_time2.setOnClickListener(this);
        tv_startPrice2 = view.findViewById(R.id.tv_startPrice2);
        tv_startPrice2.setOnClickListener(this);
        tv_sendPrice2 = view.findViewById(R.id.tv_sendPrice2);
        tv_sendPrice2.setOnClickListener(this);

        database.delete();
        database.insert();
        myListView = view.findViewById(R.id.lv_shoperlist);
        shoperList = database.select("SHOP", "", key);
        shopListSort(view);
        shoperAdapter = new ShoperAdapter(shoperList, view.getContext());
        myListView.setAdapter(shoperAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), ShoperActivity.class);
                intent.putExtra("shopName", shoperList.get(position).getShopName());
                startActivity(intent);
            }
        });

        imageView_food1 = view.findViewById(R.id.image_food1);
        imageView_food2 = view.findViewById(R.id.image_food2);
        imageView_food3 = view.findViewById(R.id.image_food3);
        imageView_food4 = view.findViewById(R.id.image_food4);
        image_icon13 = view.findViewById(R.id.image_icon13);
        image_icon14 = view.findViewById(R.id.image_icon14);
        image_icon15 = view.findViewById(R.id.image_icon15);
        image_icon16 = view.findViewById(R.id.image_icon16);
        setCirclePictures(imageView_food1, R.drawable.food5, 20);
        setCirclePictures(imageView_food2, R.drawable.food1, 20);
        setCirclePictures(imageView_food3, R.drawable.food8, 20);
        setCirclePictures(imageView_food4, R.drawable.food10, 20);
        setCirclePictures(image_icon13, R.drawable.icon13, 20);
        setCirclePictures(image_icon14, R.drawable.icon14, 20);
        setCirclePictures(image_icon15, R.drawable.icon15, 20);
        setCirclePictures(image_icon16, R.drawable.icon16, 20);

        //设置图片自动切换
        task = new TimerTask() {
            public void run() {
                handler.sendEmptyMessage(0x123);
                position1++;
                if (position1 == 6) {
                    position1 = 0;
                }
            }
        };
        timer = new Timer(true);
        timer.schedule(task, 0, 2000);
        return view;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linearlaout2:
                break;
            case R.id.ed_search:
                Intent intent = new Intent(v.getContext(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_toFreeSendActivity:
            case R.id.layout_toFreeSendActivity2:
            case R.id.layout_toFreeSendActivity3:
            case R.id.layout_toFreeSendActivity4:

                Intent intent2 = new Intent(v.getContext(), FreeSendActivity.class);
                startActivity(intent2);
                break;
            case R.id.daodianziqu1:
                Intent intent3 = new Intent(v.getContext(), ShoperActivity.class);
                intent3.putExtra("shopName", "速得仕");
                startActivity(intent3);
                break;
            case R.id.daodianziqu2:
                Intent intent6 = new Intent(v.getContext(), ShoperActivity.class);
                intent6.putExtra("shopName", "麦当劳");
                startActivity(intent6);
                break;
            case R.id.daodianziqu3:
                Intent intent7 = new Intent(v.getContext(), ShoperActivity.class);
                intent7.putExtra("shopName", "慕玛披萨");
                startActivity(intent7);
                break;
            case R.id.linearlayout_1:
            case R.id.linearlayout_2:
            case R.id.linearlayout_3:
            case R.id.linearlayout_4:
                Intent intent4 = new Intent(v.getContext(), FruitShopActivity.class);
                startActivity(intent4);
                break;
            case R.id.tv_ifDouble12League:
            case R.id.tv_ifDouble12League2:
                flag1 = changeTextviewColor(v, tv_ifDouble12League, tv_ifDouble12League2, flag1, 0, "ifDouble12League");
                break;
            case R.id.tv_ifBenefitLeague:
            case R.id.tv_ifBenefitLeague2:
                flag2 = changeTextviewColor(v, tv_ifBenefitLeague, tv_ifBenefitLeague2, flag2, 1, "ifBenefitLeague");
                break;
            case R.id.tv_ifHaveDiscount:
            case R.id.tv_ifHaveDiscount2:
                flag3 = changeTextviewColor(v, tv_ifHaveDiscount, tv_ifHaveDiscount2, flag3, 2, "ifHaveDiscounts");
                break;
            case R.id.tv_ifFreeSendPrice:
            case R.id.tv_ifFreeSendPrice2:
                flag4 = changeTextviewColor(v, tv_ifFreeSendPrice, tv_ifFreeSendPrice2, flag4, 3, "ifFreeSend");
                break;
            case R.id.tv_remark:
            case R.id.tv_remark2:
                flag5 = shopSortColorChange(v);
                shopListSort(v);
                tv_remark.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                tv_remark2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_sellNumber:
            case R.id.tv_sellNumber2:
                flag6 = shopSortColorChange(v);
                shopListSort(v);
                tv_sellNumber.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                tv_sellNumber2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_distance:
            case R.id.tv_distance2:
                flag7 = shopSortColorChange(v);
                shopListSort(v);
                tv_distance.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                tv_distance2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_time:
            case R.id.tv_time2:
                flag8 = shopSortColorChange(v);
                shopListSort(v);
                tv_time.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                tv_time2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_startPrice:
            case R.id.tv_startPrice2:
                flag9 = shopSortColorChange(v);
                shopListSort(v);
                tv_startPrice.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                tv_startPrice2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.tv_sendPrice:
            case R.id.tv_sendPrice2:
                flag10 = shopSortColorChange(v);
                shopListSort(v);
                tv_sendPrice.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                tv_sendPrice2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
                break;
            case R.id.imageview_pic:
                Intent intent5 = new Intent(v.getContext(), ad1Activity.class);
                startActivity(intent5);
                break;
            case R.id.imageview_pic1:
            case R.id.icon1:
            case R.id.icon2:
            case R.id.icon3:
            case R.id.icon4:
            case R.id.icon5:
            case R.id.icon6:
            case R.id.icon7:
            case R.id.icon8:
            case R.id.icon9:
            case R.id.icon10:
//                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
//                builder.setTitle("提示").setMessage("界面开发中，请见谅！");
//                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                });
//                builder.create().show();
                Toast.makeText(v.getContext(), "界面开发中，请见谅！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //设置圆角图片
    public void setCirclePictures(ImageView iv, int id, int size) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), BitmapFactory.decodeResource(getResources(), id));
        roundedBitmapDrawable.setCornerRadius(size);
        iv.setImageDrawable(roundedBitmapDrawable);
    }

    //控制筛选时textview的颜色变化
    public int changeTextviewColor(View v, TextView tv, TextView tv2, int f, int position, String k) {
        int flag = f;
        if (flag == 1) {
            key[position] = "";
            tv.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
            tv.setBackground(v.getResources().getDrawable(R.drawable.background6));
            tv2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
            tv2.setBackground(v.getResources().getDrawable(R.drawable.background6));
        } else {
            key[position] = k;
            tv.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
            tv.setBackground(v.getResources().getDrawable(R.drawable.background8));
            tv2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor3));
            tv2.setBackground(v.getResources().getDrawable(R.drawable.background8));
        }
        shoperList = database.select("SHOP", "", key);
        shopListSort(v);
        shoperAdapter = new ShoperAdapter(shoperList, v.getContext());
        myListView.setAdapter(shoperAdapter);
        shoperAdapter.notifyDataSetChanged();
        return -flag;
    }

    public void shopListSort(View v) {
        if (flag5 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    double judge = Double.parseDouble(o1.getRemark()) - Double.parseDouble(o2.getRemark());
                    if (judge > 0) {
                        return -1;
                    }
                    return 1;
                }
            });
        }
        if (flag6 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    int i = Integer.parseInt(o1.getSellNumber()) - Integer.parseInt(o2.getSellNumber());
                    return -i;
                }
            });
        }
        if (flag7 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    int i = Integer.parseInt(o1.getDistance()) - Integer.parseInt(o2.getDistance());
                    return i;
                }
            });
        }
        if (flag8 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    int i = Integer.parseInt(o1.getNeedTime()) - Integer.parseInt(o2.getNeedTime());
                    return i;
                }
            });
        }
        if (flag9 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    int i = Integer.parseInt(o1.getStartSendPrice()) - Integer.parseInt(o2.getStartSendPrice());
                    return i;
                }
            });
        }
        if (flag10 == 1) {
            Collections.sort(shoperList, new Comparator<Shoper>() {
                public int compare(Shoper o1, Shoper o2) {
                    float judge = Float.parseFloat(o1.getSendPrice()) - Float.parseFloat(o2.getSendPrice());
                    if (judge > 0) {
                        return 1;
                    }
                    return -1;
                }
            });
        }
        shoperAdapter = new ShoperAdapter(shoperList, v.getContext());
        myListView.setAdapter(shoperAdapter);
        shoperAdapter.notifyDataSetChanged();
    }

    public int shopSortColorChange(View v) {
        flag5 = 0;
        flag6 = 0;
        flag7 = 0;
        flag8 = 0;
        flag9 = 0;
        flag10 = 0;
        tv_remark.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_sellNumber.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_time.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_distance.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_sendPrice.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_startPrice.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_remark2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_sellNumber2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_time2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_distance2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_sendPrice2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        tv_startPrice2.setTextColor(ContextCompat.getColor(v.getContext(), R.color.textcolor2));
        return 1;
    }


}