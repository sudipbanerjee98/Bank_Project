<%@page import="Dto.Customer"%>
<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Balance Page</title>
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

    <% long acno = (Long) request.getSession().getAttribute("ac_number");

		BankDao bankDao = new BankDao();
	 	Bank_account bank_account = bankDao.find(acno);
	 	Customer customer = bank_account.getCustomer();
    %>

    <h1>Hello <% if (customer.getGender().equals("male")) { %> Mr.<% } else { %> Ms.<% } %> <%= customer.getCname() %></h1>
    <h1>Your account balance is: <%= bank_account.getAmount() %></h1><br><br>

    <a href="Account_home_page.html"><button>Back</button></a>

</body>
</html>
