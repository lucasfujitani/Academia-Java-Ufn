<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Minha página Servlet</title>
</head>
<body>
	<div>
		<form action="login" method="POST">
			<label>E-mail</label>
			<input type="text" id="email" name="email" placeholder="seuemail@atos.com"/>
			<br>
			<br>
			<label>Senha</label>
			<input type="password" id="senha" name="senha" placeholder="**********"/>
			<br>
			<br>
			<button type="submit">Entrar</button>
		</form>
		<br>
		<form action="mega-sena" method="GET">
			<button type="submit">Gerar números</button>
		</form>
	</div>
</body>
</html>