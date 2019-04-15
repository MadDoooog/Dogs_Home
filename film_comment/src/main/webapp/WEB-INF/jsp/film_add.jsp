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
<title>film_add</title>
</head>
<body>
name<input name="name" type="text" id="name">
profile<input name="profile" type="text" id="profile">
status<input name="status" type="text" id="status">
<input type="submit" title="submit" onclick="add()">
</body>
<script type="text/javascript">
function add(){
	var name = $("#name").val();
	var profile = $("#profile").val();
	var status = $("#status").val();
	$.post("addfilm",{
		name: name,
		profile: profile,
		status: status
		},function(data){
			alert(data.msg);
		});
}
</script>
</html>