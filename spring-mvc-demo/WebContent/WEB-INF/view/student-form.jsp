

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<head>
		<title> YUPPIE! </title>
	</head>

	<body>
	
	<form:form action="processForm" modelAttribute="student">
	
		Nome: <form:input path="firstName"/>
		
		<br><br>
		
		Cognome: <form:input path="lastName"/>
		
		<br><br>
		
		Country: 
		<form:select path="country">
			
			<!--  OptionS vuole una collection  -->
			<form:options items="${theCountryOptions}"/>
			
		</form:select>
		
		<br><br>
		
		<!--  
		Java <form:radiobutton path="favoriteLanguage" value="Java"/>
		PhP <form:radiobutton path="favoriteLanguage" value="PHP"/>
		C# <form:radiobutton path="favoriteLanguage" value="C#"/>
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
		 -->
		 
		Favorite 
		
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}" />
		 
		<br><br>
		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac Os <form:checkbox path="operatingSystems" value="MacOs" />
		Windows <form:checkbox path="operatingSystems" value="Windows" />
		
		<br><br>
		
		
		<input type="submit" value="Submit" />
	
	</form:form>
	
	</body>	
	
</html>