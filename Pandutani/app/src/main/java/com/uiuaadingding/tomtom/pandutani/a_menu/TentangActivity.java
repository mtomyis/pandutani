package com.uiuaadingding.tomtom.pandutani.a_menu;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;
import com.uiuaadingding.tomtom.pandutani.R;
import com.uiuaadingding.tomtom.pandutani.SessionManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TentangActivity extends AppCompatActivity {
    private static final String TAG = TentangActivity.class.getSimpleName();
    private Button btn_Keluar, btn_gantipoto;
    SessionManager sessionManager;
    String mId;
    private Menu action;
    private TextView nama, belakang, alamat, password;
    ImageView profil;
    private static String URL_BACA = "http://192.168.43.158/hubungkanke/read_detail.php";
    private static String URL_EDIT = "http://192.168.43.158/hubungkanke/edit_detail.php";
    private static String URL_PHOTOs = "http://192.168.43.158/hubungkanke/upload.php";
    //mbak iva liat profil image nya tom
//    private static String URL_BACA = "http://192.168.4.106/hubungkanke/read_detail.php";
//    private static String URL_EDIT = "http://192.168.4.106/hubungkanke/edit_detail.php";
//    private static String URL_PHOTO = "http://192.168.4.106/hubungkanke/upload.php";
    private Bitmap bitmap;

    LocationManager locationManager;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        HashMap<String, String> user = sessionManager.getUserDetail();
//        String mNama = user.get(sessionManager.NAMA);
//        String mBelakang = user.get(sessionManager.BELAKANG);
        mId = user.get(sessionManager.ID);

        init();

        btn_Keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
            }
        });

        btn_gantipoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pilihFile();
            }
        });

    }

    private void init() {
        btn_Keluar = findViewById(R.id.idbtnkeluart);
        nama = findViewById(R.id.idnamadpnt);
        belakang = findViewById(R.id.idnamablkt);
        alamat = findViewById(R.id.idalamatt);
        password = findViewById(R.id.idkatasandit);
        profil = findViewById(R.id.idfoto);
        btn_gantipoto = findViewById(R.id.idbtngantipoto);

    }

    private void getUserDetail() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_BACA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        Log.i(TAG, response.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String berhasil = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("read");

                            if (berhasil.equals("1")) {
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String snama = object.getString("nama_petani").trim();
                                    String sbelakang = object.getString("nama_belakang").trim();
                                    String spassword = object.getString("password_petani").trim();
                                    String salamat = object.getString("alamat").trim();
                                    String sfoto = object.getString("photo").trim();

                                    nama.setText(snama);
                                    belakang.setText(sbelakang);
                                    alamat.setText(salamat);
                                    password.setText(spassword);
                                    if (sfoto.isEmpty()) {
                                        profil.setImageResource(R.drawable.farmer);
                                    } else{
                                        Picasso.with(getApplicationContext())
                                                .load(sfoto)
                                                .error(R.drawable.farmer)
                                                .into(profil, new com.squareup.picasso.Callback() {
                                                    @Override
                                                    public void onSuccess() {
                                                        Toast.makeText(TentangActivity.this, "Gambar tersedia",Toast.LENGTH_LONG).show();
                                                    }

                                                    @Override
                                                    public void onError() {
                                                        Toast.makeText(TentangActivity.this, "Gambar belum tersedia",Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(TentangActivity.this, "Gagal 1" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(TentangActivity.this, "Gagal 2" + error.toString(), Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onResume() {
        super.onResume();
        getUserDetail();
        profil.setImageBitmap(bitmap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_action, menu);

        action = menu;
        action.findItem(R.id.idmenu_save).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.idmenu_edit:
                nama.setFocusableInTouchMode(true);
                belakang.setFocusableInTouchMode(true);
                alamat.setFocusableInTouchMode(true);
                password.setFocusableInTouchMode(true);

                alamat.setText(null);

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.showSoftInput(nama, InputMethodManager.SHOW_IMPLICIT);

                action.findItem(R.id.idmenu_edit).setVisible(false);
                action.findItem(R.id.idmenu_save).setVisible(true);

                //cari lokasi metode baru
                locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                mLocationCallback = new LocationCallback() {
                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        Location mCurrentLocation = locationResult.getLastLocation();
                        LatLng myCoordinates = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
                        String cityName = getCityName(myCoordinates);
                        Toast.makeText(TentangActivity.this, "Alamat Anda Telah Ditemukan di "+cityName, Toast.LENGTH_SHORT).show();
                        alamat.append(cityName);
                    }
                };

                if (Build.VERSION.SDK_INT >= 23) {
                    Log.d("mylog", "Getting Location Permission");
                    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        Log.d("mylog", "Not granted");
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    } else
                        requestLocation();
                } else
                    requestLocation();
                //cari lokasi metode baru
                return true;

            case R.id.idmenu_save:

                SaveEditDetail();
                action.findItem(R.id.idmenu_edit).setVisible(true);
                action.findItem(R.id.idmenu_save).setVisible(false);

                nama.setFocusableInTouchMode(false);
                belakang.setFocusableInTouchMode(false);
                alamat.setFocusableInTouchMode(false);
                password.setFocusableInTouchMode(false);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void SaveEditDetail(){
        final String id = mId;
        final String nama = this.nama.getText().toString().trim();
        final String belakang = this.belakang.getText().toString().trim();
        final String alamat = this.alamat.getText().toString().trim();
        final String password = this.password.getText().toString().trim();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Menyimpan...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_EDIT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                                    String berhasil = jsonObject.getString("success");
                            if (berhasil.equals("1")){
                                Toast.makeText(TentangActivity.this, "Berhasil ", Toast.LENGTH_SHORT).show();
                                sessionManager.createSession(nama, belakang, id);
                            }
                        } catch (JSONException e) {
                            progressDialog.dismiss();
                            e.printStackTrace();
                            Toast.makeText(TentangActivity.this, "Gagal 1" + e.toString(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(TentangActivity.this, "Gagal 2" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                params.put("nama", nama);
                params.put("belakang", belakang);
                params.put("alamat", alamat);
                params.put("password", password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TentangActivity.this, MainActivity.class));
        finish();
    }

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
                profil.setImageBitmap(bitmap);
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            UploadPicture(mId, getStringImage(bitmap));
        }
    }

    private void UploadPicture(final String idp, final String photo) {

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
                                Toast.makeText(TentangActivity.this,"Berhasil", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            progressDialog.dismiss();
                            Toast.makeText(TentangActivity.this,"Gagal 1"+e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(TentangActivity.this,"Gagal 2"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id", idp);
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

    //ini juga cari lokasi metode baru
    private String getCityName(LatLng myCoordinates) {
        String myCity = "";
        Geocoder geocoder = new Geocoder(TentangActivity.this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(myCoordinates.latitude, myCoordinates.longitude, 1);
            String address = addresses.get(0).getAddressLine(0);
            myCity = addresses.get(0).getLocality();
            Log.d("mylog", "Complete Address: " + addresses.toString());
            Log.d("mylog", "Address: " + address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myCity;
    }

    private void requestLocation() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
        String provider = locationManager.getBestProvider(criteria, true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET
                }, 10);
                return;
            }
        }
        Location location = locationManager.getLastKnownLocation(provider);
        Log.d("mylog", "In Requesting Location");
        if (location != null && (System.currentTimeMillis() - location.getTime()) <= 1000 * 2) {
            LatLng myCoordinates = new LatLng(location.getLatitude(), location.getLongitude());
            String cityName = getCityName(myCoordinates);
            alamat.append(cityName);
        } else {
            LocationRequest locationRequest = new LocationRequest();
            locationRequest.setNumUpdates(1);
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            Log.d("mylog", "Last location too old getting new location!");
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            mFusedLocationClient.requestLocationUpdates(locationRequest,
                    mLocationCallback, Looper.myLooper());
        }
    }
    //ini juga cari lokasi metode baru
}
