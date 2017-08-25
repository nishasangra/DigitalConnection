<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Digital Connection Home</title>
</head>
<body bgcolor="#FFBF00">
<img  width=100px; height=75px; style="padding-bottom:50px" src="<%=request.getContextPath()%>/images/digconn.png"/>
<div ALIGN="center">
	<form>
	<table align="center">
		<tr>
		</tr>
		<tr>
		<td><h2>Welcome to Digital Connection Application</h2></td>
		</tr>
		<tr>
		<td align="center">Click <a href='<c:url value="/login" />'>Login</a> to access.</td>
		</tr>
	</table>
		
	</form>
</div>
</body>
</html>