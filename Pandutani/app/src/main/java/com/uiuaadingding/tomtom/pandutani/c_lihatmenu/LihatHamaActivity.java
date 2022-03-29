package com.uiuaadingding.tomtom.pandutani.c_lihatmenu;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.PilihHamaActivity;
import com.uiuaadingding.tomtom.pandutani.c_lihatmenu.c_adaptor.LihatAdaptor;
import com.uiuaadingding.tomtom.pandutani.c_lihatmenu.c_model.ItemLihat;
import com.uiuaadingding.tomtom.pandutani.d_detailmenu.DetailHamaActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.uiuaadingding.tomtom.pandutani.b_pilihmenu.PilihHamaActivity.EXTRA_ID;

public class LihatHamaActivity extends AppCompatActivity implements LihatAdaptor.OnItemClickListener {

    private static final String TAG = LihatHamaActivity.class.getSimpleName();

    public static final String EXTRA_IDD = "idd";
    String id;

    private RecyclerView mRecyclerView;
    private LihatAdaptor mLihatAdaptor;
    private ArrayList<ItemLihat> mListLihat;
    private RequestQueue mRequestQueue;
        private static String et_json_url = "http://192.168.43.158/hubungkanke/lihat/lihat_tahapan_hama.php";
    //mbak iva liat profil image nya tom
//    private static String et_json_url = "http://192.168.4.106/hubungkanke/lihat/lihat_tahapan_hama.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_hama);

        Intent intent = getIntent();
        id = intent.getStringExtra(EXTRA_ID);
//        Toast.makeText(LihatHamaActivity.this, "id "+id, Toast.LENGTH_LONG).show();

        mRecyclerView = findViewById(R.id.rvlihathama);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mListLihat = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, et_json_url,
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
                                String idd = result.getString("idhama");

                                mListLihat.add(new ItemLihat(imgUrl, nama, idd));
                            }

                            mLihatAdaptor = new LihatAdaptor(LihatHamaActivity.this, mListLihat);
                            mRecyclerView.setAdapter(mLihatAdaptor);
                            mLihatAdaptor.setOnItemClickListener(LihatHamaActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(LihatHamaActivity.this, "Gagal " + e.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(LihatHamaActivity.this, "Gagal meneh " + error.toString(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                return params;
            }
        };

        mRequestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent detail = new Intent(this, DetailHamaActivity.class);
        ItemLihat clicked = mListLihat.get(position);

        detail.putExtra(EXTRA_IDD, clicked.getId());

        startActivity(detail);
    }
}

