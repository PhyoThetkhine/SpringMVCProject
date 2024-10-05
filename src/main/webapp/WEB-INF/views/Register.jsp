<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>  
 
</head>
<body>
<span class="text-danger">${error}</span>
<form:form modelAttribute="userobj" method="post" action="insert">
        <label for="name">Name</label>
        <form:input path="name" />
        <form:errors path="name" cssClass="error" /><br>

        <label for="email">Email:</label>
        <form:input path="email" />
        <form:errors path="email" cssClass="error" /><br>

        <label for="password">Password:</label>
        <form:input path="password" />
        <form:errors path="password" cssClass="error" /><br>

        <input type="submit" value="Register" />
    </form:form>
   
</body>
</html>