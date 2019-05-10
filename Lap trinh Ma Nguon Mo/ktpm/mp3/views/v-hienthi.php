<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Danh sách bài hát</title>
	<link rel="stylesheet" href="styles.css">
</head>
<body>
	<h1>Danh sách bài hát</h1>
	<div class="add">
		<a href="index.php?ctrl=add"><span class="icon">+</span> Thêm bài hát</a>
	</div>
	<table>
		<tr>
			<th>Mã bài hát</th>
			<th>Tên bài hát</th>
			<th>Tác giả</th>
			<th>Năm sáng tác</th>
			<th>Tùy chọn</th>
		</tr>
		<?php if ($lst) {
			while ($i = $lst->fetch_assoc()) {?>
				<tr>
					<td><?php echo $i["mabh"]; ?></td>
					<td><?php echo $i["tenbh"]; ?></td>
					<td><?php echo $i["tacgia"]; ?></td>
					<td><?php echo $i["namst"]; ?></td>
					<td>
						<a href="index.php?ctrl=edit&mabh=<?php echo $i["mabh"] ?>"><span class="icon">!</span> Sửa</a> | 
						<a href="index.php?ctrl=delete&mabh=<?php echo $i["mabh"] ?>" onclick="return deleteQuestion('<?php echo $i["mabh"] ?>')"><span class="icon">3</span> Xóa</a>
					</td>
				</tr>
		<?php }} ?>
	</table>
	<script>
		function deleteQuestion($mabh) {
			var rs = confirm("Xóa thật không thế?");
			return rs;
		}
	</script>
</body>
</html>