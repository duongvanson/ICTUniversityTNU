function muahang(elem) {
	var product = elem.parentNode;
	var cart = document.getElementById('cart');
	var row = cart.insertRow(1);
	var name = row.insertCell(0);
	var price = row.insertCell(1);
	var img = row.insertCell(2);
	var amount = row.insertCell(3);

	name.innerHTML = product.querySelector('.namepd').innerHTML;
	price.innerHTML = "<p>$<span>"+product.querySelector('span').innerHTML+"</span></p>";
	img.innerHTML = "<img class='iconcart'>";
	amount.innerHTML = "<input type='number' onclick='thaydoi(this)' value='1'/> <br> <a onclick='xoa(this)' href='#'>X</a>";
	
	//product.querySelector('.btnadd').disabled = true;
	product.style.opacity = "0.5";
}
function xoa(elem){
	var index = (elem.parentNode.parentNode).rowIndex;
	document.querySelector("#cart").deleteRow(index);
}
function thaydoi(elem){
	if (parseInt(elem.value) == 0) {
		xoa(elem);
	}
}