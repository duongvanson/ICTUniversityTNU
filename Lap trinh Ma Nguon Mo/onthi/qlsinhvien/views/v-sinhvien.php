<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Danh sách sinh viên</title>
	<style>
		table{
			border-collapse: collapse;
		}
		table,tr,th,td{
			border:1px solid green;
			padding: 5px;
		}
	</style>
</head>
<body>
	<a href="index.php?ctrl=add">Thêm sinh viên</a>
	<form action="index.php" method="get">
		<input type="text" name="ctrl" value="search" hidden>
		<label>Tìm: </label>
		<input type="text" name="keywork">
		<input type="submit" value="Tìm">
	</form>
	<h1>Danh sách sinh viên</h1>
	<form action="index.php">
		<label>Sắp xếp: </label>
		<select name="sort">
			<option value="default">...</option>
			<option value="masv">Mã sinh viên</option>
			<option value="tensv">Tên sinh viên</option>
			<option value="namsinh">Năm sinh</option>
			<option value="lop">Lớp</option>
		</select>
		<input type="submit" value="OK">
	</form>
	<table>
		<tr>
			<th>Mã SV</th>
			<th>Tên SV</th>
			<th>Năm sinh</th>
			<th>Lớp</th>
			<th>Tùy chọn</th>
		</tr>
		<?php if(isset($rs)){
			while ($i = $rs->fetch_assoc()) {?>
		<tr>
			<td><?php echo $i["masv"]; ?></td>
			<td><?php echo $i["tensv"]; ?></td>
			<td><?php echo $i["namsinh"]; ?></td>
			<td><?php echo $i["lop"]; ?></td>
			<td>
				<a href="index.php?ctrl=edit&id=<?php echo $i["masv"] ?>">Sửa</a> |
				<a onclick="return question();" href="index.php?ctrl=delete&id=<?php echo $i["masv"]?>">Xóa</a>
			</td>
		</tr>
		<?php }} ?>
	</table>
	<script>
		function question(){
			return confirm("Xac nhan xoa?");
		}
	</script>
</body>
</html>