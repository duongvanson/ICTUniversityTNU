<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Add new user</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<form action="index.php?task=insert" method="post">
		<div>
			<label>Full name: </label>
			<input type="text" name="fullname">
		</div>
		<div>
			<label>User name: </label>
			<input type="text" name="username">
		</div>
		<div>
			<label>Password: </label>
			<input type="password" name="password">
		</div>
		<div>
			<label></label>
			<input type="submit" value="Confirm">
		</div>
	</form>
</body>
</html>