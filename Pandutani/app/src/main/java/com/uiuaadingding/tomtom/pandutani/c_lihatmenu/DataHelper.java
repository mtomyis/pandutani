package com.uiuaadingding.tomtom.pandutani.c_lihatmenu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mobile2017 on 5/4/2018.
 */

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tanggal.db";
    private static final int DATABASE_VERSION = 2;

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table padi(" +
                "et_tgl1 text null, et_tgl1_2 text null," +
                "et_tgl2 text null, et_tgl2_2 text null, " +
                "et_tgl3 text null, et_tgl3_2 text null, " +
                "et_tgl4 text null, et_tgl4_2 text null, " +
                "et_tgl5 text null, et_tgl5_2 text null, " +
                "et_tgl6 text null, et_tgl6_2 text null, " +
                "et_tgl7 text null, et_tgl7_2 text null, " +
                "et_tgl8 text null, et_tgl8_2 text null, " +
                "et_tgl9 text null, et_tgl9_2 text null, " +
                "et_tgl10 text null, et_tgl10_2 text null, " +
                "et_tgl11 text null, et_tgl11_2 text null, " +
                "et_tgl12 text null, et_tgl12_2 text null, " +
                "et_tgl13 text null, et_tgl13_2 text null, " +
                "et_tgl14 text null, et_tgl14_2 text null, " +
                "et_tgl15 text null, et_tgl15_2 text null, awal text null);";
        Log.d("Data","onCreate: " + sql);
        db.execSQL(sql);

        String sqll = "create table jagung(" +
                "et_tgl1 text null, et_tgl1_2 text null," +
                "et_tgl2 text null, et_tgl2_2 text null, " +
                "et_tgl3 text null, et_tgl3_2 text null, " +
                "et_tgl4 text null, et_tgl4_2 text null, " +
                "et_tgl5 text null, et_tgl5_2 text null, " +
                "et_tgl6 text null, et_tgl6_2 text null, " +
                "et_tgl7 text null, et_tgl7_2 text null, " +
                "et_tgl8 text null, et_tgl8_2 text null, " +
                "et_tgl9 text null, et_tgl9_2 text null, " +
                "et_tgl10 text null, et_tgl10_2 text null, " +
                "et_tgl11 text null, et_tgl11_2 text null, " +
                "et_tgl12 text null, et_tgl12_2 text null, " +
                "et_tgl13 text null, et_tgl13_2 text null, awal text null);";
        Log.d("Data","onCreate: " + sqll);
        db.execSQL(sqll);

        String sqlll = "create table kedelai(" +
                "et_tgl1 text null, et_tgl1_2 text null," +
                "et_tgl2 text null, et_tgl2_2 text null, " +
                "et_tgl3 text null, et_tgl3_2 text null, " +
                "et_tgl4 text null, et_tgl4_2 text null, " +
                "et_tgl5 text null, et_tgl5_2 text null, " +
                "et_tgl6 text null, et_tgl6_2 text null, " +
                "et_tgl7 text null, et_tgl7_2 text null, " +
                "et_tgl8 text null, et_tgl8_2 text null, " +
                "et_tgl9 text null, et_tgl9_2 text null, " +
                "et_tgl10 text null, et_tgl10_2 text null, " +
                "et_tgl11 text null, et_tgl11_2 text null, " +
                "et_tgl12 text null, et_tgl12_2 text null, " +
                "et_tgl13 text null, et_tgl13_2 text null, awal text null);";
        Log.d("Data","onCreate: " + sqlll);
        db.execSQL(sqlll);

        String ssqlll = "create table ubi(" +
                "et_tgl1 text null, et_tgl1_2 text null," +
                "et_tgl2 text null, et_tgl2_2 text null, " +
                "et_tgl3 text null, et_tgl3_2 text null, " +
                "et_tgl4 text null, et_tgl4_2 text null, " +
                "et_tgl5 text null, et_tgl5_2 text null, " +
                "et_tgl6 text null, et_tgl6_2 text null, " +
                "et_tgl7 text null, et_tgl7_2 text null, " +
                "et_tgl8 text null, et_tgl8_2 text null, " +
                "et_tgl9 text null, et_tgl9_2 text null, " +
                "et_tgl10 text null, et_tgl10_2 text null, awal text null);";
        Log.d("Data","onCreate: " + ssqlll);
        db.execSQL(ssqlll);

    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
//        String padi = "delete from padi;";
//        String jagung = "delete from jagung;";
//        String kedelai = "delete from kedelai;";
//        String ubi = "delete from ubi;";
//
//        arg0.execSQL(padi);
//        arg0.execSQL(jagung);
//        arg0.execSQL(kedelai);
//        arg0.execSQL(ubi);

    }
}
