<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>HÌNH CHỮ NHẬT</title>
	<style>
		*{
			padding: 0px;
			margin: 0px;
		}
		body{
			width: 500px;
			margin: 100px auto;
			border: 1px solid #008B8B;
		}
		label{
			display: inline-block;
			width: 150px;
		}
		div{
			margin: 5px;
		}
		input[type=text], button{
			padding: 7px;
		}
		input[class=outp]{
			color: red;
			font-weight: bold;
		}
		h1{
			padding: 5px;
			background: #008B8B;
			color: #fff;
			text-align: center;
		}
		button{
			background: #008B8B;
			color: #fff;
			border: 1px solid;
			padding: 10px 30px;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<?php
	if ($_POST) {
		$chieu_dai = (int)($_POST['chieu_dai']);
		$chieu_rong = (int)($_POST['chieu_rong']);
		if ($chieu_dai < 0 || 0 > $chieu_rong) {
			echo("<script>alert('Không được nhập số âm');</script>");
			header("Refresh:0");
		}
		$chu_vi = $chieu_dai+$chieu_rong;
		$dien_tich = $chieu_dai*$chieu_rong;
	?>
	<h1>DIỆN TÍCH HÌNH CHỮ NHẬT</h1>
		<form action="hinhchunhat.php" method="post">
			<div>
				<label>Chiều dài: </label>
				<input type="text" name="chieu_dai" value="<?php echo $chieu_dai?>">
			</div>
			<div>
				<label>Chiều rộng: </label>
				<input type="text" name="chieu_rong" value="<?php echo $chieu_rong?>">
			</div>
			<div>
				<label>Diện tích: </label>
				<input type="text" name="dien_tich" readonly="readonly" value="<?php echo $dien_tich?>">
			</div>
			<div>
				<label>Chu vi: </label>
				<input type="text" name="chu_vi" readonly="readonly" value="<?php echo $chu_vi?>">
			</div>
			<div>
				<label></label>
				<button type="submit">Tính</button>
			</div>
		</form>
	<?php } else {?>
		<h1>DIỆN TÍCH HÌNH CHỮ NHẬT</h1>
		<form action="hinhchunhat.php" method="post">
			<div>
				<label>Chiều dài: </label>
				<input type="text" name="chieu_dai" value="0">
			</div>
			<div>
				<label>Chiều rộng: </label>
				<input type="text" name="chieu_rong" value="0">
			</div>
			<div>
				<label>Diện tích: </label>
				<input class="outp" type="text" name="dien_tich" readonly="readonly" value="0">
			</div>
			<div>
				<label>Chu vi: </label>
				<input class="outp" type="text" name="chu_vi" readonly="readonly" value="0">
			</div>
			<div>
				<label></label>
				<button type="submit">Tính</button>
			</div>
		</form>
	<?php } ?>
</body>
</html>