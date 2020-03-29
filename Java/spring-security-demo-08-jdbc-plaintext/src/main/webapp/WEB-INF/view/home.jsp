<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	<p>
	Welcome to the luv2code company home page!
	</p>
	
	<hr>
	
	<!-- display user name and role -->
	
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	
	
	
	<!-- 418 -->
	<!-- 424 -->
	<security:authorize access="hasRole('MANAGER')">
	
	
	<!-- Add a link to point to /leaders ... this is for the managers -->
	
	<!-- ${pageContext.request.contextPath} ... Gives link to the root of the web app -->
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		(Only for Manager peeps)
	</p>
	
	</security:authorize>
	
	<!-- 421 -->
	<!-- 424 -->
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		(Only for Admins peeps)
	</p>
	</security:authorize>
	
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>










