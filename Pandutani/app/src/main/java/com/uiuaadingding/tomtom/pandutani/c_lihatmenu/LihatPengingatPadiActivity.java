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
import com.uiuaadingding.tomtom.pandutani.pakar.padi.MonitorHamaActivity;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl1.ScheduleClient;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl10.ScheduleClient10;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl11.ScheduleClient11;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl12.ScheduleClient12;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl13.ScheduleClient13;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl14.ScheduleClient14;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl15.ScheduleClient15;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl2.ScheduleClient2;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl3.ScheduleClient3;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl4.ScheduleClient4;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl5.ScheduleClient5;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl6.ScheduleClient6;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl7.ScheduleClient7;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl8.ScheduleClient8;
import com.uiuaadingding.tomtom.pandutani.pengingat_padi.tgl9.ScheduleClient9;

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

public class LihatPengingatPadiActivity extends AppCompatActivity {
    protected static String EXTRA_ID = "";
    private static final String TAG = LihatPengingatPadiActivity.class.getSimpleName();

    protected Cursor cursor;
    private DataHelper dbHelper;

    // This is a handle so that we can call methods on our service
    private ScheduleClient scheduleClient;
    private ScheduleClient2 scheduleClient2;
    private ScheduleClient3 scheduleClient3;
    private ScheduleClient4 scheduleClient4;
    private ScheduleClient5 scheduleClient5;
    private ScheduleClient6 scheduleClient6;
    private ScheduleClient7 scheduleClient7;
    private ScheduleClient8 scheduleClient8;
    private ScheduleClient9 scheduleClient9;
    private ScheduleClient10 scheduleClient10;
    private ScheduleClient11 scheduleClient11;
    private ScheduleClient12 scheduleClient12;
    private ScheduleClient13 scheduleClient13;
    private ScheduleClient14 scheduleClient14;
    private ScheduleClient15 scheduleClient15;

    //main activity dari pengingat padi
    private EditText pilihtanggal;
    private String ambiltanggalpersemaian; //ambil tanggal dari datepicker
    private String tanggalpersemaian; //untuk menjadikan tanggal dan dikirim ke server
    private Button hitung, simpan, hapus;

    private TextView et_tgl1, et_tgl1_2, et_tgl2, et_tgl2_2, et_tgl3, et_tgl3_2, et_tgl4, et_tgl4_2, et_tgl5, et_tgl5_2, et_tgl6, et_tgl6_2, et_tgl7, et_tgl7_2, et_tgl8, et_tgl8_2, et_tgl9, et_tgl9_2, et_tgl10, et_tgl10_2, et_tgl11, et_tgl11_2, et_tgl12, et_tgl12_2, et_tgl13, et_tgl13_2, et_tgl14, et_tgl14_2, et_tgl15, et_tgl15_2;
    private RequestQueue mmRequestQueue;
    private static String URL_LIHAT = "http://192.168.43.158/hubungkanke/lihat/lihat_hitungtanggalpengingatpadi.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pengingat_padi);
        setTitle("Padi");

        dbHelper = new DataHelper(this);

