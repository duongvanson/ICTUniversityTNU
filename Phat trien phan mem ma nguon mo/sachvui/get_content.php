<?php
	include 'simple_html_dom.php';
	$url = $_GET['chap'];
	$html = file_get_html($url);
	$contents = [];
	foreach ($html->find('p') as $p) {
		$temp = $p->plaintext;
		//trim($temp);
		if($temp != " ") array_push($contents, $temp);
	}
	echo json_encode($contents);
 ?>