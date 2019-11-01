<?php
	ini_set("default_charset", 'utf-8');
	include '../simple_html_dom.php';
	$url = $_GET['url'];
	$html = file_get_html($url);
	$contents = [];
	// $c = $html->find('p');
	// echo count($c);
	foreach ($html->find('p') as $p) {
		array_push($contents, $p->plaintext);
	}
	echo json_encode($contents);
 ?>