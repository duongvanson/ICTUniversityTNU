<?php 
	include 'simple_html_dom.php';
	$url = $_GET['any_link'];
	$html = file_get_html($url);
	$ul = $html->find('ul.scrollable-menu',0);
	if($ul == null){
		echo "error";
		exit(0);
	}
	$lis = $ul->find('li');
	$result = [];
	foreach ($lis as $li) {
		$a = $li->find('a',0);
		array_push($result, [
			"name" => $a->plaintext,
			"url" => $a->href
		]);
	}
	echo json_encode($result);
	
 ?>