package com.uiuaadingding.tomtom.pandutani.a_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.SessionManager;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.PilihHamaActivity;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.PilihPengingatActivity;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.PilihProsedurActivity;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.PilihTanampanganActivity;
import com.uiuaadingding.tomtom.pandutani.diskusi.DiskusiActivity;

public class MainActivity extends AppCompatActivity{
    private TextView nama;
    private Button btn_Tentang, btn_Pengingat, btn_Prosedur, btn_Tanamanpangan, btn_Hama, btn_Diskusi;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);
        sessionManager.checkLoginmain();

        init();

        btn_Tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TentangActivity.class));
                finish();
            }
        });

        btn_Pengingat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PilihPengingatActivity.class));
            }
        });

        btn_Prosedur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PilihProsedurActivity.class));
            }
        });

        btn_Tanamanpangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PilihTanampanganActivity.class));
            }
        });

        btn_Hama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PilihHamaActivity.class));
            }
        });

        btn_Diskusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DiskusiActivity.class));
            }
        });
    }

    private void init() {
        btn_Tentang = findViewById(R.id.idtentang);
        btn_Pengingat = findViewById(R.id.idpengingat);
        btn_Prosedur = findViewById(R.id.idprosedur);
        btn_Tanamanpangan = findViewById(R.id.idtanaman);
        btn_Hama = findViewById(R.id.idhama);
        btn_Diskusi = findViewById(R.id.iddiskusi);
    }

    @Override
    public void onBackPressed() {
        //dialog keluar
        finish();
    }
}
