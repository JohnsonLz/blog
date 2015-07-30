<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<!-- saved from url=(0038)http://v3.bootcss.com/examples/signin/ -->
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://v3.bootcss.com/favicon.ico">

    <title>登录</title>

    <!-- Bootstrap core CSS -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://v3.bootcss.com/examples/signin/signin.css" rel="stylesheet">
    <link href="http://v3.bootcss.com/examples/carousel/carousel.css" rel="stylesheet">
    <link href="./blog.css" rel="stylesheet">
    
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./Signin Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>

	<script src="./check.js"></script>
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  <style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */
</style>
<script type="text/javascript">
</script></head>

  <body>
	<div class="container">
          
        <nav class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="">石木博客</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="">主页</a></li>
                <li><a href="">关于</a></li>
                <li><a href="">联系</a></li>
                <li class="dropdown">
                  <a href="http://v3.bootcss.com/examples/carousel/#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="http://v3.bootcss.com/examples/carousel/#">Action</a></li>
                    <li><a href="http://v3.bootcss.com/examples/carousel/#">Another action</a></li>
                    <li><a href="http://v3.bootcss.com/examples/carousel/#">Something else here</a></li>
                    <li role="separator" class="divider"></li>
                    <li class="dropdown-header">Nav header</li>
                    <li><a href="http://v3.bootcss.com/examples/carousel/#">Separated link</a></li>
                    <li><a href="http://v3.bootcss.com/examples/carousel/#">One more separated link</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>

      </div>



      <form class="form-signin" action = "home.jsp" >
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="userID" class="sr-only">ID Number</label>
        <input type="text" id="userID" class="form-control"  placeholder="ID Number" required="" autofocus="" autocomplete="off">
        <label for="userPassword" class="sr-only">Password</label>
        <input type="password" id="userPassword" class="form-control" placeholder="Password" required="">
     <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="return login()" style="background-color: #222222" ">Sign in</button>

      </form>
          <div style="position:fixed; bottom :0;width:100%;text-align:center;vertical-align:middle;margin-right: auto;
  margin-left: auto;">
             <p>© 2015 Company, Inc. · <a style="color:#333333" href="http://v3.bootcss.com/examples/carousel/#">Privacy</a> · <a style="color:#333333" href="http://v3.bootcss.com/examples/carousel/#">Terms</a></p>
            </div>



    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="./Signin Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>
      <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

</div></body></html>
