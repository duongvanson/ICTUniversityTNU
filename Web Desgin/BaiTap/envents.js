function muahang(elem,$id) {
	for (var i = 0; i < document.getElementsByClassName("hang").length; i++) {
		var hang = document.getElementById("sp"+$id);
		if (hang == null) {
		var table = document.getElementById("tblGio");
	    var row = table.insertRow(1);
	    var c1 = row.insertCell(0);
	    var c2 = row.insertCell(1);
	    var c3 = row.insertCell(2);
	    var c4 = row.insertCell(3);
	    var c5 = row.insertCell(4);
	    c1.innerHTML = elem.parentNode.querySelector(".tensp").innerHTML;
	    c1.id = "sp"+$id;
	    c2.innerHTML = "<input id='sl"+$id+"' type='number' min='0' value='1' onclick='kiemTraMua("+$id+")'>";
	    c3.innerHTML = elem.parentNode.querySelector(".tien").innerHTML;
	    c3.id = "gia"+$id;
	    c4.innerHTML = elem.parentNode.querySelector(".tien").innerHTML;
	    c4.id = "tt"+$id;
	    c5.innerHTML = "<a href='#' id='delete"+$id+"' onclick='xoaSP(this)' class='delete'> x </a>";
		}else{
			var x = parseInt(document.getElementById("sl"+$id).value)+1;
			document.getElementById('sl'+$id).value = x;
			var gia = parseInt(document.getElementById("gia"+$id).innerHTML);
			document.getElementById("tt"+$id).innerHTML = (gia * x);
		}
	}
	tongTien();
}
function tongTien() {
	var tong = 0;
	for (var i = 1; i < document.getElementById("tblGio").rows.length-1; i++) {
		tong += parseInt(document.getElementById("tblGio").rows[i].cells[3].innerHTML);
	}
	document.getElementById("ttTong").innerHTML = tong;
}
function kiemTraMua($id) {
	var gt = parseInt(document.getElementById('sl'+$id).value);
	if (gt == 1) {
		alert("Số lượng đã đến giới hạn!");
	}
	var x = parseInt(document.getElementById("sl"+$id).value);
	document.getElementById('sl'+$id).value = x;
	var gia = parseInt(document.getElementById("gia"+$id).innerHTML);
	document.getElementById("tt"+$id).innerHTML = (gia * x);
	tongTien();
}
function xoaSP(row) {
	var i = row.parentNode.parentNode.rowIndex;
	document.getElementById("tblGio").deleteRow(i);
	tongTien();
}