<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
	<title>Customer Registration Form</title>
	
	<style>
		.error {color:red}
	</style>
	
</head>
<body>

<i>I campi contrassegnati dall'asterisco sono obbligatori.</i>
<br><br>

	<form:form action="processForm" modelAttribute="customer">
	
		First name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name*:	<form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/>
	
		<br><br>
		
		CAP*: <form:input path="cap"/>
		<form:errors path="cap" cssClass="error"/>
		
		<br><br>
		
		Course Code*: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>
		
		<br><br>
		
		
		
		<br><br>
		
		Free Pass: <form:input path="freePasses"/>
		<form:errors path="freePasses" cssClass="error"/>
		
		<br><br>
		
		<input type="submit" value="Invia" />
	
	</form:form>

</body>

</html>

