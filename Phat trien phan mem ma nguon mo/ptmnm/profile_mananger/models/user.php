<?php 
	class User
	{
		private $id, $username, $password, $full_name, $datecreated;
		function __construct($id, $username, $password, $full_name, $datecreated)
		{
			$this->id = $id;
			$this->username = $username;
			$this->password = $password;
			$this->full_name = $full_name;
			$this->datecreated = $datecreated;
		}
		public function getID(){
			return $this->id;
		}
		public function getUsername(){
			return $this->username;
		}
		public function getFullName(){
			return $this->full_name;
		}
		public function getDateCreated(){
			return $this->datecreated;
		}
	}
 ?>