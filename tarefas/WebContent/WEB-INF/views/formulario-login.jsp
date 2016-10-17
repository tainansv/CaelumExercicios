<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css"	href="resources/style.css" />
</head>
<body>

	<div>
		<h2>Página de login das tarefas</h2>
		<form action="efetuaLogin" method="post">
			Login: <input type="text" name="login" />
			Senha: <input type="password" name="senha" />
			<input type="submit" value="Entar nas tarefas" /> 
		</form>
	</div>

</body>
</html>