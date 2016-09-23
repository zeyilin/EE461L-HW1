<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
      <link href="clean_blog/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
      <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
      <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
  </head>

  <body>
      <!-- Navigation -->
      <nav class="navbar navbar-default navbar-custom navbar-fixed-top">
          <div class="container-fluid">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header page-scroll">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                      <span class="sr-only">Toggle navigation</span>
                      Menu <i class="fa fa-bars"></i>
                  </button>
              </div>

              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav navbar-right">
                      <li><a href="index.jsp">Home</a></li>
                      <li><a href="login">Login</a></li>
                      <li> <a href="subscribe.html">Subscribe</a></li>
                      <li><a href="newpost.jsp">New Post</a></li>
                  </ul>
              </div>
              <!-- /.navbar-collapse -->
          </div>
          <!-- /.container -->
      </nav>

      <!-- Page Header -->
      <!-- Set your background image for this header on the line below. -->
      <header class="intro-header" style="background-image: url('clean_blog/img/santander.jpg')">
          <div class="container">
              <div class="row">
                  <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                      <div class="site-heading">
                          <h1>Santander</h1>
                          <hr class="small">
                          <span class="subheading">A Travel Blog by Kassidy Knight & Zeyi Lin</span>
                      </div>
                  </div>
              </div>
          </div>
      </header>

      <!-- Main Content -->
      <div class="container">
          <div class="row">
              <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                  <div class="post-preview">
                      <a href="clean_blog/post.html">
                          <h2 class="post-title">
                              Man must explore, and this is exploration at its greatest
                          </h2>
                          <h3 class="post-subtitle">
                              Problems look mighty small from 150 miles up
                          </h3>
                      </a>
                      <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on September 24, 2014</p>
                  </div>
                  <hr>
                  <div class="post-preview">
                      <a href="clean_blog/post.html">
                          <h2 class="post-title">
                              I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.
                          </h2>
                      </a>
                      <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on September 18, 2014</p>
                  </div>
                  <hr>
                  <div class="post-preview">
                      <a href="clean_blog/post.html">
                          <h2 class="post-title">
                              Science has not yet mastered prophecy
                          </h2>
                          <h3 class="post-subtitle">
                              We predict too much for the next year and yet far too little for the next ten.
                          </h3>
                      </a>
                      <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on August 24, 2014</p>
                  </div>
                  <hr>
                  <div class="post-preview">
                      <a href="clean_blog/post.html">
                          <h2 class="post-title">
                              Failure is not an option
                          </h2>
                          <h3 class="post-subtitle">
                              Many say exploration is part of our destiny, but it’s actually our duty to future generations.
                          </h3>
                      </a>
                      <p class="post-meta">Posted by <a href="#">Start Bootstrap</a> on July 8, 2014</p>
                  </div>
                  <hr>
                  <!-- Pager -->
                  <ul class="pager">
                      <li class="next">
                          <a href="#">See All Posts &rarr;</a>
                      </li>
                  </ul>
              </div>
          </div>
      </div>

      <hr>

      <!-- jQuery -->
      <script src="clean_blog/vendor/jquery/jquery.min.js"></script>

      <!-- Bootstrap Core JavaScript -->
      <script src="bootstrap/js/bootstrap.min.js"></script>

      <!-- Contact Form JavaScript -->
      <script src="clean_blog/js/jqBootstrapValidation.js"></script>
      <script src="clean_blog/js/contact_me.js"></script>

      <!-- Theme JavaScript -->
      <script src="clean_blog/js/clean-blog.min.js"></script>

  </body>

  <body>

<%
    String guestbookName = request.getParameter("guestbookName");
    if (guestbookName == null) {
        guestbookName = "default";
    }
    pageContext.setAttribute("guestbookName", guestbookName);
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
      pageContext.setAttribute("user", user);
%>
<p>Hello, ${fn:escapeXml(user.nickname)}! (You can
<a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">sign out</a>.)</p>
<%
    } else {
%>
<p>Hello!
<a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign in</a>
to include your name with greetings you post.</p>
<%
    }
%>

<%
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Key guestbookKey = KeyFactory.createKey("Guestbook", guestbookName);
    // Run an ancestor query to ensure we see the most up-to-date
    // view of the Greetings belonging to the selected Guestbook.

    Query query = new Query("Greeting", guestbookKey).addSort("date", Query.SortDirection.DESCENDING);
    List<Entity> greetings = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(5));
    if (greetings.isEmpty()) {
        %>
        <p>Guestbook '${fn:escapeXml(guestbookName)}' has no messages.</p>
        <%
    } else {
        %>
        <p>Messages in Guestbook '${fn:escapeXml(guestbookName)}'.</p>
        <%
        for (Entity greeting : greetings) {
            pageContext.setAttribute("greeting_content",
                                     greeting.getProperty("content"));
            if (greeting.getProperty("user") == null) {
                %>
                <p>An anonymous person wrote:</p>
                <%
            } else {
                pageContext.setAttribute("greeting_user",
                                         greeting.getProperty("user"));
                %>
                <p><b>${fn:escapeXml(greeting_user.nickname)}</b> wrote:</p>
                <%
            }
            %>
            <blockquote>${fn:escapeXml(greeting_content)}</blockquote>
            <%
        }
    }
%>

    <form action="/sign" method="post">
      <div><textarea name="content" rows="3" cols="60"></textarea></div>
      <div><input type="submit" value="Post Greeting" /></div>
      <input type="hidden" name="guestbookName" value="${fn:escapeXml(guestbookName)}"/>
    </form>

    <a href="homepage.jsp">See All Posts</a>

  </body>
</html>
