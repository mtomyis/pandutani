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
import com.uiuaadingding.tomtom.pandutani.pakar.bwd.BwdActivity;
import com.uiuaadingding.tomtom.pandutani.pakar.jagung.MonitorHamaJaActivity;
import com.uiuaadingding.tomtom.pandutani.pakar.padi.MonitorHamaActivity;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl1.ScheduleClientj;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl10.ScheduleClientj10;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl11.ScheduleClientj11;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl12.ScheduleClientj12;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl13.ScheduleClientj13;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl14.ScheduleClientj14;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl2.ScheduleClientj2;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl3.ScheduleClientj3;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl4.ScheduleClientj4;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl5.ScheduleClientj5;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl6.ScheduleClientj6;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl7.ScheduleClientj7;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl8.ScheduleClientj8;
import com.uiuaadingding.tomtom.pandutani.pengingat_jagung.jtgl9.ScheduleClientj9;

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


public class LihatPengingatJagungActivity extends AppCompatActivity {
    protected static String EXTRA_ID = "";
    private static final String TAG = LihatPengingatJagungActivity.class.getSimpleName();

    protected Cursor cursor;
    private DataHelper dbHelper;

    // This is a handle so that we can call methods on our service
    private ScheduleClientj scheduleClientj;
    private ScheduleClientj2 scheduleClientj2;
    private ScheduleClientj3 scheduleClientj3;
    private ScheduleClientj4 scheduleClientj4;
    private ScheduleClientj5 scheduleClientj5;
    private ScheduleClientj6 scheduleClientj6;
    private ScheduleClientj7 scheduleClientj7;
    private ScheduleClientj8 scheduleClientj8;
    private ScheduleClientj9 scheduleClientj9;
    private ScheduleClientj10 scheduleClientj10;
    private ScheduleClientj11 scheduleClientj11;
    private ScheduleClientj12 scheduleClientj12;
    private ScheduleClientj13 scheduleClientj13;
    private ScheduleClientj14 scheduleClientj14;

    //main activity dari pengingat jagung
    private EditText pilihtanggalj;
    private String ambiltanggalpersemaianj; //ambil tanggal dari datepicker
    private String tanggalpersemaianj; //untuk menjadikan tanggal dan dikirim ke server
    private Button hitungj, simpanj, hapusj;

    private TextView et_tgl1, et_tgl1_2, et_tgl2, et_tgl2_2, et_tgl3, et_tgl3_2, et_tgl4, et_tgl4_2, et_tgl5, et_tgl5_2, et_tgl6, et_tgl6_2, et_tgl7, et_tgl7_2, et_tgl8, et_tgl8_2, et_tgl9, et_tgl9_2, et_tgl10, et_tgl10_2, et_tgl11, et_tgl11_2, et_tgl12, et_tgl12_2, et_tgl13, et_tgl13_2, et_tgl14, et_tgl14_2, et_tgl15, et_tgl15_2;
    private RequestQueue mmRequestQueue;
    private static String URL_LIHAT = "http://192.168.43.158/hubungkanke/lihat/lihat_hitungtanggalpengingatjagung.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pengingat_jagung);
        setTitle("Jagung");

        dbHelper = new DataHelper(this);

        init();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM jagung",null);
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
            pilihtanggalj.setText(cursor.getString(26).toString());
            simpanj.setVisibility(View.GONE);
        }
        else {
            Toast.makeText(getApplicationContext(), "Anda Belum Memiliki Jadwal Pengingat", Toast.LENGTH_LONG).show();
        }

        // Create a new service client and bind our activity to this service
        scheduleClientj = new ScheduleClientj(this);
        scheduleClientj.doBindService();

        scheduleClientj2 = new ScheduleClientj2(this);
        scheduleClientj2.doBindService();

        scheduleClientj3 = new ScheduleClientj3(this);
        scheduleClientj3.doBindService();

        scheduleClientj4 = new ScheduleClientj4(this);
        scheduleClientj4.doBindService();

        scheduleClientj5 = new ScheduleClientj5(this);
        scheduleClientj5.doBindService();

        scheduleClientj6 = new ScheduleClientj6(this);
        scheduleClientj6.doBindService();

        scheduleClientj7 = new ScheduleClientj7(this);
        scheduleClientj7.doBindService();

        scheduleClientj8 = new ScheduleClientj8(this);
        scheduleClientj8.doBindService();

        scheduleClientj9 = new ScheduleClientj9(this);
        scheduleClientj9.doBindService();

        scheduleClientj10 = new ScheduleClientj10(this);
        scheduleClientj10.doBindService();

        scheduleClientj11 = new ScheduleClientj11(this);
        scheduleClientj11.doBindService();

        scheduleClientj12 = new ScheduleClientj12(this);
        scheduleClientj12.doBindService();

        scheduleClientj13 = new ScheduleClientj13(this);
        scheduleClientj13.doBindService();

