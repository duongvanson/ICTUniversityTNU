function muahang(elem, $id) {
	var idpd = document.getElementById('product'+$id);
	if (idpd == null) {
		var product = elem.parentNode;
		var cart = document.getElementById('cart');
		var row = cart.insertRow(1);
		row.id = "product"+$id;
		var name = row.insertCell(0);
		var price = row.insertCell(1);
		var img = row.insertCell(2);
		var amount = row.insertCell(3);

		name.innerHTML = product.querySelector('.namepd').innerHTML;
		price.innerHTML = "<p>$<span>"+product.querySelector('span').innerHTML+"</span></p>";
		img.innerHTML = "<img class='iconcart'>";
		img.className = "iconcarttd"
		amount.innerHTML = "<input type='number' onclick='thaydoi(this)' value='1'/> <br> <a onclick='xoa(this)' href='#'>X</a>";
		
		//product.querySelector('.btnadd').disabled = true;
		//product.style.opacity = "0.5";
	}else{
		idpd.cells[3].querySelector('input').value = parseInt(idpd.cells[3].querySelector('input').value) + 1;
	}
	addEvent();
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
function addEvent(){
	var arr = document.getElementsByClassName('product');
	for (var i = 0; i < arr.length; i++) {
		arr[i].onmouseover = function(){
			if (document.getElementById("product"+this.id)!= null) {
				this.style.opacity = "0.5";
			}
		};
		arr[i].onmouseout = function(){
			this.style.opacity = "1.0";
		};
	}
}