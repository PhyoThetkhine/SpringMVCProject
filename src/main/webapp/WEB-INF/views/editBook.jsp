<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Book Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Edit Book</h1>

        <!-- Error message display -->
        <span class="text-danger">${error}</span>

        <!-- Edit Book Form -->
        <form:form action="/book/editBook/${obj.id}" method="post" modelAttribute="obj">
            <!-- ID (Read-Only) -->
            <div class="mb-3">
                <label for="id" class="form-label">ID</label>
                <form:input path="id" id="id" class="form-control" readonly="true" />
            </div>

            <!-- Title Input -->
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <form:input type="text" id="title" path="title" class="form-control" placeholder="Enter book title" />
            </div>

            <!-- Author Input -->
            <div class="mb-3">
                <label for="author" class="form-label">Author</label>
                <form:input type="text" id="author" path="author" class="form-control" placeholder="Enter book author" />
            </div>

            <!-- Price Input -->
            <div class="mb-3">
                <label for="price" class="form-label">Price</label>
                <form:input type="text" id="price" path="price" class="form-control" placeholder="Enter book price" />
            </div>

            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Update Book</button>
        </form:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>