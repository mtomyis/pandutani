package com.uiuaadingding.tomtom.pandutani.b_pilihmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.uiuaadingding.tomtom.pandutani.c_lihatmenu.LihatPengingatUbiActivity;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.c_lihatmenu.LihatPengingatJagungActivity;
import com.uiuaadingding.tomtom.pandutani.c_lihatmenu.LihatPengingatKedelaiActivity;
import com.uiuaadingding.tomtom.pandutani.c_lihatmenu.LihatPengingatPadiActivity;

public class PilihPengingatActivity extends AppCompatActivity {
    CardView cvPadi, cvJagung, cvKedelai, cvUbi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_pengingat);
        init();

        cvPadi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PilihPengingatActivity.this, LihatPengingatPadiActivity.class));
            }
        });

        cvJagung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PilihPengingatActivity.this, LihatPengingatJagungActivity.class));
            }
        });

        cvKedelai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PilihPengingatActivity.this, LihatPengingatKedelaiActivity.class));
            }
        });

        cvUbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PilihPengingatActivity.this, LihatPengingatUbiActivity.class));
            }
        });
    }

    private void init() {
        cvPadi=findViewById(R.id.idcvpadi);
        cvJagung=findViewById(R.id.idcvjagung);
        cvKedelai=findViewById(R.id.idcvkedelai);
        cvUbi=findViewById(R.id.idcvubi);

    }
}
