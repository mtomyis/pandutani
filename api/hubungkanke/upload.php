<?php

if($_SERVER['REQUEST_METHOD'] == 'POST') {

    $id = $_POST['id'];
    $photo = $_REQUEST['photo'];
   
    $path = "profile_image/$id.jpeg";
    $finalPath = "http://192.168.43.158/hubungkanke/".$path;

    require_once 'connect.php';

    $sql = "UPDATE petani SET photo ='$finalPath' WHERE idpetani='$id' ";

    if (mysqli_query($conn, $sql)) {
        
        if ( file_put_contents($path, base64_decode($photo) ) ) {
            
            $result['success'] = "1";
            $result['message'] = "success";

            echo json_encode($result);
            mysqli_close($conn);
        }

    }

}

?>

<!-- sudo chown root:root /opt/lampp/htdocs/hubungkanke
sudo chmod 0755 /opt/lampp/htdocs/hubungkanke -->