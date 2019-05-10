<?php 
	include 'model.php';
	if (isset($_POST["dsnv"])) {
		$result = getNhanVien("none");
		//var_dump($result);
		//echo "lol";
	}
	if (isset($_POST["dsnvgt1"])) {
		$result = getNhanVien("sex");
	}
	if (isset($_POST["dsnvtg1"])) {
		$result = getNhanVien("pro1");
	}
	if (isset($_POST["dsnvtg0"])) {
		$result = getNhanVien("pro0");
	}
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>CTY</title>
	<style>
		input[type="submit"]{
			background: #05598E;
			color: #fff;
			padding: 10px 20px;
			border: none;
		}
		table{
			border-collapse: collapse;
		}
		table,tr,th,td{
			border: 1px solid green;
			padding: 10px;
		}
	</style>
</head>
<body>
	<form action="index.php" method="POST">
		<input type="submit" name="dsnv" value="DSNV"> | 
		<input type="submit" name="dsnvgt1" value="DSNV gioi tinh = 1"> | 
		<input type="submit" name="dsnvtg1" value="DSNV tham gia >= 1 du an"> |
		<input type="submit" name="dsnvtg0" value="DSNV tham gia <= du an">
	</form>
	<hr>
	<table>
		<tr>
			<th>Mã</th>
			<th>Tên</th>
			<th>Ngày sinh</th>
			<th>Giới tính</th>
		</tr>
			<?php if(isset($result)){
		while ($row = $result->fetch_assoc()) {
	?>
		<tr>
			<td><?php echo $row["manv"]; ?></td>
			<td><?php echo $row["tennv"]; ?></td>
			<td><?php echo $row["ngaysinh"]; ?></td>
			<td><?php echo $row["gioitinh"]; ?></td>
		</tr>
	<?php }} ?>
	</table>
</body>
</html>