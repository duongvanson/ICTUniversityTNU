<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Danh sách bài hát</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Danh sách bài hát</h1>
	<a href="index.php?ctrl=add">Thêm bài hát</a>
	<form action="index.php" method="get">
		<input type="text" name="ctrl" value="search" hidden>
		<input type="text" name="keyword">
		<input type="submit" value="Tìm kiếm">
	</form>
	<table>
		<tr>
			<th>Mã bài hát</th>
			<th>Tên bài hát</th>
			<th>Tác giả</th>
			<th>Năm sáng tác</th>
			<th>Thể loại</th>
			<th>Tùy chọn</th>
		</tr>
		<?php if(isset($rs)){ while($i = $rs->fetch_assoc()){?>
		<tr>
			<td><?php echo $i["mabaihat"] ?></td>
			<td><?php echo $i["tenbaihat"] ?></td>
			<td><?php echo $i["tacgia"] ?></td>
			<td><?php echo $i["namsangtac"] ?></td>
			<td><?php echo $i["tentheloai"] ?></td>
			<td>
				<a href="index.php?ctrl=edit&id=<?php echo $i["mabaihat"] ?>">Sửa</a> | 
				<a onclick="return confirm('Xác nhận xóa');" href="index.php?ctrl=delete&id=<?php echo $i["mabaihat"] ?>">Xóa</a>
			</td>
		</tr>
		<?php }} ?>
	</table>
	<ul>
		<?php for($i=1; $i <= $total; $i++){?>
			<a href="index.php?page=<?php echo $i?>"><?php echo $i ?></a> 
		<?php } ?>
	</ul>
</body>
</html>