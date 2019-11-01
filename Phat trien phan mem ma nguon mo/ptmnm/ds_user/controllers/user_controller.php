<?php /**
 * 
 */
class UserControl
{
	private $userModel = null;
	function __construct()
	{
		include 'models/user_model.php';
		$this->userModel = new UserModel();
	}
	public function getAllUser()
	{
		$result = $this->userModel->getAllUser();
		if ($result) {
			$_SESSION['lstUser'] = $result;
		}
	}
	public function getByID($id)
	{
		$result = $this->userModel->getByID();
		return $result;
	}
	public function insertUser($data)
	{
		$user = new User(0, $data['username'], $data['password'], $data['fullname']);
		$result = $this->userModel->insertUser($user);
		if ($result) {
			header('location: index.php');
		}else{
			echo "Insert not success!";
		}
	}
} ?>