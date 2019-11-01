<?php /**
 * 
 */
class UserModel
{
	private $conn = null;
	function __construct()
	{
		$this->conn = mysqli_connect('localhost','root','','ds_nhanvien');
		$this->conn->query('set charset utf8');
	}
	public function getAll()
	{
		$sql = "select * from nhanvien";
		$result = $this->conn->query($sql);
		$arrNhanVien = array();
		while ($i = $result->fetch_assoc()) {
			array_push($arrNhanVien, new User(
				$i['ma_nhan_vien'],
				$i['ten_nhan_vien'],
				$i['ngay_sinh'],
				$i['que_quan'],
				$i['chuc_vu']));
		}
		return $arrNhanVien;
	}
	public function insertUser($user)
	{
		$sql = "insert into nhanvien values(0,'"
		.$user->getMa()."','"
		.$user->getTen()."','"
		.$user->getNgaySinh()."','"
		.$user->getQueQuan()."','"
		.$user->getChucVu()."')";
		echo $sql;
		$rs = $this->conn->query($sql);
		return $rs;
	}
} ?>