//        scheduleClientj14 = new ScheduleClientj14(this);
//        scheduleClientj14.doBindService();

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                pilihtanggalj.setText(sdf.format(myCalendar.getTime()));

                ambiltanggalpersemaianj = pilihtanggalj.getText().toString().trim();
                //int tgl = Integer.parseInt(ambiltanggalnya);
                Date dpersem = null;
                try {
                    dpersem = sdf.parse(ambiltanggalpersemaianj);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ dpersem.getDate() +"/"+(dpersem.getMonth()+1) +"/"+ (dpersem.getYear()+1900), Toast.LENGTH_SHORT).show();
                tanggalpersemaianj = ""+(dpersem.getYear()+1900)+"-"+(dpersem.getMonth()+1) +"-"+dpersem.getDate();

                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+tanggalpersemaian, Toast.LENGTH_SHORT).show();
            }
        };

        pilihtanggalj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(LihatPengingatJagungActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        hitungj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmRequestQueue = Volley.newRequestQueue(LihatPengingatJagungActivity.this);
                parseJSON();
            }
        });
        hapusj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM jagung");
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
                pilihtanggalj.setText("Pilih Tanggal");
                Toast.makeText(LihatPengingatJagungActivity.this, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                simpanj.setVisibility(View.VISIBLE);

                //hapus
                scheduleClientj.cancelAlarm();
                scheduleClientj2.cancelAlarm();
                scheduleClientj3.cancelAlarm();
                scheduleClientj4.cancelAlarm();
                scheduleClientj5.cancelAlarm();
                scheduleClientj6.cancelAlarm();
                scheduleClientj7.cancelAlarm();
                scheduleClientj8.cancelAlarm();
                scheduleClientj9.cancelAlarm();
                scheduleClientj10.cancelAlarm();
                scheduleClientj11.cancelAlarm();
                scheduleClientj12.cancelAlarm();
                scheduleClientj13.cancelAlarm();

            }
        });

        simpanj.setOnClickListener(new View.OnClickListener() {
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
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d1 = null;
                try {
                    d1 = sdf.parse(ambilTgl1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year = d1.getYear()+1900;
                int month = d1.getMonth();
                int day = d1.getDate();

                Calendar jagungtgl1 = Calendar.getInstance();
                jagungtgl1.set(year, month, day);
                jagungtgl1.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl1.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl1.set(Calendar.SECOND, 0);

                //tanggal 2
                String ambilTgl2 = et_tgl2.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d2 = null;
                try {
                    d2 = sdf.parse(ambilTgl2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year2 = d2.getYear()+1900;
                int month2 = d2.getMonth();
                int day2 = d2.getDate();

                Calendar jagungtgl2 = Calendar.getInstance();
                jagungtgl2.set(year2, month2, day2);
                jagungtgl2.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl2.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl2.set(Calendar.SECOND, 0);

                //tanggal 3
                String ambilTgl3 = et_tgl3.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d3 = null;
                try {
                    d3 = sdf.parse(ambilTgl3);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year3 = d3.getYear()+1900;
                int month3 = d3.getMonth();
                int day3 = d3.getDate();

                Calendar jagungtgl3 = Calendar.getInstance();
                jagungtgl3.set(year3, month3, day3);
                jagungtgl3.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl3.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl3.set(Calendar.SECOND, 0);

                //tanggal 4
                String ambilTgl4 = et_tgl4.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d4 = null;
                try {
                    d4 = sdf.parse(ambilTgl4);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year4 = d4.getYear()+1900;
                int month4 = d4.getMonth();
                int day4 = d4.getDate();

                Calendar jagungtgl4 = Calendar.getInstance();
                jagungtgl4.set(year4, month4, day4);
                jagungtgl4.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl4.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl4.set(Calendar.SECOND, 0);

                //tanggal 5
                String ambilTgl5 = et_tgl5.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d5 = null;
                try {
                    d5 = sdf.parse(ambilTgl5);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year5 = d5.getYear()+1900;
                int month5 = d5.getMonth();
                int day5 = d5.getDate();

                Calendar jagungtgl5 = Calendar.getInstance();
                jagungtgl5.set(year5, month5, day5);
                jagungtgl5.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl5.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl5.set(Calendar.SECOND, 0);

                //tanggal 6
                String ambilTgl6 = et_tgl6.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d6 = null;
                try {
                    d6 = sdf.parse(ambilTgl6);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year6 = d6.getYear()+1900;
                int month6 = d6.getMonth();
                int day6 = d6.getDate();

                Calendar jagungtgl6 = Calendar.getInstance();
                jagungtgl6.set(year6, month6, day6);
                jagungtgl6.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl6.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl6.set(Calendar.SECOND, 0);

                //tanggal 7
                String ambilTgl7 = et_tgl7.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d7 = null;
                try {
                    d7 = sdf.parse(ambilTgl7);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year7 = d7.getYear()+1900;
                int month7 = d7.getMonth();
                int day7 = d7.getDate();

                Calendar jagungtgl7 = Calendar.getInstance();
                jagungtgl7.set(year7, month7, day7);
                jagungtgl7.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl7.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl7.set(Calendar.SECOND, 0);

                //tanggal 8
                String ambilTgl8 = et_tgl8.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d8 = null;
                try {
                    d8 = sdf.parse(ambilTgl8);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year8 = d8.getYear()+1900;
                int month8 = d8.getMonth();
                int day8 = d8.getDate();

                Calendar jagungtgl8 = Calendar.getInstance();
                jagungtgl8.set(year8, month8, day8);
                jagungtgl8.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl8.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl8.set(Calendar.SECOND, 0);

                //tanggal 9
                String ambilTgl9 = et_tgl9.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d9 = null;
                try {
                    d9 = sdf.parse(ambilTgl9);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year9 = d9.getYear()+1900;
                int month9 = d9.getMonth();
                int day9 = d9.getDate();

                Calendar jagungtgl9 = Calendar.getInstance();
                jagungtgl9.set(year9, month9, day9);
                jagungtgl9.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl9.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl9.set(Calendar.SECOND, 0);

                //tanggal 10
                String ambilTgl10 = et_tgl10.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d10 = null;
                try {
                    d10 = sdf.parse(ambilTgl10);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year10 = d10.getYear()+1900;
                int month10 = d10.getMonth();
                int day10 = d10.getDate();

                Calendar jagungtgl10 = Calendar.getInstance();
                jagungtgl10.set(year10, month10, day10);
                jagungtgl10.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl10.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl10.set(Calendar.SECOND, 0);

                //tanggal 11
                String ambilTgl11 = et_tgl11.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d11 = null;
                try {
                    d11 = sdf.parse(ambilTgl11);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year11 = d11.getYear()+1900;
                int month11 = d11.getMonth();
                int day11 = d11.getDate();

                Calendar jagungtgl11 = Calendar.getInstance();
                jagungtgl11.set(year11, month11, day11);
                jagungtgl11.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl11.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl11.set(Calendar.SECOND, 0);

                //tanggal 12
                String ambilTgl12 = et_tgl12.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d12 = null;
                try {
                    d12 = sdf.parse(ambilTgl12);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year12 = d12.getYear()+1900;
                int month12 = d12.getMonth();
                int day12 = d12.getDate();

                Calendar jagungtgl12 = Calendar.getInstance();
                jagungtgl12.set(year12, month12, day12);
                jagungtgl12.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl12.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl12.set(Calendar.SECOND, 0);

                //tanggal 13
                String ambilTgl13 = et_tgl13.getText().toString().trim();
                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d13 = null;
                try {
                    d13 = sdf.parse(ambilTgl13);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year13 = d13.getYear()+1900;
                int month13 = d13.getMonth();
                int day13 = d13.getDate();

                Calendar jagungtgl13 = Calendar.getInstance();
                jagungtgl13.set(year13, month13, day13);
                jagungtgl13.set(Calendar.HOUR_OF_DAY, djam.getHours());
                jagungtgl13.set(Calendar.MINUTE, djam.getMinutes());
                jagungtgl13.set(Calendar.SECOND, 0);

//                //tanggal 14
//                String ambilTgl14 = et_tgl14.getText().toString().trim();
//                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
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
//                Calendar jagungtgl14 = Calendar.getInstance();
//                jagungtgl14.set(year14, month14, day14);
//                jagungtgl14.set(Calendar.HOUR_OF_DAY, djam.getHours());
//                jagungtgl14.set(Calendar.MINUTE, djam.getMinutes());
//                jagungtgl14.set(Calendar.SECOND, 0);
//
//                //tanggal 15
//                String ambilTgl15 = et_tgl15.getText().toString().trim();
//                //Toast.makeText(LihatPengingatJagungActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
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
//                Calendar jagungtgl15 = Calendar.getInstance();
//                jagungtgl15.set(year15, month15, day15);
//                jagungtgl15.set(Calendar.HOUR_OF_DAY, djam.getHours());
//                jagungtgl15.set(Calendar.MINUTE, djam.getMinutes());
//                jagungtgl15.set(Calendar.SECOND, 0);

                scheduleClientj.setAlarmForNotification(jagungtgl1);
                scheduleClientj2.setAlarmForNotification(jagungtgl2);
                scheduleClientj3.setAlarmForNotification(jagungtgl3);
                scheduleClientj4.setAlarmForNotification(jagungtgl4);
                scheduleClientj5.setAlarmForNotification(jagungtgl5);
                scheduleClientj6.setAlarmForNotification(jagungtgl6);
                scheduleClientj7.setAlarmForNotification(jagungtgl7);
                scheduleClientj8.setAlarmForNotification(jagungtgl8);
                scheduleClientj9.setAlarmForNotification(jagungtgl9);
                scheduleClientj10.setAlarmForNotification(jagungtgl10);
                scheduleClientj11.setAlarmForNotification(jagungtgl11);
                scheduleClientj12.setAlarmForNotification(jagungtgl12);
                scheduleClientj13.setAlarmForNotification(jagungtgl13);
                //scheduleClientj14.setAlarmForNotification(jagungtgl14);
                //Toast.makeText(LihatPengingatJagungActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into jagung (et_tgl1, et_tgl1_2, et_tgl2, et_tgl2_2, et_tgl3, et_tgl3_2, et_tgl4, et_tgl4_2, et_tgl5, et_tgl5_2, et_tgl6, et_tgl6_2, et_tgl7, et_tgl7_2, et_tgl8, et_tgl8_2, et_tgl9, et_tgl9_2, et_tgl10, et_tgl10_2, et_tgl11, et_tgl11_2, et_tgl12, et_tgl12_2, et_tgl13, et_tgl13_2, awal) VALUES('" +
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
                        pilihtanggalj.getText().toString() + "')");
                simpanj.setVisibility(View.GONE);
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
                            Toast.makeText(LihatPengingatJagungActivity.this, "Gagal catch" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(LihatPengingatJagungActivity.this, "Gagal response" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String fk="2";
                Map<String, String> params = new HashMap<>();
                params.put("tanggalpersemaian", tanggalpersemaianj);
                params.put("id", fk);
                return params;
            }
        };

        mmRequestQueue.add(stringRequest);
    }

    private void init() {
        hitungj = findViewById(R.id.btn_hitungj);
        simpanj = findViewById(R.id.btn_simpanpengingatj);
        pilihtanggalj = findViewById(R.id.tv_ambiltanggalj);
        hapusj = findViewById(R.id.btn_hapuspengingatj);
        et_tgl1 = findViewById(R.id.j_tgl1);et_tgl1_2 = findViewById(R.id.j_tgl1_2);
        et_tgl2 = findViewById(R.id.j_tgl2);et_tgl2_2 = findViewById(R.id.j_tgl2_2);
        et_tgl3 = findViewById(R.id.j_tgl3);et_tgl3_2 = findViewById(R.id.j_tgl3_2);
        et_tgl4 = findViewById(R.id.j_tgl4);et_tgl4_2 = findViewById(R.id.j_tgl4_2);
        et_tgl5 = findViewById(R.id.j_tgl5);et_tgl5_2 = findViewById(R.id.j_tgl5_2);
        et_tgl6 = findViewById(R.id.j_tgl6);et_tgl6_2 = findViewById(R.id.j_tgl6_2);
        et_tgl7 = findViewById(R.id.j_tgl7);et_tgl7_2 = findViewById(R.id.j_tgl7_2);
        et_tgl8 = findViewById(R.id.j_tgl8);et_tgl8_2 = findViewById(R.id.j_tgl8_2);
        et_tgl9 = findViewById(R.id.j_tgl9);et_tgl9_2 = findViewById(R.id.j_tgl9_2);
        et_tgl10 = findViewById(R.id.j_tgl10);et_tgl10_2 = findViewById(R.id.j_tgl10_2);
        et_tgl11 = findViewById(R.id.j_tgl11);et_tgl11_2 = findViewById(R.id.j_tgl11_2);
        et_tgl12 = findViewById(R.id.j_tgl12);et_tgl12_2 = findViewById(R.id.j_tgl12_2);
        et_tgl13 = findViewById(R.id.j_tgl13);et_tgl13_2 = findViewById(R.id.j_tgl13_2);
        //et_tgl14 = findViewById(R.id.j_tgl14);et_tgl14_2 = findViewById(R.id.j_tgl14_2);
//        et_tgl15 = findViewById(R.id.j_tgl15);et_tgl15_2 = findViewById(R.id.j_tgl15_2);
    }

    @Override
    protected void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClientj != null)
            scheduleClientj.doUnbindService();
        else if(scheduleClientj2 != null)
            scheduleClientj2.doUnbindService();
        else if(scheduleClientj3 != null)
            scheduleClientj3.doUnbindService();
        else if(scheduleClientj4 != null)
            scheduleClientj4.doUnbindService();
        else if(scheduleClientj5 != null)
            scheduleClientj5.doUnbindService();
        else if(scheduleClientj6 != null)
            scheduleClientj6.doUnbindService();
        else if(scheduleClientj7 != null)
            scheduleClientj7.doUnbindService();
        else if(scheduleClientj8 != null)
            scheduleClientj8.doUnbindService();
        else if(scheduleClientj9 != null)
            scheduleClientj9.doUnbindService();
        else if(scheduleClientj10 != null)
            scheduleClientj10.doUnbindService();
        else if(scheduleClientj11 != null)
            scheduleClientj11.doUnbindService();
        else if(scheduleClientj12 != null)
            scheduleClientj12.doUnbindService();
        else if(scheduleClientj13 != null)
            scheduleClientj13.doUnbindService();
//        else if(scheduleClientj14 != null)
//            scheduleClientj14.doUnbindService();
        super.onStop();
    }

    public void jtgl1(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 16);
        startActivity(budal);
    }
    public void jtgl2(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 17);
        startActivity(budal);
    }
    public void jtgl3(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 18);
        startActivity(budal);
    }
    public void jtgl4(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 19);
        startActivity(budal);
    }
    public void jtgl5(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 20);
        startActivity(budal);
    }
    public void jtgl6(View view) {
        Intent budal = new Intent(this, MonitorHamaJaActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 21);
        startActivity(budal);
    }
    public void jtgl7(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 22);
        startActivity(budal);
    }
    public void jtgl8(View view) {
        Intent budal = new Intent(this, BwdActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 23);
        startActivity(budal);
    }
    public void jtgl9(View view) {
        Intent budal = new Intent(this, MonitorHamaJaActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 24);
        startActivity(budal);
    }public void jtgl10(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 25);
        startActivity(budal);
    }
    public void jtgl11(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 26);
        startActivity(budal);
    }
    public void jtgl12(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 27);
        startActivity(budal);
    }public void jtgl13(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 28);
        startActivity(budal);
    }
//    public void jtgl14(View view) {
//        Intent budal = new Intent(this, DetailPengingatActivity.class);
//        budal.putExtra(LihatPengingatJagungActivity.EXTRA_ID, 14);
//        startActivity(budal);
//    }
}
