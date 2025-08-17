package Controller;

import java.io.IOException;
import java.util.List;


import Dao.BankDao;
import Dto.Bank_account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/changestatus")
public class Change_status extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		String ac_no = req.getParameter("acno");
		long acc_no = Long.parseLong(ac_no);
		
		BankDao bankDao = new BankDao();
		Bank_account bank_account = bankDao.fecth_account_details(acc_no);
		
		if(bank_account.isStatus())
		{
			bank_account.setStatus(false);
		}
		else {
			bank_account.setStatus(true);
		}
		
		bankDao.update_the_details(bank_account);
		
		resp.getWriter().print("<h1>Status_got_updated</h1>");
		
		//here i am going to take the updated information from bank-account  table
		
		List<Bank_account> list = bankDao.fetchAll();
		req.getSession().setAttribute("list", list);
		
		req.getRequestDispatcher("Admin_home_page.jsp").include(req, resp);	
	}
}
