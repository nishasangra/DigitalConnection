<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
.error {
color: #ff0000;
font-style: italic;
}
</style>
<title>Digital Connection Application</title>
</head>
<body bgcolor="#FFBF00">
<img  width=100px; height=75px; style="padding-bottom:50px" src="<%=request.getContextPath()%>/images/digconn.png"/>
<div ALIGN="center">
	<form:form method="post" action="applicant" commandName="applicant">
	<table align="center">
		<tr>
		<td style="font:18px verdana">Applicant Information</td>	
		</tr>
		<tr>
		<td align="right">First Name:</td>
		<td><form:input path="applfirstname"/></td>
		<td><form:errors path="applfirstname" cssClass="error"/></td>
		</tr>
		<tr>
		<td align="right">Middle Name:</td>
		<td><form:input path="applmidname" />	</td>
		</tr>
		<tr>
		<td align="right">Last Name:</td>
		<td><form:input path="appllastname" /></td>
		<td><form:errors path="appllastname" cssClass="error"/></td>
		</tr>
		<tr>
		<td align="right">Address Line 1:</td>
		<td><form:input path="appladdrline1" />	</td>
		<td><form:errors path="appladdrline1" cssClass="error"/>	</td>
		</tr>
		<tr>
		<td align="right">Address Line 2:</td>
		<td><form:input path="appladdrline2" />	</td>
		</tr>
		<tr>
		<td align="right">City:</td>
		<td><form:input path="city" />	</td>
		<td><form:errors path="city" cssClass="error" />	</td>
		</tr>
		<tr>
		<td align="right">State:</td>
		<td><form:input path="state" />	</td>
		<td><form:errors path="state" cssClass="error" />	</td>
		</tr>
		<tr>
		<td align="right">Zip Code:</td>
		<td><form:input path="zipcode" size="5"/>	</td>
		<td><form:errors path="zipcode" cssClass="error" />	</td>
		</tr>
		<tr>
		<td></td>
		<td align="center"> 
		<input type="submit" name="Submit" style="width:85px" id="Submit" value="Next"/></td>
		</tr>
	</table>
		
	</form:form>
</div>
</body>
</html>