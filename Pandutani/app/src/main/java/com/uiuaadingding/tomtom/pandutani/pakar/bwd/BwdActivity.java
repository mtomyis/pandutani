package com.uiuaadingding.tomtom.pandutani.pakar.bwd;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.model.LatLng;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.pakar.ubi.HasilUbActivity;

public class BwdActivity extends AppCompatActivity {
    protected static String KIRIM = "";
    protected static String KIRIMlagi = "";
    private Menu action;
    ImageView btn_bwd2, btn_bwd3, btn_bwd4, btn_bwd5;
    TextView tv5, tv2, tv3, tv4;
    double bwd2 = 0;
    double bwd3 = 0;
    double bwd4 = 0;
    double bwd5 = 0;

    double sample = 0;
    double hitu, jum;

    double sample2, sample3, sample4, sample5, sample25, sample35, sample45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bwd);
        btn_bwd2 = findViewById(R.id.bwd2);
        btn_bwd3 =  findViewById(R.id.bwd3);
        btn_bwd4 =  findViewById(R.id.bwd4);
        btn_bwd5 = findViewById(R.id.bwd5);
        tv5 = findViewById(R.id.txbwd5);
        tv4 = findViewById(R.id.txbwd4);
        tv3 = findViewById(R.id.txbwd3);
        tv2 = findViewById(R.id.txbwd2);



        btn_bwd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.findItem(R.id.idhitung).setVisible(true);
                bwd2=bwd2+2;
                sample=sample+1;
                Toast.makeText(getApplicationContext(), "Contoh yang dipakai sebanyak "+sample, Toast.LENGTH_SHORT).show();
            }
        });
        btn_bwd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.findItem(R.id.idhitung).setVisible(true);
                bwd3=bwd3+3;
                sample=sample+1;
                Toast.makeText(getApplicationContext(), "Contoh yang dipakai sebanyak "+sample, Toast.LENGTH_SHORT).show();
            }
        });
        btn_bwd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.findItem(R.id.idhitung).setVisible(true);
                bwd4=bwd4+4;
                sample=sample+1;
                Toast.makeText(getApplicationContext(), "Contoh yang dipakai sebanyak "+sample, Toast.LENGTH_SHORT).show();
            }
        });
        btn_bwd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action.findItem(R.id.idhitung).setVisible(true);
                bwd5=bwd5+5;
                sample=sample+1;
                Toast.makeText(getApplicationContext(), "Contoh yang dipakai sebanyak "+sample, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_bwd, menu);

        action = menu;
        action.findItem(R.id.idhitung).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.idhitung:

                jum = (bwd2+bwd3+bwd4+bwd5);
                hitu = jum/sample;
                Toast.makeText(getApplicationContext(), "hitu "+hitu, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(BwdActivity.this, HasilBwdActivity.class);
                intent.putExtra(HasilBwdActivity.KIRIM, hitu);
                intent.putExtra(HasilBwdActivity.KIRIMlagi, sample);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onRestart() {
        bwd2 = 0;
        bwd3 = 0;
        bwd4 = 0;
        bwd5 = 0;

        sample = 0;
        hitu = 0;
        jum = 0;
        super.onRestart();
    }
}
