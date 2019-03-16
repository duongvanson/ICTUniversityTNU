<style>
    table{
        border-collapse: collapse;
    }
    table,th, tr, td{
        border: 1px solid green;
    }
</style>
<?php
    class Connect{
        public $conn;
        public function __construct() {
            $host = "localhost";
            $database = "phanphoi";
            $user = "root";
            $pass = "";
            $this->conn = new mysqli($host, $user, $pass, $database);
            mysqli_set_charset($this->conn, "utf8");
            //var_dump($this->conn);
        }
        function getDataGroupByMaSp()
        {
            $sql = "SELECT masp,tensp,dvt,SUM(soluong) as 'soluong' FROM sanpham GROUP by masp";
            $rs = $this->conn->query($sql);
            return $rs;
        }
        function deleteSP($masp)
        {
            $sql = "delete from sanpham where masp = '$masp'";
            $rs = $this->conn->query($sql);
            return $rs;
        }
    }
?>