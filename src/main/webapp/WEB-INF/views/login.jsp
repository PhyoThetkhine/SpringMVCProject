<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>  
 
</head>
<body>
<span class="text-danger">${error}</span>
<form:form modelAttribute="loginObj" method="post" action="login">
        

        <label for="email">Email:</label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error" /><br>

        <label for="password">Password:</label>
        <form:input path="password" />
        <form:errors path="password" cssClass="error" /><br>

        <input type="submit" value="Login" />
    </form:form>
   
</body>
</html>