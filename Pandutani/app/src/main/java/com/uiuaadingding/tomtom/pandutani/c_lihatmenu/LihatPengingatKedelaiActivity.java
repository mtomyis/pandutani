package com.uiuaadingding.tomtom.pandutani.c_lihatmenu;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.d_detailmenu.DetailPengingatActivity;
import com.uiuaadingding.tomtom.pandutani.d_detailmenu.DetailPengingatActivity;
import com.uiuaadingding.tomtom.pandutani.d_detailmenu.DetailPengingatActivity;
import com.uiuaadingding.tomtom.pandutani.pakar.kedelai.MonitorHamaKeActivity;
import com.uiuaadingding.tomtom.pandutani.pakar.padi.MonitorHamaActivity;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl1.ScheduleClientk;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl10.ScheduleClientk10;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl11.ScheduleClientk11;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl12.ScheduleClientk12;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl13.ScheduleClientk13;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl2.ScheduleClientk2;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl3.ScheduleClientk3;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl4.ScheduleClientk4;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl5.ScheduleClientk5;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl6.ScheduleClientk6;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl7.ScheduleClientk7;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl8.ScheduleClientk8;
import com.uiuaadingding.tomtom.pandutani.pengingat_kedelai.ktgl9.ScheduleClientk9;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class LihatPengingatKedelaiActivity extends AppCompatActivity {
    protected static String EXTRA_ID = "";
    private static final String TAG = LihatPengingatKedelaiActivity.class.getSimpleName();

    protected Cursor cursor;
    private DataHelper dbHelper;

    // This is a handle so that we can call methods on our service
    private ScheduleClientk scheduleClientk;
    private ScheduleClientk2 scheduleClientk2;
    private ScheduleClientk3 scheduleClientk3;
    private ScheduleClientk4 scheduleClientk4;
    private ScheduleClientk5 scheduleClientk5;
    private ScheduleClientk6 scheduleClientk6;
    private ScheduleClientk7 scheduleClientk7;
    private ScheduleClientk8 scheduleClientk8;
    private ScheduleClientk9 scheduleClientk9;
    private ScheduleClientk10 scheduleClientk10;
    private ScheduleClientk11 scheduleClientk11;
    private ScheduleClientk12 scheduleClientk12;
    private ScheduleClientk13 scheduleClientk13;

    //main activity dari pengingat kedelai
    private EditText pilihtanggalk;
    private String ambiltanggalpersemaiank; //ambil tanggal dari datepicker
    private String tanggalpersemaiank; //untuk menjadikan tanggal dan dikirim ke server
    private Button hitungk, simpank, hapusk;

    private TextView et_tgl1, et_tgl1_2, et_tgl2, et_tgl2_2, et_tgl3, et_tgl3_2, et_tgl4, et_tgl4_2, et_tgl5, et_tgl5_2, et_tgl6, et_tgl6_2, et_tgl7, et_tgl7_2, et_tgl8, et_tgl8_2, et_tgl9, et_tgl9_2, et_tgl10, et_tgl10_2, et_tgl11, et_tgl11_2, et_tgl12, et_tgl12_2, et_tgl13, et_tgl13_2, et_tgl14, et_tgl14_2, et_tgl15, et_tgl15_2;
    private RequestQueue mmRequestQueue;
    private static String URL_LIHAT = "http://192.168.43.158/hubungkanke/lihat/lihat_hitungtanggalpengingatkedelai.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pengingat_kedelai);
        setTitle("Kedelai");

        dbHelper = new DataHelper(this);

        init();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM kedelai",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            cursor.moveToPosition(0);
            et_tgl1.setText(cursor.getString(0).toString());et_tgl1_2.setText(cursor.getString(1).toString());
            et_tgl2.setText(cursor.getString(2).toString());et_tgl2_2.setText(cursor.getString(3).toString());
            et_tgl3.setText(cursor.getString(4).toString());et_tgl3_2.setText(cursor.getString(5).toString());
            et_tgl4.setText(cursor.getString(6).toString());et_tgl4_2.setText(cursor.getString(7).toString());
            et_tgl5.setText(cursor.getString(8).toString());et_tgl5_2.setText(cursor.getString(9).toString());
            et_tgl6.setText(cursor.getString(10).toString());et_tgl6_2.setText(cursor.getString(11).toString());
            et_tgl7.setText(cursor.getString(12).toString());et_tgl7_2.setText(cursor.getString(13).toString());
            et_tgl8.setText(cursor.getString(14).toString());et_tgl8_2.setText(cursor.getString(15).toString());
            et_tgl9.setText(cursor.getString(16).toString());et_tgl9_2.setText(cursor.getString(17).toString());
            et_tgl10.setText(cursor.getString(18).toString());et_tgl10_2.setText(cursor.getString(19).toString());
            et_tgl11.setText(cursor.getString(20).toString());et_tgl11_2.setText(cursor.getString(21).toString());
            et_tgl12.setText(cursor.getString(22).toString());et_tgl12_2.setText(cursor.getString(23).toString());
            et_tgl13.setText(cursor.getString(24).toString());et_tgl13_2.setText(cursor.getString(25).toString());
            //et_tgl14.setText(cursor.getString(26).toString());et_tgl14_2.setText(cursor.getString(27).toString());
//            et_tgl15.setText(cursor.getString(28).toString());et_tgl15_2.setText(cursor.getString(29).toString());
            pilihtanggalk.setText(cursor.getString(26).toString());
            simpank.setVisibility(View.GONE);
        }
        else {
            Toast.makeText(getApplicationContext(), "Anda Belum Memiliki Jadwal Pengingat", Toast.LENGTH_LONG).show();
        }

        // Create a new service client and bind our activity to this service
        scheduleClientk = new ScheduleClientk(this);
        scheduleClientk.doBindService();

        scheduleClientk2 = new ScheduleClientk2(this);
        scheduleClientk2.doBindService();

        scheduleClientk3 = new ScheduleClientk3(this);
        scheduleClientk3.doBindService();

        scheduleClientk4 = new ScheduleClientk4(this);
        scheduleClientk4.doBindService();

        scheduleClientk5 = new ScheduleClientk5(this);
        scheduleClientk5.doBindService();

        scheduleClientk6 = new ScheduleClientk6(this);
        scheduleClientk6.doBindService();

        scheduleClientk7 = new ScheduleClientk7(this);
        scheduleClientk7.doBindService();

        scheduleClientk8 = new ScheduleClientk8(this);
        scheduleClientk8.doBindService();

        scheduleClientk9 = new ScheduleClientk9(this);
        scheduleClientk9.doBindService();

        scheduleClientk10 = new ScheduleClientk10(this);
        scheduleClientk10.doBindService();

        scheduleClientk11 = new ScheduleClientk11(this);
        scheduleClientk11.doBindService();

        scheduleClientk12 = new ScheduleClientk12(this);
        scheduleClientk12.doBindService();

        scheduleClientk13 = new ScheduleClientk13(this);
        scheduleClientk13.doBindService();

