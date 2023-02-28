<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
     
     <h1>Customer Login Page</h1>
     <form action="logCustomer" method="post">
     
     <label for="tbEmail"> Email: </label>
     <input type="email" name="tbEmail" id="tbEmail" value="<%=request.getParameter("tbEmail") %>"/>
     
     <br>

      <label for="tbPass"> Password: </label>
     <input type="password" name="tbPass" id="tbPass" value="<%=request.getParameter("tbPass") %>" />
     
     <br>
     <input type="submit" value="Login" />
     </form>
</body>
</html>