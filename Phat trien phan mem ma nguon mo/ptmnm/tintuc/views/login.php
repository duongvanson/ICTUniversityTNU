<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Đăng nhập</title>
	<link rel="stylesheet" href="style.css">
	<style>
		body{
			width: 500px;
			margin: 100px auto;
		}
	</style>
</head>
<body>
	<h1>Đăng nhập</h1>
	<form action="index.php?ctrl=post_login" method="post">
		<div>
			<label>Username: </label>
			<input type="text" name="username">
		</div>
		<div>
			<label>Password: </label>
			<input type="password" name="password">
		</div>
		<div>
			<label></label>
			<button type="submit">Đăng nhập</button>
		</div>
	</form>
</body>
</html>