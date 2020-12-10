<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Inicio Sesion</title>
<link rel="stylesheet"  href="/JaramilloOrellana-Pedro-Examen/css/login.css" type="text/css">
</head>
<body>
	<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div><a href="index.jsp">Home</a><span></span></div>
		</div>
		<br>
		<div class="login">
			<form action="/JaramilloOrellana-Pedro-Examen/InicioSesion" method="POST">
				<input type="text" placeholder="username" name="user" required><br>
				<input type="password" placeholder="password" name="password" required><br>
				<button type="submit" name="resp" value="Login">Login</button>
			</form>
		</div>
</body>
</html>