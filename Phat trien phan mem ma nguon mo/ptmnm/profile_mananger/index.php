<?php
	session_start();
	require_once 'controllers/user_control.php';
	$user_control = new UserControl();
	$ctrl = "";
	switch($ctrl){
		default:
			$user_control->display();
			break;
	}
 ?>