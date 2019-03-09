<?php
    class Connect{
        public $conn;
        public function __construct() {
            $host = "localhost";
            $database = "qlsach";
            $user = "root";
            $pass = "";
            $this->conn = new mysqli($host, $user, $pass, $database);
            mysqli_set_charset($this->conn, "utf8");
        }
        public function getAll()
        {
            $sql = "select * from sach";
            $rs = $this->conn->query($sql);
            return $rs;
        }
        public function search($data)
        {
            $sql = "select * from sach where mas like '%".$data."%'"
                    ."or tens like '%".$data."%'"
                    ."or tennxb like '%".$data."%'"
                    ."or namxb like '%".$data."%'"
                    ."or tacgia like '%".$data."%'"
                    ."or mota like '%".$data."%'";
            $rs = $this->conn->query($sql);
            return $rs;
        }
        public function getSach($mas)
        {
            $sql = "select * from sach where mas='".$mas."'";
            $rs = $this->conn->query($sql);
            return $rs;
        }
        public function editSach($mas, $tens, $tennxb, $namxb, $tacgia, $mota)
        {
            $sql = "update sach set tens='$tens',tennxb='$tennxb', namxb='$namxb', tacgia='$tacgia', mota='$mota' where mas='$mas'";
            $rs = $this->conn->query($sql);
            return $rs > 0;
        }
    }
?>