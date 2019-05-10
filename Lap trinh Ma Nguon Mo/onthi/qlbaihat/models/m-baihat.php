<?php
	class MBaiHat{
		var $connect = null;
		function __construct(){
			$this->connect = new mysqli("localhost","root","","qlbaihat");
			$this->connect->query("SET NAMES 'utf8'");
		}
		function getBaiHat(){
			$query = "select bh.*, tl.tentheloai as tentheloai
					from baihat bh, theloai tl
					where bh.theloai = tl.matheloai";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function getBaiHatID($id){
			$query = "select *
					from baihat
					where mabaihat = '$id'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function getPage($page, $limit){
			$start = ($page-1)*$limit;
			$query = "select bh.*, tl.tentheloai as tentheloai
					from baihat bh, theloai tl
					where bh.theloai = tl.matheloai limit $start,$limit";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function getTotal($limit){
			$query = "select * from baihat";
			$rs = $this->connect->query($query);
			$total = ceil($rs->num_rows/$limit);
			return $total;
		}
		function insertBaiHat($ma, $ten, $nam, $tacgia, $loai){
			$query = "INSERT INTO baihat(mabaihat, tenbaihat, namsangtac, tacgia, theloai) VALUES ('$ma','$ten','$nam','$tacgia','$loai')";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function updateBaiHat($ma, $ten, $nam, $tacgia, $loai){
			$query = "update baihat set tenbaihat='$ten', namsangtac='$nam',tacgia='$tacgia',theloai='$loai' where mabaihat='$ma'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function deleteBaiHat($id){
			$query = "delete from baihat where mabaihat='$id'";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function searchBaiHat($key){
			$query = "select bh.*, tl.tentheloai as tentheloai
					from baihat bh, theloai tl
					where bh.theloai = tl.matheloai and (
					bh.mabaihat like '%$key%' or 
					bh.tenbaihat like '%$key%' or 
					bh.namsangtac like '%$key%' or 
					bh.tacgia like '%$key%' or 
					bh.theloai like '%$key%'
				)";
			$rs = $this->connect->query($query);
			return $rs;
		}
	}
?>