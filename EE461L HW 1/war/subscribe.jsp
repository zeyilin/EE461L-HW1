<!-- 
Kassidy Knight and Zeyi Lin
EE461L HW 1
Last updated 9/23/2016
-->

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="ee461lblog.Post"%>
<%@ page import="ee461lblog.BlogPostsServlet"%>
<%@ page import="ee461lblog.Subscriber"%>
<%@ page import="ee461lblog.SubscriptionServlet"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Collections"%>
<%@ page import="com.googlecode.objectify.*"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Santander | A Travel Blog</title>
<!-- Bootstrap Core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Theme CSS -->
<link href="clean_blog/css/clean-blog.min.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="clean_blog/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> Menu <i
						class="fa fa-bars"></i>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp">Home</a></li>
                    <li> <a href="subscribe.jsp">Subscribe</a></li>
                    <li><a href="newpost.jsp">New Post</a></li>
                </ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('clean_blog/img/santander.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading">
						<h1>Santander</h1>
						<hr class="small">
						<span class="subheading">A Travel Blog by Kassidy Knight &
							Zeyi Lin</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	<div class="container">
    <div class="row">
		<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
			<div class="post-preview">
				<h3>Subscribe to our newsletter! Get the latest posts from the past 24 hours. Or feel free to unsubscribe.</h3>			
			    <form action="/sub" method="POST">
					<div><h4 class="post-title">Email Address</h4></div>
					<div><textarea name="email" rows = "1" cols = "60"></textarea></div>
					<br>
					<div><input type="submit" value="Subscribe" /></div>
					<br>
					<div><input type="submit" value="Unsubscribe" /></div>
					<br>
			    </form>
			</div>
		</div>
	</div>
</div>