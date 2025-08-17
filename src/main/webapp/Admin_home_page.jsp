<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home Page</title>
    <!-- Add Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            padding: 20px;
            text-align: center;
        }

        h1 {
            color: #007bff;
        }

        table {
            margin-top: 20px;
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #dee2e6;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        button {
            padding: 5px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <h1>Welcome to Admin Home Page</h1>

    <% List<Bank_account> list = (List <Bank_account>)request.getSession().getAttribute("list"); %>

    <table class="table">
        <thead>
            <tr>
                <th>Account Number</th>
                <th>Account Type</th>
                <th>Account Name</th>
                <th>Customer ID</th>
                <th>Account Status</th>
                <th>Change Status</th>
            </tr>
        </thead>
        <tbody>
            <% for(Bank_account bank_account : list) { %>
                <tr>
                    <td><%= bank_account.getAc_no() %></td>
                    <td><%= bank_account.getAccount_type() %></td>
                    <td><%= bank_account.getCustomer().getCname() %></td>
                    <td><%= bank_account.getCustomer().getCid() %></td>
                    <td><%= bank_account.isStatus() %></td>
                    <td><a href="changestatus?acno=<%= bank_account.getAc_no() %>"><button class="btn btn-primary">Change Status</button></a></td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <!-- Add Bootstrap JS (Optional, if you need Bootstrap JavaScript features) -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <br>
   <a href="Home.html"><button type="submit">Back</button></a>
</body>
</html>
