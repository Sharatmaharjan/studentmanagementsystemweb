<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<form action="added" method="post">
		<table>
		<tr>
		Username:<input type="text" name="name" />
		</tr>
		<tr>
		<td>Address:<input type="text" name="address" /></td>
		</tr>
		<tr>
		<td>Surname:<input type="text" name="surname" /></td>
		</tr>
		<tr>
		<td>Phone:<input type="text" name="phone" /></td>
		</tr>
		</table>
		<input type="submit" value="OK">
	</form>
</body>
</html>