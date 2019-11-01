<?php /**
 * 
 */
class User
{
	private $maNhanVien, $tenNhanVien, $ngaySinh, $queQuan, $chucVu;
	function __construct($manv, $tennv, $bir, $qq, $cv)
	{
		$this->maNhanVien = $manv;
		$this->tenNhanVien = $tennv;
		$this->ngaySinh = $bir;
		$this->queQuan = $qq;
		$this->chucVu = $cv;
	}
	public function getMa()
	{
		return $this->maNhanVien;
	}
	public function getTen()
	{
		return $this->tenNhanVien;
	}
	public function getNgaySinh()
	{
		return $this->ngaySinh;
	}
	public function getQueQuan()
	{
		return $this->queQuan;
	}
	public function getChucVu()
	{
		return $this->chucVu;
	}
} ?>