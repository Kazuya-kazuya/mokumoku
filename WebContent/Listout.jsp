<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.KaiinBean"%>
<jsp:useBean id="bean" class="bean.ListoutBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<form  method="POST" action="index.html">
	<input type="submit" value="戻る"><br><br>
</form>
<%=bean.getMessage() %><br>
<table>
<tr>
<td>ID</td>
<td>NAME</td>
<td>DATE</td>
<td>SEX</td>
</tr>
<%for(KaiinBean kaiin : bean.getList()){ %>
<tr>
<td><%=kaiin.getId() %></td>
<td><%=kaiin.getName() %></td>
<td><%=kaiin.getDate().toString() %></td>
<td><%=kaiin.getSex().toString() %></td>
</tr>
<%} %>
</table>
</body>
</html>