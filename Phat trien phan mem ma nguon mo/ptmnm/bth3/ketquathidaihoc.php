<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>KẾT QUẢ THI ĐẠI HỌC</title>
	<style>
		*{
			padding: 0px;
			margin: 0px;
		}
		body{
			width: 500px;
			margin: 100px auto;
			border: 1px solid #2E8B57;
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
			background: #2E8B57;
			color: #fff;
			text-align: center;
		}
		button{
			background: #2E8B57;
			color: #fff;
			border: 1px solid;
			padding: 10px 20px;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<?php
	$toan = 0;
	$ly = 0;
	$hoa = 0;
	$diem_chuan = 0;
	$tong_diem = 0;
	$ket_qua = "";
	if (isset($_POST['toan'])) {
		if (trim($_POST['toan']) == '' || trim($_POST['ly']) == ''||trim($_POST['hoa']) == '' || trim($_POST['diem_chuan']) == '') {
			echo("<script>alert('Đầu vào rỗng.');</script>");
		 	header("Refresh:0");
		 	exit();
		}
		$toan = (float)($_POST['toan']);
		$ly = (float)($_POST['ly']);
		$hoa = (float)($_POST['hoa']);
		$diem_chuan = (float)($_POST['diem_chuan']);
		if ($toan < 0 || 0 > $ly || $hoa < 0) {
			echo("<script>alert('Không được nhập số âm');</script>");
			header("Refresh:0");
		}
		$tong_diem = $toan + $ly + $hoa;
		$ket_qua = "";

		if ($toan == 0 || $ly == 0 || $hoa == 0 || $tong_diem < $diem_chuan) {
			$ket_qua = "Rớt";
		}else{
			$ket_qua = "Đậu";
		}
	}
		?>
	<h1>KẾT QUẢ THI ĐẠI HỌC</h1>
		<form action="ketquathidaihoc.php" method="post">
			<div>
				<label>Toán: </label>
				<input type="text" name="toan" value="<?php echo $toan ?>">
			</div>
			<div>
				<label>Lý: </label>
				<input type="text" name="ly" value="<?php echo $ly ?>">
			</div>
			<div>
				<label>Hóa: </label>
				<input type="text" name="hoa" value="<?php echo $hoa ?>">
			</div>
			<div>
				<label>Điểm chuẩn: </label>
				<input type="text" name="diem_chuan" value="<?php echo $diem_chuan ?>">
			</div>
			<div>
				<label>Tổng điểm: </label>
				<input class="outp" type="text" name="tong_diem" readonly="readonly" value="<?php echo $tong_diem ?>">
			</div>
			<div>
				<label>Kết quả thi: </label>
				<input class="outp" type="text" name="ket_qua" readonly="readonly" value="<?php echo $ket_qua ?>">
			</div>
			<div>
				<label></label>
				<button type="submit">Xem kết quả</button>
			</div>
		</form>
<!-- 	<?php //} else {?>
		<h1>KẾT QUẢ THI ĐẠI HỌC</h1>
		<form action="ketquathidaihoc.php" method="post">
			<div>
				<label>Toán: </label>
				<input type="text" name="toan" value="0">
			</div>
			<div>
				<label>Lý: </label>
				<input type="text" name="ly" value="0">
			</div>
			<div>
				<label>Hóa: </label>
				<input type="text" name="hoa" value="0">
			</div>
			<div>
				<label>Điểm chuẩn: </label>
				<input type="text" name="diem_chuan" value="0">
			</div>
			<div>
				<label>Tổng điểm: </label>
				<input class="outp" type="text" name="tong_diem" readonly="readonly" value="">
			</div>
			<div>
				<label>Kết quả thi: </label>
				<input class="outp" type="text" name="ket_qua" readonly="readonly" value="">
			</div>
			<div>
				<label></label>
				<button type="submit">Xem kết quả</button>
			</div>
		</form>
	<?php// } ?> -->
</body>
</html>