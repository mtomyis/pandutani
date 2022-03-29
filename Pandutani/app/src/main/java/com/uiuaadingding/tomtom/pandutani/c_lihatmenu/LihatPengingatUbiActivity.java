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
import com.uiuaadingding.tomtom.pandutani.pakar.ubi.MonitorHamaUbActivity;

import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl1.ScheduleClientu;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl10.ScheduleClientu10;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl2.ScheduleClientu2;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl3.ScheduleClientu3;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl4.ScheduleClientu4;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl5.ScheduleClientu5;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl6.ScheduleClientu6;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl7.ScheduleClientu7;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl8.ScheduleClientu8;
import com.uiuaadingding.tomtom.pandutani.pengingat_ubi.utgl9.ScheduleClientu9;

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

public class LihatPengingatUbiActivity extends AppCompatActivity {
    protected static String EXTRA_ID = "";
    private static final String TAG = LihatPengingatUbiActivity.class.getSimpleName();

    protected Cursor cursor;
    private DataHelper dbHelper;

    private ScheduleClientu scheduleClientu;
    private ScheduleClientu2 scheduleClientu2;
    private ScheduleClientu3 scheduleClientu3;
    private ScheduleClientu4 scheduleClientu4;
    private ScheduleClientu5 scheduleClientu5;
    private ScheduleClientu6 scheduleClientu6;
    private ScheduleClientu7 scheduleClientu7;
    private ScheduleClientu8 scheduleClientu8;
    private ScheduleClientu9 scheduleClientu9;
    private ScheduleClientu10 scheduleClientu10;

    private EditText pilihtanggalu;
    private String ambiltanggalpersemaianu; //ambil tanggal dari datepicker
    private String tanggalpersemaianu; //untuk menjadikan tanggal dan dikirim ke server
    private Button hitungu, simpanu, hapusu;

    private TextView et_tgl1, et_tgl1_2, et_tgl2, et_tgl2_2, et_tgl3, et_tgl3_2, et_tgl4, et_tgl4_2, et_tgl5, et_tgl5_2, et_tgl6, et_tgl6_2, et_tgl7, et_tgl7_2, et_tgl8, et_tgl8_2, et_tgl9, et_tgl9_2, et_tgl10, et_tgl10_2;
    private RequestQueue mmRequestQueue;
    private static String URL_LIHAT = "http://192.168.43.158/hubungkanke/lihat/lihat_hitungtanggalpengingatubi.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pengingat_ubi);
        setTitle("Ubi");

        dbHelper = new DataHelper(this);

