<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.data.entities.Customer" %>
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
			Customer customer = (Customer) request.getAttribute("user");
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
						<hr>
						<div class="flex-container-column profile-box-buttons">
							<button type="button" class="editBtn" onclick="changeDisplayItemID('edit_info', 'block')">Edit profile</button>
							<button type="button" class="editBtn" onclick="changeDisplayItemID('change_password', 'block')">Change password</button>
							<button type="button" class="editBtn" onclick="changeDisplayItemID('change_profilePic', 'block')">Change profile picture</button>
						</div>
					</div>
				</div>

				<div class="flex-container-column">

					<div id="edit_info" class="profile-box">
						<div class="flex-container-row profile-box-header">
							<h3>EDIT INFO</h3>
							<button class="x-button" onclick="changeDisplayItemID('edit_info', 'none')"></button>
						</div>
						<form name="editProfCust" action="/myprofile/customer/edit/profile" method="post">
							<table class="profile-box-border">
								<tr>
									<th>Update Email:</th>
									<td><input type="text" name="email"><td>
								</tr>
								<tr>
									<td><button type="submit" value="Edit" id="mail_UpdBtn">Update</button><td>
								</tr>
							</table>
						</form>
					</div>

					<div id="change_password" class="profile-box">
						<div class="flex-container-row profile-box-header">
							<h3>CHANGE PASSWORD</h3>
							<button class="x-button" onclick="changeDisplayItemID('change_password', 'none')"></button>
						</div>
						<form name="editPassCust" action="/myprofile/customer/edit/password" method="post">
							<table class="profile-box-border">
								<tr>
									<th>New Password:</th>
									<th><input type="password" name="pass"></th>
								</tr>
								<tr>
									<th></th>
									<th><button type="submit" name="submitPassword" value="Change"  id="submitPasswd">Change</button></th>
								</tr>
							</table>
						</form>
					</div>

					<div id="change_profilePic" class="profile-box">
						<div class="flex-container-row profile-box-header">
							<h3>CHANGE PROFILE PICTURE</h3>
							<button class="x-button" onclick="changeDisplayItemID('change_profilePic', 'none')"></button>
						</div>
						<table class="profile-box-border">
							<form name="editProfPicCust" action="/myprofile/customer/edit/picture" method="post">
							<tr>
								<th>Choose file:</th>
								<th><input type="file" name="myImage" accept="image/*" /></th>
							</tr>
							<tr>
								<th></th>
								<th><button type="submit" name="submitProfPic" value="Change"  id="submitProfPic">Change</button></th>
							</tr>
							</form>
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