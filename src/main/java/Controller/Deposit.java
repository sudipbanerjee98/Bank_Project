package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


import Dao.BankDao;
import Dto.BankTransaction;
import Dto.Bank_account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deposit")
public class Deposit extends HttpServlet{

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String amte =arg0.getParameter("amt");
		
		double amount = Double.parseDouble(amte);
		
		long acno = (long) arg0.getSession().getAttribute("ac_number");
		
		BankDao bankDao = new BankDao();
		Bank_account bank_account = bankDao.find(acno);
		
		bank_account.setAmount(bank_account.getAmount()+amount);
		
		BankTransaction bankTransaction = new BankTransaction();
		bankTransaction.setDeposit(amount);
		bankTransaction.setWithdraw(0);
		bankTransaction.setBalance(bank_account.getAmount());
		bankTransaction.setDate_time(LocalDateTime.now());
		
		List<BankTransaction> list = bank_account.getList();
		list.add(bankTransaction);//previous transaction history+ current transaction
		bank_account.setList(list);
		
		
		bankDao.update_the_details(bank_account);
		
		arg1.getWriter().print("<h1>Amount deposit successful</h1>");
		arg0.getRequestDispatcher("Account_home_page.html").include(arg0, arg1);
		
	}
}
