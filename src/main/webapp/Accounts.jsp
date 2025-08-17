<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Active Page</title>
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

        button {
            padding: 10px 20px;
            margin: 10px;
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

        .no-active-accounts {
            color: #dc3545;
            font-size: 18px;
        }
    </style>
</head>
<body>

    <% List<Bank_account> list = (List<Bank_account>) request.getSession().getAttribute("list");

    if (list.isEmpty()) { %>
        <h1 class="no-active-accounts">No active account found</h1>
    <% } else { %>
        <h1>Select Bank Account</h1>
        <% for (Bank_account bank_account : list) { %>
            <a href="setactiveaccount?accno=<%=bank_account.getAc_no() %>"><button><%=bank_account.getAc_no() %></button></a>
        <% } %>
    <% } %>

</body>
</html>
