package com.uiuaadingding.tomtom.pandutani.pakar.ubi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.uiuaadingding.tomtom.pandutani.R;

public class HasilUbActivity extends AppCompatActivity {
    private static final String TAG =HasilUbActivity.class.getSimpleName();;
    TextView vhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_ub);

        vhasil =findViewById(R.id.hasilubdiganosa);
        Intent intent = getIntent();
        String hasil = intent.getStringExtra("kirim");
        vhasil.setText(hasil);
        //Log.d(TAG, hasil);
    }
}
