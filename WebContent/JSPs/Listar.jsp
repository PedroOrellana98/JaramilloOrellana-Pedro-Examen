<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Listar</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="/JaramilloOrellana-Pedro-Examen/css/buscar.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body class="is-preload">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

	<div id="header">
		<h1>Listar</h1>
	</div>
	<div class="topnav">
		<a href="index.jsp">Home</a>
		<form action="/JaramilloOrellana-Pedro-Examen/Listar" method="POST">
			<a><button class="input-group-text" name="id" type="submit">Listar</button></a>
		</form>
	</div>

	<table class="container">
		<thead>
			<tr>
				<th>Tipo</th>
				<th>Operadora</th>
				<th>Numero</th>
			</tr>
		</thead>
		<tbody id="myTable">
		
		<c:forEach var="te" items="${telefono}" varStatus="loop">
			<tr>
            	<td>${te.tipo}</td>
            	<td>${te.operadora}</td>
            	<td>${te.numero}</td>
         	</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>