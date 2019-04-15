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
<title>film_list</title>
</head>
<body>
<table id="tab">
	<tr>
		<td hidden="true"><label>id</label></td>
		<td><label>name</label></td>
		<td><label>profile</label></td>
		<td><label>createTime</label></td>
		<td><label>status</label></td>
	</tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
	<tr></tr>
</table>
</body>
<script type="text/javascript">
$(function(){
	var arr = ["name","profile","createTime","status"];
	var tab = document.getElementById("tab");
	var colsNum=tab.rows.item(0).cells.length;
	var num=tab.rows.length;
	//alert(JSON.stringify(num));
	$.post("listfilm",function(data){
			if(data.msg=="success"){
				var list = data.list;
				for(var i=0; i<list.length; i++){
					list[i].createTime=getDate(list[i].createTime);
				}
				var datanum = list.length;
				if(datanum<10){	
				}else{
					datanum = 10;
				}
				tab.insertRow(datanum); //插入数据数的单元格
				for(var j=1;j<=datanum;j++){
			        for(var i=0;i<colsNum-1; i++){
			            tab.rows[j].insertCell(i);//插入列
			            tab.rows[j].cells[i].innerHTML="<a href='film_edit_"+list[j-1].id+"'>"+list[j-1][arr[i]]+"</a>";
			        }
				}
			}else{
				tab.insertRow(1);
				tab.rows[1].insertCell(1);
				tab.rows[1].cells[0].innerHTML="没有数据，请检查你的网络或与管理员联系！";
			}
		});
});

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