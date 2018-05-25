<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.SearchBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  method="POST" action="index.html">
	<input type="submit" value="戻る"><br><br>
</form>
<%=bean.getMessege() %>
<table border="1">
<tr>
<td>ID</td>
<td>NAME</td>
<td>DATE</td>
<td>SEX</td>
</tr>
<tr>
<td><%=bean.getId() %></td>
<td><%=bean.getName() %></td>
<td><%=bean.getDate().toString() %></td>
<td><%=bean.getSex().toString() %></td>
</tr>
</table>

</body>
</html>