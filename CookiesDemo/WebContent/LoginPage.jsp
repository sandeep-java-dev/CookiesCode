<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
Cookie arr[] = request.getCookies();
String username = "";
String password = "";
boolean cookieFound = false;

if(arr != null)
{
	cookieFound = true;
	for(Cookie c:arr)
	{
		String cookieName = c.getName();
		if(cookieName.equals("username")) username = c.getValue();
		if(cookieName.equals("password")) password = c.getValue();
	}
}
%>
<body>
		<form method="post" action="LoginServletPage">
			username<input type="text" name="username" value="<%=username%>"><br/>
			
			<input type="submit">
		</form>
</body>
</html>