package com.uiuaadingding.tomtom.pandutani;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.uiuaadingding.tomtom.pandutani.a_menu.LoginActivity;
import com.uiuaadingding.tomtom.pandutani.a_menu.MainActivity;
import com.uiuaadingding.tomtom.pandutani.a_menu.TentangActivity;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAMA = "NAMA";
    public static final String BELAKANG = "BELAKANG";
    public static final String ID = "ID";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String nama, String belakang, String id){
        editor.putBoolean(LOGIN, true);
        editor.putString(NAMA, nama);
        editor.putString(BELAKANG, belakang);
        editor.putString(ID, id);
        editor.apply();
    }

    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin(){
        if (!this.isLoggin()){
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
            ((TentangActivity) context).finish();
        }
    }

    public void checkLoginmain(){
        if (!this.isLoggin()){
            Intent intent = new Intent(context, LoginActivity.class);
            context.startActivity(intent);
            ((MainActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(NAMA, sharedPreferences.getString(NAMA, null));
        user.put(BELAKANG, sharedPreferences.getString(BELAKANG, null));
        user.put(ID, sharedPreferences.getString(ID, null));
        return user;
    }

    public void logout(){
        editor.clear();
        editor.commit();
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
        ((TentangActivity) context).finish();

    }
}
