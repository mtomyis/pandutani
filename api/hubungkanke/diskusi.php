<?php

if($_SERVER['REQUEST_METHOD'] == 'POST') {

    $id = $_POST['saveCurrentDate'];
    $photo = $_REQUEST['photo'];
   
    $path = "diskusi/$id.jpeg";
    $finalPath = "http://192.168.43.73/hubungkanke/".$path;

    require_once 'connect.php';
        
    if ( file_put_contents($path, base64_decode($photo) ) ) {
        
        $result['success'] = "1";
        $result['message'] = "success";

        echo json_encode($result);
        mysqli_close($conn);
    }

}

?>

<!-- sudo chown root:root /opt/lampp/htdocs/hubungkanke
sudo chmod 0755 /opt/lampp/htdocs/hubungkanke -->