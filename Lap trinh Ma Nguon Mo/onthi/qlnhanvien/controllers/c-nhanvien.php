<?php 
	/**
	 * 
	 */
	class CNhanVien
	{
		var $mnv = null;
		function __construct()
		{
			require_once 'models/m-nhanvien.php';
			$this->mnv = new MNhanVien();
		}
		function display(){
			$limit = 2;
			if (isset($_GET["page"])) {
				$page = $_GET["page"];
			}else{
				$page = 1;
			}
			$total = $this->mnv->getTotal($limit);
			$rs = $this->mnv->getPage($page, $limit);
			include 'views/v-hienthi.php';
		}
		function addNV(){
			include 'views/v-addnhanvien.php';
		}
		function insertNV($data){
			$manv = $data["manv"];
			$rs = $this->mnv->insertNV($data["manv"],$data["tennv"],$data["namsinh"],$data["gioitinh"],$data["phong"]);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Lỗi thêm!";
			}
		}
		function editNV($id){
			$rs = $this->mnv->getID($id);
			include 'views/v-editnhanvien.php';
		}
		function updateNV($data){
			$rs = $this->mnv->updateNV($data["manv"],$data["tennv"],$data["namsinh"],$data["gioitinh"],$data["phong"]);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Lỗi sửa!";
			}
		}
		function deleteNV($id){
			$rs = $this->mnv->deleteNV($id);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Lỗi Xóa!";
			}
		}
		function searchNV($key){
			if (empty(trim($key))) {
				echo "Chưa nhập gì.";
				echo "<a href='index.php'>Quay lại</a>";
				exit();
			}
			$rs = $this->mnv->searchNV($key);
			include 'views/v-hienthi.php';
		}
		function sortNV($sort, $by){
			$rs = $this->mnv->sortNV($sort, $by);
			include 'views/v-hienthi.php';
		}
	}
 ?>