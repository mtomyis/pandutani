package com.uiuaadingding.tomtom.pandutani.diskusi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.SessionManager;
import com.uiuaadingding.tomtom.pandutani.diskusi.model.Diskusi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class TambahTopikActivity extends AppCompatActivity {
    private static final String TAG = TambahTopikActivity.class.getSimpleName();

    String mId, snama;
    SessionManager sessionManager;
    String saveCurrentDate;

    private static String URL_BACA = "http://192.168.43.158/hubungkanke/read_detail.php";
    private static String URL_PHOTOs = "http://192.168.43.158/hubungkanke/diskusi.php";
    private Bitmap bitmap;

    EditText editTextName;
    Spinner spinnerGenre;
    Button buttonAddArtist, btnUpload;
    DatabaseReference databaseArtists;
    TextView pathgambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_topik);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        HashMap<String, String> user = sessionManager.getUserDetail();

        mId = user.get(sessionManager.ID);
        getUserDetail();

        editTextName = findViewById(R.id.editTextName);
        buttonAddArtist = findViewById(R.id.buttonAddArtistt);
        pathgambar = findViewById(R.id.pathgambar);
        spinnerGenre = findViewById(R.id.spinnerGenres);
        btnUpload = findViewById(R.id.idgambar);

        //getting the reference of artists node
        databaseArtists = FirebaseDatabase.getInstance().getReference("diskusis");


        //adding an onclicklistener to button
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArtist();
                finish();
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pilihFile();
            }
        });
    }

    private void addArtist() {
        //getting the values to save
        String name = editTextName.getText().toString().trim();
        String genre = spinnerGenre.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            Diskusi artist = new Diskusi(id, name, genre, snama, saveCurrentDate+".jpeg");

            //Saving the Artist
            databaseArtists.child(id).setValue(artist);

            //setting edittext to blank again
            editTextName.setText("");

            //displaying a success toast
            Toast.makeText(this, "Berhasil", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(TambahTopikActivity.this, "Gagal 1" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TambahTopikActivity.this, "Gagal 2" + error.toString(), Toast.LENGTH_SHORT).show();
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

    //image
    private void pilihFile(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Pilih Gambar"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null){
            Uri filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //profil.setImageBitmap(bitmap);
                Calendar c = Calendar.getInstance();
                java.text.SimpleDateFormat currentDate = new java.text.SimpleDateFormat("HH_mm_ss");
                saveCurrentDate = currentDate.format(c.getTime());
                pathgambar.setText(saveCurrentDate+".jpeg");

            } catch (IOException e) {
                e.printStackTrace();
            }
            UploadPicture(saveCurrentDate, getStringImage(bitmap));
        }
    }

    private void UploadPicture(final String saveCurrentDate, final String photo) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Menyimpan...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PHOTOs,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Log.i(TAG, response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String berhasil = jsonObject.getString("success");

                            if (berhasil.equals("1")){
                                Toast.makeText(TambahTopikActivity.this,"Berhasil", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(TambahTopikActivity.this,"Gagal 1"+e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(TambahTopikActivity.this,"Gagal 2"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("saveCurrentDate", saveCurrentDate);
                params.put("photo", photo);

                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public String getStringImage(Bitmap bitmap){

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] imageByteArray = byteArrayOutputStream.toByteArray();
        String enCodedImage = Base64.encodeToString(imageByteArray, Base64.DEFAULT);

        return enCodedImage;
    }
    //image

}
