package com.uiuaadingding.tomtom.pandutani.pakar.jagung;

import java.text.DecimalFormat;

public class ProsesJa {
    DecimalFormat df= new DecimalFormat("#.##");
    String nama_penyakit[]={
            "Penyakit Bulai",
            "Penyakit Hawar Daun",
            "Penyakit Karat Daun",
            "Penyakit Busuk Pelepah",
            "Penyakit Gosong)",
    };

    double gejala[][]={
            {0.20, 0.20, 0.20, 0.20, 0.20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H1
            {0, 0, 0, 0, 0, 0.25, 0.25, 0, 0.25, 0.25, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H2
            {0, 0, 0, 0, 0, 0, 0.25, 0, 0.25, 0, 0.25, 0, 0, 0.25, 0, 0, 0, 0, 0}, //H3
            {0, 0, 0, 0, 0, 0, 0.33, 0, 0, 0, 0, 0.33, 0.33, 0, 0, 0, 0, 0, 0}, //H4
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.20, 0.20, 0.20, 0.20, 0.20}, //H5

    };

    public String hitungja(double[] input) {
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
                + nama_penyakit[4] + " : " + df.format(keluar[4]) + " %\n";
        return hitung;
    }
}
