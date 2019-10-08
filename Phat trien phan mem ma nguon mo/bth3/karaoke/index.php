<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>KARAOKE</title>
	<style>
		*{
			padding: 0px;
			margin: 0px;
		}
		body{
			width: 500px;
			margin: 100px auto;
			border: 1px solid #483D8B;
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
		input[name=money]{
			color: red;
			font-weight: bold;
		}
		h1{
			padding: 5px;
			background: #483D8B;
			color: #fff;
			text-align: center;
		}
		button{
			background: #483D8B;
			color: #fff;
			border: 1px solid;
			padding: 10px 20px;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<?php
	$hour_begin = 0;
	$hour_end = 0;
	$sum = 0;
	if(isset($_POST['reset'])) header("Refresh:0");
	if (isset($_POST['hour_begin'])) {

		if (trim($_POST['hour_begin']) == '' || trim($_POST['hour_end']) == '') {
			//echo "Đầu vào rỗng.";
			echo("<script>alert('Đầu vào rỗng.');</script>");
		 	header("Refresh:0");
		 	exit();
		}
		$hour_begin = (int)($_POST['hour_begin']);
		$hour_end = (int)($_POST['hour_end']);
		if ($hour_begin < 10 || $hour_end > 24) {
			echo("<script>alert('Giờ trong khoảng 10-24');</script>");
			header("Refresh:0");
			exit();
		}
		if ($hour_end < $hour_begin) {
			echo("<script>alert('Giờ kết thúc phải > hơn giờ bắt đầu.');</script>");
			header("Refresh:0");
			//exit();
		}
		$sum = 0;
		$hour = $hour_end - $hour_begin;
		if ($hour_begin >= 10 && $hour_end <= 17) {
			$sum = $hour * 20000;
		}else if ($hour_begin > 17 && $hour_end <= 24){
			$sum = $hour * 45000;
		}else{
			$t1 = 17 - $hour_begin;
			$t2 = $hour_end - 17;
			$sum = $t1*20000 + $t2*45000;
		}
	}
	?>
	<h1>TÍNH TIỀN KARAOKE</h1>
		<form action="index.php" method="post">
			<div>
				<label>Giờ bắt đầu: </label>
				<input type="text" name="hour_begin" value="<?php echo $hour_begin?>"> (h)
			</div>
			<div>
				<label>Giờ kết thúc: </label>
				<input type="text" name="hour_end" value="<?php echo $hour_end?>"> (h)
			</div>
			<div>
				<label>Tiền thanh toán: </label>
				<input type="text" name="money" readonly="readonly" value="<?php echo $sum?>"> (VNĐ)
			</div>
			<div>
				<label></label>
				<button type="submit">Tính tiền</button>
				<button type="submit" name="reset" value="reset">Đặt lại</button>
			</div>
		</form>
	<?php //} else {?>
<!-- 		<h1>TÍNH TIỀN KARAOKE</h1>
		<form action="index.php" method="post">
			<div>
				<label>Giờ bắt đầu: </label>
				<input type="text" name="hour_begin" value="0"> (h)
			</div>
			<div>
				<label>Giờ kết thúc: </label>
				<input type="text" name="hour_end" value="0"> (h)
			</div>
			<div>
				<label>Tiền thanh toán: </label>
				<input type="text" name="money" readonly="readonly" value="0"> (VNĐ)
			</div>
			<div>
				<label></label>
				<button type="submit">Tính tiền</button>
			</div>
		</form> -->
	<?php// } ?>
</body>
</html>