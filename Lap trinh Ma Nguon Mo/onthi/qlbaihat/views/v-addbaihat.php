<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Thêm bài hát</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Nhập thông tin: </h1>
	<form action="index.php?ctrl=insert" method="POST">
		<div>
			<label>Mã bài hát: </label>
			<input type="text" name="mabaihat">
		</div>
		<div>
			<label>Tên bài hát: </label>
			<input type="text" name="tenbaihat">
		</div>
		<div>
			<label>Tác giả: </label>
			<input type="text" name="tacgia">
		</div>
		<div>
			<label>Năm sáng tác: </label>
			<input type="number" name="namsangtac">
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
	</form>
</body>
</html>