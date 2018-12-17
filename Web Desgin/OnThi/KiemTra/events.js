function muahang(btn, $id){
		var sp = document.getElementById("spmua"+$id);
		if (sp == null) {
			var cart = document.getElementById("cart");
			var hang = cart.insertRow(1);
			hang.id = "spmua"+$id;
			var ten = hang.insertCell(0);
			ten.innerHTML = btn.parentNode.querySelector(".ten").innerHTML;

			var gia = hang.insertCell(1);
			gia.innerHTML = btn.parentNode.querySelector(".gia").innerHTML;
			gia.className = "giamua";

			var soluong = hang.insertCell(2);
			soluong.innerHTML = "<input class='slmua' type='number' min='0' value='1' onclick='tanggiam(this)'>";

			var thanhtien = hang.insertCell(3);
			thanhtien.innerHTML = btn.parentNode.querySelector(".gia").innerHTML;
			thanhtien.className = "thanhtienmua";

			var xoa = hang.insertCell(4);
			xoa.innerHTML = "<a onclick='xoa(this)' href='#'>X</a>";
		}else{
			sp.querySelector(".slmua").value = parseInt(sp.querySelector(".slmua").value) + 1;
			var gia = parseInt(sp.querySelector(".giamua").innerHTML);
			var soluong = parseInt(sp.querySelector(".slmua").value);
			sp.querySelector(".thanhtienmua").innerHTML = gia*soluong;
		}
		tongtien();
	}
function tongtien(){
	var tong  =0;
	var cart = document.getElementById("cart");
	for (var i = 1; i < cart.rows.length-1; i++) {
		tong += parseInt(cart.rows[i].cells[3].innerHTML);
	}
	document.getElementById("tongthanhtien").innerHTML = tong;
}
function xoa(btn){
	var cart = document.getElementById("cart");
	cart.deleteRow(btn.parentNode.parentNode.rowIndex);
	tongtien();
}
function tanggiam(inp){
	var hang = inp.parentNode.parentNode;
	var sl = parseInt(inp.value);
	var gia = parseInt(hang.querySelector(".giamua").innerHTML);
	hang.querySelector(".thanhtienmua").innerHTML = sl*gia;
	tongtien();
}