<?php
	class MCategory{
		var $connect = null;
		function __construct(){
			$this->connect = new mysqli("localhost","root","","db_tintuc");
			$this->connect->query("SET NAMES 'utf8'");
		}
		function getCategory(){
			$query = "select *
					from category";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function getCateID($id){
			$query = "select *
					from category where cate_id = $id";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function insert($data)
		{
			$cate = $data['cate_name'];
			$query = "insert into category(cate_id, cate_name) values (1,'$cate')";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function update($data)
		{
			$cate_id = $data['cate_id'];
			$cate_name = $data['cate_name'];
			$query = "update category set cate_name='$cate_name' where cate_id=$cate_id";
			$rs = $this->connect->query($query);
			return $rs;
		}
		function deleteID($id)
		{
			$query="delete from category where cate_id = $id";
			$rs = $this->connect->query($query);
			return $rs;
		}
	}
?>