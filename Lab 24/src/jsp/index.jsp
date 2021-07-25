<%@ page language="java" contentType="text/html;charset=ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lab_24</title>

</head>
<body>
<form action="Sss" method="POST">
	<p>Directory name<input name="dir-name" type="text"/>
		<input name="type" value="Create Directory" type="submit" size="10" maxlength="10"/></p>
</form>
<br><br>
<form method="POST" action="Sss" enctype="multipart/form-data">
	File:
	<input type="file" name="file" />
	<input type="submit" value="Upload" name="type" />
</form>
<br><br>
<form method="POST" action="Sss" >
	File:
	<input type="text" name="file"/>
	<input type="submit" value="Download" name="type" />
</form>
<br><br>
<form method="POST" action="Sss" enctype="multipart/form-data">
	Field file:
	<input type="text" name="dir1"/>
	File:
	<input type="text" name="file"/>
	New field file:
	<input type="text" name="dir2"/>
	<input type="submit" value="Copy" name="type" />
</form>
<br><br>
<form method="POST" action="Sss">
	File or directory:
	<input type="text" name="file" />
	<input type="submit" value="Delete" name="type" />
</form>
</body>
</html>