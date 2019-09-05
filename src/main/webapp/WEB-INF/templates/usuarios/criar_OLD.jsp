<!-- 
************************************* ATENÇÃO *************************************
ESTOU MANTENDO ESTE ARQUIVO APENAS PARA REFERÊNCIA EM RELAÇÃO AO QUE SE TINHA ANTES
OBSERVE O QUÃO MAIS LIMPO FICOU O criar.jsp, APÓS A APLICAÇÃO DE JSTL, TAGS PRÓPRIAS 
E IMPORT DE JSP.
ESTE ARQUIVO SERÁ REMOVIDO EM ITERAÇÕES FUTURAS
************************************* ATENÇÃO *************************************
-->

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<title>Criar Usuário</title>
</head>
<body class="container">
	<h1>Criar Usuário</h1>
	<form method="post" action="/usuarios">
		<div class="form-group">
			<label for="nome-input">Nome</label>
			<c:choose>
				<c:when test="${empty NomeInvalido}">
					<input type="text" class="form-control" id="nome-input" name="nome"
						placeholder="Seu Nome" value="${param.nome}">
				</c:when>
				<c:otherwise>
				<!--  TODO: Pensar na melhor forma de alternar entre o valor original e os valores preenchidos no form (param.nome e param.sobrenome) -->
					<input type="text" class="form-control is-invalid" id="nome-input"
						name="nome" placeholder="Seu Nome" value="${param.nome}">
					<div class="invalid-feedback">${NomeInvalido}</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="form-group">
			<label for="sobrenome-input">Sobrenome</label>
			<c:choose>
				<c:when test="${empty SobrenomeInvalido}">
					<input type="text" class="form-control" id="sobrenome-input"
						name="sobrenome" placeholder="Seu Sobrenome"
						value="${param.sobrenome}">
				</c:when>
				<c:otherwise>
					<input type="text" class="form-control is-invalid"
						id="sobrenome-input" name="sobrenome" placeholder="Seu Sobrenome"
						value="${param.sobrenome}">
					<div class="invalid-feedback">${SobrenomeInvalido}</div>
				</c:otherwise>
			</c:choose>
		</div>
		<a href="/usuarios" class="btn btn-danger">Cancelar</a>
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>