<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.testwymb.com" prefix="permission"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
<link rel="stylesheet" href="/authority/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="/authority/resources/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="/authority/resources/js/layer/skin/default/layer.css" />
<link rel="stylesheet"
	href="/authority/resources/js/bootstrap-table/bootstrap-table.css" />

</head>
<body>
	<div style="margin-left: auto; margin-right: auto; width: 95%">
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div style="position: absolute; top: 15px" id="btns">
						<permission:each items="${sessionScope.loginUser.permissionList }" type="permission" var="permission">
							<a href="#" class="btn ${permission.color } btn-sm" data-code="${permission.code }"> 
								<i class="${permission.icon }"></i>${permission.name}
							</a>
						</permission:each>
					</div>
					<table id="table"></table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../common.jsp"%>
	<script src="/authority/resources/js/permission/list.js"></script>
</body>
</html>