package com.uiuaadingding.tomtom.pandutani.d_detailmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class DetailPengingatActivity extends AppCompatActivity {
    private static final String TAG = DetailPengingatActivity.class.getSimpleName();

    protected static String EXTRA_ID = "";
    private RequestQueue mmRequestQueue;
    int id;
    String idd;
    TextView tv;
    private static String URL_BACA = "http://192.168.43.158/hubungkanke/baca/baca_detailpengingat.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pengingat);

        id = getIntent().getIntExtra(EXTRA_ID, 0);
        idd = Integer.toString(id).trim();
        //Toast.makeText(DetailPengingatActivity.this, ""+id, Toast.LENGTH_SHORT).show();

        tv = findViewById(R.id.tvnotifikasi);
        mmRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
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

                                String ciri = result.getString("ciri");

                                tv.setText(ciri);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(DetailPengingatActivity.this, "Gagal meneh " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(DetailPengingatActivity.this, "Gagal meneh " + error.toString(), Toast.LENGTH_SHORT).show();

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
