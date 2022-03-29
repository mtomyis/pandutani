package com.uiuaadingding.tomtom.pandutani.pakar.jagung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.uiuaadingding.tomtom.pandutani.R;

public class MonitorHamaJaActivity extends AppCompatActivity {

    CheckBox cek1, cek2, cek3, cek4, cek5, cek6, cek7, cek8, cek9, cek10, cek11, cek12, cek13, cek14, cek15, cek16, cek17, cek18, cek19;
    Button button_proses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_hama_ja);

        init();

        button_proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double data[] = new double[19];

                if (cek1.isChecked()) {
                    data[0] = 1;
                } else {
                    data[0] = 0;
                }
                //System.out.println("nilai cek1 = " + data[0]);
                if (cek2.isChecked()) {
                    data[1] = 1;
                } else {
                    data[1] = 0;
                }

                if (cek3.isChecked()) {
                    data[2] = 1;
                } else {
                    data[2] = 0;
                }

                if (cek4.isChecked()) {
                    data[3] = 1;
                } else {
                    data[3] = 0;
                }

                if (cek5.isChecked()) {
                    data[4] = 1;
                } else {
                    data[4] = 0;
                }

                if (cek6.isChecked()) {
                    data[5] = 1;
                } else {
                    data[5] = 0;
                }

                if (cek7.isChecked()) {
                    data[6] = 1;
                } else {
                    data[6] = 0;
                }

                if (cek8.isChecked()) {
                    data[7] = 1;
                } else {
                    data[7] = 0;
                }

                if (cek9.isChecked()) {
                    data[8] = 1;
                } else {
                    data[8] = 0;
                }

                if (cek10.isChecked()) {
                    data[9] = 1;
                } else {
                    data[9] = 0;
                }

                if (cek11.isChecked()) {
                    data[10] = 1;
                } else {
                    data[10] = 0;
                }

                if (cek12.isChecked()) {
                    data[11] = 1;
                } else {
                    data[11] = 0;
                }

                if (cek13.isChecked()) {
                    data[12] = 1;
                } else {
                    data[12] = 0;
                }

                if (cek14.isChecked()) {
                    data[13] = 1;
                } else {
                    data[13] = 0;
                }

                if (cek15.isChecked()) {
                    data[14] = 1;
                } else {
                    data[14] = 0;
                }

                if (cek16.isChecked()) {
                    data[15] = 1;
                } else {
                    data[15] = 0;
                }

                if (cek17.isChecked()) {
                    data[16] = 1;
                } else {
                    data[16] = 0;
                }

                if (cek18.isChecked()) {
                    data[17] = 1;
                } else {
                    data[17] = 0;
                }

                if (cek19.isChecked()) {
                    data[18] = 1;
                } else {
                    data[18] = 0;
                }

                //Log.i(TAG, "checked sukses");
                ProsesJa proses = new ProsesJa();
                //Log.i(TAG, "new objec sukses");
                String hasilnya = proses.hitungja(data);
                //Log.i(TAG, "berhasil dapat nilai");

                mulai(hasilnya);
                //Toast.makeText(getApplicationContext(),hasilnya,Toast.LENGTH_LONG).show();

            }
        });
    }

    private void  mulai(String Hasiljadiagnosa){
        Intent intent = new Intent(this, HasilJaActivity.class);
        intent.putExtra("kirim", Hasiljadiagnosa);
        startActivity(intent);
    }

    private void init() {
        button_proses = findViewById(R.id.button_prosesja);

        cek1 = findViewById(R.id.checkBoxj2);
        cek2 = findViewById(R.id.checkBoxj3);
        cek3 = findViewById(R.id.checkBoxj4);
        cek4 = findViewById(R.id.checkBoxj5);
        cek5 = findViewById(R.id.checkBoxj6);
        cek6 = findViewById(R.id.checkBoxj7);
        cek7 = findViewById(R.id.checkBoxj8);
        cek8 = findViewById(R.id.checkBoxj9);
        cek9 = findViewById(R.id.checkBoxj10);
        cek10 = findViewById(R.id.checkBoxj11);
        cek11 = findViewById(R.id.checkBoxj12);
        cek12 = findViewById(R.id.checkBoxj13);
        cek13 = findViewById(R.id.checkBoxj14);
        cek14 = findViewById(R.id.checkBoxj15);
        cek15 = findViewById(R.id.checkBoxj16);
        cek16 = findViewById(R.id.checkBoxj17);
        cek17 = findViewById(R.id.checkBoxj18);
        cek18 = findViewById(R.id.checkBoxj19);
        cek19 = findViewById(R.id.checkBoxj20);
    }
}
