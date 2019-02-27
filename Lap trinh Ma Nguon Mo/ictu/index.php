<?php include_once 'connectdb.php';?>
<?php
    $where = "sv.masv = ct.masv";
    if(isset($_GET['search']))
    {
        $search = $_GET['search'];
        $key = $_GET['key'];
        if(!empty($search))
        {
            $where = $where." AND sv.".$key." LIKE '%".$search."%'";
        }
    }
    $sql = "select sv.masv,sv.tensv,sv.ngaysinh,sv.gioitinh,sv.quequan,ct.email,ct.sdt,ct.avatar,ct.facebook
    from sinhvien as sv, chitietsinhvien as ct
    WHERE ".$where;
    $query_sv = mysqli_query($conn, $sql);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>ICTU</title>
    <style>
        table,th,tr,td{
            border: 1px solid green;
            padding: 5px;
        }
        table{
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<form action="index.php" method="GET">
        <select name="key">
            <option value="masv">Mã sinh viên</option>
            <option value="tensv">Tên sinh viên</option>
            <option value="gioitinh">Giới tính</option>
            <option value="quequan">Quê quán</option>
        </select>
        <input type="text" name="search">
        <label for="#"></label><input type="submit" value="Tìm kiếm">
</form>
<hr>
<table>
    <th>Mã sinh viên</th>
    <th>Tên sinh viên</th>
    <th>Ngày sinh</th>
    <th>Giới tính</th>
    <th>Quê quán</th>
    <th>Email</th>
    <th>SDT</th>
    <th>Avatar</th>
    <th>Facebook</th>
<?php
    while($data = mysqli_fetch_assoc($query_sv))
    {
        echo "<tr>"
        ."<td>".$data['masv']."</td>"
        ."<td>".$data['tensv']."</td>"
        ."<td>".$data['ngaysinh']."</td>"
        ."<td>".$data['gioitinh']."</td>"
        ."<td>".$data['quequan']."</td>"
        ."<td>".$data['email']."</td>"
        ."<td>".$data['sdt']."</td>"
        ."<td>".$data['avatar']."</td>"
        ."<td>".$data['facebook']."</td>"
        ."</tr>";
    }
?>
</table>
</body>
</html>