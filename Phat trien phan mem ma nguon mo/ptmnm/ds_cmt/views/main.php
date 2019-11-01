<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Comments Main</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>DANH SÁCH COMMENT</h1>
	<?php if ($comments) {
		foreach ($comments as $cmt) {?>
	<div class="cmt">
		<h3><?php echo $cmt->getTitle() ?></h3>
		<p><?php echo $cmt->getFullName() ?></p>
		<p><?php echo $cmt->getEmail() ?></p>
		<p><?php echo $cmt->getContent() ?></p>
	</div>
	
	<?php }} ?>
	<a href="index.php?task=add">Thêm comment mới</a>
</body>
</html>