<?php include("connect.php") ?>
<?php 
	$connect = new Connect();
	$rs = $connect->getDataGroupByMaSp();
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Phân phối</title>
	<style>
		table{
			border-collapse: collapse;
		}
		table, tr,th,td{
			border: 1px solid green;
			padding: 10px;
		}
	</style>
</head>
<body>
	<h1>Bảng thống kê sản phẩm</h1>
	<table>
		<tr>
			<th>Mã sản phẩm</th>
			<th>Tên sản phẩm</th>
			<th>Đơn vị tính</th>
			<th>Tổng số lượng</th>
			<th>Tùy chọn</th>
		</tr>
		<?php
			if ($rs) {
			while ($sp = $rs->fetch_assoc()) {
		 ?>
		 <tr>
		 	<td><?php echo $sp["masp"]?></td>
		 	<td><?php echo $sp["tensp"]?></td>
		 	<td><?php echo $sp["dvt"]?></td>
		 	<td><?php echo $sp["soluong"]?></td>
		 	<td><a href="delete.php?masp=<?php echo $sp["masp"]?>">Xóa</a></td>
		 </tr>
		 <?php 
		 	}}
		  ?>
	</table>
</body>
</html>