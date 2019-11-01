<?php /**
 * 
 */
include 'comment.php';
class CMTModel
{
	private $connect;
	function __construct()
	{
		$this->_connect();
	}
	private function _connect()
	{
		$this->connect = new mysqli('localhost','root','','ds_cmt');
	}
	public function getAllComment()
	{
		$sql = "select * from comment";
		$result = $this->connect->query($sql);
		$comments = array();
		while ($i = $result->fetch_assoc()) {
			array_push($comments, new Comment($i['id'], $i['title'], $i['fullname'], $i['email'], $i['content']));
		}
		return $comments;
	}
	public function insertCMT($cmt)
	{
		$title = $cmt->getTitle();
		$fullname = $cmt->getFullName();
		$email = $cmt->getEmail();
		$content = $cmt->getContent();

		$sql = "insert into comment values(0, '$title', '$fullname', '$email','$content')";
		$result = $this->connect->query($sql);
		return $result;
	}
} ?>