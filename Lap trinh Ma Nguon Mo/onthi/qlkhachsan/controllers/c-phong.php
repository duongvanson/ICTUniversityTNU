<?php
	class CPhong{
		var $mphong = null;
		function __construct(){
			require_once 'models/m-phong.php';
			$this->mphong = new MPhong();
		}
		function display(){
			$rs = $this->mphong->getAll();
			include 'views/v-hienthi.php';
		}
		function addPhong(){
			include 'views/v-addphong.php';
		}
		function insertPhong($data){
			$rs = $this->mphong->insertPhong($data["maphong"], $data["tenphong"],$data["loaiphong"],$data["dongia"]);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Thêm lỗi";
			}
		}
		function editPhong($id){
			$phong = $this->mphong->getID($id);
			include 'views/v-editphong.php';
		}
		function updatePhong($data){
			$rs = $this->mphong->updatePhong($data["maphong"], $data["tenphong"],$data["loaiphong"],$data["dongia"]);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Sửa lỗi";
			}
		}
		function deletePhong($id){
			$rs = $this->mphong->deletePhong($id);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Xóa lỗi";
			}
		}
	}
?>