//        scheduleClientk14 = new ScheduleClientk14(this);
//        scheduleClientk14.doBindService();

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                pilihtanggalk.setText(sdf.format(myCalendar.getTime()));

                ambiltanggalpersemaiank = pilihtanggalk.getText().toString().trim();
                //int tgl = Integer.parseInt(ambiltanggalnya);
                Date dpersem = null;
                try {
                    dpersem = sdf.parse(ambiltanggalpersemaiank);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ dpersem.getDate() +"/"+(dpersem.getMonth()+1) +"/"+ (dpersem.getYear()+1900), Toast.LENGTH_SHORT).show();
                tanggalpersemaiank = ""+(dpersem.getYear()+1900)+"-"+(dpersem.getMonth()+1) +"-"+dpersem.getDate();

                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+tanggalpersemaian, Toast.LENGTH_SHORT).show();
            }
        };

        pilihtanggalk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(LihatPengingatKedelaiActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        hitungk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmRequestQueue = Volley.newRequestQueue(LihatPengingatKedelaiActivity.this);
                parseJSON();
            }
        });
        hapusk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM kedelai");
                et_tgl1.setText(null);et_tgl1_2.setText(null);
                et_tgl2.setText(null);et_tgl2_2.setText(null);
                et_tgl3.setText(null);et_tgl3_2.setText(null);
                et_tgl4.setText(null);et_tgl4_2.setText(null);
                et_tgl5.setText(null);et_tgl5_2.setText(null);
                et_tgl6.setText(null);et_tgl6_2.setText(null);
                et_tgl7.setText(null);et_tgl7_2.setText(null);
                et_tgl8.setText(null);et_tgl8_2.setText(null);
                et_tgl9.setText(null);et_tgl9_2.setText(null);
                et_tgl10.setText(null);et_tgl10_2.setText(null);
                et_tgl11.setText(null);et_tgl11_2.setText(null);
                et_tgl12.setText(null);et_tgl12_2.setText(null);
                et_tgl13.setText(null);et_tgl13_2.setText("Panen");
