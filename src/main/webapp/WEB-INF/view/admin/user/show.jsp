<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-12 mx-auto">
            <div class="d-flex justify-content-between">
                <h3>User Detail with id = ${id}</h3>
            </div>
            <hr/>
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">User Information</h5>
                    <p class="card-text">ID: ${user.id}</p>
                    <p class="card-text">Email: ${user.email}</p>
                    <p class="card-text">Full Name: ${user.fullName}</p>
                    <p class="card-text">Phone: ${user.phone}</p>
                    <p class="card-text">Address: ${user.address}</p>
                </div>
                <a href="/admin/user" class="btn btn-primary">Back to User Table</a>
            </div>

        </div>
    </div>
</div>
</body>
</html>