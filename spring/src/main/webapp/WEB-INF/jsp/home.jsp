<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin: 80px auto;width: 50%;height: 50%">
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit" value="上传">
	</form>
	<div><img alt="" src="${url }"></div>
</div>

<script src="/spring/asset/js/jquery-1.11.3.js"></script>
<script>
	$(function(){
		
		
		
		var setting = {
			url:"upload",
			type:"post",
			success:function(res){
				alert(res);
			},
			error:function(){
				alert("上传失败");
			}
		};
		
		$('#upload').click(function(){
			$.ajax(setting);
		})
	})
</script>
</body>
</html>