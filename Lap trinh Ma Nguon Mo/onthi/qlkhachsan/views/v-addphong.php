<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Thêm phòng</title>
</head>
<body>
	<form action="index.php?ctrl=insert" method="POST">
		<div>
			<label>Mã phòng: </label>
			<input type="text" name="maphong">
		</div>
		<div>
			<label>Tên phòng: </label>
			<input type="text" name="tenphong">
		</div>
		<div>
			<label>Loại phòng: </label>
			<input type="text" name="loaiphong">
		</div>
		<div>
			<label>Giá phòng: </label>
			<input type="text" name="dongia">
		</div>
		<div>
			<label></label>
			<input type="submit" value="Thêm">
		</div>
	</form>
</body>
</html>