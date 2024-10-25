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
		<c:if test= "${not empty Done}">
			<h4>Welcome ${Done}</h4>
		</c:if>
		<button><a href="logout">LogOut</a></button>
	</div>
</body>

</html>