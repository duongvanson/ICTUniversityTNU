<?php 
	include ("connect.php");
	if (isset($_GET["masp"])) {
		$connect = new Connect();
		$masp = $_GET["masp"];
		$rs=$connect->deleteSP($masp);
		if($rs >= 1){
			header("Location: index.php");
		}else {
			echo 'Loi';
		}
	}
 ?>