        init();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM padi",null);
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
            et_tgl14.setText(cursor.getString(26).toString());et_tgl14_2.setText(cursor.getString(27).toString());
            et_tgl15.setText(cursor.getString(28).toString());et_tgl15_2.setText(cursor.getString(29).toString());
            pilihtanggal.setText(cursor.getString(30).toString());
            simpan.setVisibility(View.GONE);
        }
        else {
            Toast.makeText(getApplicationContext(), "Anda Belum Memiliki Jadwal Pengingat", Toast.LENGTH_LONG).show();
        }
        // Create a new service client and bind our activity to this service
        scheduleClient = new ScheduleClient(this);
        scheduleClient.doBindService();

        scheduleClient2 = new ScheduleClient2(this);
        scheduleClient2.doBindService();

        scheduleClient3 = new ScheduleClient3(this);
        scheduleClient3.doBindService();

        scheduleClient4 = new ScheduleClient4(this);
        scheduleClient4.doBindService();

        scheduleClient5 = new ScheduleClient5(this);
        scheduleClient5.doBindService();

        scheduleClient6 = new ScheduleClient6(this);
        scheduleClient6.doBindService();

        scheduleClient7 = new ScheduleClient7(this);
        scheduleClient7.doBindService();

        scheduleClient8 = new ScheduleClient8(this);
        scheduleClient8.doBindService();

        scheduleClient9 = new ScheduleClient9(this);
        scheduleClient9.doBindService();

        scheduleClient10 = new ScheduleClient10(this);
        scheduleClient10.doBindService();

        scheduleClient11 = new ScheduleClient11(this);
        scheduleClient11.doBindService();

        scheduleClient12 = new ScheduleClient12(this);
        scheduleClient12.doBindService();

        scheduleClient13 = new ScheduleClient13(this);
        scheduleClient13.doBindService();

        scheduleClient14 = new ScheduleClient14(this);
        scheduleClient14.doBindService();

        scheduleClient15 = new ScheduleClient15(this);
        scheduleClient15.doBindService();

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                pilihtanggal.setText(sdf.format(myCalendar.getTime()));

                ambiltanggalpersemaian = pilihtanggal.getText().toString().trim();
                //int tgl = Integer.parseInt(ambiltanggalnya);
                Date dpersem = null;
                try {
                    dpersem = sdf.parse(ambiltanggalpersemaian);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ dpersem.getDate() +"/"+(dpersem.getMonth()+1) +"/"+ (dpersem.getYear()+1900), Toast.LENGTH_SHORT).show();
                tanggalpersemaian = ""+(dpersem.getYear()+1900)+"-"+(dpersem.getMonth()+1) +"-"+dpersem.getDate();

                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+tanggalpersemaian, Toast.LENGTH_SHORT).show();

            }

        };
        pilihtanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(LihatPengingatPadiActivity.this, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmRequestQueue = Volley.newRequestQueue(LihatPengingatPadiActivity.this);
                parseJSON();
            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM padi");
                        et_tgl1.setText(null);et_tgl1_2.setText(null);
                        et_tgl2.setText(null);et_tgl2_2.setText(null);
                        et_tgl3.setText(null);et_tgl3_2.setText(null);
                        et_tgl4.setText(null);et_tgl4_2.setText("Menjelang Berbunga");
                        et_tgl5.setText(null);et_tgl5_2.setText(null);
                        et_tgl6.setText(null);et_tgl6_2.setText(null);
                        et_tgl7.setText(null);et_tgl7_2.setText(null);
                        et_tgl8.setText(null);et_tgl8_2.setText(null);
                        et_tgl9.setText(null);et_tgl9_2.setText(null);
                        et_tgl10.setText(null);et_tgl10_2.setText(null);
                        et_tgl11.setText(null);et_tgl11_2.setText(null);
                        et_tgl12.setText(null);et_tgl12_2.setText(null);
                        et_tgl13.setText(null);et_tgl13_2.setText(null);
                        et_tgl14.setText(null);et_tgl14_2.setText(null);
                        et_tgl15.setText(null);et_tgl15_2.setText("Panen");
                        pilihtanggal.setText("Pilih Tanggal");
                Toast.makeText(LihatPengingatPadiActivity.this, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                simpan.setVisibility(View.VISIBLE);

                //hapus
                scheduleClient.cancelAlarm();
                scheduleClient2.cancelAlarm();
                scheduleClient3.cancelAlarm();
                scheduleClient4.cancelAlarm();
                scheduleClient5.cancelAlarm();
                scheduleClient6.cancelAlarm();
                scheduleClient7.cancelAlarm();
                scheduleClient8.cancelAlarm();
            }
        });
        simpan.setOnClickListener(new View.OnClickListener() {
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
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d1 = null;
                try {
                    d1 = sdf.parse(ambilTgl1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year = d1.getYear()+1900;
                int month = d1.getMonth();
                int day = d1.getDate();

                Calendar paditgl1 = Calendar.getInstance();
                paditgl1.set(year, month, day);
                paditgl1.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl1.set(Calendar.MINUTE, djam.getMinutes());
                paditgl1.set(Calendar.SECOND, 0);

                //tanggal 2
                String ambilTgl2 = et_tgl2.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d2 = null;
                try {
                    d2 = sdf.parse(ambilTgl2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year2 = d2.getYear()+1900;
                int month2 = d2.getMonth();
                int day2 = d2.getDate();

                Calendar paditgl2 = Calendar.getInstance();
                paditgl2.set(year2, month2, day2);
                paditgl2.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl2.set(Calendar.MINUTE, djam.getMinutes());
                paditgl2.set(Calendar.SECOND, 0);

                //tanggal 3
                String ambilTgl3 = et_tgl3.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d3 = null;
                try {
                    d3 = sdf.parse(ambilTgl3);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year3 = d3.getYear()+1900;
                int month3 = d3.getMonth();
                int day3 = d3.getDate();

                Calendar paditgl3 = Calendar.getInstance();
                paditgl3.set(year3, month3, day3);
                paditgl3.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl3.set(Calendar.MINUTE, djam.getMinutes());
                paditgl3.set(Calendar.SECOND, 0);

                //tanggal 4
                String ambilTgl4 = et_tgl4.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d4 = null;
                try {
                    d4 = sdf.parse(ambilTgl4);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year4 = d4.getYear()+1900;
                int month4 = d4.getMonth();
                int day4 = d4.getDate();

                Calendar paditgl4 = Calendar.getInstance();
                paditgl4.set(year4, month4, day4);
                paditgl4.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl4.set(Calendar.MINUTE, djam.getMinutes());
                paditgl4.set(Calendar.SECOND, 0);

                //tanggal 5
                String ambilTgl5 = et_tgl5.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d5 = null;
                try {
                    d5 = sdf.parse(ambilTgl5);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year5 = d5.getYear()+1900;
                int month5 = d5.getMonth();
                int day5 = d5.getDate();

                Calendar paditgl5 = Calendar.getInstance();
                paditgl5.set(year5, month5, day5);
                paditgl5.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl5.set(Calendar.MINUTE, djam.getMinutes());
                paditgl5.set(Calendar.SECOND, 0);

                //tanggal 6
                String ambilTgl6 = et_tgl6.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d6 = null;
                try {
                    d6 = sdf.parse(ambilTgl6);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year6 = d6.getYear()+1900;
                int month6 = d6.getMonth();
                int day6 = d6.getDate();

                Calendar paditgl6 = Calendar.getInstance();
                paditgl6.set(year6, month6, day6);
                paditgl6.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl6.set(Calendar.MINUTE, djam.getMinutes());
                paditgl6.set(Calendar.SECOND, 0);

                //tanggal 7
                String ambilTgl7 = et_tgl7.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d7 = null;
                try {
                    d7 = sdf.parse(ambilTgl7);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year7 = d7.getYear()+1900;
                int month7 = d7.getMonth();
                int day7 = d7.getDate();

                Calendar paditgl7 = Calendar.getInstance();
                paditgl7.set(year7, month7, day7);
                paditgl7.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl7.set(Calendar.MINUTE, djam.getMinutes());
                paditgl7.set(Calendar.SECOND, 0);

                //tanggal 8
                String ambilTgl8 = et_tgl8.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d8 = null;
                try {
                    d8 = sdf.parse(ambilTgl8);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year8 = d8.getYear()+1900;
                int month8 = d8.getMonth();
                int day8 = d8.getDate();

                Calendar paditgl8 = Calendar.getInstance();
                paditgl8.set(year8, month8, day8);
                paditgl8.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl8.set(Calendar.MINUTE, djam.getMinutes());
                paditgl8.set(Calendar.SECOND, 0);

                //tanggal 9
                String ambilTgl9 = et_tgl9.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d9 = null;
                try {
                    d9 = sdf.parse(ambilTgl9);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year9 = d9.getYear()+1900;
                int month9 = d9.getMonth();
                int day9 = d9.getDate();

                Calendar paditgl9 = Calendar.getInstance();
                paditgl9.set(year9, month9, day9);
                paditgl9.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl9.set(Calendar.MINUTE, djam.getMinutes());
                paditgl9.set(Calendar.SECOND, 0);

                //tanggal 10
                String ambilTgl10 = et_tgl10.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d10 = null;
                try {
                    d10 = sdf.parse(ambilTgl10);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year10 = d10.getYear()+1900;
                int month10 = d10.getMonth();
                int day10 = d10.getDate();

                Calendar paditgl10 = Calendar.getInstance();
                paditgl10.set(year10, month10, day10);
                paditgl10.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl10.set(Calendar.MINUTE, djam.getMinutes());
                paditgl10.set(Calendar.SECOND, 0);

                //tanggal 11
                String ambilTgl11 = et_tgl11.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d11 = null;
                try {
                    d11 = sdf.parse(ambilTgl11);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year11 = d11.getYear()+1900;
                int month11 = d11.getMonth();
                int day11 = d11.getDate();

                Calendar paditgl11 = Calendar.getInstance();
                paditgl11.set(year11, month11, day11);
                paditgl11.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl11.set(Calendar.MINUTE, djam.getMinutes());
                paditgl11.set(Calendar.SECOND, 0);

                //tanggal 12
                String ambilTgl12 = et_tgl12.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d12 = null;
                try {
                    d12 = sdf.parse(ambilTgl12);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year12 = d12.getYear()+1900;
                int month12 = d12.getMonth();
                int day12 = d12.getDate();

                Calendar paditgl12 = Calendar.getInstance();
                paditgl12.set(year12, month12, day12);
                paditgl12.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl12.set(Calendar.MINUTE, djam.getMinutes());
                paditgl12.set(Calendar.SECOND, 0);

                //tanggal 13
                String ambilTgl13 = et_tgl13.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d13 = null;
                try {
                    d13 = sdf.parse(ambilTgl13);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year13 = d13.getYear()+1900;
                int month13 = d13.getMonth();
                int day13 = d13.getDate();

                Calendar paditgl13 = Calendar.getInstance();
                paditgl13.set(year13, month13, day13);
                paditgl13.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl13.set(Calendar.MINUTE, djam.getMinutes());
                paditgl13.set(Calendar.SECOND, 0);

                //tanggal 14
                String ambilTgl14 = et_tgl14.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d14 = null;
                try {
                    d14 = sdf.parse(ambilTgl14);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year14 = d14.getYear()+1900;
                int month14 = d14.getMonth();
                int day14 = d14.getDate();

                Calendar paditgl14 = Calendar.getInstance();
                paditgl14.set(year14, month14, day14);
                paditgl14.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl14.set(Calendar.MINUTE, djam.getMinutes());
                paditgl14.set(Calendar.SECOND, 0);

                //tanggal 15
                String ambilTgl15 = et_tgl15.getText().toString().trim();
                //Toast.makeText(LihatPengingatPadiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d15 = null;
                try {
                    d15 = sdf.parse(ambilTgl15);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year15 = d15.getYear()+1900;
                int month15 = d15.getMonth();
                int day15 = d15.getDate();

                Calendar paditgl15 = Calendar.getInstance();
                paditgl15.set(year15, month15, day15);
                paditgl15.set(Calendar.HOUR_OF_DAY, djam.getHours());
                paditgl15.set(Calendar.MINUTE, djam.getMinutes());
                paditgl15.set(Calendar.SECOND, 0);

                scheduleClient.setAlarmForNotification(paditgl1);
                scheduleClient2.setAlarmForNotification(paditgl2);
                scheduleClient3.setAlarmForNotification(paditgl3);
                scheduleClient4.setAlarmForNotification(paditgl4);
                scheduleClient5.setAlarmForNotification(paditgl5);
                scheduleClient6.setAlarmForNotification(paditgl6);
                scheduleClient7.setAlarmForNotification(paditgl7);
                scheduleClient8.setAlarmForNotification(paditgl8);
                scheduleClient9.setAlarmForNotification(paditgl9);
                scheduleClient10.setAlarmForNotification(paditgl10);
                scheduleClient11.setAlarmForNotification(paditgl11);
                scheduleClient12.setAlarmForNotification(paditgl12);
                scheduleClient13.setAlarmForNotification(paditgl13);
                scheduleClient14.setAlarmForNotification(paditgl14);
                scheduleClient15.setAlarmForNotification(paditgl15);
                //Toast.makeText(LihatPengingatPadiActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into padi (et_tgl1, et_tgl1_2, et_tgl2, et_tgl2_2, et_tgl3, et_tgl3_2, et_tgl4, et_tgl4_2, et_tgl5, et_tgl5_2, et_tgl6, et_tgl6_2, et_tgl7, et_tgl7_2, et_tgl8, et_tgl8_2, et_tgl9, et_tgl9_2, et_tgl10, et_tgl10_2, et_tgl11, et_tgl11_2, et_tgl12, et_tgl12_2, et_tgl13, et_tgl13_2, et_tgl14, et_tgl14_2, et_tgl15, et_tgl15_2, awal) VALUES('" +
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
                        et_tgl14.getText().toString() + "','" +et_tgl14_2.getText().toString() + "','" +
                        et_tgl15.getText().toString() + "','" +et_tgl15_2.getText().toString() + "','" +
                        pilihtanggal.getText().toString() + "')");
                simpan.setVisibility(View.GONE);
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
                                String tgl14 = result.getString("tgl14").trim();String tgl14_2 = result.getString("tgl14_2").trim();
                                String tgl15 = result.getString("tgl15").trim();String tgl15_2 = result.getString("tgl15_2").trim();

                                et_tgl1.setText(tgl1);et_tgl1_2.setText(tgl1_2);
                                et_tgl2.setText(tgl2);et_tgl2_2.setText(tgl2_2);
                                et_tgl3.setText(tgl3);et_tgl3_2.setText(tgl3_2);
                                et_tgl4.setText(tgl4);//et_tgl4_2.setText(tgl4_2);
                                et_tgl5.setText(tgl5);et_tgl5_2.setText(tgl5_2);
                                et_tgl6.setText(tgl6);et_tgl6_2.setText(tgl6_2);
                                et_tgl7.setText(tgl7);et_tgl7_2.setText(tgl7_2);
                                et_tgl8.setText(tgl8);et_tgl8_2.setText(tgl8_2);
                                et_tgl9.setText(tgl9);et_tgl9_2.setText(tgl9_2);
                                et_tgl10.setText(tgl10);et_tgl10_2.setText(tgl10_2);
                                et_tgl11.setText(tgl11);et_tgl11_2.setText(tgl11_2);
                                et_tgl12.setText(tgl12);et_tgl12_2.setText(tgl12_2);
                                et_tgl13.setText(tgl13);et_tgl13_2.setText(tgl13_2);
                                et_tgl14.setText(tgl14);et_tgl14_2.setText(tgl14_2);
                                et_tgl15.setText(tgl15);//et_tgl15_2.setText(tgl15_2);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LihatPengingatPadiActivity.this, "Gagal" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(LihatPengingatPadiActivity.this, "Gagal " + error.toString(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String fk="1";
                Map<String, String> params = new HashMap<>();
                params.put("tanggalpersemaian", tanggalpersemaian);
                params.put("id", fk);
                return params;
            }
        };

        mmRequestQueue.add(stringRequest);
    }

    private void init() {
        hitung = findViewById(R.id.btn_hitung);
        simpan = findViewById(R.id.btn_simpanpengingat);
        pilihtanggal = findViewById(R.id.tv_ambiltanggal);
        hapus = findViewById(R.id.btn_hapuspengingat);
        et_tgl1 = findViewById(R.id.p_tgl1);et_tgl1_2 = findViewById(R.id.p_tgl1_2);
        et_tgl2 = findViewById(R.id.p_tgl2);et_tgl2_2 = findViewById(R.id.p_tgl2_2);
        et_tgl3 = findViewById(R.id.p_tgl3);et_tgl3_2 = findViewById(R.id.p_tgl3_2);
        et_tgl4 = findViewById(R.id.p_tgl4);et_tgl4_2 = findViewById(R.id.p_tgl4_2);
        et_tgl5 = findViewById(R.id.p_tgl5);et_tgl5_2 = findViewById(R.id.p_tgl5_2);
        et_tgl6 = findViewById(R.id.p_tgl6);et_tgl6_2 = findViewById(R.id.p_tgl6_2);
        et_tgl7 = findViewById(R.id.p_tgl7);et_tgl7_2 = findViewById(R.id.p_tgl7_2);
        et_tgl8 = findViewById(R.id.p_tgl8);et_tgl8_2 = findViewById(R.id.p_tgl8_2);
        et_tgl9 = findViewById(R.id.p_tgl9);et_tgl9_2 = findViewById(R.id.p_tgl9_2);
        et_tgl10 = findViewById(R.id.p_tgl10);et_tgl10_2 = findViewById(R.id.p_tgl10_2);
        et_tgl11 = findViewById(R.id.p_tgl11);et_tgl11_2 = findViewById(R.id.p_tgl11_2);
        et_tgl12 = findViewById(R.id.p_tgl12);et_tgl12_2 = findViewById(R.id.p_tgl12_2);
        et_tgl13 = findViewById(R.id.p_tgl13);et_tgl13_2 = findViewById(R.id.p_tgl13_2);
        et_tgl14 = findViewById(R.id.p_tgl14);et_tgl14_2 = findViewById(R.id.p_tgl14_2);
        et_tgl15 = findViewById(R.id.p_tgl15);et_tgl15_2 = findViewById(R.id.p_tgl15_2);
    }

    @Override
    protected void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClient != null)
            scheduleClient.doUnbindService();
        else if(scheduleClient2 != null)
            scheduleClient2.doUnbindService();
        else if(scheduleClient3 != null)
            scheduleClient3.doUnbindService();
        else if(scheduleClient4 != null)
            scheduleClient4.doUnbindService();
        else if(scheduleClient5 != null)
            scheduleClient5.doUnbindService();
        else if(scheduleClient6 != null)
            scheduleClient6.doUnbindService();
        else if(scheduleClient7 != null)
            scheduleClient7.doUnbindService();
        else if(scheduleClient8 != null)
            scheduleClient8.doUnbindService();
        else if(scheduleClient9 != null)
            scheduleClient9.doUnbindService();
        else if(scheduleClient10 != null)
            scheduleClient10.doUnbindService();
        else if(scheduleClient11 != null)
            scheduleClient11.doUnbindService();
        else if(scheduleClient12 != null)
            scheduleClient12.doUnbindService();
        else if(scheduleClient13 != null)
            scheduleClient13.doUnbindService();
        else if(scheduleClient14 != null)
            scheduleClient14.doUnbindService();
        else if(scheduleClient15 != null)
            scheduleClient15.doUnbindService();
        super.onStop();
    }

    public void ptgl1(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 1);
        startActivity(budal);
    }
    public void ptgl2(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 2);
        startActivity(budal);
    }
    public void ptgl3(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 3);
        startActivity(budal);
    }
    public void ptgl4(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 4);
        startActivity(budal);
    }
    public void ptgl5(View view) {
        Intent budal = new Intent(this, MonitorHamaActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 5);
        startActivity(budal);
    }
    public void ptgl6(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 6);
        startActivity(budal);
    }
    public void ptgl7(View view) {
        Intent budal = new Intent(this, MonitorHamaActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 7);
        startActivity(budal);
    }
    public void ptgl8(View view) {
        Intent budal = new Intent(this, BwdActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 8);
        startActivity(budal);
    }
    public void ptgl9(View view) {
        Intent budal = new Intent(this, MonitorHamaActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 9);
        startActivity(budal);
    }public void ptgl10(View view) {
        Intent budal = new Intent(this, BwdActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 10);
        startActivity(budal);
    }
    public void ptgl11(View view) {
        Intent budal = new Intent(this, MonitorHamaActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 11);
        startActivity(budal);
    }
    public void ptgl12(View view) {
        Intent budal = new Intent(this, BwdActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 12);
        startActivity(budal);
    }public void ptgl13(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 13);
        startActivity(budal);
    }
    public void ptgl14(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 14);
        startActivity(budal);
    }
    public void ptgl15(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatPadiActivity.EXTRA_ID, 15);
        startActivity(budal);
    }


}
