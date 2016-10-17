<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

<script type="text/javascript">
	function finalizaAgora(id) {
		$.post("finalizaTarefa", {'id' : id}, function(resposta) {
		// selecionando o elemento html através da
		// ID e alterando o HTML dele
		$("#tarefa"+id).html(resposta);
	});
}

	function removeTarefaAjax(id){
		$.post("removeTarefa", {'id' : id}, function(){
			$("#tarefa"+id).remove();
		})
	}
</script>

<a href="novaTarefa">Criar nova tarefa</a>
<a href="menu">Voltar ao menu</a>
<br /> <br />
<table id="tabela">
	<tr>
		<th>Id</th>
		<th>Descrição</th>
		<th>Finalizado?</th>
		<th>Data de finalização</th>
	</tr>
	<c:forEach items="${tarefas}" var="tarefa">
		<tr id="tarefa${tarefa.id }">
			<td>${tarefa.id}</td>
			<td>${tarefa.descricao}</td>
			<c:if test="${tarefa.finalizado eq false}">
				<td>
					<a href="#" onClick="finalizaAgora(${tarefa.id})">
						Finaliza agora!
					</a>
				</td>
			</c:if>
			<c:if test="${tarefa.finalizado eq true}">
				<td>Finalizado</td>
			</c:if>
			<td>
				<fmt:formatDate
					value="${tarefa.dataFinalizacao.time}"
					pattern="dd/MM/yyyy"/>
			</td>
			<td><a href="removeTarefa?id=${tarefa.id }">Remover</a></td>
			<td><a href="mostraTarefa?id=${tarefa.id }">Alterar</a>
			<td><a href="#" onClick="removeTarefaAjax(${tarefa.id })">Excluir</a></td>
		</tr>
	</c:forEach>
</table>


</body>
</html>