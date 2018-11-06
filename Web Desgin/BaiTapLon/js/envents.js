function changeStyle() {
		document.getElementById("style").href="css/styles.css";
		}
// Onload check cookie
function checkCookie() {
	document.cookie="firstname=John;expires=Wed, 18 Dec 2023 12:00:00 GMT"
}
//Dang nhap he thong
function dangNhap() {
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	if (username == "admin" && password=="123456") {
		alert("Đăng nhập thành công!");
	}else if (username == "" || password == "") {
		alert("Vui lòng nhập đủ thông tin!");
	} else{
		alert("Tài khoản hoặc mật khẩu không chính xác!");
	}
}
//Dang ky he thong
function dangKy() {
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	var re_password = document.getElementById('re-password').value;
	if (username == "" || password == "" || re_password == "") {
		alert("Vui lòng nhập đủ thông tin!");
	}else
	if (username == "admin") {
		alert("Tài khoản đã tồn tại!");
	}else
	if (password != re_password) {
		alert("Mật khẩu không khớp!");
	}else{
		alert("Đăng ký thành công!");
	}
}