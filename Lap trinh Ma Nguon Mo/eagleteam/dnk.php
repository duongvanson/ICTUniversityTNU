<?php 
	class HoatDong{
		var $id, $title, $is_final, $score, $desc;
		public function HoatDong($id, $title, $is_final, $score, $desc)
	    {
	        $this->id = $id;
	        $this->title = $title;
	        $this->is_final = $is_final;
	        $this->score = $score;
	        $this->desc = $desc;
	    }
	}
	class DiemNgoaiKhoa
	{
		var $hoten, $lop, $dukien, $diem, $choduyet, $hoatdong;
	    public function __construct()
	    {
	        
	    }
	}
?>
<?php
	include 'simple_html_dom.php';
	$url = "https://sinhvien.ictu.edu.vn/hoat-dong/diem-ca-nhan/";
	if (isset($_GET["msv"]) && !empty($_GET["msv"])) {
		$msv = strtoupper($_GET["msv"]);
		$url .= $msv.".html";
		$html = file_get_html($url);
		if (strpos($html, "Không tìm thấy thông tin sinh viên!")) {
			echo 'Không có dữ liệu về sinh viên này. :p :p';
			exit();
		}
		$div = $html->find('.text-uppercase', 0);
		$hoten = $div->find('h1',0)->innertext;
		$lop = $div->find('h2', 0)->innertext;
		$dukien = $div->find('span', 0)->innertext;
		$diem = $div->find('span', 1)->innertext;
		$choduyet = $div->find('span', 2)->innertext;
		$list = substr($html, strpos($html, 'list:')+5);
		$list = substr($list,0, strpos($list, '],')+2);
		$list = substr($list, 2, strrpos($list, "}")-2);
		$dnk = new DiemNgoaiKhoa();
		$dnk->hoten = $hoten;
		$dnk->lop = $lop;
		$dnk->dukien = $dukien;
		$dnk->diem = $diem;
		$dnk->choduyet = $choduyet;
		$dnk->hoatdong = array();
		if (!empty($list)) {
			$arr = explode("},", $list);
			for ($i = 0; $i < sizeof($arr); $i++) {
				//
				$json = "{".$arr[$i];
				$id = strpos($json, "id")?substr($json, strpos($json, "id")):"id:null";
				$id = $id != "id:null"?substr($id,0, strpos($id, ",")):$id;
				$title = strpos($json, "title")?substr($json, strpos($json, "title")):"title:null";
				$title = $title == "title:null"?$title:strpos($title, ",is")?substr($title, 0, strpos($title, ",is")):substr($title,0, strrpos($title, "\"")+1);
				$title = str_replace("&#34;", "", $title);
				//echo $title."<br>";
				$final = strpos($json, "is_final")?substr($json, strpos($json, "is_final")):"is_final:null";
				$final = $final != "is_final:null"?substr($final,0, strpos($final, ",")):$final;
				$score = strpos($json, "score")?substr($json, strpos($json, "score")):"score:null";
				$score = $score != "score:null"?substr($score,0, strpos($score, ",")):$score;
				$desc = strpos($json, "desc")?substr($json, strpos($json, "desc")):"desc:null";
				//$desc = $desc != "desc:null"?substr($desc,0, strpos($desc, ",)):$desc;
				//echo substr($id, strpos($id, ":")+1)."<br>";
				//echo str_replace("\"", "", substr($title, strpos($title, ":")+1))."<br>";
				// echo $final."<br>";
				// echo $score."<br>";
				// echo $desc."<br>";
				// echo '<br><hr>';
			 	array_push($dnk->hoatdong, new HoatDong(
		 		substr($id, strpos($id, ":")+1),
		 		str_replace("\"", "", substr($title, strpos($title, ":")+1)),
		 		isFinal(substr($final, strpos($final, ":")+1)),
		 		isScore(substr($score, strpos($score, ":")+1)),
		 		isNote(str_replace("\"", "", substr($desc, strpos($desc, ":")+1)))));
		 	}
		} else {
			$dnk->hoatdong = "Không có dữ liệu điểm hoạt động";
		}
		echo json_encode($dnk);
	}else {
		echo 'Không có dữ liệu. :p :p';
	}
?>
<?php
	function isFinal($final)
	{
		switch ($final) {
			case 'e':
			case 'h':
				return "wait";
				break;
			case 'a':
			case 'b':
			case 'c':
			case 'd':
				return "ok";
				break;
			default:
				return $final;
				break;
		}
	}
	function isScore($score)
	{
		switch ($score) {
			case 'b':
			case 'c':
				return 5;
				break;
			case 'j':
				return 6;
				break;
			case 'd':
			case 'e':
			case 'f':
				return 7;
				break;
			case 'h':case 'g':
				return 10;
				break;
			default:
				return $score;
				break;
		}
	}
	function isNote($score)
	{
		switch ($score) {
			case 'f':case'd':
				return "Cộng 5 điểm khi tham gia hoạt động.";
				break;
			case 'g':
				return "Cộng 7 điểm khi tham gia hoạt động.";
				break;
			case 'k':case 'h':
				return "Cộng 10 điểm khi tham gia hoạt động.";
				break;
			case 'null':
				return "Hoạt động đang chờ duyệt điểm";
				break;
			default:
				return $score;
				break;
		}
	}
?>