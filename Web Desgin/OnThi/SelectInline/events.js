function chonmau(mau) {
	var lc = mau.className;
	if (!lc.includes("activecolor")) {
		mau.className = mau.className + " activecolor";
	}
	//console.log(mau.className);
	var cha = mau.parentNode.parentNode;
	var lis = cha.querySelectorAll("li");
	for (var i = 0; i < lis.length; i++) {
		//console.log(lis[i] != mau);
		if(lis[i] != mau){
			lis[i].className = lis[i].className.replace(" activecolor","");
			//console.log(lis[i].className);
		}
	}
	console.log(mau.querySelector("span").innerHTML);
	var x = mau.className;
	x = x.replace("color","");
	x = x.replace("activecolor","");
	x = x.trim();
	console.log(x)
}
function chonsize(size){
	var lc = size.className;
	if (!lc.includes("activesize")) {
		size.className = size.className+" activesize";
	}
	var lis = size.parentNode.parentNode.querySelectorAll("li");
	for (var i = 0; i < lis.length; i++) {
		if(lis[i] != size){
			lis[i].className = lis[i].className.replace(" activesize","");
		}
	}
}