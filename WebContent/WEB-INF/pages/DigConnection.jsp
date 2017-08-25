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
<script>
    var counter = 0;
    function openWindow(){
        window.open('http://www.google.com','mywindow'+counter,'width=400,height=350');
        counter++;
    }
</script>
<body bgcolor="#FFBF00">
<img  width=100px; height=75px; style="padding-bottom:50px" src="<%=request.getContextPath()%>/images/digconn.png"/>
<div ALIGN="center">
	<form:form method="POST" action = "digconnection" commandName="digconnection">
	<table align="center">
		<tr>
		<td style="font:18px verdana">Digital Connection Information</td>	
		</tr>
		<tr>
		<td align="right">Connection Type:</td>
		<td><form:select path="conntype" name="conntype">
			<option value="Personal">Personal</option>
    		<option value="Commercial">Commercial</option>
    		</form:select>
		<td>
		<td><form:errors path="conntype" cssClass="error"/></td>
		</tr>
		<tr>
		<td align="right">Connection Duration:</td>
		<td><form:select path="connduration" name="connduration">
			<option value="6 Months">6 Months</option>
    		<option value="12 Months">12 Months</option>
    		</form:select>
    		<td>
		<td><form:errors path="connduration"  cssClass="error" /></td>
		</tr>
		<tr>
		<td align="right">Connection Usage:</td>
		<td><form:select path="connusagetype" name="connusagetype">
			<option value="Private">Private</option>
    		<option value="Business">Business</option>
    		</form:select>
    		</td>
		<td><form:errors path="connusagetype" cssClass="error" />	</td>
		</tr>
		<tr>
		<td align="right">Automatic Renewal(5% Discount):</td>
		<td>
			<input type="radio" name="renewalautopayment" value="Yes" checked> Yes
			<input type="radio" name="renewalautopayment" value="No"> No
		</td>
		</tr>
		<tr>
		<td></td>
		<td><input type="button" value="Previous" style="width:85px" onclick="window.location='/digconn/payment'"/> 
		<input type="submit" name="Submit" style="width:85px" id="Submit" value="Submit"/></td>
		</tr>
	</table>
		
	</form:form>
</div>
</body>
</html>