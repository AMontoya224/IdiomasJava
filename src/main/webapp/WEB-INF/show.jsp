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
				 <h1>
					
				</h1> 
				<form action="/languages/" method="GET">
					<button type="submit" class="link">
						Dashboard
					</button>
				</form>
			</div>
			<h3>
				<c:out value="${language.getName()}"/>
			</h3>
			<h3>
				<c:out value="${language.getCreator()}"/>
			</h3>
			<h3>
				<c:out value="${language.getCurrentVersion()}"/>
			</h3>
			<form action="/languages/edit/${language.getId()}" method="GET">
				<button type="submit" class="link">
					Edit
				</button>
			</form>
			<form action="/languages/delete/${language.getId()}" method="POST">
				<input type="hidden" name="_method" value="DELETE" />
				<button type="submit" class="delete">
					Delete
				</button>
			</form>
		</main>
	</body>
</html>