<?php
	class CBaiHat{
		var $mbaihat = null;
		function __construct(){
			require_once 'models/m-baihat.php';
			$this->mbaihat = new MBaiHat();
		}
		function display(){
			$limit = 2;
			// $rs = $this->mbaihat->getBaiHat();
			if (isset($_GET["page"])) {
				$page = $_GET["page"];
			}else{
				$page = 1;
			}
			$total = $this->mbaihat->getTotal($limit);
			$rs = $this->mbaihat->getPage($page, $limit);
			include 'views/v-hienthi.php';
		}
		function addBaiHat(){
			include 'views/v-addbaihat.php';
		}
		function insertBaiHat($data){
			$rs = $this->mbaihat->insertBaiHat($data["mabaihat"], $data["tenbaihat"],$data["namsangtac"],$data["tacgia"],$data["theloai"]);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Lỗi thêm";
			}
		}
		function searchBaiHat($key){
			$rs = $this->mbaihat->searchBaiHat($key);
			include 'views/v-hienthi.php';
		}
		function editBaiHat($id){
			$rs = $this->mbaihat->getBaiHatID($id);
			include 'views/v-editbaihat.php';
		}
		function updateBaiHat($data){
			$rs = $this->mbaihat->updateBaiHat($data["mabaihat"], $data["tenbaihat"],$data["namsangtac"],$data["tacgia"],$data["theloai"]);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Lỗi UPDATE";
			}
		}
		function deleteBaiHat($id){
			$rs = $this->mbaihat->deleteBaiHat($id);
			if ($rs) {
				header("location: index.php");
			}else{
				echo "Lỗi UPDATE";
			}
		}
	}
?>