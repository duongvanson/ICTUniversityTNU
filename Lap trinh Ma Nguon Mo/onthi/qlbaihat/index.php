<?php
	require_once 'controllers/c-baihat.php';
	$cbaihat = new CBaiHat();
	$ctrl = "";
	if (isset($_GET["ctrl"])) {
		$ctrl = $_GET["ctrl"];
	}
	switch($ctrl){
		case 'add':
			$cbaihat->addBaiHat();
			break;
		case 'insert':
			$cbaihat->insertBaiHat($_POST);
			break;
		case 'search':
			$cbaihat->searchBaiHat($_GET["keyword"]);
			break;
		case 'edit':
			$cbaihat->editBaiHat($_GET["id"]);
			break;
		case 'update':
			$cbaihat->updateBaiHat($_POST);
			break;
		case 'delete':
			$cbaihat->deleteBaiHat($_GET["id"]);
			break;
		default:
			$cbaihat->display();
			break;
	}
 ?>