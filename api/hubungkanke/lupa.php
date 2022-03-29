<?php

require_once 'connect.php';

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $nama = $_POST['namadepan'];
    $enkripsi = $_POST['enkripsi'];
    $password = $_POST['passwordpetani'];

    $sql = "UPDATE petani SET password_petani='$password' WHERE nama_petani='$nama' AND enkripsi='$enkripsi' ";

    if(mysqli_query($conn, $sql)) {

          $result["success"] = "1";
          $result["message"] = "success";

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