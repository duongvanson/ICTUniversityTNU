<?php 
	session_start();
	include 'controllers/cmt_control.php';
	$cmtControl = new CMTControl();
	$task = "default";
	if (isset($_GET['task'])) {
		$task = $_GET['task'];
	}
	switch ($task) {
		case 'default':
			$cmtControl->getAllComment();
			$comments = $_SESSION['comments'];
			include 'views/main.php';
			break;
		case 'add':
			include 'views/add_comment.php';
			break;
		case 'insert':
			$cmtControl->insertCMT($_POST);
			break;
		default:
			include 'views/main.php';
			break;
	}
 ?>