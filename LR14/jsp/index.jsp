<%@ page language="java"   contentType="text/html;charset=ISO-8859-1"%>//directives
<%@ page import="jsspclass.* "%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LR14</title>
<%! String name = null;
	String table = null;
	Regimex r = new Regimex();
	Integer n = r.GetHOUR();
	protected String Salutation(Integer h) {
		String rc = "Good ";
		if ((h >= 0) && (h <= 6))
			rc += "night";
		else if ((h > 6) && (h <= 12))
			rc += "morning";
		else if ((h > 12) && (h <= 17))
			rc += "afternoon";
		else
			rc += "evening";
		return rc;
	}
	protected String NextWeekTable(Integer CountString){
		Regimex r1 = new Regimex();
		table = "<table>";
		table+="<tr> <td>" + r1.GetCurrentDate() + "</td>";
			table += " <td>" + r1.GetDayOfWeek() + "</td></tr>";

		for(Integer i = 1;i<CountString;i++){
			table += "<tr> <td>" + r1.AddDays(1) + "</td>";
			table += " <td>" + r1.GetDayOfWeek() + "</td></tr>";
		}
		table+="</table>";
		return table;
	}%>
</head>
<body>
	<h1>
		<%=Salutation(n)%>
		<%=NextWeekTable(7)%>
		<br>
	</h1>
	<form>
		<input type="submit" name="f1" value="press(jsp:include)"/>
		<input type="submit" name="f2" value="press(include)"/>
	    <input type="submit" name="f3" value="press(forward)"/>

	</form>
		<%if("press(jsp:include)".equals(request.getParameter("f1"))){ %>
			<%if ((n >= 0) && (n <= 6)){out.println("JSP:INCLUDE");%>
					<jsp:include page="night.jsp"/>
			<%}else if ((n > 6) && (n <= 12)){out.println("JSP:INCLUDE");%>
					<jsp:include page="morning.jsp"/>
			<%}else if ((n > 12) && (n <= 17)){ out.println("JSP:INCLUDE");%>
					<jsp:include page="afternoon"/>
			<%}else{ out.println("JSP:INCLUDE");%>
					<jsp:include page="evening.jsp"/>
			<%}%>
		<%}%>
	<br>
	<br>
		<% if("press(include)".equals(request.getParameter("f2"))){ %>
			<%if ((n >= 0) && (n <= 6)){ out.println("INCLUDE");%>
					<%@ include file="night.jsp" %>
			<%}else if ((n > 6) && (n <= 12)){out.println("INCLUDE");%>
					<%@ include file="morning.jsp" %>
			<%}else if ((n > 12) && (n <= 17)){out.println("INCLUDE");%>
					<%@ include file="afternoon.jsp" %>
			<%}else{out.println("INCLUDE");%>
					<%@ include file="evening.jsp" %>
			<%}%>
		<%}%>
	<br>
	<br>

		<% if("press(forward)".equals(request.getParameter("f3"))){ %>
			<%if ((n >= 0) && (n <= 6)){%>
					<jsp:forward page="night.jsp"/>
			<%}else if ((n > 6) && (n <= 12)){%>
					<jsp:forward page="morning.jsp"/>
			<%}else if ((n > 12) && (n <= 17)){%>
					<jsp:forward page="afternoon.jsp"/>
			<%}else{%>
					<jsp:forward page="evening.jsp"/>
			<%}%>
		<%}%>
	<br>
	<br>


	<form>
		<input type="submit" name="f4" value="to servlet Afternoon (jsp:include)"/>
		<input type="submit" name="f5" value="to servlet Afternoon (jsp:forward)"/>
	</form>
		<% if("to servlet Afternoon (jsp:include)".equals(request.getParameter("f4"))){ %>
			<jsp:include page="afternoon">
				<jsp:param name="hour" value="<%=n%>" />
			</jsp:include>
		<%}%>
		<% if("to servlet Afternoon (jsp:forward)".equals(request.getParameter("f5"))){ %>
			<jsp:forward page="afternoon">
				<jsp:param name="hour" value="<%=n%>" />
			</jsp:forward>
		<%}%>
		<br>
		<br>
    <br>
	<br>
	<br>
    <br>

	<a href="Jjj?hour=<%=r.GetHOUR()%>">to Jjj</a>

	<br>
	<br>

	<form action="Jjj" method="post">
		<input type="text" name="hour" value="<%=n%>" visible="false"/>
		<input type = "submit" name="press"  value = "to Jjj (POST)" size = "20"/>
	</form>
</body>
</html>