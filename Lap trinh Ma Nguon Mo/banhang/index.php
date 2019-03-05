<?php
	include ('database.php');
	$db = new Database();
	$mathang = $db->getMatHang();
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Hàng</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>Mã loại hàng</th>
			<th>Tên mặt hàng</th>
			<th>Giá bán</th>
		</tr>
		<?php
			while ($hang = mysqli_fetch_assoc($mathang)) {
		?>
		<tr>
			<td><?php echo $hang["id"] ?></td>
			<td><?php echo $hang["maloaihang"] ?></td>
			<td><?php echo $hang["tenmathang"] ?></td>
			<td><?php echo $hang["giaban"] ?></td>
			<td><a href="xoa.php?id=<?php echo $hang["id"] ?>" onclick="return confirm('Xác nhận xóa')">XÓA</a></td>
			<td><a href="sua.php?id=<?php echo $hang["id"]?>">SỬA</a></td>
		</tr>
		<?php
			}
		?>
	</table>
</body>
</html>