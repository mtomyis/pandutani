package com.uiuaadingding.tomtom.pandutani.b_pilihmenu.b_model;

public class ItemPilih {

    private String mImageUrl, mNama, mId;

    public ItemPilih(String ImageUrl, String Nama, String Id) {
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
