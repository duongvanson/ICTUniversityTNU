<?php 
	include '../simple_html_dom.php';
	$url = "https://sachvui.com/doc-sach/doi-ngan-dung-ngu-dai-robin-sharma/hay-la-chinh-minh.html";
	$html = file_get_html($url);
	$ul = $html->find('ul.scrollable-menu',0);
	$lis = $ul->find('li');
	$result = [];
	foreach ($lis as $li) {
		$a = $li->find('a',0);
		//echo $a->href;
		array_push($result, [
			"name" => $a->plaintext,
			"url" => $a->href
		]);
	}
	echo json_encode($result);
 ?>