<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

     <h1>Customer Registration</h1>
     <form action="regCustomer" method="post">
          
       Name :<input type="text" name="tbName" id="tbName"  />
       <br>
       Email :<input type="text" name="tbEmail" id="tbEmail"/>
       <br>
       Mobile:<input type="text" name="tbMob" id="tbMob" />
       <br>
       Password:<input type="text" name="tbPass" id="tbPass"/>
       <br>
       
       State:<select name="ddlStates" id="tbState">
       
            <option>---select----</option>
            <option value="uttar pradesh">U.P</option>
            
            <option value="karnataka">KA</option>
            <option value="Mumbai">MA</option>
       
       </select>
       <br>
       <input type="submit" value="Register" />
       
</form>

</body>
</html>