<?php /**
 * Author: Son Duong 2112
 */
include 'users.php';
class UserModel
{
	private $connect;
	function __construct()
	{
		$this->connect = new mysqli('localhost','root','','ds_user');
		//$this->connect->query('set utf8');
	}

	public function getAllUser()
	{
		$sql = "select * from username";
		$result = $this->connect->query($sql);
		$lstUser = array();
		while ($i = $result->fetch_assoc()) {
			array_push($lstUser, new User($i['id'], $i['username'], '', $i['fullname']));
		}
		return $lstUser;
	}
	public function insertUser($user)
	{
		$id = $user->getID();
		$username = $user->getUsername();
		$pw = $user->getPassword();
		$fname = $user->getFullName();
		$sql = "insert into username values($id, '$username', '$pw', '$fname')";
		$result = $this->connect->query($sql);
		return $result;
	}
} ?>