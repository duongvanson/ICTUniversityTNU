<?php 
	/**
	 * 
	 */
	class CBaiHat
	{
		var $mbaihat;
		function __construct()
		{
			require_once 'models/m-baihat.php';
			$this->mbaihat = new MBaiHat();
		}
		function listBaiHat()
		{
			$lst = $this->mbaihat->listBaiHat();
			require_once 'views/v-hienthi.php';
		}
		function editBaiHat($mabh)
		{
			$baihat = $this->mbaihat->getBaiHat($mabh);
			require_once 'views/v-sua-bai-hat.php';
		}
		function updateBaiHat($data)
		{
			$rs = $this->mbaihat->updateBaiHat($data["mabh"], $data["tenbh"], $data["tacgia"], $data["namst"]);
			if ($rs) {
				header("location:index.php");
			}else{
				echo "Lỗi";
			}
		}
		function deleteBaiHat($mabh)
		{
			$rs = $this->mbaihat->deleteBaiHat($mabh);
			if ($rs) {
				header("location:index.php");
			}else{
				echo "Lỗi xóa";
			}
		}
		function insertBaiHat($data)
		{
			$rs = $this->mbaihat->insertBaiHat($data["mabh"], $data["tenbh"], $data["tacgia"], $data["namst"]);
			if ($rs) {
				header("location:index.php");
			}else{
				echo "Lỗi thêm";
			}
		}
		function addBaiHat()
		{
			require_once 'views/v-them-bai-hat.php';
		}
	}
?>