<?php
	require_once 'controller/c-baihat.php';
	$cbaihat = new CBaiHat();
	$ctrl = "";

	if (isset($_GET["ctrl"])) {
		$ctrl = $_GET["ctrl"];
	}
	switch ($ctrl) {
		case 'edit':
			$mabh = $_GET["mabh"];
			$cbaihat->editBaiHat($mabh);
			break;
		case 'update':
			$cbaihat->updateBaiHat($_POST);
			break;
		case 'delete':
			$mabh = $_GET["mabh"];
			$cbaihat->deleteBaiHat($mabh);
			break;
		case 'add':
			$cbaihat->addBaiHat();
			break;
		case 'insert':
			$cbaihat->insertBaiHat($_POST);
			break;
		default:
			$cbaihat->listBaiHat();
			break;
	}
?>