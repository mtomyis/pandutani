<?php

if ($_SERVER['REQUEST_METHOD']=='GET') {

    require_once 'connect.php';

    $response = $conn->prepare("SELECT nama_tanaman, gambar_tanaman, idtanaman_pangan FROM tanamanpangan;");

    $response -> execute();

    $response->bind_result($nama_tanaman, $gambar_tanaman, $idtanaman_pangan);

    $result = array();

    while ($response->fetch()) {

        $h['nama']        = $nama_tanaman;
        $h['gambar']       = $gambar_tanaman;
        $h['idtanaman']       = $idtanaman_pangan;

        array_push($result, $h);
    }
    echo json_encode($result);
}
else {
 
     $result["success"] = "0";
     $result["message"] = "Error!";
     echo json_encode($result);
 
     mysqli_close($conn);
 }

?>
    