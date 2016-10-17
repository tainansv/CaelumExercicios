<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
//<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de contatos</title>
</head>
<body>

	<c:import url="cabecalho.jsp" />

	<table>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereco</th>
			<th>Data de nascimento</th>
		</tr>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : '8099ff' }">
				<td>${contato.nome}</td>
				<td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado
						</c:otherwise>
					</c:choose>
				</td>
				<td>${contato.endereco }</td>
				<td>
					<fmt:formatDate value="${contato.dataNascimento.time }" pattern="dd/MM/yyyy"/>
				</td>
				<td><a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a></td>
				<td><a href="mvc?logica=PaginaAlteraOuAdicionaLogic&id=${contato.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="mvc?logica=PaginaAlteraOuAdicionaLogic&id=">Adicionar</a>
	<c:import url="rodape.jsp" />

</body>
</html>