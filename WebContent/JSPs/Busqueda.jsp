<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Buscar</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="../css/login.css" type="text/css">

</head>
<body class="is-preload">
	<c:set var="p1" value="${requestScope['telefono']}" />

	<div id="header">
		<h1>Buscar</h1>
	</div>
	<div class="topnav">
		<a href="../index.jsp">Home</a>
		<form action="../Buscar?id=1" method="POST">
			<a><input type="text" class="form-control" name="correo"
					placeholder="Buscar por correo..."></a>
			<a><button class="input-group-text" name="buscarCorreo" value="correoB"
						type="submit">Buscar</button></a>
		</form>
		<form action="../Buscar" method="POST">	
			<a><input type="text" class="form-control" name="cedula"
					placeholder="Buscar por cedula....."></a>		
			<a><button class="input-group-text" name="buscarCed" value="cedulaB" type="submit">Buscar</button></a>
		</form>
	</div>

	<table class="container">
		<thead>
			<tr>
				<th>Email</th>
				<th>Tipo</th>
				<th>Operadora</th>
				<th>Numero</th>
			</tr>
		</thead>
		<tbody id="myTable">

			<c:forEach var="telf" items="${p1}">
				<tr>

					<td>${telf.correo}<a href="mailto:${telf.correo }"><img width="25px"
							height="25px"
							src="https://img.icons8.com/flat_round/64/000000/secured-letter--v1.png" /></a></td>
					<td>${telf.tipo}</td>
					<td>${telf.operadora}</td>
					<td>${telf.numero}<a href="tel: ${telf.numero }"><img width="25px"
							height="25px"
							src="https://img.icons8.com/ultraviolet/40/000000/phone.png" /></a>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>