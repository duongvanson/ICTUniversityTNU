function fnGiam($id){
	document.querySelector('#sl'+$id).stepDown()
	var sl = parseInt(document.getElementById('sl'+$id).value);
	if (sl == 1) {
		alert("Số lượng đã đến giới hạn!");
	}
	tinhTien($id);
	countSum();
}
function fnTang($id){
	document.querySelector('#sl'+$id).stepUp()
	tinhTien($id);
	countSum();
}
function countSum() {
	var sl1 = parseInt(document.getElementById('sl1').value);
	var sl2 = parseInt(document.getElementById('sl2').value);
	document.getElementById('sum').innerHTML = sl1+sl2;

	var tien1 = parseInt(document.getElementById('giaTong1').value);
	var tien2 = parseInt(document.getElementById('giaTong2').value);
	document.getElementById('tongTien').value = tien1+tien2;
}
function tinhTien($id){
	var sl = parseInt(document.getElementById('sl'+$id).value);
	var gia = parseInt(document.querySelector('#gia'+$id).innerHTML);
	document.getElementById('giaTong'+$id).value = gia*sl;
}