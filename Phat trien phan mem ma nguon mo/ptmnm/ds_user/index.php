<?php
	session_start();
	include 'controllers/user_controller.php';
	$userControl = new UserControl();
	$task = "default";
	if (isset($_GET['task'])) {
		$task = $_GET['task'];
	}
	switch ($task) {
		case 'default':
			$userControl->getAllUser();
			$lstUser = $_SESSION['lstUser'];
			include 'views/display.php';
			break;
		case 'add':
			include 'views/add_user.php';
			break;
		case 'insert':
			$userControl->insertUser($_POST);
			break;
		case 'edit':
			$user = $userControl->getByID($_GET['id']);
			include 'views/edit_user.php';
			break;
		default:
			include 'views/display.php';
			break;
	}
 ?>