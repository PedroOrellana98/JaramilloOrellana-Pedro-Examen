<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Usuario</title>
<link rel="stylesheet"  href="/JaramilloOrellana-Pedro-Examen/css/crear.css" type="text/css">
</head>
<body>
	<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div><a href="index.jsp">Home</a><span></span></div>
			<br>
			<br>
			<div><form action="Listar" method="GET">
				<a href="Listar">Listar</a></form></div>
		</div>
		<br>
		<form action="/JaramilloOrellana-Pedro-Examen/CrearUsuario" method="POST">
			<div class="login">
				<h1>Registrar Usuario</h1><br>
				<input type="text" placeholder="Nombre" name="nombre" required><br>
				<input type="text" placeholder="Apellido" name="apellido" required><br>
				<input type="text" placeholder="Cedula" name="cdi" required><br>
				<input type="text" placeholder="E-mail" name="email" required><br>
				<input type="password" placeholder="Password" name="password" required><br>
				<button type="submit" name="resp" value="Registrarse">Siguiente</button>
			</div>
		</form>
</body>
</html>