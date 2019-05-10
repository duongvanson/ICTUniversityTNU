<?php 
	

	function getNhanVien($cond)
	{
		$connect = mysqli_connect("localhost","root","","ctyktppm");
		mysqli_query($connect, "SET NAMES 'utf8'");
		$query = "";
		switch ($cond) {
			case 'none':
				$query = "SELECT * FROM nhanvien";
				break;
			case 'sex':
				$query = "SELECT * FROM nhanvien WHERE gioitinh = 1";
				break;
			case 'pro1':
				$query= "SELECT *
						FROM nhanvien nv
						WHERE nv.manv IN (
						    SELECT manv
						    FROM thamgia
						    GROUP BY(manv)
						    HAVING COUNT(manv) >= 1)";
				break;
			case 'pro0':
				$query = "SELECT *
						FROM nhanvien nv
						WHERE nv.manv NOT IN (
						    SELECT manv
						    FROM thamgia
						    GROUP BY(manv)
						    HAVING COUNT(manv) >= 1)";
				break;
			default:
				$query = "SELECT * FROM nhanvien";
				break;
			}
			$result = mysqli_query($connect, $query);
			return $result;
	}
 ?>