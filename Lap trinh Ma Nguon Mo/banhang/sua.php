<?php 
	require_once 'database.php';
	$db = new Database();
	if (isset($_GET["id"])) {
		$rs = $db->getMatHangID($_GET["id"]);
	}
	if (isset($_POST["id"])) {
		if($db->updateMatHang($_POST["id"], $_POST["maloaihang"], $_POST["tenmathang"], $_POST["giaban"])){
			header("Location: index.php");exit;
		}else{
			echo ("Update fail!");
		}
	}
 ?>
 <!DOCTYPE html>
 <html lang="en">
 <head>
 	<meta charset="UTF-8">
 	<title>Sửa</title>
 	<style>
 		label{
 			display: inline-block;
 			width: 100px;
 		}
 	</style>
 </head>
 <body>
 	<?php
		if ($hang = mysqli_fetch_assoc($rs)) {
	?>
 	<form action="sua.php?id=<?php echo $hang["id"]?>" method="post">
 		<div>
 			<label>ID: </label>
 			<input type="text" name="id" value="<?php echo $hang["id"]?>" />
 		</div>
 		<div>
 			<label>Loại mặt hàng: </label>
 			<input type="text" name="maloaihang" value="<?php echo $hang["maloaihang"]?>" />
 		</div>
 		<div>
 			<label>Tên hàng: </label>
 			<input type="text" name="tenmathang" value="<?php echo $hang["tenmathang"]?>" />
 		</div>
 		<div>
 			<label>Giá bán: </label>
 			<input type="text" name="giaban" value="<?php echo $hang["giaban"]?>" />
 		</div>
 	<?php } ?>
 		<label></label>
 		<input type="submit" value="Xác nhận">
 	</form>
 </body>
 </html>