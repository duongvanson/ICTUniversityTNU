<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>EDIT</title>
</head>
<body>
	<?php if($rs){ $i = $rs->fetch_assoc()?>
	<form action="index.php?ctrl=update" method="POST">
		<div>
			<label>Mã bài hát: </label>
			<input disabled type="text" name="mabaihat" value="<?php echo $i["mabaihat"] ?>">
		</div>
		<div>
			<label>Tên bài hát: </label>
			<input type="text" name="tenbaihat" value="<?php echo $i["tenbaihat"] ?>">
		</div>
		<div>
			<label>Tác giả: </label>
			<input type="text" name="tacgia" value="<?php echo $i["tacgia"] ?>">
		</div>
		<div>
			<label>Năm sáng tác: </label>
			<input type="number" name="namsangtac" value="<?php echo $i["namsangtac"] ?>">
		</div>
		<div>
			<label>Thể loại: </label>
			<select name="theloai">
				<option value="rap">Nhạc rap</option>
				<option value="tre">Nhạc trẻ</option>
			</select>
		</div>
		<div>
			<label></label>
			<input type="submit" value="Xác nhận">
		</div>
		<input hidden type="text" name="mabaihat" value="<?php echo $i["mabaihat"] ?>">
	</form>
<?php } ?>
</body>
</html>