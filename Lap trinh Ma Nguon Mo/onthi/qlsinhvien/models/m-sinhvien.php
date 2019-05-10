<?php 
	/**
	 * 
	 */
	class MSinhVien
	{
		var $connect = null;
		function __construct()
		{
			$this->connect = new mysqli("localhost","root","","qlsinhvien");
			$this->connect->query("SET NAMES 'utf8'");
		}
		function getSinhVien($sort)
		{
			$query = "SELECT sv.masv, sv.tensv, sv.namsinh,l.tenlop as lop
						FROM sinhvien sv,lop l
						WHERE sv.malop = l.malop";
			if ($sort != "default") {
				$query .= " order by $sort asc";
			}
			$rs = $this->connect->query($query);
			return $rs;
		}
		function getID($id){
			$query = "select * from sinhvien where masv ='$id'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function search($key){
			$query = "SELECT sv.masv, sv.tensv, sv.namsinh,l.tenlop as lop
						FROM sinhvien sv,lop l
						WHERE sv.malop = l.malop and (
						sv.masv like '%$key%' or 
						sv.tensv like '%$key%' or 
						sv.namsinh like '%$key%' or 
						sv.malop like '%$key%'
						)";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function updateSinhVien($ma, $ten, $namsinh, $malop){
			$query = "update sinhvien set tensv = '$ten', namsinh='$namsinh', malop='$malop' where masv='$ma'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function deleteSinhVien($id)
		{
			$query = "delete from sinhvien where masv = '$id'";
			$rs = $this->connect->query($query);
			return rs;
		}
		function insertSinhVien($ma, $ten, $namsinh, $malop)
		{
			# code...
			$query = "insert into sinhvien(masv,tensv,namsinh,malop) values('$ma', '$ten', '$namsinh', '$malop')";
			$rs = $this->connect->query($query);
			return $rs;
		}
	}
 ?>