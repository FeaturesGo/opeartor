<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 	<form action='<s:url value="/loginValidata" ></s:url>'>
		<label>用户名:</label>
		<input type="text" name="userName">
		<p></p>
		<label>密 码:</label>
		<input type="password" name="userPwd">
		<p></p>
		<input type="submit" value="提交">
	</form>
	
	<br><br>

	<form action='<s:url value="/artic/saveArtic" ></s:url>'>
		<input type="text" name="type" >
		<p></p>
		<input type="text" name="clickNum">
		<p></p>
		<input type="text" name="title">
		<p></p>
		<input type="text" name="description">
		<p></p>
		<input type="text" name="content">
		<p></p>
		<input type="text" name="imgUrl">
		<p></p>
		<input type="text" name="videoUrl">
		<p></p>
		<input type="submit" value="提交">
	</form>
	
</body>
</html>