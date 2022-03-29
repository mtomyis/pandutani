package com.uiuaadingding.tomtom.pandutani.pakar.kedelai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.uiuaadingding.tomtom.pandutani.R;

public class HasilKeActivity extends AppCompatActivity {
    private static final String TAG =HasilKeActivity.class.getSimpleName();;
    TextView vhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_ke);

        vhasil =findViewById(R.id.hasilkediganosa);
        Intent intent = getIntent();
        String hasil = intent.getStringExtra("kirim");
        vhasil.setText(hasil);
        //Log.d(TAG, hasil);

    }
}
