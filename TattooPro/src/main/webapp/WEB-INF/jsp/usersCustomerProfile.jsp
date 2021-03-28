<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.DTO.CustomerDTO" %>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.html.generator.HtmlGenerator" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link type="text/css" href="/main_style.css" rel="stylesheet">
		<link rel="icon" href="/source/Logo_only.svg">
	
		<title>TATTOO-pro</title>
	</head>

	<script src="/basic_JS.js"></script>

	<body>
		<h1 class="sr-only">TATTOO PRO - WEBSITE</h1>

		<%=HtmlGenerator.getHeader()%>

		<%
			CustomerDTO customer = (CustomerDTO) request.getAttribute("customer");
		%>
		<section id="profile-container" class="main-section flex-container-column">
			<div id="profile-head-wrap" class="flex-container-row">
				<div style="background-image: url(/images/<%=customer.getUsername()%>);"></div>
				<h1><%= customer.getUsername()%></h1>
			</div>

			<div id="profile-main" class="flex-container-row">

				<div class="profile-box">
					<div class="profile-box-header">
						<h3>PROFILE INFO</h3>
					</div>
					<div class="profile-box-border">
						<table>
							<tr>
								<th>Username:</th>
								<td><%= customer.getUsername()%></td>
							</tr>
							<tr>
								<th>Email:</th>
								<td><%= customer.getEmail()%></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</section>
		<footer class="main-footer">
			Copyright &copy; &nbsp;&nbsp;&nbsp; 2020 TattooPro &nbsp;&nbsp;&nbsp; CVUT FIT
		</footer>
	</body>
</html>