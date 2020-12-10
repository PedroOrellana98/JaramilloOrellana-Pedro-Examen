<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Telefono</title>
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
		<form action="/JaramilloOrellana-Pedro-Examen/CrearTelefono" method="POST">
			<div class="login">
				<h1>Registrar Telefono</h1><br>
				<input type="text" placeholder="Numero" name="numero" required><br>
				<input type="text" placeholder="Operadora" name="operadora" required><br>
				<input type="text" placeholder="Tipo" name="tipo" required><br>
				<button type="submit" name="resp" value="Registrarse">Enviar</button>
			</div>
		</form>
</body>
</html>