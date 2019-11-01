<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Profile Mananger</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<table>
		<tr> 
			<th>ID</th>
			<th>USER NAME</th>
			<th>FULL NAME</th>
			<th>DATE CREATED</th>
		</tr>
		<?php if ($result) {
			for($i = 0; $i < count($result); $i++){
				$user = $result[$i];
				?>
		<tr>
			<td><?php echo $user->getID()?></td>
			<td><?php echo $user->getUsername() ?></td>
			<td><?php echo $user->getFullName() ?></td>
			<td><?php echo $user->getDateCreated() ?></td>
		</tr>
		<?php 
		}
		} ?>
	</table>
</body>
</html>