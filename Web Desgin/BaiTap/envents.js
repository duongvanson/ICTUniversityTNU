function muahang($id) {
	var h1 = document.getElementById("sp1");
	var h2 = document.getElementById("sp2");
	if ($id == 1) {
	if(h1 === null || h1 === undefined){
		var table = document.getElementById("tblGio");
	    var row = table.insertRow(1);
	    var c1 = row.insertCell(0);
	    var c2 = row.insertCell(1);
	    var c3 = row.insertCell(2);
	    var c4 = row.insertCell(3);
	    var c5 = row.insertCell(4);
	    c1.innerHTML = "Sản phẩm 1";
	    c1.id = "sp1";
	    c2.innerHTML = "<input id='sl1' type='number' min='0' value='1' onclick='kiemTraMua(1)'>";
	    c3.innerHTML = "10000";
	    c3.id = "gia1";
	    c4.innerHTML = "10000";
	    c4.id = "tt1";
	    c5.innerHTML = "<a href='#' id='delete1' onclick='xoaSP(this)' class='delete'> x </a>";
		}
	}
	if ($id == 2) {
	if(h2 === null || h2 === undefined){
		var table = document.getElementById("tblGio");
	    var row = table.insertRow(1);
	    var c1 = row.insertCell(0);
	    var c2 = row.insertCell(1);
	    var c3 = row.insertCell(2);
	    var c4 = row.insertCell(3);
	    var c5 = row.insertCell(4);
	    c1.innerHTML = "Sản phẩm 2";
	    c1.id = "sp2";
	    c2.innerHTML = "<input id='sl2' type='number' min='0' value='1' onclick='kiemTraMua(2)'>";
	    c3.innerHTML = "15000";
	    c3.id = "gia2";
	    c4.innerHTML = "15000";
	    c4.id = "tt2";
	    c5.innerHTML = "<a href='#' id='delete2' onclick='xoaSP(this)' class='delete'> x </a>";
		}
	}
	var x = parseInt(document.getElementById("sl"+$id).value)+1;
	document.getElementById('sl'+$id).value = x;
	var gia = parseInt(document.getElementById("gia1").innerHTML);
	document.getElementById("tt"+$id).innerHTML = (gia * x);
	tongTien();
}
function tongTien() {
	var h1 = document.getElementById("tt1");
	var h2 = document.getElementById("tt2");
	var x1 = 0;
	var x2 = 0;
	if(h1 === null || h1 === undefined) {
		if (h2=== null || h2 === undefined) {
			document.getElementById("ttTong").innerHTML	 = 0;
		}
		else{
			x2 = parseInt(document.getElementById("tt2").innerHTML);
			document.getElementById("ttTong").innerHTML	 = x2;
		}
	}else{
		if (h2=== null || h2 === undefined) {
			x1 = parseInt(document.getElementById("tt1").innerHTML);
			document.getElementById("ttTong").innerHTML	 = x1;
		}
		else{
			x1 = parseInt(document.getElementById("tt1").innerHTML);
			x2 = parseInt(document.getElementById("tt2").innerHTML);
			document.getElementById("ttTong").innerHTML	 = x1+x2;
		}
	}
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