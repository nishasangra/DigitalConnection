<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style> 
.error {
color:#FE2EF7; font-style: italic;
}
</style>
<title>Digital Connection</title>
</head>

<body bgcolor="#FFBF00">
<img  width=100px; height=75px; style="padding-bottom:50px" src="<%=request.getContextPath()%>/images/digconn.png"/>
<div ALIGN="center">
<form:form method="POST" action="login" commandName="login">
<table align="center">
<tr><td align="center"><font size="3" color="Pink">${errval}</font></td>
</tr>
     <tr>
          <td>Username:</td>
          
              <td><input type="text" name="username" required/></td>
              
              <td><form:errors path="username" cssClass="error"/></td>  
     <tr>
   <tr>
   <td>Password:</td>
        <td><input type="password" name="password" required/></td>
       
        <td><form:errors path="password" cssClass="error"/></td>
  </tr>
<tr>
<td align="right"><input type="submit" name="Submit" id="Submit" value="Login" />
</tr>
</table>
</form:form>
</div>
</body>
</html>