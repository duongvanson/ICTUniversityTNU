<?php 
	/**
	 * 
	 */
	class CSinhVien
	{
		var $msinhvien = null;
		function __construct()
		{
			require_once 'models/m-sinhvien.php';
			$this->msinhvien = new MSinhVien();
		}
		function display($sort)
		{
			$rs = $this->msinhvien->getSinhVien($sort);
			include 'views/v-sinhvien.php';
		}
		function search($key)
		{
			$rs = $this->msinhvien->search($key);
			include 'views/v-sinhvien.php';
		}
		function editSinhVien($id){
			$rs = $this->msinhvien->getID($id);
			include 'views/v-edit-sinhvien.php';
		}
		function updateSinhVien($data)
		{
			$rs = $this->msinhvien->updateSinhVien($data["masv"], $data["tensv"], $data["namsinh"], $data["malop"]);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Loi";
				var_dump($rs);
			}
		}
		function deleteSinhVien($id)
		{
			$rs = $this->msinhvien->deleteSinhVien($id);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Loi xoa";
			}
		}
		function addSinhVien()
		{
			include 'views/v-add-sinhvien.php';
		}
		function insertSinhVien($data)
		{
			# code...
			$rs = $this->msinhvien->insertSinhVien($data["masv"], $data["tensv"], $data["namsinh"], $data["malop"]);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Loi them";
			}
		}
	}
 ?>