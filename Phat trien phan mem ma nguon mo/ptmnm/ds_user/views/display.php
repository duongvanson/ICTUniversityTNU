<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>User Manager</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<a href="index.php?task=add">Add new DSUser</a>
	<table>
		<tr>
			<th>ID</th>
			<th>User name</th>
			<th>Full name</th>
			<th>Options</th>
		</tr>
		<?php 
		if ($lstUser) {
		 	foreach ($lstUser as $item) {?>
		 <tr>
		 	<td><?php echo $item->getID() ?></td>
		 	<td><?php echo $item->getUserName() ?></td>
		 	<td><?php echo $item->getFullName() ?></td>
		 	<td>
		 		<a href="#">Sửa</a> | 
		 		<a href="#">Xóa</a>
		 	</td>
		 </tr>
		 <?php }} ?>
	</table>
</body>
</html>