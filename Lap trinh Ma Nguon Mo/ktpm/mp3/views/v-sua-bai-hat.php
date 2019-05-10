<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="styles.css">
</head>
<body>
	<?php if ($baihat) {
		while ($bh = $baihat->fetch_assoc()) {?>
	<form action="index.php?ctrl=update" method="POST">
		<div>
			<label>Mã bài hát: </label>
			<input type="text" disabled name="mabh" value="<?php echo $bh["mabh"] ?>">
		</div>
		
		<div>
			<label>Tên bài hát: </label>
			<input type="text" name="tenbh" value="<?php echo $bh["tenbh"] ?>">
		</div>
		
		<div>
			<label>Tác giả: </label>
			<input type="text" name="tacgia" value="<?php echo $bh["tacgia"] ?>">
		</div>

		<div>
			<label>Năm sáng tác: </label>
			<input type="text" name="namst" value="<?php echo $bh["namst"] ?>">
		</div>

		<div>
			<label></label>
			<input type="submit" name="capnhat" value="Xác nhận">
		</div>

		<input type="text" hidden name="mabh" value="<?php echo $bh["mabh"] ?>">
	</form>

	<?php }} ?>
</body>
</html>