        init();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM ubi",null);
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
            pilihtanggalu.setText(cursor.getString(26).toString());
            simpanu.setVisibility(View.GONE);
        }
        else {
            Toast.makeText(getApplicationContext(), "Anda Belum Memiliki Jadwal Pengingat", Toast.LENGTH_LONG).show();
        }

        // Create a new service client and bind our activity to this service
        scheduleClientu = new ScheduleClientu(this);
        scheduleClientu.doBindService();

        scheduleClientu2 = new ScheduleClientu2(this);
        scheduleClientu2.doBindService();

        scheduleClientu3 = new ScheduleClientu3(this);
        scheduleClientu3.doBindService();

        scheduleClientu4 = new ScheduleClientu4(this);
        scheduleClientu4.doBindService();

        scheduleClientu5 = new ScheduleClientu5(this);
        scheduleClientu5.doBindService();

        scheduleClientu6 = new ScheduleClientu6(this);
        scheduleClientu6.doBindService();

        scheduleClientu7 = new ScheduleClientu7(this);
        scheduleClientu7.doBindService();

        scheduleClientu8 = new ScheduleClientu8(this);
        scheduleClientu8.doBindService();

        scheduleClientu9 = new ScheduleClientu9(this);
        scheduleClientu9.doBindService();

        scheduleClientu10 = new ScheduleClientu10(this);
        scheduleClientu10.doBindService();

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                pilihtanggalu.setText(sdf.format(myCalendar.getTime()));

                ambiltanggalpersemaianu = pilihtanggalu.getText().toString().trim();
                //int tgl = Integer.parseInt(ambiltanggalnya);
                Date dpersem = null;
                try {
                    dpersem = sdf.parse(ambiltanggalpersemaianu);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ dpersem.getDate() +"/"+(dpersem.getMonth()+1) +"/"+ (dpersem.getYear()+1900), Toast.LENGTH_SHORT).show();
                tanggalpersemaianu = ""+(dpersem.getYear()+1900)+"-"+(dpersem.getMonth()+1) +"-"+dpersem.getDate();

                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+tanggalpersemaian, Toast.LENGTH_SHORT).show();
            }
        };

        pilihtanggalu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(LihatPengingatUbiActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        hitungu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmRequestQueue = Volley.newRequestQueue(LihatPengingatUbiActivity.this);
                parseJSON();
            }
        });
        hapusu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("DELETE FROM ubi");
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
                pilihtanggalu.setText("Pilih Tanggal");
                Toast.makeText(LihatPengingatUbiActivity.this, "Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                simpanu.setVisibility(View.VISIBLE);

                //hapus
                scheduleClientu.cancelAlarm();
                scheduleClientu2.cancelAlarm();
                scheduleClientu3.cancelAlarm();
                scheduleClientu4.cancelAlarm();
                scheduleClientu5.cancelAlarm();
                scheduleClientu6.cancelAlarm();
                scheduleClientu7.cancelAlarm();
                scheduleClientu8.cancelAlarm();
                scheduleClientu9.cancelAlarm();
                scheduleClientu10.cancelAlarm();
            }
        });

        //ini
        simpanu.setOnClickListener(new View.OnClickListener() {
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
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d1 = null;
                try {
                    d1 = sdf.parse(ambilTgl1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year = d1.getYear()+1900;
                int month = d1.getMonth();
                int day = d1.getDate();

                Calendar ubitgl1 = Calendar.getInstance();
                ubitgl1.set(year, month, day);
                ubitgl1.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl1.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl1.set(Calendar.SECOND, 0);

                //tanggal 2
                String ambilTgl2 = et_tgl2.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d2 = null;
                try {
                    d2 = sdf.parse(ambilTgl2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year2 = d2.getYear()+1900;
                int month2 = d2.getMonth();
                int day2 = d2.getDate();

                Calendar ubitgl2 = Calendar.getInstance();
                ubitgl2.set(year2, month2, day2);
                ubitgl2.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl2.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl2.set(Calendar.SECOND, 0);

                //tanggal 3
                String ambilTgl3 = et_tgl3.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d3 = null;
                try {
                    d3 = sdf.parse(ambilTgl3);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year3 = d3.getYear()+1900;
                int month3 = d3.getMonth();
                int day3 = d3.getDate();

                Calendar ubitgl3 = Calendar.getInstance();
                ubitgl3.set(year3, month3, day3);
                ubitgl3.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl3.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl3.set(Calendar.SECOND, 0);

                //tanggal 4
                String ambilTgl4 = et_tgl4.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d4 = null;
                try {
                    d4 = sdf.parse(ambilTgl4);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year4 = d4.getYear()+1900;
                int month4 = d4.getMonth();
                int day4 = d4.getDate();

                Calendar ubitgl4 = Calendar.getInstance();
                ubitgl4.set(year4, month4, day4);
                ubitgl4.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl4.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl4.set(Calendar.SECOND, 0);

                //tanggal 5
                String ambilTgl5 = et_tgl5.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d5 = null;
                try {
                    d5 = sdf.parse(ambilTgl5);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year5 = d5.getYear()+1900;
                int month5 = d5.getMonth();
                int day5 = d5.getDate();

                Calendar ubitgl5 = Calendar.getInstance();
                ubitgl5.set(year5, month5, day5);
                ubitgl5.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl5.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl5.set(Calendar.SECOND, 0);

                //tanggal 6
                String ambilTgl6 = et_tgl6.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d6 = null;
                try {
                    d6 = sdf.parse(ambilTgl6);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year6 = d6.getYear()+1900;
                int month6 = d6.getMonth();
                int day6 = d6.getDate();

                Calendar ubitgl6 = Calendar.getInstance();
                ubitgl6.set(year6, month6, day6);
                ubitgl6.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl6.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl6.set(Calendar.SECOND, 0);

                //tanggal 7
                String ambilTgl7 = et_tgl7.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d7 = null;
                try {
                    d7 = sdf.parse(ambilTgl7);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year7 = d7.getYear()+1900;
                int month7 = d7.getMonth();
                int day7 = d7.getDate();

                Calendar ubitgl7 = Calendar.getInstance();
                ubitgl7.set(year7, month7, day7);
                ubitgl7.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl7.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl7.set(Calendar.SECOND, 0);

                //tanggal 8
                String ambilTgl8 = et_tgl8.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d8 = null;
                try {
                    d8 = sdf.parse(ambilTgl8);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year8 = d8.getYear()+1900;
                int month8 = d8.getMonth();
                int day8 = d8.getDate();

                Calendar ubitgl8 = Calendar.getInstance();
                ubitgl8.set(year8, month8, day8);
                ubitgl8.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl8.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl8.set(Calendar.SECOND, 0);

                //tanggal 9
                String ambilTgl9 = et_tgl9.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d9 = null;
                try {
                    d9 = sdf.parse(ambilTgl9);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year9 = d9.getYear()+1900;
                int month9 = d9.getMonth();
                int day9 = d9.getDate();

                Calendar ubitgl9 = Calendar.getInstance();
                ubitgl9.set(year9, month9, day9);
                ubitgl9.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl9.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl9.set(Calendar.SECOND, 0);

                //tanggal 10
                String ambilTgl10 = et_tgl10.getText().toString().trim();
                //Toast.makeText(LihatPengingatUbiActivity.this, "tanggal: "+ambilTgl1, Toast.LENGTH_SHORT).show();
                Date d10 = null;
                try {
                    d10 = sdf.parse(ambilTgl10);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int year10 = d10.getYear()+1900;
                int month10 = d10.getMonth();
                int day10 = d10.getDate();

                Calendar ubitgl10 = Calendar.getInstance();
                ubitgl10.set(year10, month10, day10);
                ubitgl10.set(Calendar.HOUR_OF_DAY, djam.getHours());
                ubitgl10.set(Calendar.MINUTE, djam.getMinutes());
                ubitgl10.set(Calendar.SECOND, 0);


                scheduleClientu.setAlarmForNotification(ubitgl1);
                scheduleClientu2.setAlarmForNotification(ubitgl2);
                scheduleClientu3.setAlarmForNotification(ubitgl3);
                scheduleClientu4.setAlarmForNotification(ubitgl4);
                scheduleClientu5.setAlarmForNotification(ubitgl5);
                scheduleClientu6.setAlarmForNotification(ubitgl6);
                scheduleClientu7.setAlarmForNotification(ubitgl7);
                scheduleClientu8.setAlarmForNotification(ubitgl8);
                scheduleClientu9.setAlarmForNotification(ubitgl9);
                scheduleClientu10.setAlarmForNotification(ubitgl10);
                //Toast.makeText(LihatPengingatUbiActivity.this, "Berhasil", Toast.LENGTH_SHORT).show();

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into ubi (et_tgl1, et_tgl1_2, et_tgl2, et_tgl2_2, et_tgl3, et_tgl3_2, et_tgl4, et_tgl4_2, et_tgl5, et_tgl5_2, et_tgl6, et_tgl6_2, et_tgl7, et_tgl7_2, et_tgl8, et_tgl8_2, et_tgl9, et_tgl9_2, et_tgl10, et_tgl10_2, awal) VALUES('" +
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
                        pilihtanggalu.getText().toString() + "')");
                simpanu.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            }
        });
        //ini

    }

    private void init() {
        hitungu = findViewById(R.id.btn_hitungu);
        simpanu = findViewById(R.id.btn_simpanpengingatu);
        pilihtanggalu = findViewById(R.id.tv_ambiltanggalu);
        hapusu = findViewById(R.id.btn_hapuspengingatu);
        et_tgl1 = findViewById(R.id.u_tgl1);et_tgl1_2 = findViewById(R.id.u_tgl1_2);
        et_tgl2 = findViewById(R.id.u_tgl2);et_tgl2_2 = findViewById(R.id.u_tgl2_2);
        et_tgl3 = findViewById(R.id.u_tgl3);et_tgl3_2 = findViewById(R.id.u_tgl3_2);
        et_tgl4 = findViewById(R.id.u_tgl4);et_tgl4_2 = findViewById(R.id.u_tgl4_2);
        et_tgl5 = findViewById(R.id.u_tgl5);et_tgl5_2 = findViewById(R.id.u_tgl5_2);
        et_tgl6 = findViewById(R.id.u_tgl6);et_tgl6_2 = findViewById(R.id.u_tgl6_2);
        et_tgl7 = findViewById(R.id.u_tgl7);et_tgl7_2 = findViewById(R.id.u_tgl7_2);
        et_tgl8 = findViewById(R.id.u_tgl8);et_tgl8_2 = findViewById(R.id.u_tgl8_2);
        et_tgl9 = findViewById(R.id.u_tgl9);et_tgl9_2 = findViewById(R.id.u_tgl9_2);
        et_tgl10 = findViewById(R.id.u_tgl10);et_tgl10_2 = findViewById(R.id.u_tgl10_2);
    }

    @Override
    protected void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClientu != null)
            scheduleClientu.doUnbindService();
        else if(scheduleClientu2 != null)
            scheduleClientu2.doUnbindService();
        else if(scheduleClientu3 != null)
            scheduleClientu3.doUnbindService();
        else if(scheduleClientu4 != null)
            scheduleClientu4.doUnbindService();
        else if(scheduleClientu5 != null)
            scheduleClientu5.doUnbindService();
        else if(scheduleClientu6 != null)
            scheduleClientu6.doUnbindService();
        else if(scheduleClientu7 != null)
            scheduleClientu7.doUnbindService();
        else if(scheduleClientu8 != null)
            scheduleClientu8.doUnbindService();
        else if(scheduleClientu9 != null)
            scheduleClientu9.doUnbindService();
        else if(scheduleClientu10 != null)
            scheduleClientu10.doUnbindService();
        super.onStop();
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
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LihatPengingatUbiActivity.this, "Gagal catch" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(LihatPengingatUbiActivity.this, "Gagal response" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String fk="4";
                Map<String, String> params = new HashMap<>();
                params.put("tanggalpersemaian", tanggalpersemaianu);
                params.put("id", fk);
                return params;
            }
        };

        mmRequestQueue.add(stringRequest);
    }

    public void utgl1(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 16);
        startActivity(budal);
    }
    public void utgl2(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 17);
        startActivity(budal);
    }
    public void utgl3(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 18);
        startActivity(budal);
    }
    public void utgl4(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 19);
        startActivity(budal);
    }
    public void utgl5(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 20);
        startActivity(budal);
    }
    public void utgl6(View view) {
        Intent budal = new Intent(this, MonitorHamaUbActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 21);
        startActivity(budal);
    }
    public void utgl7(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 22);
        startActivity(budal);
    }
    public void utgl8(View view) {
        Intent budal = new Intent(this, BwdActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 23);
        startActivity(budal);
    }
    public void utgl9(View view) {
        Intent budal = new Intent(this, MonitorHamaUbActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 24);
        startActivity(budal);

    }public void utgl10(View view) {
        Intent budal = new Intent(this, DetailPengingatActivity.class);
        budal.putExtra(LihatPengingatUbiActivity.EXTRA_ID, 25);
        startActivity(budal);
    }
}
