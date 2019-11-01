<?php 
	/**
	 * 
	 */
	class UserControl
	{
		private $modelUser = null;
		function __construct()
		{
			include 'models/user.php';
			include 'models/UserModel.php';
			$this->modelUser = new UserModel();
		}
		public function getAll()
		{
			$rs = $this->modelUser->getAll();
			if ($rs) {
				$_SESSION['lstUser'] = $rs;
			}
		}
		public function insert($p)
		{
			$user = new User($p['manhanvien'],$p['tennhanvien'],$p['ngaysinh'],$p['quequan'],$p['chucvu']);
			$rs = $this->modelUser->insertUser($user);
			if ($rs) {
				header('location: index.php');
			}else{
				echo "Thêm thất bại.";
			}
		}
	}
 ?>