<!DOCTYPE html>
<html lang="vi">
	<head>
		<title>Thêm nhân viên</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<form action="index.php?ctrl=insert" method="POST">
			<div>
				<label>Mã NV: </label>
				<input type="text" name="manv">
			</div>
			<div>
				<label>Tên NV: </label>
				<input type="text" name="tennv">
			</div>
			<div>
				<label>Năm sinh NV: </label>
				<input type="text" name="namsinh">
			</div>
			<div>
				<label>Giới tính NV: </label>
				<input type="text" name="gioitinh">
			</div>
			<div>
				<label></label>
				<select name="phong">
					<option value="p01">Nhân sự</option>
					<option value="p02">Hành chính</option>
				</select>
			</div>
			<div>
				<label></label>
				<input type="submit" value="Xác nhận">
			</div>
		</form>
	</body>
</html>