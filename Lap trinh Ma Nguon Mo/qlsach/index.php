<?php
    include("connect.php");
    $db = new Connect();
    $data = "vsond";
    if(isset($_POST["data"])){
        $data = trim($_POST["data"]);
        if(!empty($data)){
            $rs = $db->search($data);
            echo "<h4 class='search'>Kết quả tìm kiếm cho:'".$data."'</h4>";
        }
    }else{
        $rs = $db->getAll();
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>quản lý sách</title>
    <style>
        table{
            border-collapse: collapse;
            margin: 10px 0px;
        }
        table,th, tr, td{
            border: 1px solid green;
            padding: 5px;
        }
    </style>
</head>
<body>
    <form action="index.php" method="POST">
        <input type="text" name="data">
        <input type="submit" value="Tìm kiếm">
    </form>
    <?php
        if(empty($data)){
            echo "<h4 class='search'> Vui lòng nhập từ khóa!</h4>";
            exit();
        }
    ?>
    <table>
        <tr>
            <th>Mã sách</th>
            <th>Tên sách</th>
            <th>Tên NXB</th>
            <th>Năm XB</th>
            <th>Tác giả</th>
            <th>Mô tả</th>
            <th>Thay đổi</th>
        </tr>
        <?php
            while($i = $rs->fetch_assoc()){
        ?>
        <tr>
                <td><?php echo $i["mas"] ?></td>
                <td><?php echo $i["tens"] ?></td>
                <td><?php echo $i["tennxb"] ?></td>
                <td><?php echo $i["namxb"] ?></td>
                <td><?php echo $i["tacgia"] ?></td>
                <td><?php echo $i["mota"] ?></td>
                <td>
                    <a href="edit.php?mas=<?php echo $i['mas'] ?>">Sửa</a>
                </td>
        </tr>
        <?php } ?>
    </table>
</body>
</html>