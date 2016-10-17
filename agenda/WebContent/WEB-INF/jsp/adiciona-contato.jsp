<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tainan"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar contato</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	
	<c:import url="cabecalho.jsp" />
	
	<form action="mvc">
		Nome: <input type="text" name="nome" /><br />
		E-mail: <input type="text" name="email" /><br />
		Endereço: <input type="text" name="endereco" /><br />
		Data Nascimento: <tainan:campoData id="dataNascimento"/><br />
		<input type="hidden" name="logica" value="AlteraOuAdicionaContatoLogic"/>
		<input type="hidden" name="id"/>
		<input type="submit" value="Gravar" />
	</form>
	
	<c:import url="rodape.jsp"></c:import>

</body>
</html>