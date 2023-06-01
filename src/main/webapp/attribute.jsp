<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session attribute</title>
</head>
<body>
	<%
	String sessionKey1 = (String) request.getSession().getAttribute("sessionKey1");
	String sessionKey2 = (String) request.getSession().getAttribute("sessionKey2");
	String reqKey = (String) request.getAttribute("reqKey");
	out.println("sessionKey1=" + sessionKey1);
	out.println("sessionKey2=" + sessionKey2);
	out.println("reqKey=" + reqKey);
	%>
</body>
</html>