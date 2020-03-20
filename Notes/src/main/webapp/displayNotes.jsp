<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>

<style>
.wrapper {
	margin-left: 40%;
	margin-right: 40%;
}
</style>

<meta charset="ISO-8859-1">
<title>Notes</title>
</head>
<body>
<div class="wrapper">
	<c:forEach var="note" items="${notes}">
	   <h1 align="center">${note.key}</h1>
	   <hr width="100px">
	   <h3 align="center">${note.value}</h3>
	   
	   
		   <form action="deleteNote" method="POST">
		   	<input type="submit" value="Delete"/>
		   	<input type="hidden" name="delete_record" value="${note.key}" />
		   </form>
	   <br><br>
	</c:forEach>
</div>
</body>
</html>