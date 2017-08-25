<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact Manager Home</title>
</head>
<body bgcolor="#FFBF00">
<img  width=100px; height=75px; style="padding-bottom:50px" src="<%=request.getContextPath()%>/images/digconn.png"/>
<div ALIGN="center">
	<form:form method="post" commandName="model">	
	<table align="center">
		<tr>
		<td style="font:18px verdana">Connection Details Information</td>		
		</tr>
		<tr>
		<td>The monthly payment for your Connection is:</td>
		<td>${model.quotevalue}</td>
		</tr>
		<tr>
    <td>Application/Connection Number for your reference is:</td>
    <td>${model.quote}</td>
    </tr>
		<tr>
		<td align="center">
		<input type="button" value="Close" onclick="window.location='/DigitalConnection/welcome'"/>
		</td>
		</tr>
	</table>
	</form:form>
</div>
</body>
</html>