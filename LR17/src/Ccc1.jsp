<%@ page language="java"   contentType="text/html;charset=ISO-8859-1"%>
<%@ page import="jspclass.CBean "%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab_17</title>

</head>
<body>
	<% CBean Cb = (CBean)request.getAttribute("atrCBean");%>
	<br><%=request.getParameter("CBean")%> Value1 = <%=Cb.GetValue1()%>
	<br><%=request.getParameter("CBean")%> Value2 = <%=Cb.GetValue2()%>
	<br><%=request.getParameter("CBean")%> Value3 = <%=Cb.GetValue3()%>
</body>
</html>