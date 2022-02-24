<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			<c:out value="${language.getName()}"/>
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<main>
			<div class="row">
				 <form action="/languages/delete/${language.getId()}" method="POST">
					<input type="hidden" name="_method" value="DELETE" />
					<button type="submit" class="delete">
						Delete
					</button>
				</form>
				<form action="/languages/" method="GET">
					<button type="submit" class="link">
						Dashboard
					</button>
				</form>
			</div>
			<form:form method="POST" action="/languages/update" modelAttribute="language">
				<input type="hidden" name="_method" value="put">
				<input type="hidden" name="id" value="${language.getId()}">
				<div>
					<p><form:errors path="name" class="error"/></p>
					<p><form:errors path="creator" class="error"/></p>
					<p><form:errors path="currentVersion" class="error"/></p>
				</div>
				<div class="justify">
					<form:label path="name" for="name">
						Name:
					</form:label>
					<form:input path="name" type="text" name="name" id="name" value="${language.getName()}" />
				</div>
				<div class="justify">
					<form:label path="creator" for="creator">
						Creator:
					</form:label>
					<form:input path="creator" type="text" id="creator" name="creator" value="${language.getCreator()}" />
				</div>
				<div class="justify">
					<form:label path="currentVersion" for="currentVersion">
						CurrentVersion:
					</form:label>
					<form:input path="currentVersion" type="text" id="currentVersion" name="currentVersion" value="${language.getCurrentVersion()}" />
				</div>
				<button type="submit" class="submit" >
					Submit
				</button>
			</form:form>
		</main>
	</body>
</html>