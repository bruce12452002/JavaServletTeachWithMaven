<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 我是 JSP 註解，檢視/原始碼 時，不會看到這行註解 --%>
	<%
		out.println(request.getAttribute("a")); // 在 JSP 中，request、out 是關鍵字
	%>
</body>
</html>