<%@page import="Dto.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Transaction Page</title>
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
            padding: 10px 20px;
            margin-top: 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
            display: inline-block;
            text-decoration: none; /* Added to remove underlines from buttons */
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h1>Welcome to Transaction Page</h1>

    <%
        long acno = (long)request.getSession().getAttribute("ac_number");
        BankDao bankDao = new BankDao();
        Bank_account bank_account = bankDao.find(acno);
        List<BankTransaction> list = bank_account.getList();
    %>

    <table class="table">
        <thead>
            <tr>
                <th>Tid</th>
                <th>Deposit</th>
                <th>Withdraw</th>
                <th>Balance</th>
                <th>Transaction Date</th>
            </tr>
        </thead>
        <tbody>
            <% for(BankTransaction bankTransaction : list) { %>
                <tr>
                    <td><%= bankTransaction.getTid() %></td>
                    <td><%= bankTransaction.getDeposit() %></td>
                    <td><%= bankTransaction.getWithdraw() %></td>
                    <td><%= bankTransaction.getBalance() %></td>
                    <td><%= bankTransaction.getDate_time() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>

    <a href="Account_home_page.html"><button class="btn btn-primary">Back</button></a>

    <!-- Add Bootstrap JS (Optional, if you need Bootstrap JavaScript features) -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
