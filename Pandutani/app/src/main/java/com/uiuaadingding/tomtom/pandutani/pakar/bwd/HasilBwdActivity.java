package com.uiuaadingding.tomtom.pandutani.pakar.bwd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.uiuaadingding.tomtom.pandutani.R;

public class HasilBwdActivity extends AppCompatActivity {
    protected static String KIRIM = "hitung";
    protected static String KIRIMlagi = "sampel";

    TextView textView;
    double hitu, sampel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_bwd);

        textView = findViewById(R.id.hasildiganosabwd);

        Intent intent = getIntent();
        hitu = intent.getExtras().getDouble(KIRIM, 0.00);
        sampel = intent.getExtras().getDouble(KIRIMlagi, 0.00);


        Toast.makeText(getApplicationContext(), "hitu "+hitu, Toast.LENGTH_SHORT).show();

        if (hitu<=3){
            //Toast.makeText(getApplicationContext(), " kurang dari 3", Toast.LENGTH_SHORT).show();
            textView.append("Dari "+sampel +" contoh yang digunakan, tanaman berada dilevel 3 kebawah \n\n\n" +
                    "Gunakan 75 kg urea/ha bila tingkat hasil 5 ton/ha GKG. Tambahkan 25 kg urea untuk kenaikan setiap kenaikan 1 ton/ha");
        }

        else if (hitu>=3.0 && hitu<4){
            //Toast.makeText(getApplicationContext(), " lebih dari 3.5", Toast.LENGTH_SHORT).show();
            textView.append("Dari "+sampel +" contoh yang digunakan, Tanaman berada dilevel antara lebih dari 3 dan kurang dari 4 \n\n\n" +
                    "Gunakan 50 kg urea/ha bila tingkat hasil 5 ton/ha. Tambahkan 25 kg urea untuk kenaikan setiap kenaikan 1 ton/ha.");
        }

        if (hitu>4){
            //Toast.makeText(getApplicationContext(), "antara lebih dari 3 dan kurang dari 3.5", Toast.LENGTH_SHORT).show();
            textView.append("Dari "+sampel +" contoh yang digunakan, Tanaman berada dilevel lebih dari 4 mendekati 5 \n\n\n" +
                    "Tanaman tidak perlu dipupuk N bila tingkat hasil 5-6 ton/ha. Tambahkan 50 kg/ha urea jika tingkat hasil di atas 6 ton/ha.");
        }

    }
}
