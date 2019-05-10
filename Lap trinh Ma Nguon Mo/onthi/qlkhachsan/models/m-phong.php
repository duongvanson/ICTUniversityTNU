<?php
	class MPhong{
		var $connect = null;
		function __construct(){
			$this->connect = new mysqli("localhost","root","","qlkhachsan");
			$this->connect->query("SET NAMES 'utf8'");
		}
		function getAll(){
			$query = "SELECT * FROM phong";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function getID($ID){
			$query = "SELECT * FROM phong where maphong ='$ID'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function insertPhong($ma, $ten, $loai, $gia){
			$query = "INSERT INTO phong(maphong, tenphong, loaiphong, dongia)
			 VALUES ('$ma', '$ten', '$loai', '$gia')";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function updatePhong($ma, $ten, $loai, $gia){
			$query = "UPDATE phong SET tenphong='$ten', loaiphong='$loai', dongia='$gia' where maphong='$ma'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function deletePhong($ma){
			$query = "DELETE FROM phong WHERE maphong='$ma'";
			$rs = $this->connect->query($query);
			return $rs;
		}
	}
?>