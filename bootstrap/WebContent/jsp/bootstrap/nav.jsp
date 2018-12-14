<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--[if lt IE 9]>
   <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
   <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<![endif]-->
<title>导航元素</title>
<link href="../../asset/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
</head>
<body>
	<div class="container">
		<p>标签式的导航菜单</p>
		<ul class="nav nav-tabs">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">SVN</a></li>
			<li><a href="#">IOS</a></li>
			<li><a href="#">VB.NET</a></li>
			<li><a href="#">JAVA</a></li>
			<li><a href="#">PHP</a></li>
		</ul>
	</div>
	<div class="container">
		<p>胶囊式导航菜单</p>
		<ul class="nav nav-pills">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">SVN</a></li>
			<li><a href="#">IOS</a></li>
			<li><a href="#">VB.NET</a></li>
			<li><a href="#">JAVA</a></li>
			<li><a href="#">PHP</a></li>
		</ul>
	</div>
	<div class="container">
		<p>垂直的胶囊式导航菜单</p>
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">SVN</a></li>
			<li><a href="#">IOS</a></li>
			<li><a href="#">VB.NET</a></li>
			<li><a href="#">JAVA</a></li>
			<li><a href="#">PHP</a></li>
		</ul>
	</div>
	
	<div class="container">
		<p>两端对齐的导航</p>
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">SVN</a></li>
			<li><a href="#">IOS</a></li>
			<li><a href="#">VB.NET</a></li>
			<li><a href="#">JAVA</a></li>
			<li><a href="#">PHP</a></li>
		</ul>
	</div>
	<div class="container">
		<p>两端对齐的导航</p>
		<ul class="nav nav-tabs nav-justified">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">SVN</a></li>
			<li><a href="#">IOS</a></li>
			<li><a href="#">VB.NET</a></li>
			<li><a href="#">JAVA</a></li>
			<li><a href="#">PHP</a></li>
		</ul>
	</div>
	<div class="container">
		<p>禁用链接</p>
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">HTML</a></li>
			<li class="disabled"><a href="#">CSS</a></li>
			<li><a href="#">JavaScript</a></li>
			<li><a href="#">Java</a></li>
			<li><a href="#">MySQL</a></li>
			<li><a href="#">Oracle</a></li>
			<li><a href="#">myBatis</a></li>
		</ul>
	</div>
	<div class="container">
		<p>带有下拉菜单的标签</p>
		<ul class="nav nav-pills">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">HTML</a></li>
			<li><a href="#">CSS</a></li>
			<li><a href="#">JavaScript</a></li>
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Java<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">EJB</a></li>
					<li><a href="#">Applet</a></li>
					<li><a href="#">Swing</a></li>
					<li class="divider"></li>
					<li><a href="#">分离的链接</a></li>
				</ul>
			</li>
			
		</ul>
	</div>
	
	<div class="container">
		<p>动态标签</p>
		<ul class="nav nav-pills">
			<li class="active"><a href="#home" data-toggle="tab">首页</a></li>
			<li><a href="#menu1" data-toggle="tab">菜单1</a></li>
			<li><a href="#menu2" data-toggle="tab">菜单2</a></li>
			<li><a href="#menu3" data-toggle="tab">菜单3</a></li>
		</ul>
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<h3>首页</h3>
			</div>
			<div id="menu1" class="tab-pane fade">
				<h3>菜单1</h3>
			</div>
			<div id="menu2" class="tab-pane fade">
				<h3>菜单2</h3>		
			</div>
			<div id="menu3" class="tab-pane fade">
				<h3>菜单3</h3>		
			</div>
		</div>
	</div>
	<script src="../../asset/jquery-2.1.4/jquery.min.js"></script>
	<script src="../../asset/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
	</script>
</body>
</html>



