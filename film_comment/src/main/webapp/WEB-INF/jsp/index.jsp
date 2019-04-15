<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js">
</script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js">
</script>
<title>首页</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	$.post("index/movies",function(data){
		var list = data.list;
		for(var temp = 1; temp < 6; temp++){
			var str = "#"+temp;
			var content = "<a href='user_filmInfo_"+list[temp-1].id+"'>"+list[temp-1].name+"</a>";
			$(str).html(content);
		}
	});
});
</script>
<div>title</div>
<div>滚动条</div>
<div>分区</div>
<div>分区</div>
<div id="1">1</div>
<div id="2">2</div>
<div id="3">3</div>
<div id="4">4</div>
<div id="5">5</div>

</body>
</html>