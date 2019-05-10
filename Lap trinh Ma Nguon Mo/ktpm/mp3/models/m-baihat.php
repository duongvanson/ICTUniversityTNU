<?php
	/**
	 * 
	 */
	class MBaiHat
	{
		var $connect;
		function __construct()
		{
			$this->connect = mysqli_connect("localhost","root","","mp3");
			mysqli_query($this->connect, "SET NAMES 'utf8'");
		}
		function listbaihat()
		{
			$query = "select * from baihat";
			$rs = mysqli_query($this->connect, $query);
			return $rs;
		}
		function getBaiHat($mabh)
		{
			$query = "select * from baihat where mabh = '$mabh'";
			$rs = mysqli_query($this->connect, $query);
			return $rs;
		}
		function updateBaiHat($mabh, $tenbh, $tacgia, $namst)
		{
			$query = "update baihat set tenbh = '$tenbh', tacgia='$tacgia', namst='$namst' where mabh='$mabh'";
			$rs = mysqli_query($this->connect, $query);
			return $rs;
		}
		function deleteBaiHat($mabh)
		{
			$query = "delete from baihat where mabh='$mabh'";
			$rs = mysqli_query($this->connect, $query);
			return $rs;
		}
		function insertBaiHat($mabh, $tenbh, $tacgia, $namst)
		{
			$query = "insert into baihat(mabh, tenbh, tacgia, namst) values('$mabh','$tenbh','$tacgia','$namst')";
			$rs = mysqli_query($this->connect, $query);
			return $rs;
		}
	}
?>