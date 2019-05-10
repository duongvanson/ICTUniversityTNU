<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Sửa phòng</title>
</head>
<body>
	<?php if(isset($phong)) { $i = $phong->fetch_assoc() ?>
	<form action="index.php?ctrl=update" method="POST">
		<div>
			<label>Mã phòng: </label>
			<input type="text" name="maphong" disabled value="<?php echo $i["maphong"]?>">
		</div>
		<div>
			<label>Tên phòng: </label>
			<input type="text" name="tenphong" value="<?php echo $i["tenphong"]?>">
		</div>
		<div>
			<label>Loại phòng: </label>
			<input type="text" name="loaiphong" value="<?php echo $i["loaiphong"]?>">
		</div>
		<div>
			<label>Giá phòng: </label>
			<input type="text" name="dongia" value="<?php echo $i["dongia"]?>">
		</div>
		<div>
			<label></label>
			<input type="submit" value="Cập nhật">
		</div>
			<input type="text" name="maphong" hidden value="<?php echo $i["maphong"]?>">
	</form>
<?php }?>
</body>
</html>