<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.data.entities.TattooArtist" %>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.html.generator.HtmlGenerator" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link type="text/css" rel="stylesheet" href="/main_style.css">
		<link rel="icon" href="/source/Logo_only.svg">
	
		<title>TATTOO-pro</title>
	</head>

	<script src="/basic_JS.js"></script>

	<body>
		<h1 class="sr-only">TATTOO PRO - WEBSITE</h1>

		<%=HtmlGenerator.getHeader()%>

		<%
			TattooArtist artist = (TattooArtist)request.getAttribute("user");
		%>
		<section id="profile-container" class="main-section flex-container-column">
			<div id="profile-head-wrap" class="flex-container-row">
				<div style="background-image: url(/images/<%=artist.getUsername()%>);"></div>
				<h1><%= artist.getUsername()%></h1>
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
								<td><%= artist.getUsername()%></td>
							</tr>
							<tr>
								<th>Email:</th>
								<td><%= artist.getEmail()%></td>
							</tr>
							<tr>
								<th>Years of experience:</th>
								<td><%= artist.getYearsOfExperience()%> Years</td>
							</tr>
							<tr>
								<th>Your Hourly Price:</th>
								<% if (artist.getPricePerHour() == null) { %>
									<td>Not-set</td>
								<% } else { %>
									<td><%= artist.getPricePerHour()%></td>
								<% } %>
							</tr>
							<tr>
								<th>Verification:</th>
								<% if (artist.getVerified()) { %>
									<td>Verified</td>
								<% } else { %>
									<td>Not-verified</td>
								<% } %>
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
						<form name="editProf" action="/myprofile/artist/edit/profile" method="post">
							<table class="profile-box-border">
								<tr>
									<th>Update Email:</th>
									<td><input type="text" name="email" value="<%=artist.getEmail()%>"><td>
								</tr>
								<tr>
									<th>Update experience:</th>
									<td><input type="number" name="exp" value="<%=artist.getYearsOfExperience()%>"><td>
								</tr>
								<tr>
									<th>Update price:</th>
									<td><input type="number" name="price" value="<%=artist.getPricePerHour()%>"><td>
								</tr>
								<tr>
									<th></th>
									<td><button type="submit" value="Edit" id="prof_Upd">Update</button><td>
								</tr>
							</table>
						</form>
					</div>

					<div id="change_password" class="profile-box">
						<div class="flex-container-row profile-box-header">
							<h3>CHANGE PASSWORD</h3>
							<button class="x-button" onclick="changeDisplayItemID('change_password', 'none')"></button>
						</div>
						<form name="editPass" action="/myprofile/artist/edit/password" method="post">
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
							<form name="editProfPic" action="/myprofile/artist/edit/picture" method="post">
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