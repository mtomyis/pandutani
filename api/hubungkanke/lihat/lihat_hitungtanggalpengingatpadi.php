<?php

require_once '../connect.php';

if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $tglpersemaian = $_POST['tanggalpersemaian'];
    $id = $_POST['id'];

    //$tglpersemaian="2019-5-1";

    $response = $conn->prepare("SELECT jarak_hst FROM pengingat where fk_idtanaman_pangan='$id';");

    $response -> execute();

    $response->bind_result($jarak_hst);

    $result = array();

    while ($response->fetch()) {

        $h = $jarak_hst;

        array_push($result, $h);
    }
    $olahlahan = json_encode($result[0]);
    $penanaman = json_encode($result[1]);
    $pengairan = json_encode($result[2]);
    $pengairan2 = json_encode($result[3]);
    $monitorhama = json_encode($result[4]);
    $pemupukan = json_encode($result[5]);
    $monitorhama2 = json_encode($result[6]);
    $pemupukanbwd = json_encode($result[7]);
    $monitorhama3 = json_encode($result[8]);
    $pemupukanbwd2 = json_encode($result[9]);
    $monitorhama4 = json_encode($result[10]);
    $pemupukanbwd3 = json_encode($result[11]);
    $pengairan3 = json_encode($result[12]);
    $pengairan4 = json_encode($result[13]);
    $panen = json_encode($result[14]);

    //dijadikan string ke +19 days dan strusnya
    $Iolahlahan = "+$olahlahan days";
    $Ipenanaman = "+$penanaman days";
    $Ipengairan = "+$pengairan days";
    $Ipengairan2 = "+$pengairan2 days";
    $Imonitorhama = "+$monitorhama days";
    $Ipemupukan = "+$pemupukan days";
    $Imonitorhama2 = "+$monitorhama2 days";
    $Ipemupukanbwd = "+$pemupukanbwd days";
    $Imonitorhama3 = "+$monitorhama3 days";
    $Ipemupukanbwd2 = "+$pemupukanbwd2 days";
    $Imonitorhama4 = "+$monitorhama4 days";
    $Ipemupukanbwd3 = "+$pemupukanbwd3 days";
    $Ipengairan3 = "+$pengairan3 days";
    $Ipengairan4 = "+$pengairan4 days";
    $Ipanen = "+$panen days";

    $tgl1 = date('Y-m-d', strtotime($Iolahlahan, strtotime($tglpersemaian))); $tgl1_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl1)));
    $tgl2 = date('Y-m-d', strtotime($Ipenanaman, strtotime($tglpersemaian))); $tgl2_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl2)));
    $tgl3 = date('Y-m-d', strtotime($Ipengairan, strtotime($tgl2))); $tgl3_2 = date('Y-m-d', strtotime('+10 days', strtotime($tgl2)));
    $tgl4 = date('Y-m-d', strtotime($Ipengairan2, strtotime($tgl2))); $tgl4_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl4)));
    $tgl5 = date('Y-m-d', strtotime($Imonitorhama, strtotime($tgl2))); $tgl5_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl5)));
    $tgl6 = date('Y-m-d', strtotime($Ipemupukan, strtotime($tgl2))); $tgl6_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl6)));
    $tgl7 = date('Y-m-d', strtotime($Imonitorhama2, strtotime($tgl2))); $tgl7_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl7)));
    $tgl8 = date('Y-m-d', strtotime($Ipemupukanbwd, strtotime($tgl2))); $tgl8_2 = date('Y-m-d', strtotime('+28 days', strtotime($tgl2)));
    $tgl9 = date('Y-m-d', strtotime($Imonitorhama3, strtotime($tgl7))); $tgl9_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl9)));
    $tgl10 = date('Y-m-d', strtotime($Ipemupukanbwd2, strtotime($tgl8_2))); $tgl10_2 = date('Y-m-d', strtotime('+10 days', strtotime($tgl8_2)));
    $tgl11 = date('Y-m-d', strtotime($Imonitorhama4, strtotime($tgl9))); $tgl11_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl11)));
    $tgl12 = date('Y-m-d', strtotime($Ipemupukanbwd3, strtotime($tgl10_2))); $tgl12_2 = date('Y-m-d', strtotime('+10 days', strtotime($tgl10_2)));
    $tgl13 = date('Y-m-d', strtotime($Ipengairan3, strtotime($tgl12_2))); $tgl13_2 = date('Y-m-d', strtotime('+90 days', strtotime($tgl2)));
    $tgl14 = date('Y-m-d', strtotime($Ipengairan4, strtotime($tgl2))); $tgl14_2 = date('Y-m-d', strtotime('+99 days', strtotime($tgl2)));
    $tgl15 = date('Y-m-d', strtotime($Ipanen, strtotime($tgl2))); $tgl15_2 = date('Y-m-d', strtotime('+1 days', strtotime($tgl15)));


    $sql = "SELECT * FROM petani";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['read'] = array();

    if( mysqli_num_rows($response) > 0 ) {
        $l['tgl1'] = $tgl1; $l['tgl1_2'] = $tgl1_2;
        $l['tgl2'] = $tgl2; $l['tgl2_2'] = $tgl2_2;
        $l['tgl3'] = $tgl3; $l['tgl3_2'] = $tgl3_2;
        $l['tgl4'] = $tgl4; $l['tgl4_2'] = $tgl4_2;
        $l['tgl5'] = $tgl5; $l['tgl5_2'] = $tgl5_2;
        $l['tgl6'] = $tgl6; $l['tgl6_2'] = $tgl6_2;
        $l['tgl7'] = $tgl7; $l['tgl7_2'] = $tgl7_2;
        $l['tgl8'] = $tgl8; $l['tgl8_2'] = $tgl8_2;
        $l['tgl9'] = $tgl9; $l['tgl9_2'] = $tgl9_2;
        $l['tgl10'] = $tgl10; $l['tgl10_2'] = $tgl10_2;
        $l['tgl11'] = $tgl11; $l['tgl11_2'] = $tgl11_2;
        $l['tgl12'] = $tgl12; $l['tgl12_2'] = $tgl12_2;
        $l['tgl13'] = $tgl13; $l['tgl13_2'] = $tgl13_2;
        $l['tgl14'] = $tgl14; $l['tgl14_2'] = $tgl14_2;
        $l['tgl15'] = $tgl15; $l['tgl15_2'] = $tgl15_2;


    array_push($result['read'], $l);
    }
    echo json_encode($result);

 }else {
 
     $result["success"] = "0";
     $result["message"] = "Error!";
     echo json_encode($result);
 }
 
 ?>