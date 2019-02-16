function showhang(){
    document.getElementById("muahang").style.display = "block";
}
function show(s){
    var soluongmua = parseInt(document.getElementById("soluongmua").innerHTML);
    if(soluongmua == 0){
        document.getElementById('null').style.display = "block";
    }else{
        document.getElementById('null').style.display = "none";
    }
    if (s == 1) {
        document.getElementById("muahang").style.display = "block";
    }else{
        document.getElementById("muahang").style.display = "none";
    }
}
function muahang(e, $id){
    var idmua = document.getElementById("mua"+$id);
    var soluong = document.getElementById("soluongmua");
    var soluongmua = parseInt(soluong.innerHTML);
    soluong.innerHTML = soluongmua+1 +"";
    if (idmua == null) {
        //Lấy thông tin
        var info = e.parentNode;
        var img = info.querySelector('img').src;
        var ten = info.querySelector('h2').innerHTML;
        var gia = info.querySelector('span').innerHTML;
        //
        var gio = document.getElementById("gio");
        var hang = gio.insertRow(0);
        hang.id = "mua"+$id;
        var anh = hang.insertCell(0);
        anh.width="35%";
        var thongtin = hang.insertCell(1);
        thongtin.width="50%";
        var xoa = hang.insertCell(2);
        anh.innerHTML = "<img class='anhsanpham' src='"+img+"'>";
        thongtin.innerHTML = 
        "<h2>"+ten+"</h2>"+
        "<p>Giá: <span class='gia'>"+gia+"</span></p>"+
        "<p>Số lượng: <span class='sl'>1</span></p>";
        xoa.innerHTML = "<a class='xoa' href='#' onclick='xoa(this,"+$id+")'>Xóa</a>";
        xoa.width="15%";
    }else{
        var hang = idmua.parentNode;
        var sl = parseInt(hang.querySelector('.sl').innerHTML);
        hang.querySelector('.sl').innerHTML = sl+1;
    }
}
function xoa(e,$id){
    var soluong = document.getElementById("soluongmua");
    var soluongmua = parseInt(soluong.innerHTML);
    var hang = e.parentNode.parentNode;
    var sl = parseInt(hang.querySelector('.sl').innerHTML);
    soluong.innerHTML = (soluongmua-sl) + "";

    document.getElementById("gio").deleteRow(hang.rowIndex);
}