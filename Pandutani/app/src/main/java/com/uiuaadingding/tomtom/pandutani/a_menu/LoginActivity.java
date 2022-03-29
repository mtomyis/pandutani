package com.uiuaadingding.tomtom.pandutani.a_menu;

import android.content.Intent;
import android.os.Environment;
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
import com.uiuaadingding.tomtom.pandutani.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText et_Namadepan, et_Katasandi;
    private Button btn_Masuk, btn_Daftar, btn_Lupa;
    private ProgressBar p_Tunggu;
    Boolean CheckEditText;
    private static String URL_LOGIN = "http://192.168.43.158/hubungkanke/login.php";
    //mbak iva
    //private static String URL_LOGIN = "http://192.168.4.106/hubungkanke/login.php";

    String ambilnamadpn, ambilkatasandi;
    SessionManager sessionManager;
    
    final static String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/pandutani/" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

		new File(path  ).mkdir();
		
        sessionManager =  new SessionManager(this);

        init();
        btn_Masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if(CheckEditText){
                    masuk(ambilnamadpn,ambilkatasandi);
                }
                else{
                    Toast.makeText(LoginActivity.this, "isi semua formnya!",Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_Lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, LupaActivity.class));
                finish();
            }
        });
        btn_Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, DaftarActivity.class));
                finish();
            }
        });
    }

    private void CheckEditTextIsEmptyOrNot() {
        ambilnamadpn = this.et_Namadepan.getText().toString().trim();
        ambilkatasandi = this.et_Katasandi.getText().toString().trim();
        if(TextUtils.isEmpty(ambilnamadpn) || TextUtils.isEmpty(ambilkatasandi)){
            CheckEditText = false;
        }
        else{
            CheckEditText = true;
        }
    }
    private void masuk(final String nama, final String password){
        p_Tunggu.setVisibility(View.VISIBLE);
        btn_Masuk.setVisibility(View.GONE);
        btn_Daftar.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String berhasil = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("login");

                    if (berhasil.equals("1")){
                        for (int i = 0; i < jsonArray.length(); i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            String nama = object.getString("nama_petani").trim();
                            String belakang = object.getString("nama_belakang").trim();
                            String id = object.getString("idpetani").trim();

                            Toast.makeText(LoginActivity.this,"Berhasil. \nSelamat Datang "+nama+" "+belakang, Toast.LENGTH_SHORT).show();

                            sessionManager.createSession(nama, belakang, id);

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else if (berhasil.equals("0")){
                        Toast.makeText(LoginActivity.this,"Gagal", Toast.LENGTH_SHORT).show();
                        p_Tunggu.setVisibility(View.GONE);
                        btn_Daftar.setVisibility(View.VISIBLE);
                        btn_Masuk.setVisibility(View.VISIBLE);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(LoginActivity.this,"Gagal "+e.toString(),Toast.LENGTH_SHORT).show();
                    p_Tunggu.setVisibility(View.GONE);
                    btn_Masuk.setVisibility(View.VISIBLE);
                    btn_Daftar.setVisibility(View.VISIBLE);
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,"Gagal "+error.toString(),Toast.LENGTH_SHORT).show();
                        p_Tunggu.setVisibility(View.GONE);
                        btn_Masuk.setVisibility(View.VISIBLE);
                        btn_Daftar.setVisibility(View.VISIBLE);
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>params=new HashMap<>();
                params.put("nama", nama);
                params.put("password", password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void init() {
        p_Tunggu = findViewById(R.id.idtunggum);
        et_Namadepan = findViewById(R.id.idnamadpnm);
        et_Katasandi = findViewById(R.id.idkatasandim);
        btn_Daftar = findViewById(R.id.idbtndaftarm);
        btn_Masuk = findViewById(R.id.idbtnmasukm);
        btn_Lupa = findViewById(R.id.idbtnlupam);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
