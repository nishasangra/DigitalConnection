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
	<form:form method="post" action="payment" commandName="payment">
	<table align="center" border="0">
		<tr>
		<td style="font:18px verdana">Payment Information</td>	
		</tr>
		<tr>
		<td align="right">SSN Number:</td>
		<td><form:input path="ssn"/>
		</td>
		<td><form:errors path="ssn" cssClass="error"/></td>
		</tr>
		<tr>
		<td align="right">Mode of income:</td>
		<td><form:select path="incomemode" name="incomemode">
			<option value="Salaried">Salaried</option>
    		<option value="Contractor">Contractor</option>
    		</form:select>
		</td>
		<td><form:errors path="incomemode"  cssClass="error" /></td>
		</tr>
		<tr>
		<td align="right">Annual Income:</td>
		<td><form:input path="annualincome" /></td>
		<td><form:errors path="annualincome" cssClass="error" /></td>
		</tr>
		<tr>
		<td align="right">Credit Card Type:</td>
		<td>
			<form:select path="creditcardtype" name="creditcardtype">
			<option value="Visa">Visa</option>
    		<option value="AMEX">AMEX</option>
    		<option value="Master">Master</option>
    		</form:select>
			<form:errors path="creditcardtype" cssClass="error"/>
		</td>
		</tr>
		<tr>
		<td align="right">Credit Card Number:</td>
		<td>
			<form:input path="creditcardnumber"/>
		</td>
		<td>
			<form:errors path="creditcardnumber" cssClass="error"/>
		</td>
		</tr>
		<tr>
		<td align="right">Expiry Date(MM/DD):</td>
		<td>
			<form:input path="expirydate"/>
		</td>
		<td>
			<form:errors path="expirydate" cssClass="error"/>
		</td>
		</tr>
		<tr>
		<td align="right">Name as on Credit Card:</td>
		<td>
			<form:input path="creditcardname"/>
		</td>
		<td>
			<form:errors path="creditcardname" cssClass="error"/>
		</td>
		</tr>
		<tr>
		<td align="right">Billing ZipCode:</td>
		<td>
			<form:input path="billingzipcode"/>
		</td>
		<td>
		<form:errors path="billingzipcode" cssClass="error"/>
		</td>
		</tr>
		<tr>
		<td></td>
		<td><input type="button" value="Previous" style="width:85px" onclick="window.location='/digconn/applicant'"/> 
		<input type="submit" name="Submit" style="width:85px" id="Submit" value="Next"/></td>
		</tr>
	</table>
		
	</form:form>
</div>
</body>
</html>