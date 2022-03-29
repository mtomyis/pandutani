<?php

require_once 'connect.php';

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $nama = $_POST['nama'];
    $password = $_POST['password'];

    $sql = "SELECT * FROM petani WHERE nama_petani='$nama' AND password_petani='$password' ";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['login'] = array();
    
    if ( mysqli_num_rows($response) > 0 ) {
        
        $row = mysqli_fetch_assoc($response);

        // if ( password_verify($password, $row['password_petani']) ) {
            
            $index['nama_petani'] = $row['nama_petani'];
            $index['nama_belakang'] = $row['nama_belakang'];
            $index['idpetani'] = $row['idpetani'];

            array_push($result['login'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);

        } else {

            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);

            mysqli_close($conn);

        }

    // }

}

?>