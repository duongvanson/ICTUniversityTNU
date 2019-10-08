<?php
	class MUser{
		var $connect = null;
		function __construct(){
			$this->connect = new mysqli("localhost","root","","db_tintuc");
			$this->connect->query("SET NAMES 'utf8'");
		}
		function login($data){
			$username = $data['username'];
			$pass = $data['password'];
			$query = "select * from user 
			where user_name = '$username' and password =  '$pass'";
			$rs = $this->connect->query($query);
			return $rs;
		}
	}
?>