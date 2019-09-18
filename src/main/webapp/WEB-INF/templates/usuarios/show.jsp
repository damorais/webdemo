<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="minha" tagdir="/WEB-INF/tags" %>

<!doctype html>
<html lang="en">
<head>
	<c:import url="/WEB-INF/templates/common/_metatags.jsp" />
	<c:import url="/WEB-INF/templates/common/_bootstrap_css.jsp" />	
	<title>Criar Usuário</title>
</head>
<body class="container">
	<h1>Usuário</h1>
		
	<form>
	  <div class="form-group row">
	    <label for="">Nome</label>
	    <input type="text" class="form-control" readonly value="${Usuario.nome}">
	  </div>
	 <div class="form-group row">
	    <label for="">Sobrenome</label>
	    <input type="text" class="form-control" readonly value="${Usuario.sobrenome}">
	  </div>
	  <a href="/usuarios" class="btn btn-danger">Voltar</a>
	</form>

	<c:import url="/WEB-INF/templates/common/_bootstrap_js.jsp" />
</body>
</html>