<?php 
	/**
	 * 
	 */
	class CUser
	{
		var $muser = null;
		function __construct(){
			require_once 'models/m-user.php';
			$this->muser = new MUser();
		}
		function login()
		{
			include 'views/login.php';
		}

		function post_login($data)
		{
			$res = $this->muser->login($data);
			if ($res) {
				$_SESSION['auth'] = $data;
				header('location: index.php?ctrl=mananger');
			}
		}
		function logout()
		{
			unset($_SESSION['auth']);
			
			
			header('location:index.php');
		}
	}
 ?>