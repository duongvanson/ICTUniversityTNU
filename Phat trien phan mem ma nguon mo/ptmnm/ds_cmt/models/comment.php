<?php /**
 * 
 */
class Comment
{
	private $id, $title, $fullname, $email, $content;
	function __construct($id, $title, $fullname, $email, $content)
	{
		$this->id = $id;
		$this->title = $title;
		$this->email = $email;
		$this->fullname = $fullname;
		$this->content = $content;
	}
	public function getID()
	{
		return $this->id;
	}
	public function getTitle()
	{
		return $this->title;
	}
	public function getFullName()
	{
		return $this->fullname;
	}
	public function getEmail()
	{
		return $this->email;
	}
	public function getContent()
	{
		return $this->content;
	}
} ?>