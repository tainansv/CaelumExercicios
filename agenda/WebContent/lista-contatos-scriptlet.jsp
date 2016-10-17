<%@page import="java.text.*"%>
<%@page import="br.com.tainan.agenda.dao.*, br.com.tainan.agenda.modelo.*, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de contatos</title>
</head>
<body>
	
	<table>
		<tr>
			<th>Nome</th>
			<th>Email</th>
			<th>Endereço</th>
		</tr>
		<%
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		for(Contato contato : contatos){
			String data = new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());
		%>
		<tr>
			<td><%=contato.getNome() %></td>
			<td><%=contato.getEmail() %></td>
			<td><%=contato.getEndereco() %></td>
			<td><%=data %></td>
		</tr>
		<%
		};
		%>
	</table>
	
</body>
</html>