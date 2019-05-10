<?php 
	class MNhanVien{
		var $connect = null;
		function __construct(){
			$this->connect = new mysqli("localhost","root","","qlnhanvien");
			$this->connect->query("SET NAMES 'utf8'");
		}
		function getTotal($limit){
			$query="select * from nhanvien";
			$rs = $this->connect->query($query);
			$total = ceil($rs->num_rows/$limit);
			return $total;
		}
		function getPage($page, $limit){
			$s = ($page-1)*$limit;
			$query = "select nv.*,p.tenp as tenphong from nhanvien nv, phong p where p.map = nv.phong limit $s,$limit";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function getAll(){
			$query = "select nv.*,p.tenp as tenphong from nhanvien nv, phong p where p.map = nv.phong";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function getID($id){
			$query = "select * from nhanvien where manv = '$id' ";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function insertNV($ma, $ten, $namsinh, $gioitinh, $phong){
			$query = "insert into nhanvien(manv, tennv, namsinh, gioitinh, phong) values('$ma','$ten','$namsinh','$gioitinh','$phong')";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function updateNV($ma, $ten, $namsinh, $gioitinh, $phong){
			$query = "update nhanvien set tennv='$ten', namsinh='$namsinh', gioitinh='$gioitinh', phong='$phong' where manv='$ma'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function deleteNV($ma){
			$query = "delete from nhanvien where manv = '$ma'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function searchNV($key){
			$query = "select nv.*,p.tenp as tenphong from nhanvien nv, phong p where p.map = nv.phong and (
			nv.manv like '%$key%' or 
			nv.tennv like '%$key%' or 
			nv.namsinh like '%$key%' or 
			nv.gioitinh like '%$key%' or 
			p.tenp like '%$key%'
		)";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function sortNV($sort, $by){
			$query = "select nv.*,p.tenp as tenphong from nhanvien nv, phong p where p.map = nv.phong order by $sort $by";
			$rs = $this->connect->query($query);
			return $rs;
		}
	}
 ?>