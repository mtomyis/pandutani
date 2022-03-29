package com.uiuaadingding.tomtom.pandutani.pakar.padi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.uiuaadingding.tomtom.pandutani.R;

public class HasilActivity extends AppCompatActivity {
    private static final String TAG =HasilActivity.class.getSimpleName();;
    TextView vhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        vhasil =findViewById(R.id.hasildiganosa);
        Intent intent = getIntent();
        String hasil = intent.getStringExtra("kirim");
        vhasil.setText(hasil);
        //Log.d(TAG, hasil);
    }
}
