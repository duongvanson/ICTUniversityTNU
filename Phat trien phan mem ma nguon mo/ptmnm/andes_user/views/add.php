<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Thêm nhân viên</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Nhập thông tin nhân viên</h1>
	<form action="index.php?task=insert" method="post">
		<div>
			<label>Mã nhân viên: </label>
			<input type="text" name="manhanvien">
		</div>
		<div>
			<label>Tên nhân viên: </label>
			<input type="text" name="tennhanvien">
		</div>
		<div>
			<label>Ngày sinh: </label>
			<input type="date" name="ngaysinh">
		</div>
		<div>
			<label>Quê quán: </label>
			<input type="text" name="quequan">
		</div>
		<div>
			<label>Chức vụ: </label>
			<input type="text" name="chucvu">
		</div>
		<div>
			<label></label>
			<input type="submit" value="Xác nhận">
		</div>
	</form>
</body>
</html>