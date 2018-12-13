function xemTT($xem){
	if ($xem == true) {
		document.getElementById('info').style.display = 'block';
		document.getElementById('mainlogo').style.display = 'none';
	}else{
		document.getElementById('info').style.display = 'none';
		document.getElementById('mainlogo').style.display = 'inline-block';
	}
}
function them(){
	var ten = document.getElementById('monan').value;
	var soluong = parseInt(document.getElementById('soluong').value);
	var gia = parseInt(document.getElementById('giatien').value);
	if (ten == "" || isNaN(soluong) || isNaN(gia)) {
		alert("Nhập đủ rồi thêm.");
	}else{
		var table = document.getElementById('giohang');
		var row = table.insertRow(1);
		var c1 = row.insertCell(0);
		var c2 = row.insertCell(1);
		var c3 = row.insertCell(2);
		var c4 = row.insertCell(3);
		var c5 = row.insertCell(4);
		c1.innerHTML = ten;
		c2.innerHTML = "<input type='number' name='sl' class='sluong' value='"+soluong+"' onclick='thayDoi(this)' min='0'/>";
		c3.innerHTML = gia;
		c3.className = "gia";
		c4.innerHTML = soluong*gia;
		c4.className = "thanhtien";
		c5.innerHTML = "<a href='#' onclick='xoaSP(this)'>X</a>";
	}
	tongTien()
}
function thayDoi(element){
	var row = element.parentNode.parentNode;
	var sl = parseInt(row.querySelector('.sluong').value);
	var gia = parseInt(row.querySelector('.gia').innerHTML);
	row.querySelector('.thanhtien').innerHTML = sl*gia;
	tongTien()
}
function xoaSP(row) {
	var i = row.parentNode.parentNode.rowIndex;
	document.getElementById("giohang").deleteRow(i);
	tongTien()
}
function tongTien(){
	var tien = 0;
	var table = document.getElementById("giohang");
	for (var i = 1; i < table.rows.length-1; i++) {
		var tt = parseInt(table.rows[i].cells[3].innerHTML);
		tien += tt;
		//alert(table.rows[i]);
	}
	document.getElementById("tongtien").innerHTML = tien;
}