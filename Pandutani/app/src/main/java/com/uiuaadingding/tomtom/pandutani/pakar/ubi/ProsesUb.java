package com.uiuaadingding.tomtom.pandutani.pakar.ubi;

import java.text.DecimalFormat;

public class ProsesUb {
    DecimalFormat df= new DecimalFormat("#.##");
    String nama_penyakit[]={
            "Penyakit Bercak Daun Coklat",
            "Penyakit Bercak Daun Baur",
            "Penyakit Bercak Daun Putih",
            "Penyakit Bakteri Hawar Daun",
            "Penyakit Antrak Nose",
            "Penyakit Usuk Pangkal Batang/Akar",
            "Penyakit Selaput Lendir Putih)",
    };

    double gejala[][]={
            {0.09, 0.09, 0.09, 0.09, 0.09, 0.09, 0.09, 0.09, 0.09, 0.09, 0.09, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H1
            {0.1, 0, 0, 0, 0.1, 0.1, 0, 0, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0, 0.1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H2
            {0.14, 0, 0, 0, 0, 0.14, 0.14, 0, 0.14, 0.14, 0, 0, 0, 0, 0, 0, 0.14, 0.14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H3
            {0, 0, 0, 0, 0, 0.11, 0, 0, 0.11, 0.11, 0, 0, 0, 0, 0, 0, 0, 0, 0.11, 0.11, 0.11, 0.11, 0.11, 0.11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H4
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.14, 0.14, 0.14, 0.14, 0.14, 0.14, 0.14, 0, 0, 0, 0, 0}, //H5
            {0, 0, 0, 0, 0, 0, 0, 0, 0.16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.16, 0.16, 0.16, 0.16, 0.16}, //H6
            {0, 0, 0, 0, 0, 0, 0.07, 0, 0.07, 0, 0, 0, 0, 0, 0.07, 0, 0.07, 0, 0.07, 0, 0, 0, 0.07, 0.07, 0.07, 0.07, 0, 0.07, 0.07, 0.07, 0, 0, 0, 0, 0.07}, //H7
    };

    public String hitungUb(double[] input) {
        String hitung;
        double[] hasil = new double[gejala.length];
        double[] keluar = new double[gejala.length];
        for (int i = 0; i < gejala.length; i++) { //hama
            for (int j = 0; j < gejala[0].length; j++) { //gejala
                hasil[i] += input[j] * gejala[i][j];
            }
            keluar[i] = hasil[i] * 100;
            //System.out.println(hasil);
        }

        double temp = 0;
        int index = 0;

        for (int i = 0; i < hasil.length; i++) {
            if (temp < keluar[i]) {
                temp = keluar[i];
                index = i;
            }
        }
//        for (int i = 0; i < nama_penyakit.length; i++) {
//            System.out.println(nama_penyakit[i]);
//        }

        hitung =nama_penyakit[index]+"\n\n"
                +"Berikut daftar nilai tiap penyakit \n"+
                nama_penyakit[0] + " : " + df.format(keluar[0]) + " %\n"
                + nama_penyakit[1] + " : " + df.format(keluar[1]) + " %\n"
                + nama_penyakit[2] + " : " + df.format(keluar[2]) + " %\n"
                + nama_penyakit[3] + " : " + df.format(keluar[3]) + " %\n"
                + nama_penyakit[4] + " : " + df.format(keluar[4]) + " %\n"
                + nama_penyakit[5] + " : " + df.format(keluar[4]) + " %\n"
                + nama_penyakit[6] + " : " + df.format(keluar[4]) + " %\n";

        return hitung;
    }
}
