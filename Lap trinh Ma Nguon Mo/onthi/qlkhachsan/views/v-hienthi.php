<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Khách sạn X</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Danh sách phòng</h1>
	<a href="index.php?ctrl=add">Thêm phòng</a>
	<table>
		<tr>
			<th>Mã phòng</th>
			<th>Tên phòng</th>
			<th>Loại phòng</th>
			<th>Đơn giá</th>
			<th>Tùy chọn</th>
		</tr>
		<?php if($rs){
			while ($i = $rs->fetch_assoc()) {?>
			<tr>
				<td><?php echo $i["maphong"] ?></td>
				<td><?php echo $i["tenphong"] ?></td>
				<td><?php echo $i["loaiphong"] ?></td>
				<td><?php echo $i["dongia"] ?></td>
				<td>
					<a href="index.php?ctrl=edit&id=<?php echo $i['maphong'] ?>">Sửa</a> | 
					<a onclick="return ques();" href="index.php?ctrl=delete&id=<?php echo $i['maphong'] ?>">Xóa</a>
				</td>
			</tr>
		<?php }} ?>
	</table>
	<script>
		function ques() {
			var rs = confirm("Xác nhận xóa? ");
			return rs;
		}
	</script>
</body>
</html>