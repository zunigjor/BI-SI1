<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.DTO.CustomerDTO" %>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.html.generator.HtmlGenerator" %>
<%@ page import="java.util.List" %>
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
<body>
    <h1 class="sr-only">TATTOO PRO - WEBSITE</h1>

	<%=HtmlGenerator.getHeader()%>

	<section class="main-section">
		<div class="full-width">
			<table class="users-table auto-margin">
				<tr>
					<th>Username</th>
					<th>E-mail</th>
				</tr>
				<%
					List<CustomerDTO> artists = (List<CustomerDTO>) request.getAttribute("customers");

					for(CustomerDTO customer:artists){%>
				<tr>
					<td><a href="/users/customer/<%=customer.getUsername()%>"><%=customer.getUsername()%></a></td>
					<td><%=customer.getEmail()%></td>
				</tr>
				<%}%>
			</table>
		</div>
	</section>
	<footer class="main-footer">
		Copyright &copy; &nbsp;&nbsp;&nbsp; 2020 TattooPro &nbsp;&nbsp;&nbsp; CVUT FIT
	</footer>
<h1 class="sr-only">TATTOO PRO - WEBSITE</h1>
</body>
</html>
