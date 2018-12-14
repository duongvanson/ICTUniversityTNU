function muahang(){
	var sl = parseInt(document.getElementById('sl').value);
	if (sl >= 10) {
		alert("Đề bài bảo >= 10 thì không cho mua ^_^");
	}else{
		var cart = document.getElementById('cart');
		var row = cart.insertRow(1);
		var name = row.insertCell(0);
		var color = row.insertCell(1);
		var quantity = row.insertCell(2);
		var price = row.insertCell(3);
		var total = row.insertCell(4);
		var del = row.insertCell(5);

		var type = document.getElementById('sltype');
		name.innerHTML = type.options[type.selectedIndex].text;
		var cl = document.getElementById('slcolor');
		color.innerHTML = cl.options[cl.selectedIndex].text;
		quantity.innerHTML = "<input min='0' onclick='thaydoi(this)' type='number' value='"+sl+"'>";
		var p = parseFloat(document.getElementById('price').innerHTML);
		price.innerHTML = p;
		price.className = "isprice";
		total.innerHTML = p*sl;
		total.className = "istotal";
		del.innerHTML = "<a href='#' onclick='xoa(this)'>X</a>";
	}
}
function xoa(row) {
	var i = row.parentNode.parentNode.rowIndex;
	document.getElementById('cart').deleteRow(i);
}
function thaydoi(elem){
	var row = elem.parentNode.parentNode;
	var price = parseFloat(row.querySelector('.isprice').innerHTML);
	row.querySelector('.istotal').innerHTML = price*parseInt(elem.value);
}