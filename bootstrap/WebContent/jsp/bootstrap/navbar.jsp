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
<title>导航栏</title>
<link href="../../asset/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
</head>
<body>
	<h2>默认导航栏</h2>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">菜鸟教程</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li><a href="#">IOS</a></li>
					<li><a href="#">PHP</a></li>
					<li><a href="#">.NET</a></li>
					<li><a href="#">Python</a></li>
					<li><a href="#">Oracle</a></li>
					<li><a href="#">HTML</a></li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">JAVA<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">JSP</a></li>
							<li><a href="#">EJB</a></li>
							<li><a href="#">Swing</a></li>
							<li class="divider"></li>
							<li><a href="#">Servlet</a></li>
							<li class="divider"></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<h2>响应式导航栏</h2>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse">
					<span class="sr-only">导航切换</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">菜鸟教程</a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">ios</a></li>
					<li><a href="#">SVN</a></li>
					<li><a href="#">GIT</a></li>
					<li><a href="#">ClearCase</a></li>
					<li><a href="#">Maven</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Java<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">jemeter</a></li>
							<li><a href="#">EJB</a></li>
							<li><a href="#">Jasper Report</a></li>
							<li class="divider"></li>
							<li><a href="#">分割线1</a></li>
							<li class="divider"></li>
							<li><a href="#">分割线2</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<h2>导航栏中的表单</h2>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header"><a class="navbar-brand">菜鸟教程</a></div>
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search"></input>
					<button type="submit" class="btn btn-default">提交按钮</button>
				</div>
				<button type="button" class="btn btn-default navbar-btn">导航栏按钮</button>
			</form>
		</div>
	</nav>
	
	<h2>导航栏中的文本</h2>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">菜鸟教程</a>
			</div>
			<div>
				<p class="navbar-text">文本1</p>
				<p class="navbar-text">文本2</p>
			</div>
		</div>
	</nav>
	
<script src="../../asset/jquery-2.1.4/jquery.min.js"></script>
<script src="../../asset/bootstrap/js/bootstrap.js"></script>
</body>
</html>



