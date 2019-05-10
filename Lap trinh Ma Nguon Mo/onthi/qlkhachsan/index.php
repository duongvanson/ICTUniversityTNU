<?php
	require_once 'controllers/c-phong.php';
	$cphong = new CPhong();
	$ctrl = "";
	if (isset($_GET["ctrl"])) {
		$ctrl = $_GET["ctrl"];
	}
	switch($ctrl){
		case "add":
			$cphong->addPhong();
			break;
		case 'insert':
			$cphong->insertPhong($_POST);
			break;
		case 'edit':
			$cphong->editPhong($_GET["id"]);
			break;
		case 'update':
			$cphong->updatePhong($_POST);
			break;
		case 'delete':	
			$cphong->deletePhong($_GET["id"]);
			break;
		default:
			$cphong->display();
			break;
	}
?>