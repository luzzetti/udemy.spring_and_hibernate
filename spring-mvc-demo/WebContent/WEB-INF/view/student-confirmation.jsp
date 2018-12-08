

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<title> YUPPIE! </title>
	</head>

	<body>
	
	<h1>Student Confirmation:</h1>
	
	<p>
	The student is confirmed.
	Nome: ${student.firstName}
	Cognome: ${student.lastName}
	Country: ${student.country}
	</p>
	
	<br><br>
	
	Favorite Language : ${student.favoriteLanguage}
	
	<br><br>
	
	Operating Systems:
	<ul>
	
		<c:forEach var="temp" items="${student.operatingSystems}"> 
			
			<li> ${temp} </li>
			
		</c:forEach>
		
	</ul>
	
	
	
	<br><br>
	
	
	</body>	
	
</html>