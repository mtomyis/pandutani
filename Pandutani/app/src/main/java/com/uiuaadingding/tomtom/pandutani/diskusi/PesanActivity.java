package com.uiuaadingding.tomtom.pandutani.diskusi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.SessionManager;
import com.uiuaadingding.tomtom.pandutani.diskusi.adaptor.PesanList;
import com.uiuaadingding.tomtom.pandutani.diskusi.model.Pesan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PesanActivity extends AppCompatActivity {
    private static final String TAG = PesanActivity.class.getSimpleName();

    private Menu action;
    Button buttonAddTrack;
    EditText editTextTrackName;
    SeekBar seekBarRating;
    TextView textViewRating, textViewArtist;
    ListView listViewTracks;
    String mId, snama;
    SessionManager sessionManager;
    LinearLayout ly;

    DatabaseReference databaseTracks;
    private static String URL_BACA = "http://192.168.43.158/hubungkanke/read_detail.php";
    ImageView gambar;

    List<Pesan> pesans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        Intent intent = getIntent();
        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        HashMap<String, String> user = sessionManager.getUserDetail();

        mId = user.get(sessionManager.ID);
        getUserDetail();

        databaseTracks = FirebaseDatabase.getInstance().getReference("pesans").child(intent.getStringExtra(DiskusiActivity.DISKUSI_ID));

        buttonAddTrack = (Button) findViewById(R.id.buttonAddTrack);
        editTextTrackName = (EditText) findViewById(R.id.editTextName);
        textViewArtist = (TextView) findViewById(R.id.textViewArtist);
        listViewTracks = (ListView) findViewById(R.id.listViewTracks);
        gambar = findViewById(R.id.idgambar);
        ly = findViewById(R.id.isimenu);

        pesans = new ArrayList<>();

        textViewArtist.setText(intent.getStringExtra(DiskusiActivity.DISKUSI_NAME));
        setTitle(intent.getStringExtra(DiskusiActivity.DISKUSI_PETANI));
        if (intent.getStringExtra(DiskusiActivity.DISKUSI_GAMBAR).isEmpty()) {
            gambar.setImageResource(R.drawable.farmer);
        } else{
            Picasso.with(getApplicationContext())
                    .load("http://192.168.43.158/hubungkanke/diskusi/"+intent.getStringExtra(DiskusiActivity.DISKUSI_GAMBAR))
                    .error(R.drawable.farmer)
                    .into(gambar, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            Toast.makeText(PesanActivity.this, "Gambar tersedia",Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onError() {
                            Toast.makeText(PesanActivity.this, "Gambar belum tersedia",Toast.LENGTH_LONG).show();
                        }
                    });
        }

        buttonAddTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTrack();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();

        databaseTracks.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pesans.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Pesan track = postSnapshot.getValue(Pesan.class);
                    pesans.add(track);
                }
                PesanList trackListAdapter = new PesanList(PesanActivity.this, pesans);
                listViewTracks.setAdapter(trackListAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void saveTrack() {
        String trackName = editTextTrackName.getText().toString().trim();
//        int rating = seekBarRating.getProgress();
        if (!TextUtils.isEmpty(trackName)) {
            String id  = databaseTracks.push().getKey();
            Pesan track = new Pesan(id, trackName, snama);
            databaseTracks.child(id).setValue(track);
            //Toast.makeText(this, "Track saved", Toast.LENGTH_LONG).show();
            editTextTrackName.setText("");
        } else {
            Toast.makeText(this, "Please enter pesan", Toast.LENGTH_LONG).show();
        }
    }

    //nama petani
    private void getUserDetail() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_BACA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, response.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String berhasil = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("read");

                            if (berhasil.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    snama = object.getString("nama_petani").trim();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(PesanActivity.this, "Gagal 1" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PesanActivity.this, "Gagal 2" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", mId);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    //nama petani

    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        action = menu;
        action.findItem(R.id.idmenu_save).setVisible(false);
        ly.setVisibility(View.VISIBLE);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.idmenu_edit:
                action.findItem(R.id.idmenu_edit).setVisible(false);
                action.findItem(R.id.idmenu_save).setVisible(true);
                ly.setVisibility(View.GONE);
                return true;

            case R.id.idmenu_save:
                action.findItem(R.id.idmenu_edit).setVisible(true);
                action.findItem(R.id.idmenu_save).setVisible(false);
                ly.setVisibility(View.VISIBLE);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //menu
}
