<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.DTO.TattooArtistDTO" %>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.html.generator.HtmlGenerator" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
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
                    <th>Verified</th>
                    <th>Years of Experience</th>
                </tr>
                <%
                    List<TattooArtistDTO> artists = (List<TattooArtistDTO>) request.getAttribute("artists");

                    for(TattooArtistDTO artist:artists){%>
                    <tr>
                        <td><a href="/users/artist/<%=artist.getUsername()%>"><%=artist.getUsername()%></a></td>
                        <td><%=artist.getEmail()%></td>
                        <td><%=artist.getVerified()%></td>
                        <td><%=artist.getYearsOfExperience()%> Years</td>
                    </tr>
                <%}%>
            </table>
        </div>
    </section>
    <footer class="main-footer">
        Copyright &copy; &nbsp;&nbsp;&nbsp; 2020 TattooPro &nbsp;&nbsp;&nbsp; CVUT FIT
    </footer>
</body>
</html>
