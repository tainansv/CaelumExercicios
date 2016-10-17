<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tainan"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar contato</title>
</head>
<body>

	<c:import url="cabecalho.jsp" />

	<form action="mvc">
	<table>
		<tr>
			<th></th>
			<th>Atual</th>
			<th>Novos dados</th>
		</tr>
		<tr>
			<td>Nome</td>
			<td>${contato.nome }</td>
			<td><input type="text" name="nome"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${contato.email }</td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td>Endereço</td>
			<td>${contato.endereco }</td>
			<td><input type="text" name="endereco"/></td>
		</tr>
		<tr>
			<td>Data de nascimento</td>
			<td><fmt:formatDate value="${contato.dataNascimento.time }" pattern="dd/MM/yyyy"/></td>
			<td><tainan:campoData id="dataNascimento"/></td>
		</tr>
		<tr>
			<td><input type="hidden" name="id" value="${contato.id }"/></td>
			<td><input type="hidden" name="logica" value="AlteraOuAdicionaContatoLogic"/></td>
			<td><input type="submit"/></td></tr>
	</table>
	</form>

	<c:import url="rodape.jsp" />
	
</body>
</html>