<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<div>Lista</div>
<ul>

<c:forEach var="usuario" items="${Usuarios}">
	<li>${usuario.nome}</li>
</c:forEach>
</ul>	
</body>
</html>