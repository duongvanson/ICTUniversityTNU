<?php 
	class HoatDong{
		var $tieude, $theloai, $donvi, $diadiem, $thoigian,$diem, $trangthai;
		public function HoatDong($tieude, $theloai, $donvi, $diadiem, $thoigian,$diem,$trangthai)
	    {
	        $this->tieude = $tieude;
	        $this->theloai = $theloai;
	        $this->donvi = $donvi;
	        $this->diadiem = $diadiem;
	        $this->thoigian = $thoigian;
	        $this->diem = $diem;
	        $this->trangthai = $trangthai;
	    }
	}
?>
<?php
	header('Content-Type: application/json; charset=utf-8');
	include 'simple_html_dom.php';
	$host = "https://sinhvien.ictu.edu.vn";
	if (isset($_GET["trangthai"]) && !empty($_GET["trangthai"])){
		$trangthai = $_GET["trangthai"];
		$url = "https://sinhvien.ictu.edu.vn/hoat-dong/?trang-thai=".$trangthai;
		if ($trangthai != "dangdienra" && $trangthai != "sapdienra") {
			$url = "https://sinhvien.ictu.edu.vn/hoat-dong";
			//exit();
		}
	}else{
		echo 'NULL';
		$url = "https://sinhvien.ictu.edu.vn/hoat-dong";
		//exit();
	}
	$html = file_get_html($url);
	$list_title = $html->find('.activity-title');
	if (count($list_title) == 0) {
		echo "Không có hoạt động...";
		exit();
	}
	$list_content = $html->find('ul.activity-info');
	$list_score = $html->find(".bg-blue");
	$list_status = $html->find(".m-t-3");
	$hoatdong = array();
	$total = count($list_title);
	for ($i=0; $i < $total; $i++) { 
		$tieude = $list_title[$i]->find('h3',0)->innertext;
		$theloai = $list_content[$i]->find('li',0)->find('a',0)->innertext;
		$donvi = $list_content[$i]->find('li',1)->find('a',0)->innertext;
		$diadiem = $list_content[$i]->find('li',2)->find('a',0)->innertext;
		$thoigian = $list_content[$i]->find('li',3)->find('span',0)->innertext;
		$diem = $list_score[$i]->innertext;
		$trangthai = $list_status[$i]->innertext;
		array_push($hoatdong, new HoatDong($tieude, $theloai, $donvi, $diadiem, $thoigian, $diem, $trangthai));
	}
	echo json_encode($hoatdong);
?>