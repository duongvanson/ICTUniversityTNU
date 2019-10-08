<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Mananger Category</title>
	<link rel="stylesheet" href="style.css">
	<style>
		body{
			margin: 20px;
		}
	</style>
</head>
<body>
	<h1>Quản lý thể loại</h1><br>
	<a href="index.php?ctrl=addCate">Thêm thể loại</a>
	<table>
		<tr>
			<th>Mã thể loại</th>
			<th>Tên thể loại</th>
			<th>Tùy chọn</th>
		</tr>
		<?php if(isset($res)){ while($i = $res->fetch_assoc()){?>
		<tr>
			<td><?php echo $i["cate_id"] ?></td>
			<td><?php echo $i["cate_name"] ?></td>
			<td>
				<a href="index.php?ctrl=editCate&id=<?php echo $i["cate_id"] ?>">Sửa</a> | 
				<a onclick="return confirm('Xác nhận xóa');" href="index.php?ctrl=deleteCate&id=<?php echo $i["cate_id"] ?>">Xóa</a>
			</td>
		</tr>
		<?php }} ?>
	</table>
	<a href="index.php?ctrl=logout">Đăng xuất</a>
</body>
</html>