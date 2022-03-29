package com.uiuaadingding.tomtom.pandutani.d_detailmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;
import com.uiuaadingding.tomtom.pandutani.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.uiuaadingding.tomtom.pandutani.c_lihatmenu.LihatProsedurActivity.EXTRA_IDD;

public class DetailProsedurActivity extends AppCompatActivity {
    private static final String TAG = DetailProsedurActivity.class.getSimpleName();

    private ImageView et_Ivgambar;
    private TextView et_Nama, et_Uraian;
    String idd;
    private RequestQueue mmRequestQueue;

    private static String URL_BACA = "http://192.168.43.158/hubungkanke/baca/baca_detailprosedur.php";
//    private static String URL_BACA = "http://192.168.4.106/hubungkanke/baca/baca_detailhama.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_prosedur);

        Intent intent = getIntent();
        idd = intent.getStringExtra(EXTRA_IDD);
        //Toast.makeText(DetailProsedurActivity.this, "id "+idd, Toast.LENGTH_LONG).show();

        init();
        mmRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void init() {
        et_Ivgambar = findViewById(R.id.id_detail_ivgambar_prosedur);
        et_Nama = findViewById(R.id.id_detail_tvnama_prosedur);
        et_Uraian = findViewById(R.id.id_detail_tvuraian_prosedur);
    }

    private void parseJSON() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_BACA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, response.toString());
                        try {
                            //JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i=0; i<jsonArray.length(); i++){
                                JSONObject result = jsonArray.getJSONObject(i);

                                String imgUrl = result.getString("gambar");
                                String nama = result.getString("nama");
                                String uraian_prosedur = result.getString("uraian");

                                et_Nama.setText(nama);
                                et_Uraian.setText(uraian_prosedur);
                                if (imgUrl.isEmpty()) {
                                    et_Ivgambar.setImageResource(R.drawable.farmer);
                                } else{
                                    Picasso.with(getApplicationContext())
                                            .load("http://192.168.43.158/pandutani/upload/"+imgUrl)
                                            .placeholder(R.drawable.farmer)
                                            .error(R.drawable.farmer)
                                            .into(et_Ivgambar, new com.squareup.picasso.Callback() {
                                                @Override
                                                public void onSuccess() {
                                                    //Toast.makeText(DetailProsedurActivity.this, "gambar berhasil diambil",Toast.LENGTH_LONG).show();
                                                }

                                                @Override
                                                public void onError() {
                                                    Toast.makeText(DetailProsedurActivity.this, "gagal mengambil",Toast.LENGTH_LONG).show();
                                                }
                                            });
                                }

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(DetailProsedurActivity.this, "Gagal mengambil " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(DetailProsedurActivity.this, "Gagal mengambil " + error.toString(), Toast.LENGTH_SHORT).show();

            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idd);
                return params;
            }
        };

        mmRequestQueue.add(stringRequest);
    }
}
