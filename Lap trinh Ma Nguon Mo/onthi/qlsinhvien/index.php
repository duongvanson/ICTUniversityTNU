<?php
	require_once 'controllers/c-sinhvien.php';
	$csinhvien = new CSinhVien();
	$ctrl = "";
	$sort = "default";
	if (isset($_GET["sort"])) {
		$sort = $_GET["sort"];
	}
	if (isset($_GET["ctrl"])) {
		$ctrl = $_GET["ctrl"];
	}
	switch ($ctrl){
		case 'search':
			$csinhvien->search($_GET["keywork"]);
			break;
		case 'edit':
			$csinhvien->editSinhVien($_GET["id"]);
			break;
		case 'update':
			$csinhvien->updateSinhVien($_POST);
			break;
		case 'delete':
			$csinhvien->deleteSinhVien($_GET["id"]);
			break;
		case 'add':
			$csinhvien->addSinhVien();
			break;
		case 'insert':
			$csinhvien->insertSinhVien($_POST);
			break;
		default:
			$csinhvien->display($sort);
			break;
	}
 ?>