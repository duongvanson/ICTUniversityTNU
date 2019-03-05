<?php 
	require_once 'database.php';
	$db = new Database();
	if (isset($_GET["id"])) {
		$db->xoaMatHang($_GET["id"]);
	}
	header("Location: index.php");exit;
 ?>