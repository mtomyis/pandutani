package com.uiuaadingding.tomtom.pandutani.a_menu;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
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
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.uiuaadingding.tomtom.pandutani.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class DaftarActivity extends AppCompatActivity {
    private EditText et_Namadepan, et_NamaBelakang, et_Alamat, et_Katasandi, et_Katasandi2;
    private Button btn_Daftar;
    private ProgressBar p_Tunggu;
    Boolean CheckEditText;
    String random_string;
    private static String URL_DAFTAR = "http://192.168.43.158/hubungkanke/register.php";
    //mbakiva
    //private static String URL_DAFTAR = "http://192.168.4.106/hubungkanke/register.php";

    String ambilnamadpn, ambilnamablk, ambilalamat, ambilkatasandi, ambilkatasandi2;
    ImageButton btnlokasi;

    LocationManager locationManager;
    private FusedLocationProviderClient mFusedLocationClient;
    private LocationCallback mLocationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        init();
        btn_Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if (CheckEditText) {
                    daftar();
                    if (FileHelper.saveToFile(random_string)){
                        Toast.makeText(DaftarActivity.this,"Silahkan Gunakan file pandutani.txt untuk ganti password \n terdapat pada folder pandutani",Toast.LENGTH_LONG).show();
                    }
                    else Toast.makeText(DaftarActivity.this,"Gagal menyimpan file untuk ganti password",Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(DaftarActivity.this, "isi semua formnya!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //cari lokasi metode baru
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mLocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                Location mCurrentLocation = locationResult.getLastLocation();
                LatLng myCoordinates = new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude());
                String cityName = getCityName(myCoordinates);
                Toast.makeText(DaftarActivity.this, "Alamat Anda Telah Ditemukan di "+cityName, Toast.LENGTH_SHORT).show();
                et_Alamat.append(cityName);
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
    }

    //ini juga cari lokasi metode baru
    private String getCityName(LatLng myCoordinates) {
        String myCity = "";
        Geocoder geocoder = new Geocoder(DaftarActivity.this, Locale.getDefault());
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
            et_Alamat.append(cityName);
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

    private void init() {
        p_Tunggu = findViewById(R.id.idtunggud);
        et_Namadepan = findViewById(R.id.idnamadpnd);
        et_NamaBelakang = findViewById(R.id.idnamablkd);
        et_Alamat = findViewById(R.id.idalamatd);
        et_Katasandi = findViewById(R.id.idkatasandid);
        et_Katasandi2 = findViewById(R.id.idkatasandi2d);
        btn_Daftar = findViewById(R.id.idbtndaftard);
        btnlokasi = findViewById(R.id.btnlokasid);
    }

    public void CheckEditTextIsEmptyOrNot() {
        ambilnamadpn = this.et_Namadepan.getText().toString().trim();
        ambilnamablk = this.et_NamaBelakang.getText().toString().trim();
        ambilalamat = this.et_Alamat.getText().toString().trim();
        ambilkatasandi = this.et_Katasandi.getText().toString().trim();
        ambilkatasandi2 = this.et_Katasandi2.getText().toString().trim();
        if(TextUtils.isEmpty(ambilnamadpn) || TextUtils.isEmpty(ambilnamablk) || TextUtils.isEmpty(ambilalamat) || TextUtils.isEmpty(ambilkatasandi) || TextUtils.isEmpty(ambilkatasandi2)){
            CheckEditText = false;
        }
        else{
            if (ambilkatasandi.equals(ambilkatasandi2)){
                CheckEditText = true;
            }
            else {
                CheckEditText = false;
                Toast.makeText(DaftarActivity.this, "Konfirmasi Kata Sandi Tidak Sama", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void daftar() {

        //acak kata
        char[] chars1 = "ABCDEF012GHIJKL345MNOPQR678STUVWXYZ9".toCharArray();
        StringBuilder sb1 = new StringBuilder();
        Random random1 = new Random();
        for (int i = 0; i < 6; i++)
        {
            char c1 = chars1[random1.nextInt(chars1.length)];
            sb1.append(c1);
        }
        random_string = sb1.toString();

        p_Tunggu.setVisibility(View.VISIBLE);
        btn_Daftar.setVisibility(View.GONE);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DAFTAR,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String berhasil = jsonObject.getString("success");

                            if (berhasil.equals("1")){

                                Toast.makeText(DaftarActivity.this,"Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DaftarActivity.this, LoginActivity.class));
                                finish();

                            }else if (berhasil.equals("0")){
                                Toast.makeText(DaftarActivity.this,"Pendaftaran Gagal", Toast.LENGTH_SHORT).show();
                                p_Tunggu.setVisibility(View.GONE);
                                btn_Daftar.setVisibility(View.VISIBLE);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(DaftarActivity.this,"Pendaftaran Gagal " +e.toString(), Toast.LENGTH_SHORT).show();
                            p_Tunggu.setVisibility(View.GONE);
                            btn_Daftar.setVisibility(View.VISIBLE);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DaftarActivity.this,"Pendaftaran Gagal " +error.toString(), Toast.LENGTH_SHORT).show();
                        p_Tunggu.setVisibility(View.GONE);
                        btn_Daftar.setVisibility(View.VISIBLE);
                    }
                })
        {
            protected Map<String,String> getParams() throws AuthFailureError{
                Map<String,String> params = new HashMap<>();
                params.put("namadepan", ambilnamadpn);
                params.put("namabelakang", ambilnamablk);
                params.put("passwordpetani",ambilkatasandi);
                params.put("alamat",ambilalamat);
                params.put("acak", random_string);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(DaftarActivity.this, LoginActivity.class));
        finish();
    }
}
