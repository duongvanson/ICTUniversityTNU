<?php 
	$ctrl = "";
	require_once 'controllers/c-nhanvien.php';
	$cnv = new CNhanVien();
	if (isset($_GET["ctrl"])) {
		$ctrl = $_GET["ctrl"];
	}
	switch($ctrl){
		case 'add':		
			$cnv->addNV();
			break;
		case 'insert':
			$cnv->insertNV($_POST);
			break;
		case 'edit':
			$cnv->editNV($_GET["id"]);
			break;
		case 'update':
			$cnv->updateNV($_POST);
			break;
		case 'delete':
			$cnv->deleteNV($_GET["id"]);
			break;
		case 'search':
			$cnv->searchNV($_GET['keyword']);
			break;
		case 'sort':
			$cnv->sortNV($_GET["sort"], $_GET["by"]);
			break;
		default:
			$cnv->display();
			break;
	}
 ?>