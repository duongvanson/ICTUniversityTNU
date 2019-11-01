<?php 
	/**
	 * 
	 */
	class UserModel
	{
		var $connect = null;
		function __construct()
		{
			include 'user.php';
			$this->connect = new mysqli("localhost", "root", "","ql_taikhoan");
			$this->connect->query("SET NAMES 'utf8'");
		}
		function getListUser()
		{
			$sql = "select * from taikhoan";
			$list = $this->connect->query($sql);
			$result = Array();
			while($i = $list->fetch_assoc()){
				array_push($result, new User(
					$i['id'],
					$i['username'],
					"",
					$i['fullname'],
					$i['datecreated']));
			}
			return $result;
		}
	}
 ?>