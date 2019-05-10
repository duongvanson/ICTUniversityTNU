<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>EDIT</title>
</head>
<body>
	<?php if (isset($rs)) {
		$i = $rs->fetch_assoc();
	?>
	<form action="index.php?ctrl=update" method="post">
		<div>
			<label>Mã SV: </label> <input disabled type="text" value="<?php echo $i["masv"] ?>">
		</div>
		<div>
			<label>Tên SV: </label> <input type="text" name="tensv" value="<?php echo $i["tensv"] ?>">
		</div>
		<div>
			<label>Năm sinh: </label> <input type="text" name="namsinh" value="<?php echo $i["namsinh"] ?>">
		</div>
		<div>
			<label>Mã lớp: </label> <input type="text" name="malop" value="<?php echo $i["malop"] ?>">
		</div>
		 <input hidden type="text" name="masv" value="<?php echo $i["masv"] ?>">
		<div>
			<label></label> <input type="submit" value="Xác nhận">
		</div>
	</form>
	<?php } ?>
</body>
</html>