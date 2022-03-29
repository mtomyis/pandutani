<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $id = $_POST['id'];

    require_once '../connect.php';

    $response = $conn -> prepare("SELECT nama_hama, gambar_hama, uraian_hama, penanggulangan FROM hama WHERE idhama='$id';");
    
    $response -> execute();

    $response -> bind_result($nama_hama, $gambar_hama, $uraian_hama, $penanggulangan);

    $result = array();;
        
    while ($response->fetch()) {
        $h['nama']        = $nama_hama;
        $h['gambar']       = $gambar_hama;
        $h['uraian']       = $uraian_hama;
        $h['penanggulangan']       = $penanggulangan;

        array_push($result, $h);
    }
     echo json_encode($result);

 }else {
 
     $result["success"] = "0";
     $result["message"] = "Error!";
     echo json_encode($result);
 
     mysqli_close($conn);
 }
 
 ?>