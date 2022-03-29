package com.uiuaadingding.tomtom.pandutani.b_pilihmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.b_adaptor.PilihAdaptor;
import com.uiuaadingding.tomtom.pandutani.b_pilihmenu.b_model.ItemPilih;
import com.uiuaadingding.tomtom.pandutani.d_detailmenu.DetailTanampanganActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PilihTanampanganActivity extends AppCompatActivity implements PilihAdaptor.OnItemClickListener {

    private static final String TAG = PilihHamaActivity.class.getSimpleName();

    public static final String EXTRA_ID = "id";

    private RecyclerView mRecyclerView;
    private PilihAdaptor mPilihAdaptor;
    private ArrayList<ItemPilih> mListPilih;
    private RequestQueue mRequestQueue;
    private static String et_json_url = "http://192.168.43.158/hubungkanke/pilih_tanaman.php";
    //mbak iva liat profil image nya tom
//    private static String et_json_url = "http://192.168.4.106/hubungkanke/pilih_tanaman.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_tanampangan);

        mRecyclerView = findViewById(R.id.rvpilihtanamanpangan);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        mListPilih = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON();
    }

    private void parseJSON() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, et_json_url,
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
                                String id = result.getString("idtanaman");

                                mListPilih.add(new ItemPilih(imgUrl, nama, id));
                            }

                            mPilihAdaptor = new PilihAdaptor(PilihTanampanganActivity.this, mListPilih);
                            mRecyclerView.setAdapter(mPilihAdaptor);
                            mPilihAdaptor.setOnItemClickListener(PilihTanampanganActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(PilihTanampanganActivity.this, "Gagal " + e.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(PilihTanampanganActivity.this, "Gagal meneh " + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        mRequestQueue.add(stringRequest);
    }

    @Override
    public void onItemClick(int position) {
        Intent detail = new Intent(this, DetailTanampanganActivity.class);
        ItemPilih clicked = mListPilih.get(position);

        detail.putExtra(EXTRA_ID, clicked.getId());
        startActivity(detail);
    }
}
