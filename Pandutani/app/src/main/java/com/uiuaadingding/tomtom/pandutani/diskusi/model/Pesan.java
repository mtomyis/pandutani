package com.uiuaadingding.tomtom.pandutani.diskusi.model;

//import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 2/26/2017.
 */
//@IgnoreExtraProperties
public class Pesan {
    private String id;
    private String pesanName;
//    private String pesanGambar;
    private String pesanPetani;

    public Pesan() {

    }

    public Pesan(String id, String pesanName, String pesanPetani) {
        this.pesanName = pesanName;
//        this.pesanGambar = pesanGambar;
        this.pesanPetani = pesanPetani;
        this.id = id;
    }

    public String getPesanName() {
        return pesanName;
    }

    public String getId() {
        return id;
    }
//
//    public String getPesanGambar() {
//        return pesanGambar;
//    }

    public String getPesanPetani() {
        return pesanPetani;
    }
}
