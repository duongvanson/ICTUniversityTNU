<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sửa thể loại</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>SỬA THỂ LOẠI</h1>
	<?php if($rs){ $i = $rs->fetch_assoc()?>
	<form action="index.php?ctrl=updateCate" method="post">
		<div>
			<label>ID: </label>
			<input type="text" name="cate_id" value="<?php echo $i['cate_id'] ?>" disabled>
		</div>
		<div>
			<label>Tên thể loại: </label>
			<input type="text" name="cate_name" value="<?php echo $i['cate_name'] ?>">
		</div>
		<div>
			<label></label>
			<button type="submit">Cập nhật</button>
		</div>
		<input type="text" name="cate_id" value="<?php echo $i['cate_id'] ?>" hidden>
	</form>
	<?php } ?>
</body>
</html>