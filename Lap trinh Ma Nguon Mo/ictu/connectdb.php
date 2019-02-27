<?php 
	$server = "root";
	$pass = "";
	$host = "localhost";
	$database = "ictu";
    $conn = mysqli_connect($host, $server, $pass, $database);
    mysqli_set_charset($conn, "utf8");
	mysqli_query($conn, "SET NAMES 'UTF-8'");
 ?>