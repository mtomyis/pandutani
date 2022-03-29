package com.uiuaadingding.tomtom.pandutani.pakar.padi;


import java.text.DecimalFormat;

public class Proses {

    DecimalFormat df= new DecimalFormat("#.##");
    String nama_penyakit[]={
            "Hama Putih (Nyumphula depunctalis GUER)",
            "Hama Trip Padi (Trips oryzae)",
            "Hama Ulat tentara (Pseudaletia-unipuncta)",
            "Hama Ganjur (Pachydiplosis oryzae)",
            "Hama Uret atau kuuk (Melolontha vulgaris F)",
            "Hama Orong-orong (Gryllotalpa africana)",
            "Hama Wereng coklat (Nilaparvata lugens Stal)",
            "Hama Wereng hijau (Nephotettix)",
            "Hama Walang sangit (Leptocoriza acuta Thumb)",
            "Hama Kepik hijau (Nezara viridula)",
            "Hama Penggerek batang padi (Tryporyza innotata WLK)",
            "Hama Tikus (Rattus argentiventer)",
            "Hama Burung Emprit (Lonchura lencogastroides H & M)",
    };

    double gejala[][]={
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H1
            {0.33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.33, 0, 0, 0, 0, 0, 0.33, 0, 0, 0, 0, 0, 0, 0, 0}, //H2
            {0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H3
            {0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0}, //H4
            {0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H5
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0}, //H6
            {0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0}, //H7
            {0, 0, 0, 0, 0, 0, 0, 0.33, 0, 0, 0, 0, 0, 0, 0, 0, 0.33, 0, 0, 0, 0, 0, 0.33, 0, 0, 0, 0}, //H8
            {0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //H9
            {0, 0, 0.33, 0, 0, 0, 0, 0, 0, 0.33, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.33, 0, 0, 0}, //H10
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, //H11
            {0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0}, //H12
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.50}, //H13

    };

    public String hitung(double[] input) {
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
                + nama_penyakit[5] + " : " + df.format(keluar[5]) + " %\n"
                + nama_penyakit[6] + " : " + df.format(keluar[6]) + " %\n"
                + nama_penyakit[7] + " : " + df.format(keluar[7]) + " %\n"
                + nama_penyakit[8] + " : " + df.format(keluar[8]) + " %\n"
                + nama_penyakit[9] + " : " + df.format(keluar[9]) + " %\n"
                + nama_penyakit[10] + " : " + df.format(keluar[10]) + " %\n"
                + nama_penyakit[11] + " : " + df.format(keluar[11]) + " %\n"
                + nama_penyakit[12] + " : " + df.format(keluar[12]) + " %\n"
        ;
        return hitung;
    }
}

