<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Thêm thể loại</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>THÊM THỂ LOẠI</h1>
	<form action="index.php?ctrl=insertCate" method="post">
		<div>
			<label>Nhập tên: </label>
			<input type="text" name="cate_name">
		</div>
		<div>
			<label></label>
			<button type="submit">Thêm</button>
		</div>
	</form>
</body>
</html>