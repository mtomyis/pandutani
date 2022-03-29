<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $id = $_POST['id'];

    require_once '../connect.php';

    $response = $conn -> prepare("SELECT nama_tanaman, gambar_tanaman, uraian_tanaman FROM tanamanpangan WHERE idtanaman_pangan='$id';");
    
    $response -> execute();

    $response -> bind_result($nama_tanaman, $gambar_tanaman, $uraian_tanaman);

    $result = array();;
        
    while ($response->fetch()) {
        $h['nama']        = $nama_tanaman;
        $h['gambar']       = $gambar_tanaman;
        $h['uraian']       = $uraian_tanaman;

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