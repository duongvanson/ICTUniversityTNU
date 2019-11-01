<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Thêm comment mới</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Thêm nội dung mới</h1>
	<form action="index.php?task=insert" method="post">
		<div>
			<label>Tiêu đề: </label>
			<input type="text" name="title">
		</div>
		<div>
			<label>Họ tên: </label>
			<input type="text" name="fullname">
		</div>
		<div>
			<label>Email: </label>
			<input type="text" name="email">
		</div>
		<div>
			<label>Nội dung: </label>
			<textarea name="content" cols="30" rows="5"></textarea>
		</div>
		<div>
			<label></label>
			<input type="submit" value ="Gửi nội dung">
		</div>
	</form>
</body>
</html>