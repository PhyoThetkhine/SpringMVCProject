<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <h2>User Form</h2>
    <form:form modelAttribute="userobj" method="post" action="adduser">
        <label for="id">ID:</label>
        <form:input path="id" />
        <form:errors path="id" cssClass="error" /><br>

        <label for="name">Name:</label>
        <form:input path="name" />
        <form:errors path="name" cssClass="error" /><br>

        <label for="age">Age:</label>
        <form:input path="age" />
        <form:errors path="age" cssClass="error" /><br>

        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>
