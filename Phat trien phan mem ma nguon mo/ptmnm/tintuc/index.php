<?php
	session_start();
	require_once 'controllers/c-user.php';
	require_once 'controllers/c-category.php';
	$cuser = new CUser();
	$ccategory = new CCategory();
	//$ctrl = "";
	if (isset($_GET["ctrl"])) {
		$ctrl = $_GET["ctrl"];		
	}else{
		$ctrl = "mananger";
	}

	if ($ctrl!="login" && $ctrl != "post_login") {
		if (empty($_SESSION['auth'])) {
			header("location: index.php?ctrl=login");
		}
	}else{
		if(!empty($_SESSION['auth'])){
			header("Location:index.php");
		}
	}
	switch($ctrl){
		case 'login':
			$cuser->login();
			break;
		case 'post_login':
			$cuser->post_login($_POST);
			break;
		case 'mananger':
			$ccategory->mananger();
			break;
		case 'addCate':
			$ccategory->add();
			break;
		case 'insertCate':
			$ccategory->insert($_POST);
			break;
		case 'editCate':
			$ccategory->edit($_GET['id']);
			break;
		case 'updateCate':
			$ccategory->update($_POST);
			break;
		case 'deleteCate':
			$ccategory->delete($_GET['id']);
			break;
		case 'logout':
			$cuser->logout();
			break;
		default:
			$cuser->login();
			break;
	}
 ?>