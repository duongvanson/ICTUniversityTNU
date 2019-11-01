<?php /**
 * 
 */
class CMTControl
{
	private $cmtModel = null;
	function __construct()
	{
		include 'models/cmt_model.php';
		$this->cmtModel = new CMTModel();
	}
	public function getAllComment()
	{
		$result = $this->cmtModel->getAllComment();
		if ($result) {
			$_SESSION['comments'] = $result;
		}
	}
	public function insertCMT($data)
	{
		if (empty($data['title']) || empty($data['email']) || empty($data['fullname']) || empty($data['content'])) {
			echo "<p>Thêm comment thất bại!</p>";
			echo "<a href='index.php?task=add'>Quay lại</a> | ";
			echo "<a href='index.php'>Trang chủ</a>";
			return;
		}
		$cmt = new Comment(0, $data['title'],$data['email'],$data['fullname'],$data['content']);
		$result = $this->cmtModel->insertCMT($cmt);
		if ($result) {
			header('location: index.php');
		}else{
			echo "Thêm comment thất bại!";
		}
	}
} ?>