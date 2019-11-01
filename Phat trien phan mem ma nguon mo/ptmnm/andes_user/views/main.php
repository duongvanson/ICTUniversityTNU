<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Andes User</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>DANH SÁCH NHÂN VIÊN ANDES</h1>
	<table>
		<tr>
			<th>Mã nhân viên</th>
			<th>Tên nhân viên</th>
			<th>Ngày sinh</th>
			<th>Quê quán</th>
			<th>Chức vụ</th>
		</tr>
		<?php if (isset($lstUser)) {
			foreach ($lstUser as $p) {?>
		<tr>
			<td><?php echo $p->getMa() ?></td>
			<td><?php echo $p->getTen() ?></td>
			<td><?php echo $p->getNgaySinh() ?></td>
			<td><?php echo $p->getQueQuan() ?></td>
			<td><?php echo $p->getChucVu() ?></td>
		</tr>
	<?php }} ?>
	</table>
	<a href="index.php?task=add">Thêm nhân viên mới</a>
</body>
</html>