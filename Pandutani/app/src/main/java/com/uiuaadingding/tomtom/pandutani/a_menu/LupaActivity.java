package com.uiuaadingding.tomtom.pandutani.a_menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uiuaadingding.tomtom.pandutani.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LupaActivity extends AppCompatActivity {
    private EditText et_Namadepan, et_NamaBelakang, et_Katasandi, et_Katasandi2;
    private Button btn_Simpan;
    private ProgressBar p_Tunggu;
    Boolean CheckEditText;
    private static String URL_DAFTAR = "http://192.168.43.158/hubungkanke/lupa.php";
    //mbakiva
    //private static String URL_DAFTAR = "http://192.168.4.106/hubungkanke/lupa.php";

    String ambilnamadpn, ambilnamablk, ambilkatasandi, ambilkatasandi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa);

        init();
        btn_Simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if(CheckEditText){
                    simpan();
                }
                else{
                    Toast.makeText(LupaActivity.this, "isi semua formnya!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void init() {
        p_Tunggu = findViewById(R.id.idtunggul);
        et_Namadepan = findViewById(R.id.idnamadpnl);
        et_NamaBelakang = findViewById(R.id.idnamablkl);
        et_Katasandi = findViewById(R.id.idkatasandil);
        et_Katasandi2 = findViewById(R.id.idkatasandi2l);
        btn_Simpan = findViewById(R.id.idbtnubahpassl);
    }

    public void CheckEditTextIsEmptyOrNot() {
        ambilnamadpn = this.et_Namadepan.getText().toString().trim();
        ambilnamablk = this.et_NamaBelakang.getText().toString().trim();
        ambilkatasandi = this.et_Katasandi.getText().toString().trim();
        ambilkatasandi2 = this.et_Katasandi2.getText().toString().trim();
        if(TextUtils.isEmpty(ambilnamadpn) || TextUtils.isEmpty(ambilnamablk) || TextUtils.isEmpty(ambilkatasandi) || TextUtils.isEmpty(ambilkatasandi2)){
            CheckEditText = false;
        }
        else{
            if (ambilkatasandi.equals(ambilkatasandi2)){
                CheckEditText = true;
            }
            else {
                CheckEditText = false;
                Toast.makeText(LupaActivity.this, "Konfirmasi Kata Sandi Tidak Sama", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void simpan() {
        p_Tunggu.setVisibility(View.VISIBLE);
        btn_Simpan.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DAFTAR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String berhasil = jsonObject.getString("success");

                            if (berhasil.equals("1")){
                                Toast.makeText(LupaActivity.this,"Perubahan Berhasil", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LupaActivity.this, LoginActivity.class));
                                finish();

                            }else if (berhasil.equals("0")){
                                Toast.makeText(LupaActivity.this,"Perubahan Gagal", Toast.LENGTH_SHORT).show();
                                p_Tunggu.setVisibility(View.GONE);
                                btn_Simpan.setVisibility(View.VISIBLE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LupaActivity.this,"Perubahan Gagal " +e.toString(), Toast.LENGTH_SHORT).show();
                            p_Tunggu.setVisibility(View.GONE);
                            btn_Simpan.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LupaActivity.this,"Gagal " +error.toString(), Toast.LENGTH_SHORT).show();
                        p_Tunggu.setVisibility(View.GONE);
                        btn_Simpan.setVisibility(View.VISIBLE);
                    }
                })
        {
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("namadepan", ambilnamadpn);
                params.put("enkripsi", ambilnamablk);
                params.put("passwordpetani",ambilkatasandi);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(LupaActivity.this, LoginActivity.class));
        finish();
    }
}
