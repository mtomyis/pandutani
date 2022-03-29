<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {
    
    $id = $_POST['id'];

    require_once '../connect.php';

    $response = $conn -> prepare("SELECT ciri_tanaman FROM pengingat WHERE idpengingat='$id';");
    
    $response -> execute();

    $response -> bind_result($ciri_tanaman);

    $result = array();;
        
    while ($response->fetch()) {
        $h['ciri']       = $ciri_tanaman;

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