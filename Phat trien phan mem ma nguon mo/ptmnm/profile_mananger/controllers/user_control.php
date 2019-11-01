<?php 
	/**
	 * 
	 */
	class UserControl
	{
		var $user_model = null;
		function __construct()
		{
			require_once 'models/user_model.php';
			$this->user_model = new UserModel();
		}
		function display()
		{
			$result = $this->user_model->getListUser();
			include 'views/user_view.php';
		}
	}
 ?>