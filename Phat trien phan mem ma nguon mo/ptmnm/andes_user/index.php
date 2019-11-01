<?php
	session_start();
	$task = "default";
	if (isset($_GET['task'])) {
		$task = $_GET['task'];
	}
	include 'controllers/ctrl_user.php';
	$userCtrl = new UserControl();
	switch ($task) {
		case 'add':
			include 'views/add.php';
			break;
		case 'insert':
			$userCtrl->insert($_POST);
			break;
		default:
			$userCtrl->getAll();
			$lstUser = $_SESSION['lstUser'];
			include 'views/main.php';
			break;
	}
 ?>