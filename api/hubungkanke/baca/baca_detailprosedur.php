<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $id = $_POST['id'];

    require_once '../connect.php';

    $response = $conn -> prepare("SELECT nama_prosedur, gambar_prosedur, uraian_prosedur FROM prosedur WHERE idprosedur='$id';");
    
    $response -> execute();

    $response -> bind_result($nama_prosedur, $gambar_prosedur, $uraian_prosedur);

    $result = array();;
        
    while ($response->fetch()) {
        $h['nama']        = $nama_prosedur;
        $h['gambar']       = $gambar_prosedur;
        $h['uraian']       = $uraian_prosedur;

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