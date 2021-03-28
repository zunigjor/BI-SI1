<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.DTO.MessageDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fit.cvut.si1.semestralka.tattooPro.web.html.generator.HtmlGenerator" %>
<%@ page import="org.springframework.web.util.HtmlUtils"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<%
	List<MessageDTO> sent = (List<MessageDTO>) request.getAttribute("sent");
%>
	<head>
	    <meta charset="utf-8">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link type="text/css" href="/main_style.css" rel="stylesheet">
		<link rel="icon" href="/source/Logo_only.svg">
	
		<title>TATTOO-pro</title>
	</head>
	
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript">
		$(document).on('click', 'table tr', function(){
			$(this).addClass('mess_selected').siblings().removeClass('mess_selected')
		})
	</script>
	<script src="/basic_JS.js"></script>

	<body>
	<h1 class="sr-only">TATTOO PRO - WEBSITE</h1>

	<%=HtmlGenerator.getHeader()%>
	<section class="mess_choice-panel">
		<button class="mess_choice-button" type="button" onclick="changeDisplayItemID('mess_new-container', 'block')">NEW MESSAGE</button>
		<a href="received" class="mess_choice-button">RECEIVED</a>
		<a href="#" class="mess_choice-button">SENT</a>
	</section>
		<section class="main-section mess-main-section">
			<div class="mess_main">
				<table id="mess_table">
					<tr>
						<th>Username</th>
						<th>Date</th>
						<th></th>
					</tr>
					<%! int id = 0;%>
					<%for(MessageDTO message:sent){%>
					<%
						id += 1;
						String mess_source = message.getMessageText();
						String mess_escaped = HtmlUtils.htmlEscape(mess_source);
					%>
					<tr class="mess_tr" onclick="equalHTML( 'MSID_<%=id%>', 'mess_content-box' )">
						<td id="MSID_<%=id%>" style='display: none;'><%=mess_escaped%></td>
						<td><%=message.getReceiver()%></td>
						<td class="mess_timestamp"><%=message.getTimeStamp()%></td>
                        <td class="mess_respond-button"><button onclick="messageRespond('mess_new-container', 'block', 'username', '<%=message.getReceiver()%>')">&#62;</button></td>
					</tr>
					<%}%>
				</table>
			</div>
			<div class="mess_content">
				<p id="mess_content-box"></p>
			</div>
		</section>

		<section class="mess_new" id="mess_new-container">
			<div class="mess_new-head">
				<h1>New Message</h1>
				<button class="x-button" type="button" onclick="changeDisplayItemID('mess_new-container', 'none')"></button>
			</div>
			<form name="newMessage" class="mess_new-body" action="/myprofile/messages/new" method="post">
				<h2>To:</h2>
				<input name="username" id="username">
				<h2>Text:</h2>
				<textarea name="messageText" id="messageText"></textarea>
				<div class="mess_new-options" >
					<button type="submit" name="submitMessage" id="mess_send-message-btn" onclick="changeDisplayItemID('mess_new-container', 'none')">Send</button>
				</div>
			</form>
		</section>
		
		<footer class="main-footer">
			Copyright &copy; &nbsp;&nbsp;&nbsp; 2020 TattooPro &nbsp;&nbsp;&nbsp; CVUT FIT
		</footer>
	</body>
</html>

