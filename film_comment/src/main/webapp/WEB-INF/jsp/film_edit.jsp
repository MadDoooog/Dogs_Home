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
<title>film_edit</title>
</head>
<body>
<div>
<a href="film_list">电影列表</a>
</div>
name<input name="name" type="text" id="name">
profile<input name="profile" type="text" id="profile">
createTime<input type="date" id="createTime" />
status<input name="status" type="text" id="status">
<input type="submit" title="submit" onclick="ok()">
</body>
<script type="text/javascript">
$(function(){
	var filmid = ${sessionScope.film_edit};
	$.post("editfilm",{
		id: filmid
		},function(data){
			$("#name").val(data.obj.name);
			$("#profile").val(data.obj.profile);
			$("#createTime").val(getDate(data.obj.createTime));
			$("#status").val(data.obj.status);
		});
});

function ok(){
	var name = $("#name").val();
	var profile = $("#profile").val();
	var createTime = $("#createTime").val();
	var status = $("#status").val();
	$.post("editfilmok",{
		name: name,
		profile: profile,
		createTime: createTime,
		status: status
		},function(data){
			alert(data.msg);
		});
}

function getDate(time){
	var date = new Date(time);
	var str = date.getFullYear()
    + "-"// "年"
    + ((date.getMonth() + 1) > 10 ? (date.getMonth() + 1) : "0"+ (date.getMonth() + 1))
    + "-"// "月"
    + (date.getDate() < 10 ? "0" + date.getDate() : date.getDate());
	return str;
}
</script>
</html>