<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="styles.css">
</head>
<body>
	<form action="index.php?ctrl=insert" method="POST">
		<div>
			<label>Mã bài hát: </label>
			<input type="text" name="mabh" value="">
		</div>
		
		<div>
			<label>Tên bài hát: </label>
			<input type="text" name="tenbh" value="">
		</div>
		
		<div>
			<label>Tác giả: </label>
			<input type="text" name="tacgia" value="">
		</div>

		<div>
			<label>Năm sáng tác: </label>
			<input type="text" name="namst" value="">
		</div>

		<div>
			<label></label>
			<input type="submit" name="capnhat" value="Xác nhận thêm">
		</div>
	</form>

</body>
</html>