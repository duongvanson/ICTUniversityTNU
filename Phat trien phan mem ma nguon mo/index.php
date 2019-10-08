<!DOCTYPE html>
<html>
<head>
	<title>INDEX</title>
	<style>
		body{
			padding-top: 300px;
		}
		h1{
			text-align: center;
			height: 100%;
		}
	</style>
	<script>
		setInterval(function(){
			var x = parseInt(Math.random()*10);
			//document.write(x);
			switch(x){
				case 1: change("red"); break;
				case 2: change("blue"); break;
				case 3: change("green"); break;
				case 4: change("gray"); break;
				case 5: change("black"); break;
				case 6: change("yellow"); break;
				case 7: change("grey"); break;
				case 8: change("white"); break;
				case 9: change("red"); break;
				case 10: change("pink"); break;
				default:
				break;
			}
		},1000);
		function change(color) {
			document.getElementById('content').style.color=color;
		}
	</script>
</head>
<body>
	<h1 id="content">HỌC ĐỂ LÀM GÌ?</h1>
</body>
</html>