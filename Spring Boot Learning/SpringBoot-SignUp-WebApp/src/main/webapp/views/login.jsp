<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Login Page</title>
	<link rel="stylesheet" href="CSS/style.css">
</head>
<body>	
	<div class="login-form">
			<c:if test= "${not empty ErrorMsg}">
				<h4>${ErrorMsg}</h4>
			</c:if>
		<h2>Login</h2>
		<form action="login" method="post">
			<label for="username">Username:</label>
			<input type="text" id="username" name="username" required><br><br>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required><br><br>
			<button type="submit">Login</button>
		</form>
		Create account ?<a href="regPage">Register</a>
	</div>
</body>

</html>