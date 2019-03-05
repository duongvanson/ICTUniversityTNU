<?php
class Database{
	var $conn;
	public function __construct()
	{
		$host = "localhost";
		$user = "root";
		$pass = "";
		$database = "banhang";
		$this->conn = mysqli_connect($host,$user,$pass,$database);
		mysqli_set_charset($this->conn, "utf8");
		if(mysqli_connect_error($this->conn)){
			echo "Loi ket noi database.";
		}else{
			//echo "Ket noi thanh cong!";
		}
	}
	//========== Lay du lieu mat hang
	public function getMatHang()
	{
		$sql = "select * from mathang";
		return mysqli_query($this->conn, $sql);
	}
	public function updateMatHang($id,$maloaihang, $tenmathang, $giaban)
	{
		$sql = "update mathang set 
		maloaihang = '".$maloaihang
		."',tenmathang ='".$tenmathang
		."', giaban = ".$giaban
		." where id = ".$id;
		return mysqli_query($this->conn, $sql);
	}
	public function getMatHangID($id)
	{
		$sql = "select * from mathang where id =".$id;
		return mysqli_query($this->conn, $sql);
	}
	public function xoaMatHang($id)
	{
		$sql = "delete from mathang where id=".$id;
		return mysqli_query($this->conn, $sql);
	}

}
?>