<%@ page language="java"   contentType="text/html;charset=ISO-8859-1"%>
<%@ page import="jspclass.CBean "%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab_16</title>

</head>
<body>
<%-- извлечена ссылка на  объект типа  CBean и с помощью get-методов объекта  выведены в окно браузера значения переменных   Value1, Value2 и Vаlue3. --%>
	<% ServletContext sc = getServletContext();
	CBean Cb = (CBean)sc.getAttribute("atrABean");%>
	<br><%=request.getParameter("CBean")%> Value1 = <%=Cb.GetValue1()%>
	<br><%=request.getParameter("CBean")%> Value2 = <%=Cb.GetValue2()%>
	<br><%=request.getParameter("CBean")%> Value3 = <%=Cb.GetValue3()%>
</body>
</html>