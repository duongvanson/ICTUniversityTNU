<?php
    include("connect.php");
    $db = new Connect();
    if(isset($_GET["mas"])){
        $rs = $db->getSach($_GET["mas"]);
    }
    if(isset($_POST["mas"])){
        $e = $db->editSach($_POST["mas"],$_POST["tens"], $_POST["tennxb"], $_POST["namxb"], $_POST["tacgia"], $_POST["mota"]);
        if($e){
            header("location: index.php");
        }else{
            echo "Edit error";
        }
    }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sửa sách</title>
    <style>
        label{
            width: 80px;
            display: inline-block;
        }
        div{
            margin: 5px;
        }
    </style>
</head>
<body>
    <?php
        if($rs){
            while($i = $rs->fetch_assoc()){
    ?>
    <form action="edit.php" method="POST">
        <div><label for="">Mã: </label><input type="text" name="mas" value="<?php echo $i['mas'] ?>"></div>
        <div><label for="">Tên: </label><input type="text" name="tens" value="<?php echo $i['tens'] ?>"></div>
        <div><label for="">Nhà XB: </label><input type="text" name="tennxb" value="<?php echo $i['tennxb'] ?>"></div>
        <div><label for="">Năm XB: </label><input type="text" name="namxb" value="<?php echo $i['namxb'] ?>"></div>
        <div><label for="">Tác giả: </label><input type="text" name="tacgia" value="<?php echo $i['tacgia'] ?>"></div>
        <div><label for="">Mô tả: </label><input type="text" name="mota" value="<?php echo $i['mota'] ?>"></div>
        <div><label for=""></label><input type="submit" value="Lưu"></div>
    </form>
            <?php } } ?>
</body>
</html>