<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<title> Customer Confirmation Page </title>
</head>

<body>

The customer is confirmed: 
<br>
First Name: ${customer.firstName} 
<br>
Last Name: ${customer.lastName}
<br>

CAP: ${customer.cap }
<br>

Course Code: ${customer.courseCode }

<br><br>

Free pass requested: ${customer.freePasses }

</body>

</html>