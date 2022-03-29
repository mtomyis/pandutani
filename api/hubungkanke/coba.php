    <?php 
    require_once 'connect.php';

    $response = $conn->prepare("SELECT jarak_hst FROM pengingat;");

    $response -> execute();

    $response->bind_result($jarak_hst);

    $result = array();

    while ($response->fetch()) {

        $h['jarak'] = $jarak_hst;

        array_push($result, $h);
    }
    $tgl1 = json_encode($result[0]);
    echo $tgl1;
    ?>