<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>XẾP LOẠI HỌC TẬP</title>
	<style>
		*{
			padding: 0px;
			margin: 0px;
		}
		body{
			width: 500px;
			margin: 100px auto;
			border: 1px solid #008080;
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
			background: #008080;
			color: #fff;
			text-align: center;
		}
		button{
			background: #008080;
			color: #fff;
			border: 1px solid;
			padding: 10px 20px;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<?php
	$score_1 = 0;
	$score_2 = 0;
	$score_avg = 0;
	$result = "";
	$grade = "";
	if (isset($_POST['score_1'])) {
		if (trim($_POST['score_1']) == '' || trim($_POST['score_2']) == '') {
			echo("<script>alert('Đầu vào rỗng.');</script>");
		 	header("Refresh:0");
		 	exit();
		}
		$score_1 = (float)($_POST['score_1']);
		$score_2 = (float)($_POST['score_2']);

		if ($score_1 < 0 || 0 > $score_2) {
			echo("<script>alert('Không được nhập số âm');</script>");
			header("Refresh:0");
		}
		$score_avg = round(($score_1 + $score_2*2)/3.0,2);
		if ($score_avg >= 5) {
			$result = "Được lên lớp";
		}else{
			$result = "Ở lại lớp";
		}
		if ($score_avg >= 8) {
			$grade = "Giỏi";
		}else if($score_avg > 6.5 && $score_avg < 8){
			$grade = "Khá";
		}else if($score_avg >= 5 && $score_avg < 6.5){
			$grade = "Trung bình";
		}else{
			$grade = "Yếu";
		}
	}
	?>
	<h1>KẾT QUẢ HỌC TẬP</h1>
		<form action="ketquahoctap.php" method="post">
			<div>
				<label>Điểm HK 1: </label>
				<input type="text" name="score_1" value="<?php echo $score_1 ?>">
			</div>
			<div>
				<label>Điểm HK 2: </label>
				<input type="text" name="score_2" value="<?php echo $score_2 ?>">
			</div>
			<div>
				<label>Điểm trung bình: </label>
				<input class="outp" type="text" name="score_avg" value="<?php echo $score_avg ?>" readonly="readonly">
			</div>
			<div>
				<label>Kết quả: </label>
				<input class="outp" type="text" name="result" readonly="readonly" value="<?php echo $result ?>">
			</div>
			<div>
				<label>Xếp loại học lực: </label>
				<input class="outp" type="text" name="grade" readonly="readonly" value="<?php echo $grade ?>">
			</div>
			<div>
				<label></label>
				<button type="submit">Xem kết quả</button>
			</div>
		</form>
<!-- 	<?php //} else {?>
		<h1>KẾT QUẢ HỌC TẬP</h1>
		<form action="ketquahoctap.php" method="post">
			<div>
				<label>Điểm HK 1: </label>
				<input type="text" name="score_1" value="0">
			</div>
			<div>
				<label>Điểm HK 2: </label>
				<input type="text" name="score_2" value="0">
			</div>
			<div>
				<label>Điểm trung bình: </label>
				<input class="outp" type="text" name="score_avg" value="0" readonly="readonly">
			</div>
			<div>
				<label>Kết quả: </label>
				<input class="outp" type="text" name="result" readonly="readonly" value="">
			</div>
			<div>
				<label>Xếp loại học lực: </label>
				<input class="outp" type="text" name="grade" readonly="readonly" value="">
			</div>
			<div>
				<label></label>
				<button type="submit">Xem kết quả</button>
			</div>
		</form>
	<?php// } ?> -->
</body>
</html>