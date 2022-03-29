<?php

if ($_SERVER['REQUEST_METHOD'] =='POST'){

    $namapetani = $_POST['namadepan'];
    $nama_belakang = $_POST['namabelakang'];
    $password = $_POST['passwordpetani'];
    $alamat = $_POST['alamat'];
    $acak = $_POST['acak'];

    // $password = password_hash($password, PASSWORD_DEFAULT);

    require_once 'connect.php';
    
    $cek ="SELECT * FROM petani WHERE nama_petani='$namapetani' ";
    $ceksama = mysqli_query($conn, $cek);
    if ( mysqli_num_rows($ceksama) >= 1 ) {
		//nama sudah ada
    	$result["success"] = "0";
        $result["message"] = "error";

        echo json_encode($result);
        mysqli_close($conn);
    }
    else{
    
    $sql = "INSERT INTO petani (nama_petani, nama_belakang, password_petani, alamat, enkripsi) VALUES ('$namapetani', '$nama_belakang', '$password', '$alamat', '$acak')";

    if ( mysqli_query($conn, $sql) ) {
        $result["success"] = "1";
        $result["message"] = "success";

        echo json_encode($result);
        mysqli_close($conn);

    } else {

        $result["success"] = "0";
        $result["message"] = "error";

        echo json_encode($result);
        mysqli_close($conn);
    }
    }
}

?>
