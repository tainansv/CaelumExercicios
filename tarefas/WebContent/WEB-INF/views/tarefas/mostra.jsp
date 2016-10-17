<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar</title>
<link type="text/css" href="resources/css/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.js"></script>
</head>
<body>

<h3>Alterar tarefa - ${tarefa.id}</h3>
<form action="alteraTarefa" method="post">
	<input type="hidden" name="id" value="${tarefa.id}" />
	Descrição:<br />
	<textarea name="descricao" cols="100" rows="5">
		${tarefa.descricao}
	</textarea>
	<br />
	Finalizado? <input type="checkbox" name="finalizado"
		value="true" ${tarefa.finalizado? 'checked' : '' }/> <br />
	Data de finalização: <br />
	<fmt:formatDate value='${tarefa.dataFinalizacao.time}' pattern='dd/MM/yyyy' var="dataFormatada" />
	<t:campoData id="dataFinalizacao" val="${dataFormatada }" />
	<br />
	<input type="submit" value="Alterar"/>
</form>



</body>
</html>