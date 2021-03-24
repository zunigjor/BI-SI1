<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.html.generator.HtmlGenerator" %>
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
	<%=HtmlGenerator.getHeader()%>

	<section class="main-section flex-container-column">
		<div id="info-header">
			<h1>Information</h1>
		</div>
		<div class="flex-container-row info-content">
			<div>
				<h3>Developers and Contacts:</h3>
				<ul>
					<li>Project email: tattoopro@email.cz</li>
					<li>Team members:
						<ul>
							<li>Cihlář Ondřej cihlaond@fit.cvut.cz</li>
							<li>Seibert Michal seibemic@fit.cvut.cz</li>
							<li>Patera Michal patermi2@fit.cvut.cz</li>
							<li>Pončák Adam poncaada@fit.cvut.cz</li>
							<li>Šprachta Vít spracvit@fit.cvut.cz</li>
							<li>Zuňiga Jorge zunigjor@fit.cvut.cz</li>
						</ul>
					</li>
				</ul>
			</div>
			<div>
				<h3>About:</h3>
				<p> TattooPro is a platform for connecting tattoo artists with their clients.<br>
					Often clients have an idea about the tattoo they want to get but have <br>
					trouble finding a tattoo artist that might be an expert in the selected style.<br>
					This platform enables tattoo artists to get in touch with more clients<br>
					willing to get a tattoo in the style they like to do and enables them<br>
					to gain more experience in that style.<br>
					If you would like to know more you can <br></p>
				<ul>
					<li><i><a href="https://gitlab.fit.cvut.cz/seibemic/si1" target="_blank">visit the project gitlab</a></i></li>
					<li><i><a href="https://gitlab.fit.cvut.cz/seibemic/si1/wikis/home">visit the wiki page</a></i></li>
					<li><i><a href="https://gitlab.fit.cvut.cz/seibemic/si1/blob/master/1.%20Iterace/Analytick%C3%A1_dokumentace.pdf"> read the documentation</a></i></li>
				</ul>
			</div>
		</div>
	</div>
    <footer class="main-footer">
        Copyright &copy; &nbsp;&nbsp;&nbsp; 2020 TattooPro &nbsp;&nbsp;&nbsp; CVUT FIT
    </footer>
</body>
</html>

