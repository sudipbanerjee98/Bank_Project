<%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Account Creation Page</title>
    <!-- Add Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            padding: 20px;
            text-align: center;
            background-image: url("https://images.pexels.com/photos/6771985/pexels-photo-6771985.jpeg?auto=compress&cs=tinysrgb&w=600");
            background-repeat: no-repeat;
            background-size: cover;
        }

        h1 {
            color: blue;
        }

        form {
            max-width: 300px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input {
            margin-bottom: 10px;
        }

        button {
            width: 48%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        button[type="reset"] {
            background-color: #dc3545;
        }
    </style>
</head>
<body>

    <h1>Welcome to Account Creation Page</h1>

    <% Customer customer = (Customer) request.getSession().getAttribute("customer"); %>
    <h1>Hello, Dear <%= customer.getCname() %></h1>

    <form action="create_bank_account">
        <div>
            <input type="radio" value="savings" name="accounttype" required="required"> Savings<br><br>
            <input type="radio" value="current" name="accounttype" required="required"> Current<br><br>
            <button class="btn btn-primary">Submit</button>
            <button type="reset" class="btn btn-danger">Cancel</button>
        </div>
    </form>

    <!-- Add Bootstrap JS (Optional, if you need Bootstrap JavaScript features) -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
