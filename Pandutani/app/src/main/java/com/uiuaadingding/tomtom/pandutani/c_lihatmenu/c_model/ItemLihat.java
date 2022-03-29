package com.uiuaadingding.tomtom.pandutani.c_lihatmenu.c_model;

public class ItemLihat {
    private String mImageUrl, mNama, mId;

    public ItemLihat(String ImageUrl, String Nama, String Id) {
        this.mImageUrl = ImageUrl;
        this.mNama = Nama;
        this.mId = Id;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getNama() {
        return mNama;
    }
    public String getId() {
        return mId;
    }
}
