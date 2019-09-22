<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% String succ = request.getParameter("success"); %>
<%if(succ.equals("yes")){
	%>

<script>
window.onload = function() {
	self.window.alert("결제가 완료되었습니다.");
    location.href="index.jsp";
}
</script>
<%}else{ %>

<script>
window.onload = function() {
	self.window.alert("결제가 실패했습니다.");
    location.href="index.jsp";
}
</script>
<%} %>
<!DOCTYPE html>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>