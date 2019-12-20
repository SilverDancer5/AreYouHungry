package com.example.ayh.ui.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.ayh.R;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table SHOP ( ID INTEGER PRIMARY KEY , image INTEGER , shopName TEXT ,remark TEXT , sellNumber TEXT," +
                "distance TEXT ,ifDouble12League INTEGER,ifBenefitLeague INTEGER,ifHaveDiscounts INTEGER,ifFreeSend INTEGER,ifCollected INTEGER," +
                "startSendPrice TEXT ,sendPrice TEXT ,time TEXT ,personalizadSignature TEXT, label1 TEXT ,label2 TEXT ,label3 TEXT ,label4 TEXT,label5 TEXT, " +
                "food1 INTEGER ,food2 INTEGER ,food3 INTEGER ,food4 INTEGER,food5 INTEGER)";
        String sql2 = "create table MYMENU ( ID INTEGER PRIMARY KEY, image INTEGER, menuName TEXT, sellNumber TEXT, price TEXT, number TEXT, ifNeedSubtract INTEGER)";
        String sql3 = "create table BILL ( ID INTEGER PRIMARY KEY,userID INTEGER, shopID INTEGER, foodNumber1 INTEGER," +
                "foodNumber2 INTEGER,foodNumber3 INTEGER,foodNumber4 INTEGER,foodNumber5 INTEGER)";

        db.execSQL(sql);
        db.execSQL(sql2);
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertBill(String tableName, ContentValues contentValues) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(tableName, null, contentValues);
        db.close();
    }

    public void update(String tableName, ContentValues contentValues, int ID) {
        SQLiteDatabase db = getWritableDatabase();
        db.update(tableName, contentValues, "ID = ?", new String[]{String.valueOf(ID)});
        db.close();
    }

    public List<Shoper> selectById(int key_id) {
        List<Shoper> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("SHOP", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int image = cursor.getInt(cursor.getColumnIndex("image"));
            String shopName = cursor.getString(cursor.getColumnIndex("shopName"));
            String remark = cursor.getString(cursor.getColumnIndex("remark"));
            String sellNumber = cursor.getString(cursor.getColumnIndex("sellNumber"));
            String distance = cursor.getString(cursor.getColumnIndex("distance"));
            int ifDouble12League = cursor.getInt(cursor.getColumnIndex("ifDouble12League"));
            int ifBenefitLeague = cursor.getInt(cursor.getColumnIndex("ifBenefitLeague"));
            int ifHaveDiscounts = cursor.getInt(cursor.getColumnIndex("ifHaveDiscounts"));
            int ifFreeSend = cursor.getInt(cursor.getColumnIndex("ifFreeSend"));
            int ifCollected = cursor.getInt(cursor.getColumnIndex("ifCollected"));
            String startSendPrice = cursor.getString(cursor.getColumnIndex("startSendPrice"));
            String sendPrice = cursor.getString(cursor.getColumnIndex("sendPrice"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String personalizadSignature = cursor.getString(cursor.getColumnIndex("personalizadSignature"));
            String label1 = cursor.getString(cursor.getColumnIndex("label1"));
            String label2 = cursor.getString(cursor.getColumnIndex("label2"));
            String label3 = cursor.getString(cursor.getColumnIndex("label3"));
            String label4 = cursor.getString(cursor.getColumnIndex("label4"));
            String label5 = cursor.getString(cursor.getColumnIndex("label5"));
            int food1 = cursor.getInt(cursor.getColumnIndex("food1"));
            int food2 = cursor.getInt(cursor.getColumnIndex("food2"));
            int food3 = cursor.getInt(cursor.getColumnIndex("food3"));
            int food4 = cursor.getInt(cursor.getColumnIndex("food4"));
            int food5 = cursor.getInt(cursor.getColumnIndex("food5"));
            Shoper shoper = new Shoper(id, image, shopName, remark, sellNumber, distance, ifDouble12League, ifBenefitLeague, ifHaveDiscounts, ifFreeSend, ifCollected,
                    startSendPrice, sendPrice, time, personalizadSignature, label1, label2, label3, label4, label5, food1, food2, food3, food4, food5);
            if(key_id == id){
                list.add(shoper);
            }
        }
        db.close();
        return list;
    }

    public List<Shoper> selectByIfCollected(int key_ifCollected) {
        List<Shoper> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("SHOP", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int image = cursor.getInt(cursor.getColumnIndex("image"));
            String shopName = cursor.getString(cursor.getColumnIndex("shopName"));
            String remark = cursor.getString(cursor.getColumnIndex("remark"));
            String sellNumber = cursor.getString(cursor.getColumnIndex("sellNumber"));
            String distance = cursor.getString(cursor.getColumnIndex("distance"));
            int ifDouble12League = cursor.getInt(cursor.getColumnIndex("ifDouble12League"));
            int ifBenefitLeague = cursor.getInt(cursor.getColumnIndex("ifBenefitLeague"));
            int ifHaveDiscounts = cursor.getInt(cursor.getColumnIndex("ifHaveDiscounts"));
            int ifFreeSend = cursor.getInt(cursor.getColumnIndex("ifFreeSend"));
            int ifCollected = cursor.getInt(cursor.getColumnIndex("ifCollected"));
            String startSendPrice = cursor.getString(cursor.getColumnIndex("startSendPrice"));
            String sendPrice = cursor.getString(cursor.getColumnIndex("sendPrice"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String personalizadSignature = cursor.getString(cursor.getColumnIndex("personalizadSignature"));
            String label1 = cursor.getString(cursor.getColumnIndex("label1"));
            String label2 = cursor.getString(cursor.getColumnIndex("label2"));
            String label3 = cursor.getString(cursor.getColumnIndex("label3"));
            String label4 = cursor.getString(cursor.getColumnIndex("label4"));
            String label5 = cursor.getString(cursor.getColumnIndex("label5"));
            int food1 = cursor.getInt(cursor.getColumnIndex("food1"));
            int food2 = cursor.getInt(cursor.getColumnIndex("food2"));
            int food3 = cursor.getInt(cursor.getColumnIndex("food3"));
            int food4 = cursor.getInt(cursor.getColumnIndex("food4"));
            int food5 = cursor.getInt(cursor.getColumnIndex("food5"));
            Shoper shoper = new Shoper(id, image, shopName, remark, sellNumber, distance, ifDouble12League, ifBenefitLeague, ifHaveDiscounts, ifFreeSend, ifCollected,
                    startSendPrice, sendPrice, time, personalizadSignature, label1, label2, label3, label4, label5, food1, food2, food3, food4, food5);
            if(key_ifCollected == ifCollected){
                list.add(shoper);
            }
        }
        db.close();
        return list;
    }

    public List<Shoper> select(String tableName, String key, String[] keyArrey) {
        List<Shoper> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(tableName, null, null, null, null, null, null);
        if (tableName.equals("SHOP")) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex("ID"));
                int image = cursor.getInt(cursor.getColumnIndex("image"));
                String shopName = cursor.getString(cursor.getColumnIndex("shopName"));
                String remark = cursor.getString(cursor.getColumnIndex("remark"));
                String sellNumber = cursor.getString(cursor.getColumnIndex("sellNumber"));
                String distance = cursor.getString(cursor.getColumnIndex("distance"));
                int ifDouble12League = cursor.getInt(cursor.getColumnIndex("ifDouble12League"));
                int ifBenefitLeague = cursor.getInt(cursor.getColumnIndex("ifBenefitLeague"));
                int ifHaveDiscounts = cursor.getInt(cursor.getColumnIndex("ifHaveDiscounts"));
                int ifFreeSend = cursor.getInt(cursor.getColumnIndex("ifFreeSend"));
                int ifCollected = cursor.getInt(cursor.getColumnIndex("ifCollected"));
                String startSendPrice = cursor.getString(cursor.getColumnIndex("startSendPrice"));
                String sendPrice = cursor.getString(cursor.getColumnIndex("sendPrice"));
                String time = cursor.getString(cursor.getColumnIndex("time"));
                String personalizadSignature = cursor.getString(cursor.getColumnIndex("personalizadSignature"));
                String label1 = cursor.getString(cursor.getColumnIndex("label1"));
                String label2 = cursor.getString(cursor.getColumnIndex("label2"));
                String label3 = cursor.getString(cursor.getColumnIndex("label3"));
                String label4 = cursor.getString(cursor.getColumnIndex("label4"));
                String label5 = cursor.getString(cursor.getColumnIndex("label5"));
                int food1 = cursor.getInt(cursor.getColumnIndex("food1"));
                int food2 = cursor.getInt(cursor.getColumnIndex("food2"));
                int food3 = cursor.getInt(cursor.getColumnIndex("food3"));
                int food4 = cursor.getInt(cursor.getColumnIndex("food4"));
                int food5 = cursor.getInt(cursor.getColumnIndex("food5"));
                Shoper shoper = new Shoper(id, image, shopName, remark, sellNumber, distance, ifDouble12League, ifBenefitLeague, ifHaveDiscounts, ifFreeSend, ifCollected,
                        startSendPrice, sendPrice, time, personalizadSignature, label1, label2, label3, label4, label5, food1, food2, food3, food4, food5);
                if (!key.equals("")) {
                    if (shopName.contains(key)) {
                        list.add(shoper);
                    }
                } else {
                    int[] values = {1, 1, 1, 1};
                    if (!keyArrey[0].equals("")) {
                        values[0] = ifDouble12League;
                    }
                    if (!keyArrey[1].equals("")) {
                        values[1] = ifBenefitLeague;
                    }
                    if (!keyArrey[2].equals("")) {
                        values[2] = ifHaveDiscounts;
                    }
                    if (!keyArrey[3].equals("")) {
                        values[3] = ifFreeSend;
                    }
                    if (values[0] == 1 && values[1] == 1 && values[2] == 1 && values[3] == 1) {
                        list.add(shoper);
                    }
                }

            }
        }
        db.close();
        return list;
    }

    public List<MyMenu> selectMenu() {
        List<MyMenu> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("MYMENU", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int image = cursor.getInt(cursor.getColumnIndex("image"));
            String menuName = cursor.getString(cursor.getColumnIndex("menuName"));
            String sellNumber = cursor.getString(cursor.getColumnIndex("sellNumber"));
            String price = cursor.getString(cursor.getColumnIndex("price"));
            String number = cursor.getString(cursor.getColumnIndex("number"));
            int ifNeedSubtract = cursor.getInt(cursor.getColumnIndex("ifNeedSubtract"));
            MyMenu myMenu = new MyMenu(id, image, menuName, sellNumber, price, number, ifNeedSubtract);
            list.add(myMenu);
        }
        db.close();
        return list;
    }

    public MyMenu selectMenuItem(int index) {
        MyMenu myMenu = new MyMenu();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("MYMENU", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            int image = cursor.getInt(cursor.getColumnIndex("image"));
            String menuName = cursor.getString(cursor.getColumnIndex("menuName"));
            String sellNumber = cursor.getString(cursor.getColumnIndex("sellNumber"));
            String price = cursor.getString(cursor.getColumnIndex("price"));
            String number = cursor.getString(cursor.getColumnIndex("number"));
            int ifNeedSubtract = cursor.getInt(cursor.getColumnIndex("ifNeedSubtract"));
            if (index == id) {
                myMenu = new MyMenu(id, image, menuName, sellNumber, price, number, ifNeedSubtract);
            }
        }
        db.close();
        return myMenu;
    }

    public List<Bill> selectBill() {
        List<Bill> list = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("BILL", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int ID = cursor.getInt(cursor.getColumnIndex("ID"));
            int userID = cursor.getInt(cursor.getColumnIndex("userID"));
            int shopID = cursor.getInt(cursor.getColumnIndex("shopID"));
            int foodNumber1 = cursor.getInt(cursor.getColumnIndex("foodNumber1"));
            int foodNumber2 = cursor.getInt(cursor.getColumnIndex("foodNumber2"));
            int foodNumber3 = cursor.getInt(cursor.getColumnIndex("foodNumber3"));
            int foodNumber4 = cursor.getInt(cursor.getColumnIndex("foodNumber4"));
            int foodNumber5 = cursor.getInt(cursor.getColumnIndex("foodNumber5"));
            Bill bill = new Bill(ID, userID, shopID, foodNumber1, foodNumber2, foodNumber3, foodNumber4, foodNumber5);
            list.add(bill);
        }
        db.close();
        return list;
    }


    public void delete() {
        SQLiteDatabase db = getWritableDatabase();
        for (int i = 0; i < 25; i++) {
            String sql = "delete from SHOP where id = " + i;
            db.execSQL(sql);
        }
        for (int i = 0; i < 54; i++) {
            String sql = "delete from MYMENU where id = " + i;
            db.execSQL(sql);
        }
        db.close();
    }

    public void insert() {
        SQLiteDatabase db = getWritableDatabase();
        String sql1 = "insert into SHOP values(0," + R.drawable.shoperpicture1 + ",\"八猪麻辣烫\",\"4.7\",\"93\",\"4900\",0,0,1,0,-1,\"20\",\"3.5\"," +
                "\"45\",\"\",\" 27元减14 \",\" 39元减19 \",\" 48元减24 \",\" 70元减30 \",\" 5.8折 \",22,23,21,29,30)";
        String sql2 = "insert into SHOP values(1," + R.drawable.shoperpicture2 + ",\"巴哩巴哩\",\"4.8\",\"8323\",\"825\",1,0,1,1,-1,\"20\",\"0\"," +
                "\"30\",\"回头客了，真的是很好吃啊，点赞\",\" 0元配送 \",\" 21减20 \",\" 35减30 \",\" 70减40 \",\" 支持自取 \",19,27,28,29,39)";
        String sql3 = "insert into SHOP values(2," + R.drawable.shoperpicture3 + ",\"香尔麦\",\"4.5\",\"1782\",\"808\",1,1,1,0,-1,\"15\",\"1\"," +
                "\"35\",\"深夜续命，完美\",\" 25元减2 \",\" 39元减3 \",\" 69减6 \",\" 109减10 \",\" 津贴1元 \",13,14,15,16,17)";
        String sql4 = "insert into SHOP values(3," + R.drawable.shoperpicture4 + ",\"速得仕\",\"4.7\",\"3457\",\"160\",1,0,1,0,-1,\"14\",\"1\"," +
                "\"30\",\"都是现炸的很好吃满足\",\" 23减1 \",\" 35减2 \",\" 6元会员红包 \",\" 品质联盟 \",\"\",12,11,13,14,21)";
        String sql5 = "insert into SHOP values(4," + R.drawable.shoperpicture5 + ",\"韩国哈尼炸鸡\",\"4.6\",\"4108\",\"855\",1,1,1,1,-1,\"10\",\"0\"," +
                "\"30\",\"大写的好吃\",\" 0元配送 \",\" 35减30 \",\" 57减33 \",\" 67减35 \",\" 津贴1元 \",12,11,41,42,17)";
        String sql6 = "insert into SHOP values(5," + R.drawable.shoperpicture6 + ",\"迪力堡现烤汉堡\",\"4.7\",\"2660\",\"1400\",1,1,1,1,-1,\"20\",\"0\"," +
                "\"33\",\"江宁区汉堡薯条人气飙升第6名\",\" 0元配送 \",\" 16减16 \",\" 36减21 \",\" 42减32 \",\" 津贴1元 \",13,14,15,16,17)";
        String sql7 = "insert into SHOP values(6," + R.drawable.shoperpicture7 + ",\"麦当劳\",\"4.7\",\"1198\",\"1100\",0,0,1,0,-1,\"0\",\"9\"," +
                "\"28\",\"麦乐鸡性价比很高\",\" 一元特价 \",\" 开发票 \",\"\",\"\",\"\",12,11,9,10,17)";
        String sql8 = "insert into SHOP values(7," + R.drawable.shoperpicture8 + ",\"小厨瓦香鸡\",\"4.9\",\"1368\",\"3000\",1,0,1,0,-1,\"26\",\"3\"," +
                "\"54\",\"好吃好吃，鸡肉口感很好\",\" 30减1 \",\" 80减2 \",\" 6元会员红包 \",\" 品质联盟 \",\"\",32,33,39,41,42)";
        String sql9 = "insert into SHOP values(8," + R.drawable.shoperpicture9 + ",\"米乐饭团\",\"4.6\",\"483\",\"3000\",1,0,1,0,-1,\"15\",\"3\"," +
                "\"45\",\"\",\" 25减4 \",\" 30减6 \",\" 40减8 \",\" 50减9 \",\" 6元会员红包 \",37,38,43,44,31)";
        String sql10 = "insert into SHOP values(9," + R.drawable.shoperpicture10 + ",\"放心豆浆油条\",\"4.7\",\"650\",\"1100\",1,0,1,0,-1,\"15\",\"2\"," +
                "\"33\",\"\",\" 17减1 \",\" 25减2 \",\" 37减3 \",\" 50减5 \",\" 55减8 \",9,10,11,15,19)";
        String sql11 = "insert into SHOP values(10," + R.drawable.shoperpicture11 + ",\"霏霏煎饼粥铺\",\"4.7\",\"835\",\"3100\",1,0,1,1,-1,\"18\",\"0\"," +
                "\"40\",\" 这个鸡蛋饼好香啊 \",\" 0元配送 \",\" 26减12 \",\" 40减16 \",\" 50减20 \",\" 78减35 \",18,46,47,35,34)";
        String sql12 = "insert into SHOP values(11," + R.drawable.shoperpicture12 + ",\"泰皇虾仁菠萝饭\",\"4.5\",\"1783\",\"2200\",1,0,1,0,-1,\"10\",\"3\"," +
                "\"38\",\" 大份黄焖鸡赞赞赞 \",\" 15减14 \",\" 26减12 \",\" 32减17 \",\" 40减19 \",\" 50减22 \",28,40,48,49,27)";
        String sql13 = "insert into SHOP values(12," + R.drawable.shoperpicture13 + ",\"江南小粥\",\"4.7\",\"961\",\"3300\",1,0,1,0,-1,\"15\",\"1\"," +
                "\"46\",\" 红枣山药粥包装好味道好 \",\" 26减11 \",\" 39减16 \",\" 59减22 \",\" 6元会员红包 \",\"\",49,50,51,52,45)";
        String sql14 = "insert into SHOP values(13," + R.drawable.shoperpicture14 + ",\"小馋客水饺\",\"4.6\",\"1788\",\"1800\",1,0,1,0,-1,\"10\",\"2\"," +
                "\"45\",\" 饭菜质量很高，很划算 \",\" 15减4 \",\" 25减7 \",\" 35减9 \",\" 6元会员红包 \",\" 食安保障 \",53,25,18,15,9)";
        String sql15 = "insert into SHOP values(14," + R.drawable.shoperpicture15 + ",\"凌晨一点战斗鸡排饭\",\"4.4\",\"2823\",\"886\",1,0,1,0,-1,\"15\",\"1\"," +
                "\"50\",\"\",\" 20减15 \",\" 35减17 \",\" 55减25 \",\" 75减40 \",\" 100减56 \",43,42,41,40,39)";
        String sql16 = "insert into SHOP values(15," + R.drawable.shoperpicture16 + ",\"淮南牛羊肉汤\",\"4.8\",\"3061\",\"3100\",1,1,1,0,-1,\"0\",\"2\"," +
                "\"52\",\" 强烈推荐牛肉面 \",\" 23减1 \",\" 45减2 \",\" 津贴1元 \",\" 60减4 \",\" 80减5 \",20,24,35,36,21)";
        String sql17 = "insert into SHOP values(16," + R.drawable.shoperpicture17 + ",\"咖喱范鸡排饭\",\"4.6\",\"359\",\"1900\",1,1,1,0,-1,\"0\",\"1\"," +
                "\"38\",\" 江宁饺子性价比第一名 \",\" 12减12 \",\" 17减16 \",\" 津贴1元 \",\" 43减20 \",\" 65减28 \",47,41,42,43,47)";
        String sql18 = "insert into SHOP values(17," + R.drawable.shoperpicture18 + ",\"疯狂酸辣粉\",\"4.7\",\"3243\",\"2000\",1,0,1,0,-1,\"10\",\"2\"," +
                "\"41\",\" 好吃，店主服务态度超级好，真心不错 \",\" 25减12 \",\" 35减16 \",\" 45减24 \",\" 55减28 \",\" 支持自取 \",24,25,26,27,28)";
        String sql19 = "insert into SHOP values(18," + R.drawable.shoperpicture19 + ",\"慢时空烘培\",\"4.5\",\"42\",\"1700\",1,0,1,0,-1,\"30\",\"4\"," +
                "\"37\",\"\",\" 28减2 \",\" 38减4 \",\" 48减6 \",\" 68减8 \",\" 88减10 \",24,25,26,27,28)";
        String sql20 = "insert into SHOP values(19," + R.drawable.shoperpicture20 + ",\"慕玛披萨\",\"4.7\",\"1500\",\"838\",1,0,1,1,-1,\"20\",\"0\"," +
                "\"32\",\" 来了份黄金榴莲披萨，现在贼满足 \",\" 0元配送 \",\" 25减19 \",\" 55减28 \",\" 75减36 \",\" 99减45 \",19,27,28,44,29)";
        String sql21 = "insert into SHOP values(20," + R.drawable.shoperpicture21 + ",\"每日优鲜\",\"4.3\",\"921\",\"2900\",0,0,1,0,-1,\"20\",\"5\"," +
                "\"54\",\"\",\" 开发票 \",\" 49减10 \",\" 69减14 \",\"\",\"\",0,1,2,3,4)";
        String sql22 = "insert into SHOP values(21," + R.drawable.shoperpicture22 + ",\"果小乐\",\"4.6\",\"894\",\"1500\",1,0,0,1,-1,\"20\",\"0\"," +
                "\"34\",\"\",\" 0元配送 \",\" 食安保 \",\" 开发票 \",\" 品质联盟 \",\"\",3,1,5,6,7)";
        String sql23 = "insert into SHOP values(22," + R.drawable.shoperpicture23 + ",\"百果园\",\"4.5\",\"654\",\"3300\",0,0,1,0,-1,\"20\",\"4.5\"," +
                "\"43\",\"\",\" 49减10 \",\" 99减20 \",\"\",\"\",\"\",0,7,6,8,4)";
        String sql24 = "insert into SHOP values(23," + R.drawable.shoperpicture24 + ",\"切切吧水果\",\"4.7\",\"651\",\"5500\",0,0,1,0,-1,\"20\",\"5.5\"," +
                "\"37\",\"\",\" 28减3 \",\" 48减5 \",\" 68减7 \",\" 98减10 \",\" 198减20 \",7,8,4,5,2)";
        String sql25 = "insert into SHOP values(24," + R.drawable.shoperpicture25 + ",\"果乐慧水果店\",\"4.6\",\"545\",\"1500\",1,0,0,0,-1,\"20\",\"2\"," +
                "\"44\",\"\",\" 品质联盟 \",\" 1.1元起 \",\"\",\"\",\"\",1,0,5,6,3)";

        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);
        db.execSQL(sql8);
        db.execSQL(sql9);
        db.execSQL(sql10);
        db.execSQL(sql11);
        db.execSQL(sql12);
        db.execSQL(sql13);
        db.execSQL(sql14);
        db.execSQL(sql15);
        db.execSQL(sql16);
        db.execSQL(sql17);
        db.execSQL(sql18);
        db.execSQL(sql19);
        db.execSQL(sql20);
        db.execSQL(sql21);
        db.execSQL(sql22);
        db.execSQL(sql23);
        db.execSQL(sql24);
        db.execSQL(sql25);

        String str1 = "insert into MYMENU values(0," + R.drawable.menupicture1 + ",\"进口车厘子\",\"257\",\"168\",\"0\",0)";
        String str2 = "insert into MYMENU values(1," + R.drawable.menupicture2 + ",\"江西蜜桔\",\"355\",\"3.5\",\"0\",0)";
        String str3 = "insert into MYMENU values(2," + R.drawable.menupicture3 + ",\"海南陵水千禧\",\"221\",\"13.8\",\"0\",0)";
        String str4 = "insert into MYMENU values(3," + R.drawable.menupicture4 + ",\"削好甘蔗节\",\"333\",\"3.98\",\"0\",0)";
        String str5 = "insert into MYMENU values(4," + R.drawable.menupicture5 + ",\"榴莲\",\"243\",\"35.8\",\"0\",0)";
        String str6 = "insert into MYMENU values(5," + R.drawable.menupicture6 + ",\"脆枣\",\"151\",\"9.98\",\"0\",0)";
        String str7 = "insert into MYMENU values(6," + R.drawable.menupicture7 + ",\"香梨\",\"161\",\"4.5\",\"0\",0)";
        String str8 = "insert into MYMENU values(7," + R.drawable.menupicture8 + ",\"苹果\",\"212\",\"3.99\",\"0\",0)";
        String str9 = "insert into MYMENU values(8," + R.drawable.menupicture9 + ",\"龙眼\",\"123\",\"5.99\",\"0\",0)";
        String str10 = "insert into MYMENU values(9," + R.drawable.menupicture10 + ",\"油条\",\"115\",\"1.5\",\"0\",0)";
        String str11 = "insert into MYMENU values(10," + R.drawable.menupicture11 + ",\"豆浆\",\"157\",\"2\",\"0\",0)";
        String str12 = "insert into MYMENU values(11," + R.drawable.menupicture12 + ",\"薯条\",\"389\",\"6\",\"0\",0)";
        String str13 = "insert into MYMENU values(12," + R.drawable.menupicture13 + ",\"里脊肉\",\"423\",\"2\",\"0\",0)";
        String str14 = "insert into MYMENU values(13," + R.drawable.menupicture14 + ",\"汉堡\",\"156\",\"15.99\",\"0\",0)";
        String str15 = "insert into MYMENU values(14," + R.drawable.menupicture15 + ",\"鸡肉卷\",\"547\",\"15.99\",\"0\",0)";
        String str16 = "insert into MYMENU values(15," + R.drawable.menupicture16 + ",\"脆皮香蕉\",\"123\",\"14.99\",\"0\",0)";
        String str17 = "insert into MYMENU values(16," + R.drawable.menupicture17 + ",\"地瓜条\",\"78\",\"14.99\",\"0\",0)";
        String str18 = "insert into MYMENU values(17," + R.drawable.menupicture18 + ",\"百事可乐\",\"88\",\"13.99\",\"0\",0)";
        String str19 = "insert into MYMENU values(18," + R.drawable.menupicture19 + ",\"豆腐脑\",\"275\",\"5\",\"0\",0)";
        String str20 = "insert into MYMENU values(19," + R.drawable.menupicture20 + ",\"披萨\",\"152\",\"47\",\"0\",0)";
        String str21 = "insert into MYMENU values(20," + R.drawable.menupicture21 + ",\"淮南牛肉汤\",\"142\",\"13.3\",\"0\",0)";
        String str22 = "insert into MYMENU values(21," + R.drawable.menupicture22 + ",\"维他\",\"199\",\"5\",\"0\",0)";
        String str23 = "insert into MYMENU values(22," + R.drawable.menupicture23 + ",\"佛系健身套餐\",\"45\",\"20\",\"0\",0)";
        String str24 = "insert into MYMENU values(23," + R.drawable.menupicture24 + ",\"大快朵颐套餐\",\"48\",\"45\",\"0\",0)";
        String str25 = "insert into MYMENU values(24," + R.drawable.menupicture25 + ",\"酸辣粉\",\"49\",\"12\",\"0\",0)";
        String str26 = "insert into MYMENU values(25," + R.drawable.menupicture26 + ",\"凉皮\",\"149\",\"13\",\"0\",0)";
        String str27 = "insert into MYMENU values(26," + R.drawable.menupicture27 + ",\"青菜面\",\"45\",\"9\",\"0\",0)";
        String str28 = "insert into MYMENU values(27," + R.drawable.menupicture28 + ",\"烤涛涛\",\"999\",\"999\",\"0\",0)";
        String str29 = "insert into MYMENU values(28," + R.drawable.menupicture29 + ",\"拌馄饨\",\"95\",\"9\",\"0\",0)";
        String str30 = "insert into MYMENU values(29," + R.drawable.menupicture30 + ",\"农夫山泉\",\"25\",\"3\",\"0\",0)";
        String str31 = "insert into MYMENU values(30," + R.drawable.menupicture31 + ",\"青梅绿茶\",\"31\",\"5\",\"0\",0)";
        String str32 = "insert into MYMENU values(31," + R.drawable.menupicture32 + ",\"冰红茶\",\"43\",\"5\",\"0\",0)";
        String str33 = "insert into MYMENU values(32," + R.drawable.menupicture33 + ",\"乌鸡面\",\"49\",\"18\",\"0\",0)";
        String str34 = "insert into MYMENU values(33," + R.drawable.menupicture34 + ",\"土鸡面\",\"87\",\"18\",\"0\",0)";
        String str35 = "insert into MYMENU values(34," + R.drawable.menupicture35 + ",\"猪肚面\",\"101\",\"18\",\"0\",0)";
        String str36 = "insert into MYMENU values(35," + R.drawable.menupicture36 + ",\"乳鸽面\",\"155\",\"20\",\"0\",0)";
        String str37 = "insert into MYMENU values(36," + R.drawable.menupicture37 + ",\"老鸭汤\",\"178\",\"12\",\"0\",0)";
        String str38 = "insert into MYMENU values(37," + R.drawable.menupicture38 + ",\"葱油拌面\",\"157\",\"8\",\"0\",0)";
        String str39 = "insert into MYMENU values(38," + R.drawable.menupicture39 + ",\"鸡蛋炒面\",\"57\",\"14\",\"0\",0)";
        String str40 = "insert into MYMENU values(39," + R.drawable.menupicture40 + ",\"鸡腿\",\"88\",\"8\",\"0\",0)";
        String str41 = "insert into MYMENU values(40," + R.drawable.menupicture41 + ",\"大牌饭\",\"191\",\"19\",\"0\",0)";
        String str42 = "insert into MYMENU values(41," + R.drawable.menupicture42 + ",\"榴莲炸鸡\",\"255\",\"49.8\",\"0\",0)";
        String str43 = "insert into MYMENU values(42," + R.drawable.menupicture43 + ",\"麻辣炸鸡\",\"132\",\"50.9\",\"0\",0)";
        String str44 = "insert into MYMENU values(43," + R.drawable.menupicture44 + ",\"饭团\",\"112\",\"10\",\"0\",0)";
        String str45 = "insert into MYMENU values(44," + R.drawable.menupicture45 + ",\"酸奶捞\",\"119\",\"14\",\"0\",0)";
        String str46 = "insert into MYMENU values(45," + R.drawable.menupicture46 + ",\"夹心海苔\",\"118\",\"13\",\"0\",0)";
        String str47 = "insert into MYMENU values(46," + R.drawable.menupicture47 + ",\"煎饼\",\"98\",\"14\",\"0\",0)";
        String str48 = "insert into MYMENU values(47," + R.drawable.menupicture48 + ",\"黄焖鸡米饭\",\"185\",\"15\",\"0\",0)";
        String str49 = "insert into MYMENU values(48," + R.drawable.menupicture49 + ",\"鸡蛋菠萝炒饭\",\"166\",\"17\",\"0\",0)";
        String str50 = "insert into MYMENU values(49," + R.drawable.menupicture50 + ",\"香菇瘦肉粥\",\"178\",\"16\",\"0\",0)";
        String str51 = "insert into MYMENU values(50," + R.drawable.menupicture51 + ",\"烧卖\",\"158\",\"5\",\"0\",0)";
        String str52 = "insert into MYMENU values(51," + R.drawable.menupicture52 + ",\"肉包\",\"200\",\"2\",\"0\",0)";
        String str53 = "insert into MYMENU values(52," + R.drawable.menupicture53 + ",\"红糖方糕\",\"270\",\"5.8\",\"0\",0)";
        String str54 = "insert into MYMENU values(53," + R.drawable.menupicture54 + ",\"鲜肉香菇水饺\",\"154\",\"16\",\"0\",0)";

        db.execSQL(str1);
        db.execSQL(str2);
        db.execSQL(str3);
        db.execSQL(str4);
        db.execSQL(str5);
        db.execSQL(str6);
        db.execSQL(str7);
        db.execSQL(str8);
        db.execSQL(str9);
        db.execSQL(str10);
        db.execSQL(str11);
        db.execSQL(str12);
        db.execSQL(str13);
        db.execSQL(str14);
        db.execSQL(str15);
        db.execSQL(str16);
        db.execSQL(str17);
        db.execSQL(str18);
        db.execSQL(str19);
        db.execSQL(str20);
        db.execSQL(str21);
        db.execSQL(str22);
        db.execSQL(str23);
        db.execSQL(str24);
        db.execSQL(str25);
        db.execSQL(str26);
        db.execSQL(str27);
        db.execSQL(str28);
        db.execSQL(str29);
        db.execSQL(str30);
        db.execSQL(str31);
        db.execSQL(str32);
        db.execSQL(str33);
        db.execSQL(str34);
        db.execSQL(str35);
        db.execSQL(str36);
        db.execSQL(str37);
        db.execSQL(str38);
        db.execSQL(str39);
        db.execSQL(str40);
        db.execSQL(str41);
        db.execSQL(str42);
        db.execSQL(str43);
        db.execSQL(str44);
        db.execSQL(str45);
        db.execSQL(str46);
        db.execSQL(str47);
        db.execSQL(str48);
        db.execSQL(str49);
        db.execSQL(str50);
        db.execSQL(str51);
        db.execSQL(str52);
        db.execSQL(str53);
        db.execSQL(str54);


        db.close();
    }

}
