<!DOCTYPE html>
<html>
	<head>
        <meta charset="utf-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link type="text/css" href="/main_style.css" rel="stylesheet">
		<link type="text/css" href="/login_register.css" rel="stylesheet">
		<link rel="icon" href="/source/Logo_only.svg">
		
		<title>TATTOO-pro</title>
	</head>

	<body>

		<div id="form-container">
			<div class="form-header">
				<a href="/users">
					<img src="/source/Logo_only.svg" class="logo">
				</a>
				<h2>Login Form</h2>
			</div>
			<div class="form-content-login">
				<form name="login" action="/login" method="post" id="flogin">
					<label for="uname" id="un">Username:</label>
					<input type="text" name="username" placeholder="Username" id="uname" required><br/><br/>
					<label for="upass" id="ps">Password:</label>
					<input type="password" name="password" placeholder="Password" id="upass" required><br/><br/>
					<button type="submit" name="submit" value="Login"  id="submit">Login</button><br/>
				</form>
			</div>
			<div class="form-footer">
					<a href="/register">New Member</a>
			</div>
		</div>

	</body>
</html> 