<!DOCTYPE html>
<html lang="vi">
	<head>
		<title>Thêm nhân viên</title>
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<?php if($rs){ $i = $rs->fetch_assoc()?>
		<form action="index.php?ctrl=update" method="POST">
			<div>
				<label>Mã NV: </label>
				<input type="text" name="manv" value="<?php echo $i['manv'] ?>" disabled>
			</div>
			<div>
				<label>Tên NV: </label>
				<input type="text" name="tennv" value="<?php echo $i['tennv'] ?>">
			</div>
			<div>
				<label>Năm sinh NV: </label>
				<input type="text" name="namsinh" value="<?php echo $i['namsinh'] ?>">
			</div>
			<div>
				<label>Giới tính NV: </label>
				<input type="text" name="gioitinh" value="<?php echo $i['gioitinh'] ?>">
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
			<input type="text" name="manv" value="<?php echo $i['manv'] ?>" hidden>
		</form>
	<?php } ?>
	</body>
</html>