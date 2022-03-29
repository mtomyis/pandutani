package com.uiuaadingding.tomtom.pandutani.diskusi.model;

//import com.google.firebase.database.IgnoreExtraProperties;


//@IgnoreExtraProperties
public class Diskusi {
    private String diskusiId;
    private String diskusiName;
    private String diskusiGenre;
    private String diskusiPetani;
    private String diskusiGambar;

    public Diskusi(){
        //this constructor is required
    }

    public Diskusi(String diskusiId, String diskusiName, String diskusiGenre, String diskusiPetani, String diskusiGambar) {
        this.diskusiId = diskusiId;
        this.diskusiName = diskusiName;
        this.diskusiGenre = diskusiGenre;
        this.diskusiPetani = diskusiPetani;
        this.diskusiGambar = diskusiGambar;
    }

    public String getDiskusiId() {
        return diskusiId;
    }

    public String getDiskusiName() {
        return diskusiName;
    }

    public String getDiskusiGenre() {
        return diskusiGenre;
    }

    public String getDiskusiPetani() {
        return diskusiPetani;
    }

    public String getDiskusiGambar() {
        return diskusiGambar;
    }
}
