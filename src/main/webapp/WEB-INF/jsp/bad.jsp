<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link type="text/css" href="/main_style.css" rel="stylesheet">
		<link rel="icon" href="/source/Logo_only.svg">

		<title>TATTOO-pro</title>
	</head>
<body class="full-screen">
	<h1 class="sr-only">TATTOO PRO - WEBSITE</h1>
	
	<a href="/users" class="home-image">
		<img src="/source/Logo_L.svg" class="logo">
	</a>
    <section class="main-section">
		<div class="auto-margin error-wrap">
			<div class="error-img">
			</div>
			<h3>
			Oh no!<br>An error has occured.
			</h3>
			<p><b>${errorMsg}</b>
			</p>
		</div>
	</section>
</body>
</html>