//                et_tgl14.setText(null);et_tgl14_2.setText(null);
//                et_tgl15.setText(null);et_tgl15_2.setText("Panen");
                pilihtanggalk.setText("Pilih Tanggal");
                Toast.makeText(LihatPengingatKedelaiActivity.this, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                simpank.setVisibility(View.VISIBLE);

                //hapus
                scheduleClientk.cancelAlarm();
                scheduleClientk2.cancelAlarm();
                scheduleClientk3.cancelAlarm();
                scheduleClientk4.cancelAlarm();
                scheduleClientk5.cancelAlarm();
                scheduleClientk6.cancelAlarm();
                scheduleClientk7.cancelAlarm();
                scheduleClientk8.cancelAlarm();
                scheduleClientk9.cancelAlarm();
                scheduleClientk10.cancelAlarm();
                scheduleClientk11.cancelAlarm();
                scheduleClientk12.cancelAlarm();
                scheduleClientk13.cancelAlarm();
            }
        });

        simpank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                //definisi jam notifikasi
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("kk:mm");
                Date djam = null;
                try {
                    djam = simpleDateFormat.parse("06:43");
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //tanggal 1
                String ambilTgl1 = et_tgl1.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d1 = null;
                try {
                    d1 = sdf.parse(ambilTgl1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year = d1.getYear()+1900;
                int month = d1.getMonth();
                int day = d1.getDate();

                Calendar kedelaitgl1 = Calendar.getInstance();
                kedelaitgl1.set(year, month, day);
                kedelaitgl1.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl1.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl1.set(Calendar.SECOND, 0);

                //tanggal 2
                String ambilTgl2 = et_tgl2.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d2 = null;
                try {
                    d2 = sdf.parse(ambilTgl2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year2 = d2.getYear()+1900;
                int month2 = d2.getMonth();
                int day2 = d2.getDate();

                Calendar kedelaitgl2 = Calendar.getInstance();
                kedelaitgl2.set(year2, month2, day2);
                kedelaitgl2.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl2.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl2.set(Calendar.SECOND, 0);

                //tanggal 3
                String ambilTgl3 = et_tgl3.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d3 = null;
                try {
                    d3 = sdf.parse(ambilTgl3);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year3 = d3.getYear()+1900;
                int month3 = d3.getMonth();
                int day3 = d3.getDate();

                Calendar kedelaitgl3 = Calendar.getInstance();
                kedelaitgl3.set(year3, month3, day3);
                kedelaitgl3.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl3.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl3.set(Calendar.SECOND, 0);

                //tanggal 4
                String ambilTgl4 = et_tgl4.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d4 = null;
                try {
                    d4 = sdf.parse(ambilTgl4);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year4 = d4.getYear()+1900;
                int month4 = d4.getMonth();
                int day4 = d4.getDate();

                Calendar kedelaitgl4 = Calendar.getInstance();
                kedelaitgl4.set(year4, month4, day4);
                kedelaitgl4.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl4.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl4.set(Calendar.SECOND, 0);

                //tanggal 5
                String ambilTgl5 = et_tgl5.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d5 = null;
                try {
                    d5 = sdf.parse(ambilTgl5);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year5 = d5.getYear()+1900;
                int month5 = d5.getMonth();
                int day5 = d5.getDate();

                Calendar kedelaitgl5 = Calendar.getInstance();
                kedelaitgl5.set(year5, month5, day5);
                kedelaitgl5.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl5.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl5.set(Calendar.SECOND, 0);

                //tanggal 6
                String ambilTgl6 = et_tgl6.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d6 = null;
                try {
                    d6 = sdf.parse(ambilTgl6);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year6 = d6.getYear()+1900;
                int month6 = d6.getMonth();
                int day6 = d6.getDate();

                Calendar kedelaitgl6 = Calendar.getInstance();
                kedelaitgl6.set(year6, month6, day6);
                kedelaitgl6.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl6.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl6.set(Calendar.SECOND, 0);

                //tanggal 7
                String ambilTgl7 = et_tgl7.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d7 = null;
                try {
                    d7 = sdf.parse(ambilTgl7);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year7 = d7.getYear()+1900;
                int month7 = d7.getMonth();
                int day7 = d7.getDate();

                Calendar kedelaitgl7 = Calendar.getInstance();
                kedelaitgl7.set(year7, month7, day7);
                kedelaitgl7.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl7.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl7.set(Calendar.SECOND, 0);

                //tanggal 8
                String ambilTgl8 = et_tgl8.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d8 = null;
                try {
                    d8 = sdf.parse(ambilTgl8);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year8 = d8.getYear()+1900;
                int month8 = d8.getMonth();
                int day8 = d8.getDate();

                Calendar kedelaitgl8 = Calendar.getInstance();
                kedelaitgl8.set(year8, month8, day8);
                kedelaitgl8.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl8.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl8.set(Calendar.SECOND, 0);

                //tanggal 9
                String ambilTgl9 = et_tgl9.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d9 = null;
                try {
                    d9 = sdf.parse(ambilTgl9);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year9 = d9.getYear()+1900;
                int month9 = d9.getMonth();
                int day9 = d9.getDate();

                Calendar kedelaitgl9 = Calendar.getInstance();
                kedelaitgl9.set(year9, month9, day9);
                kedelaitgl9.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl9.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl9.set(Calendar.SECOND, 0);

                //tanggal 10
                String ambilTgl10 = et_tgl10.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d10 = null;
                try {
                    d10 = sdf.parse(ambilTgl10);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year10 = d10.getYear()+1900;
                int month10 = d10.getMonth();
                int day10 = d10.getDate();

                Calendar kedelaitgl10 = Calendar.getInstance();
                kedelaitgl10.set(year10, month10, day10);
                kedelaitgl10.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl10.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl10.set(Calendar.SECOND, 0);

                //tanggal 11
                String ambilTgl11 = et_tgl11.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d11 = null;
                try {
                    d11 = sdf.parse(ambilTgl11);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year11 = d11.getYear()+1900;
                int month11 = d11.getMonth();
                int day11 = d11.getDate();

                Calendar kedelaitgl11 = Calendar.getInstance();
                kedelaitgl11.set(year11, month11, day11);
                kedelaitgl11.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl11.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl11.set(Calendar.SECOND, 0);

                //tanggal 12
                String ambilTgl12 = et_tgl12.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d12 = null;
                try {
                    d12 = sdf.parse(ambilTgl12);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year12 = d12.getYear()+1900;
                int month12 = d12.getMonth();
                int day12 = d12.getDate();

                Calendar kedelaitgl12 = Calendar.getInstance();
                kedelaitgl12.set(year12, month12, day12);
                kedelaitgl12.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl12.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl12.set(Calendar.SECOND, 0);

                //tanggal 13
                String ambilTgl13 = et_tgl13.getText().toString().trim();
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d13 = null;
                try {
                    d13 = sdf.parse(ambilTgl13);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year13 = d13.getYear()+1900;
                int month13 = d13.getMonth();
                int day13 = d13.getDate();

                Calendar kedelaitgl13 = Calendar.getInstance();
                kedelaitgl13.set(year13, month13, day13);
                kedelaitgl13.set(Calendar.HOUR_OF_DAY, djam.getHours());
                kedelaitgl13.set(Calendar.MINUTE, djam.getMinutes());
                kedelaitgl13.set(Calendar.SECOND, 0);

//                //tanggal 14
//                String ambilTgl14 = et_tgl14.getText().toString().trim();
//                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
//                Date d14 = null;
//                try {
//                    d14 = sdf.parse(ambilTgl14);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                int year14 = d14.getYear()+1900;
//                int month14 = d14.getMonth();
//                int day14 = d14.getDate();
//
//                Calendar kedelaitgl14 = Calendar.getInstance();
//                kedelaitgl14.set(year14, month14, day14);
//                kedelaitgl14.set(Calendar.HOUR_OF_DAY, djam.getHours());
//                kedelaitgl14.set(Calendar.MINUTE, djam.getMinutes());
//                kedelaitgl14.set(Calendar.SECOND, 0);
//
//                //tanggal 15
//                String ambilTgl15 = et_tgl15.getText().toString().trim();
//                //Toast.makeText(LihatPengingatKedelaiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
//                Date d15 = null;
//                try {
//                    d15 = sdf.parse(ambilTgl15);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                int year15 = d15.getYear()+1900;
//                int month15 = d15.getMonth();
//                int day15 = d15.getDate();
//
//                Calendar kedelaitgl15 = Calendar.getInstance();
//                kedelaitgl15.set(year15, month15, day15);
//                kedelaitgl15.set(Calendar.HOUR_OF_DAY, djam.getHours());
//                kedelaitgl15.set(Calendar.MINUTE, djam.getMinutes());
//                kedelaitgl15.set(Calendar.SECOND, 0);

                scheduleClientk.setAlarmForNotification(kedelaitgl1);
                scheduleClientk2.setAlarmForNotification(kedelaitgl2);
                scheduleClientk3.setAlarmForNotification(kedelaitgl3);
                scheduleClientk4.setAlarmForNotification(kedelaitgl4);
                scheduleClientk5.setAlarmForNotification(kedelaitgl5);
                scheduleClientk6.setAlarmForNotification(kedelaitgl6);
                scheduleClientk7.setAlarmForNotification(kedelaitgl7);
                scheduleClientk8.setAlarmForNotification(kedelaitgl8);
                scheduleClientk9.setAlarmForNotification(kedelaitgl9);
                scheduleClientk10.setAlarmForNotification(kedelaitgl10);
                scheduleClientk11.setAlarmForNotification(kedelaitgl11);
                scheduleClientk12.setAlarmForNotification(kedelaitgl12);
                scheduleClientk13.setAlarmForNotification(kedelaitgl13);
                //scheduleClientk14.setAlarmForNotification(kedelaitgl14);
                //Toast.makeText(LihatPengingatKedelaiActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into kedelai (et_tgl1, et_tgl1_2, et_tgl2, et_tgl2_2, et_tgl3, et_tgl3_2, et_tgl4, et_tgl4_2, et_tgl5, et_tgl5_2, et_tgl6, et_tgl6_2, et_tgl7, et_tgl7_2, et_tgl8, et_tgl8_2, et_tgl9, et_tgl9_2, et_tgl10, et_tgl10_2, et_tgl11, et_tgl11_2, et_tgl12, et_tgl12_2, et_tgl13, et_tgl13_2, awal) VALUES('" +
                        et_tgl1.getText().toString() + "','" +et_tgl1_2.getText().toString() + "','" +
                        et_tgl2.getText().toString() + "','" +et_tgl2_2.getText().toString() + "','" +
                        et_tgl3.getText().toString() + "','" +et_tgl3_2.getText().toString() + "','" +
                        et_tgl4.getText().toString() + "','" +et_tgl4_2.getText().toString() + "','" +
                        et_tgl5.getText().toString() + "','" +et_tgl5_2.getText().toString() + "','" +
                        et_tgl6.getText().toString() + "','" +et_tgl6_2.getText().toString() + "','" +
                        et_tgl7.getText().toString() + "','" +et_tgl7_2.getText().toString() + "','" +
                        et_tgl8.getText().toString() + "','" +et_tgl8_2.getText().toString() + "','" +
                        et_tgl9.getText().toString() + "','" +et_tgl9_2.getText().toString() + "','" +
                        et_tgl10.getText().toString() + "','" +et_tgl10_2.getText().toString() + "','" +
                        et_tgl11.getText().toString() + "','" +et_tgl11_2.getText().toString() + "','" +
                        et_tgl12.getText().toString() + "','" +et_tgl12_2.getText().toString() + "','" +
                        et_tgl13.getText().toString() + "','" +et_tgl13_2.getText().toString() + "','" +
                        pilihtanggalk.getText().toString() + "')");
                simpank.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void parseJSON() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LIHAT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("read");

                            for (int i=0; i<jsonArray.length(); i++){
                                JSONObject result = jsonArray.getJSONObject(i);

                                String tgl1 = result.getString("tgl1").trim();String tgl1_2 = result.getString("tgl1_2").trim();
                                String tgl2 = result.getString("tgl2").trim();String tgl2_2 = result.getString("tgl2_2").trim();
                                String tgl3 = result.getString("tgl3").trim();String tgl3_2 = result.getString("tgl3_2").trim();
                                String tgl4 = result.getString("tgl4").trim();String tgl4_2 = result.getString("tgl4_2").trim();
                                String tgl5 = result.getString("tgl5").trim();String tgl5_2 = result.getString("tgl5_2").trim();
                                String tgl6 = result.getString("tgl6").trim();String tgl6_2 = result.getString("tgl6_2").trim();
                                String tgl7 = result.getString("tgl7").trim();String tgl7_2 = result.getString("tgl7_2").trim();
                                String tgl8 = result.getString("tgl8").trim();String tgl8_2 = result.getString("tgl8_2").trim();
                                String tgl9 = result.getString("tgl9").trim();String tgl9_2 = result.getString("tgl9_2").trim();
                                String tgl10 = result.getString("tgl10").trim();String tgl10_2 = result.getString("tgl10_2").trim();
                                String tgl11 = result.getString("tgl11").trim();String tgl11_2 = result.getString("tgl11_2").trim();
                                String tgl12 = result.getString("tgl12").trim();String tgl12_2 = result.getString("tgl12_2").trim();
                                String tgl13 = result.getString("tgl13").trim();String tgl13_2 = result.getString("tgl13_2").trim();
                                //String tgl14 = result.getString("tgl14").trim();String tgl14_2 = result.getString("tgl14_2").trim();
                                //String tgl15 = result.getString("tgl15").trim();String tgl15_2 = result.getString("tgl15_2").trim();

                                et_tgl1.setText(tgl1);et_tgl1_2.setText(tgl1_2);
                                et_tgl2.setText(tgl2);et_tgl2_2.setText(tgl2_2);
                                et_tgl3.setText(tgl3);et_tgl3_2.setText(tgl3_2);
                                et_tgl4.setText(tgl4);et_tgl4_2.setText(tgl4_2);
                                et_tgl5.setText(tgl5);et_tgl5_2.setText(tgl5_2);
                                et_tgl6.setText(tgl6);et_tgl6_2.setText(tgl6_2);
                                et_tgl7.setText(tgl7);et_tgl7_2.setText(tgl7_2);
                                et_tgl8.setText(tgl8);et_tgl8_2.setText(tgl8_2);
                                et_tgl9.setText(tgl9);et_tgl9_2.setText(tgl9_2);
                                et_tgl10.setText(tgl10);et_tgl10_2.setText(tgl10_2);
                                et_tgl11.setText(tgl11);et_tgl11_2.setText(tgl11_2);
                                et_tgl12.setText(tgl12);et_tgl12_2.setText(tgl12_2);
                                et_tgl13.setText(tgl13);et_tgl13_2.setText(tgl13_2);
//                                et_tgl14.setText(tgl14);et_tgl14_2.setText(tgl14_2);
//                                et_tgl15.setText(tgl15);et_tgl15_2.setText(tgl15_2);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LihatPengingatKedelaiActivity.this, "Gagal catch" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(LihatPengingatKedelaiActivity.this, "Gagal response" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String fk="3";
                Map<String, String> params = new HashMap<>();
                params.put("tanggalpersemaian", tanggalpersemaiank);
                params.put("id", fk);
                return params;
            }
        };

        mmRequestQueue.add(stringRequest);
    }

    private void init() {
        hitungk = findViewById(R.id.btn_hitungk);
        simpank = findViewById(R.id.btn_simpanpengingatk);
        pilihtanggalk = findViewById(R.id.tv_ambiltanggalk);
        hapusk = findViewById(R.id.btn_hapuspengingatk);
        et_tgl1 = findViewById(R.id.k_tgl1);et_tgl1_2 = findViewById(R.id.k_tgl1_2);
        et_tgl2 = findViewById(R.id.k_tgl2);et_tgl2_2 = findViewById(R.id.k_tgl2_2);
        et_tgl3 = findViewById(R.id.k_tgl3);et_tgl3_2 = findViewById(R.id.k_tgl3_2);
        et_tgl4 = findViewById(R.id.k_tgl4);et_tgl4_2 = findViewById(R.id.k_tgl4_2);
        et_tgl5 = findViewById(R.id.k_tgl5);et_tgl5_2 = findViewById(R.id.k_tgl5_2);
        et_tgl6 = findViewById(R.id.k_tgl6);et_tgl6_2 = findViewById(R.id.k_tgl6_2);
        et_tgl7 = findViewById(R.id.k_tgl7);et_tgl7_2 = findViewById(R.id.k_tgl7_2);
        et_tgl8 = findViewById(R.id.k_tgl8);et_tgl8_2 = findViewById(R.id.k_tgl8_2);
        et_tgl9 = findViewById(R.id.k_tgl9);et_tgl9_2 = findViewById(R.id.k_tgl9_2);
        et_tgl10 = findViewById(R.id.k_tgl10);et_tgl10_2 = findViewById(R.id.k_tgl10_2);
        et_tgl11 = findViewById(R.id.k_tgl11);et_tgl11_2 = findViewById(R.id.k_tgl11_2);
        et_tgl12 = findViewById(R.id.k_tgl12);et_tgl12_2 = findViewById(R.id.k_tgl12_2);
        et_tgl13 = findViewById(R.id.k_tgl13);et_tgl13_2 = findViewById(R.id.k_tgl13_2);
        //et_tgl14 = findViewById(R.id.k_tgl14);et_tgl14_2 = findViewById(R.id.k_tgl14_2);
//        et_tgl15 = findViewById(R.id.k_tgl15);et_tgl15_2 = findViewById(R.id.k_tgl15_2);
    }

    @Override
    protected void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClientk != null)
            scheduleClientk.doUnbindService();
        else if(scheduleClientk2 != null)
            scheduleClientk2.doUnbindService();
        else if(scheduleClientk3 != null)
            scheduleClientk3.doUnbindService();
        else if(scheduleClientk4 != null)
            scheduleClientk4.doUnbindService();
        else if(scheduleClientk5 != null)
            scheduleClientk5.doUnbindService();
        else if(scheduleClientk6 != null)
            scheduleClientk6.doUnbindService();
        else if(scheduleClientk7 != null)
            scheduleClientk7.doUnbindService();
        else if(scheduleClientk8 != null)
            scheduleClientk8.doUnbindService();
        else if(scheduleClientk9 != null)
            scheduleClientk9.doUnbindService();
        else if(scheduleClientk10 != null)
            scheduleClientk10.doUnbindService();
        else if(scheduleClientk11 != null)
            scheduleClientk11.doUnbindService();
        else if(scheduleClientk12 != null)
            scheduleClientk12.doUnbindService();
        else if(scheduleClientk13 != null)
            scheduleClientk13.doUnbindService();
//        else if(scheduleClientk14 != null)
//            scheduleClientk14.doUnbindService();
        super.onStop();
    }

    public void ktgl1(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 29);
        startActivity(budal);
    }
    public void ktgl2(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 30);
        startActivity(budal);
    }
    public void ktgl3(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 31);
        startActivity(budal);
    }
    public void ktgl4(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 32);
        startActivity(budal);
    }
    public void ktgl5(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 33);
        startActivity(budal);
    }
    public void ktgl6(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 34);
        startActivity(budal);
    }
    public void ktgl7(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 35);
        startActivity(budal);
    }
    public void ktgl8(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 36);
        startActivity(budal);
    }
    public void ktgl9(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 37);
        startActivity(budal);

    }public void ktgl10(View view) {
        Intent budal = new Intent(this, MonitorHamaKeActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 38);
        startActivity(budal);
    }
    public void ktgl11(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 39);
        startActivity(budal);
    }
    public void ktgl12(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 40);
        startActivity(budal);
    }public void ktgl13(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 41);
        startActivity(budal);
    }
//    public void ktgl14(View view) {
//        Intent budal = new Intent(this, DetailPengingatActivity.class);
//        budal.putExtra(LihatPengingatKedelaiActivity.EXTRA_ID, 14);
//        startActivity(budal);
//    }
}
