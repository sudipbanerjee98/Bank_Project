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

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String amt =req.getParameter("amt");
		
		double amount = Double.parseDouble(amt);
		
		long acno = (Long) req.getSession().getAttribute("ac_number");
		
		BankDao bankDao = new BankDao();
		
		Bank_account bank_account = bankDao.find(acno);
		
		if(bank_account.getAmount()<amount)
		{
			resp.getWriter().print("<h1>Insufficient balance your available balance is: "+ bank_account.getAmount()+"</h1>");
		}
		else {
			if(amount>bank_account.getAcc_limit())
			{
				resp.getWriter().print("<h1> you are exceeding your account limit your actual limit is:"+ bank_account.getAcc_limit()+"</h1>");
			}
			else
			{
				bank_account.setAmount(bank_account.getAmount()-amount);
				
				

				BankTransaction bankTransaction = new BankTransaction();
				bankTransaction.setWithdraw(amount);
				bankTransaction.setDeposit(0);
				bankTransaction.setBalance(bank_account.getAmount());
				bankTransaction.setDate_time(LocalDateTime.now());
				
				List<BankTransaction> list = bank_account.getList();
				list.add(bankTransaction);//previous transaction history+ current transaction
				bank_account.setList(list);
				
				
				bankDao.update_the_details(bank_account);
				
				resp.getWriter().print("<h1>amount has been withdrwan successfully</h1>");
				req.getRequestDispatcher("Account_home_page.html").include(req, resp);
					
				
			}
		}
		
		
		
		
		
	}

}
