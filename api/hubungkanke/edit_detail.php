<?php
require_once 'connect.php';

if($_SERVER['REQUEST_METHOD'] == 'POST'){

    $name = $_POST['nama'];
    $belakang = $_POST['belakang'];
    $alamat = $_POST['alamat'];
    $password = $_POST['password'];

    $id = $_POST['id'];

    //require_once 'connect.php';

    $sql = "UPDATE petani SET nama_petani='$name', nama_belakang='$belakang' , alamat='$alamat' , password_petani='$password' WHERE idpetani='$id' ";

    if(mysqli_query($conn, $sql)) {

          $result["success"] = "1";
          $result["message"] = "success";

          echo json_encode($result);
          mysqli_close($conn);
      }
  }

else{

   $result["success"] = "0";
   $result["message"] = "error!";
   echo json_encode($result);

   mysqli_close($conn);
}

?>


