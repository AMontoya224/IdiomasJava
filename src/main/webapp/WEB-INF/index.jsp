<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>
			languages
		</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body>
		<table>
        	<thead>
		        <tr>
		            <th>Name</th>
		            <th>Creator</th>
		            <th>Version</th>
		            <th>Actions</th>
		        </tr>
		    </thead>
        	<tbody>
				<c:forEach var="language" items="${languagesList}">
					<tr>
                    	<td>
                    		<form action="/languages/${language.getId()}" method="GET">
								<button type="submit" class="link">
									<c:out value="${language.getName()}"/>
								</button>
							</form>
						</td>
                        <td><c:out value="${language.getCreator()}"/></td>
                        <td><c:out value="${language.getCurrentVersion()}"/></td>
                        <td>
                        	<div class="row">
	                        	<form action="/languages/edit/${language.getId()}" method="GET">
									<button type="submit" class="link">
										edit
									</button>
								</form>
								<form action="/languages/delete/${language.getId()}" method="POST">
									<input type="hidden" name="_method" value="DELETE" />
									<button type="submit" class="delete">
										delete
									</button>
								</form>
							</div>
						</td>
					</tr>
            	</c:forEach>
			</tbody>
		</table>
		<main>
			<form:form method="POST" action="/languages/register" modelAttribute="language">
				<div>
					<p><form:errors path="name" class="error"/></p>
					<p><form:errors path="creator" class="error"/></p>
					<p><form:errors path="currentVersion" class="error"/></p>
				</div>
				<div class="justify">
					<form:label path="name" for="name">
						Name:
					</form:label>
					<form:input path="name" type="text" name="name" id="name" />
				</div>
				<div class="justify">
					<form:label path="creator" for="creator">
						Creator:
					</form:label>
					<form:input path="creator" type="text" id="creator" name="creator"/>
				</div>
				<div class="justify">
					<form:label path="currentVersion" for="currentVersion">
						Version:
					</form:label>
					<form:input path="currentVersion" type="text" id="currentVersion" name="currentVersion"/>
				</div>
				<button type="submit" class="submit" >
					Submit
				</button>
			</form:form>
		</main>
	</body>
</html>