package Controller;

import java.io.IOException;
import java.util.List;
import Dao.BankDao;
import Dao.CustomerDao;
import Dto.Bank_account;
import Dto.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create_bank_account")
public class Create_bank_account extends HttpServlet
{
      @Override
      protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException 
      {
		String acc_type =arg0.getParameter("accounttype");
		Customer customer =(Customer) arg0.getSession().getAttribute("customer");
		
		List<Bank_account> list = customer.getBankaccounts();
	
		boolean flag = true;
		
		for (Bank_account bank_account : list) 
		{
			if(bank_account.getAccount_type().equals(acc_type))
			{
				flag=false;
				break;
			}
		}
		if(flag==true)
		{
			Bank_account bank_account = new Bank_account();
			//bank_account.setAcc_no(0);
			//bank_account.setStatus(false);
			//bank_account.setAmount(0);
			 bank_account.setAccount_type(acc_type);
			
			if(bank_account.getAccount_type().equals("savings"))
			{
				bank_account.setAcc_limit(10000);
			}
				
			
			else
			{
				bank_account.setAcc_limit(15000);
			
			}
				bank_account.setCustomer(customer);
		
			
			BankDao bankDao = new BankDao();
			bankDao.save_account(bank_account);
			
			List<Bank_account> list2 = list;
			list2.add(bank_account);
			
			//customer.setBankaccounts(list2);
			
			CustomerDao customerDao = new CustomerDao();
			customerDao.update(customer);
			arg1.getWriter().print("<h1>Congratulations your account_has_created_successfully</h1>");
			arg0.getRequestDispatcher("Home.html").include(arg0, arg1);
			
		}
		else
		{
			arg1.getWriter().print("<h1>Already_account_is_existed</h1>");
		}
	}
	}
