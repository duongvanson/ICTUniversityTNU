<?php 
	/**
	 * 
	 */
	class CCategory
	{
		var $mcategory = null;
		function __construct(){
			require_once 'models/m-category.php';
			$this->mcategory = new MCategory();
		}
		function mananger()
		{
			$res = $this->mcategory->getCategory();
			include 'views/v-category-mananger.php';
		}
		function add()
		{
			include 'views/v-add-cate.php';
		}
		function insert($data)
		{
			$res = $this->mcategory->insert($data);
			if ($res) {
				header('location: index.php?ctrl=mananger');
			}else{
				echo "Thêm thất bại";
			}
		}
		function edit($id)
		{
			$rs = $this->mcategory->getCateID($id);
			include 'views/v-edit-cate.php';
		}
		function update($data)
		{
			$res = $this->mcategory->update($data);
			if ($res) {
				header('location: index.php?ctrl=mananger');
			}else{
				echo "Sửa thất bại";
			}
		}
		function delete($id)
		{
			$rs = $this->mcategory->deleteID($id);
			if ($rs) {
				header('location: index.php?ctrl=mananger');
			}else{
				echo "Xóa thất bại.";
			}
		}
	}
 ?>