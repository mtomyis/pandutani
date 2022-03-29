package com.uiuaadingding.tomtom.pandutani.pakar.ubi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.uiuaadingding.tomtom.pandutani.R;

public class MonitorHamaUbActivity extends AppCompatActivity {

    CheckBox cek1, cek2, cek3, cek4, cek5, cek6, cek7, cek8, cek9, cek10, cek11, cek12, cek13, cek14, cek15, cek16, cek17, cek18, cek19, cek20, cek21, cek22, cek23, cek24, cek25, cek26, cek27, cek28, cek29, cek30, cek31, cek32, cek33, cek34, cek35;
    Button button_proses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_hama_ub);

        init();

        button_proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double data[] = new double[35];

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

                if (cek20.isChecked()) {
                    data[19] = 1;
                } else {
                    data[19] = 0;
                }

                if (cek21.isChecked()) {
                    data[20] = 1;
                } else {
                    data[20] = 0;
                }

                if (cek22.isChecked()) {
                    data[21] = 1;
                } else {
                    data[21] = 0;
                }

                if (cek23.isChecked()) {
                    data[22] = 1;
                } else {
                    data[22] = 0;
                }

                if (cek24.isChecked()) {
                    data[23] = 1;
                } else {
                    data[23] = 0;
                }

                if (cek25.isChecked()) {
                    data[24] = 1;
                } else {
                    data[24] = 0;
                }

                if (cek26.isChecked()) {
                    data[25] = 1;
                } else {
                    data[25] = 0;
                }

                if (cek27.isChecked()) {
                    data[26] = 1;
                } else {
                    data[26] = 0;
                }

                if (cek28.isChecked()) {
                    data[27] = 1;
                } else {
                    data[27] = 0;
                }

                if (cek29.isChecked()) {
                    data[28] = 1;
                } else {
                    data[28] = 0;
                }

                if (cek30.isChecked()) {
                    data[29] = 1;
                } else {
                    data[29] = 0;
                }

                if (cek31.isChecked()) {
                    data[30] = 1;
                } else {
                    data[30] = 0;
                }

                if (cek32.isChecked()) {
                    data[31] = 1;
                } else {
                    data[31] = 0;
                }

                if (cek33.isChecked()) {
                    data[32] = 1;
                } else {
                    data[32] = 0;
                }

                if (cek34.isChecked()) {
                    data[33] = 1;
                } else {
                    data[33] = 0;
                }

                if (cek35.isChecked()) {
                    data[34] = 1;
                } else {
                    data[34] = 0;
                }

                //Log.i(TAG, "checked sukses");
                ProsesUb proses = new ProsesUb();
                //Log.i(TAG, "new objec sukses");
                String hasilnya = proses.hitungUb(data);
                //Log.i(TAG, "berhasil dapat nilai");

                mulai(hasilnya);
                //Toast.makeText(getApplicationContext(),hasilnya,Toast.LENGTH_LONG).show();

            }
        });
    }

    private void  mulai(String Hasildiagnosa){
        Intent intent = new Intent(this, HasilUbActivity.class);
        intent.putExtra("kirim", Hasildiagnosa);
        startActivity(intent);
    }

    private void init() {
        button_proses = findViewById(R.id.button_prosesu);

        cek1 = findViewById(R.id.checkBoxu2);
        cek2 = findViewById(R.id.checkBoxu3);
        cek3 = findViewById(R.id.checkBoxu4);
        cek4 = findViewById(R.id.checkBoxu5);
        cek5 = findViewById(R.id.checkBoxu6);
        cek6 = findViewById(R.id.checkBoxu7);
        cek7 = findViewById(R.id.checkBoxu8);
        cek8 = findViewById(R.id.checkBoxu9);
        cek9 = findViewById(R.id.checkBoxu10);
        cek10 = findViewById(R.id.checkBoxu11);
        cek11 = findViewById(R.id.checkBoxu12);
        cek12 = findViewById(R.id.checkBoxu13);
        cek13 = findViewById(R.id.checkBoxu14);
        cek14 = findViewById(R.id.checkBoxu15);
        cek15 = findViewById(R.id.checkBoxu16);
        cek16 = findViewById(R.id.checkBoxu17);
        cek17 = findViewById(R.id.checkBoxu18);
        cek18 = findViewById(R.id.checkBoxu19);
        cek19 = findViewById(R.id.checkBoxu20);
        cek20 = findViewById(R.id.checkBoxu21);
        cek21 = findViewById(R.id.checkBoxu22);
        cek22 = findViewById(R.id.checkBoxu23);
        cek23 = findViewById(R.id.checkBoxu24);
        cek24 = findViewById(R.id.checkBoxu25);
        cek25 = findViewById(R.id.checkBoxu26);
        cek26 = findViewById(R.id.checkBoxu27);
        cek27 = findViewById(R.id.checkBoxu28);
        cek28 = findViewById(R.id.checkBoxu29);
        cek29 = findViewById(R.id.checkBoxu30);
        cek30 = findViewById(R.id.checkBoxu31);
        cek31 = findViewById(R.id.checkBoxu32);
        cek32 = findViewById(R.id.checkBoxu33);
        cek33 = findViewById(R.id.checkBoxu34);
        cek34 = findViewById(R.id.checkBoxu35);
        cek35 = findViewById(R.id.checkBoxu36);

    }
}
