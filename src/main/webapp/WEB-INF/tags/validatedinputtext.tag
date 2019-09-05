<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="rotulo" required="true" %>
<%@ attribute name="valor" required="true" %>
<%@ attribute name="erroValidacao" required="true" %>
<%@ attribute name="invalido" required="true" %>
<%@ attribute name="textoPlaceholder" %>

<%@ attribute name="idCampo" required="true" %>
<%@ attribute name="nomeCampo" required="true" %>

<label for="nome-input">${rotulo}</label>
<c:choose>
	<c:when test="${invalido}">
		<input type="text" class="form-control is-valid" id="${idCampo}" name="${nomeCampo}"
			placeholder="${textoPlaceholder}" value="${valor}">
	</c:when>
	<c:otherwise>
		<input type="text" class="form-control is-invalid" id="${idCampo}"
			name="${nomeCampo}" placeholder="${textoPlaceholder}" value="${valor}">
		<div class="invalid-feedback">${erroValidacao}</div>
	</c:otherwise>
</c:choose>