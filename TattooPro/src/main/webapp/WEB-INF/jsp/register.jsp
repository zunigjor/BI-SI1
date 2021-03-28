<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<div class="form-container">
			<div class="form-header">
				<a href="/users">
					<img src="/source/Logo_only.svg" class="logo">
				</a>
				<h2>Registration Form</h2>
			</div>
			<div class="form-content">
				<form name="regi" action="/register" method="post">
					<div class="form-labels">
						<div class="label-div"><label for="expand-toggle" id="art" >Are you an artist? <b>*</b></label></div>
						<div class="label-div"><label  for="r4" id="un">Username<b>*</b> :</label></div>
						<div class="label-div"><label  for="r5" id="pwd">Password<b>*</b> :</label></div>
						<div class="label-div"><label  for="r6" id="em">Email<b>*</b> :</label></div>
					</div>
					<div class="form-input">
						<input type="checkbox" name="isart" id="expand-toggle"><br/>
						<input type="text" name="uname" id="r4" required><br/>
						<input type="password" name="pass" id="r5" required><br/>
						<input type="text" name="email" id="r6" required><br/>

						<button type="submit" id="button" style="width:auto;color:#ffffff">Register</button><br/>

					</div>
				</form>
			</div>
		</div>
	</body>
</html>