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
<title>filmInfo</title>
</head>
<body>
<label id="id" hidden="true"></label>
<label id="name"></label>
<label id="profile"></label>
<div id="labels"></div>
<table id="tab">
<tr></tr>
</table>
</body>
<script type="text/javascript">
$(function(){
	var tab = document.getElementById("tab");
	var colsNum=tab.rows.item(0).cells.length;
	var num=tab.rows.length;
	$.post("filmInfo",function(data){
		if(data.msg=="success"){
			var film = data.obj;
			$("#id").html(film.id);
			$("#name").html(film.name);
			$("#profile").html(film.profile);
			
			var labels = data.list[0];
			var labelsContent = "";
			if(labels!=null&&labels.length>0){
				for(var i=0; i<labels.length; i++){
					labelsContent += "<a href='#' style='color:red'>"+labels[i].name+labels[i].color+labels[i].num+"</a>";
				}
			}else{
				labelsContent = "还没有标签哦，试着打一个标签看看";
			}
			$("#labels").html(labelsContent);
			
			var comments = data.list[1];
			var tabsContent = "";
			if(comments!=null&&comments.length>0){
				for(var i=0; i<comments.length; i++){
					//labelsContent += "<a href='#' style='color:red'>"+comments[i].name+comments[i].color+comments[i].num+"</a>";
				}
			}else{
				tabsContent = "还没有评论！试着发表你的评论";
			}
			var tab = document.getElementById("tab");
			tab.insertRow(1);
			tab.rows[1].insertCell(0);
			tab.rows[1].cells[0].innerHTML=tabsContent;
		}
	});
});
</script>
</html>