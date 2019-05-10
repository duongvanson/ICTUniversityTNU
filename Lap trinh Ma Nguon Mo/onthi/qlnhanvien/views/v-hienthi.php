<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Quản lý nhân viên</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Danh sách nhân viên</h1>
	<form action="index.php" method="GET">
		<input type="text" name="ctrl" value="search" hidden>
		<label>Từ khóa: </label>
		<input type="text" name="keyword">
		<input type="submit" value="Tìm kiếm">
	</form>
	<form action="index.php" method="GET">
		<input type="text" name="ctrl" value="sort" hidden>
		<label>Sắp xếp: </label>
		<select name="sort">
			<option value="manv">Mã nhân viên</option>
			<option value="tennv">Tên nhân viên</option>
			<option value="namsinh">Năm sinh</option>
			<option value="gioitinh">Giới tính</option>
		</select>
		<label> Theo</label>
		<select name="by">
			<option value="asc">Tăng dần</option>
			<option value="desc">Giảm dần</option>
		</select>
		<input type="submit" value="Xem">
	</form>
	<?php if (isset($_GET["keyword"])) {
		echo "Kết quả tìm kiếm cho '". $_GET['keyword']."'<br>";
	} ?>
	<a href="index.php?ctrl=add">Thêm nhân viên</a>
	<table>
		<tr>
			<th>Mã nhân viên</th>
			<th>Tên nhân viên</th>
			<th>Năm sinh</th>
			<th>Giới tính</th>
			<th>Phòng</th>
			<th>Tùy chọn</th>
		</tr>
		<?php if (isset($rs)) {
			while ($i = $rs->fetch_assoc()) {?>
		<tr>
			<td><?php echo $i["manv"] ?></td>
			<td><?php echo $i["tennv"] ?></td>
			<td><?php echo $i["namsinh"] ?></td>
			<td><?php echo $i["gioitinh"] ?></td>
			<td><?php echo $i["tenphong"] ?></td>
			<td>
				<a href="index.php?ctrl=edit&id=<?php echo $i['manv'] ?>">Sửa</a> | 
				<a onclick="return confirm('Xác nhận xóa?');" href="index.php?ctrl=delete&id=<?php echo $i['manv'] ?>">Xóa</a>
			</td>
		</tr>
		<?php }} ?>
	</table>
	<ul>
		<?php for($i=1;$i<=$total;$i++){?>
		<a href="index.php?page=<?php echo $i ?>"><?php echo $i ?></a>
		<?php } ?>
	</ul>
</body>
</html>