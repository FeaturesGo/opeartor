<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>耕耘e号</title>

    <link href='<s:url value="/public/css/bootstrap.min.css"></s:url>' rel="stylesheet">
    <link href='<s:url value="/public/css/style.css"></s:url>' rel="stylesheet">
    <link href='<s:url value="/public/css/login.css"></s:url>' rel="stylesheet">

</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-6">
            <div class="signin-info">
                <!--<div class="logopanel m-b">-->
                <!--<h1>[e]</span></h1>-->
                <!--</div>-->
                <!--<div class="m-b"></div>-->
                <!--<h4>欢迎使用 <strong>耕耘e号后台管理系统</strong></h4>-->
            </div>
        </div>
        <div class="col-sm-6">
            <form method="post" name="loginform" action="${pageContext.request.contextPath}/loginValidata" class="loginForm">
                <h4 class="no-margins" >登录：</h4>
                <p class="m-t-md login_top">欢迎登陆耕耘e号后台管理系统</p>
                <input type="text" name="userName" class="form-control uname" placeholder="用户名" />
                <input type="password" name="userPwd" class="form-control pword m-b" placeholder="密码" />
                <!--<a href="">忘记密码了？</a>-->
                <button class="btn btn-success btn-block" onclick="toLogin()">登录</button>
            </form>
            <p style="text-align:left">
                &copy; 2017 All Rights Reserved. 杭州魂之力科技</p>
        </div>
    </div>

</div>


<script type="text/javascript" src='<s:url value="/public/js/jquery-2.1.1.min.js"></s:url>'></script>
<script type="text/javascript">

    /* function toLogin() {
    	var userName = loginform.userName.value;
    	var userPwd = loginform.userPwd.value;
    	
    	$.ajax({
    		url:"${pageContext.request.contextPath}/loginValidata",
    		type:"POST",
    		data:{"userName":userName,"userPwd":userPwd},
    		success:function(data,err) {
    			console.log(data);
    			debugger;
    			if(data.code == "0000") {
    				window.location.href="${pageContext.request.contextPath}/home";
    			} else {
    				alert(data.codeDesc);
    			}
    		}
    	});
    } */

</script>

</body>

</html>