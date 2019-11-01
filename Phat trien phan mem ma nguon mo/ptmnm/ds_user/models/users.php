<?php 
	/**
	 * Author: Son Duong 2112
	 */
	class User
	{
		private $id, $username, $password, $fullname;
		function __construct($id, $username, $password, $fullname)
		{
			$this->id = $id;
			$this->username = $username;
			$this->password = $password;
			$this->fullname = $fullname;
		}
		public function getID()
		{
			return $this->id;
		}
		public function getUsername()
		{
			return $this->username;
		}
		public function getFullName()
		{
			return $this->fullname;
		}
		public function getPassword()
		{
			return $this->password;
		}
	}
 ?>