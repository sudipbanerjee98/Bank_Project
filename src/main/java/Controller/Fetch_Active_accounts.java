package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Dto.Bank_account;
import Dto.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/fetchactiveaccount")
public class Fetch_Active_accounts extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		Customer customer =(Customer) req.getSession().getAttribute("customer");
	
		List<Bank_account> list =customer.getBankaccounts();
		
		ArrayList<Bank_account> list2 =new ArrayList<>();
	
		for (Bank_account bank_account : list) 
		{
		
			if(bank_account.isStatus()== true)
			{
//				resp.getWriter().print("Status is active");
				list2.add(bank_account);
			}
//			else {
//				resp.getWriter().print("Status is in-active");
//			}
			
			req.getSession().setAttribute("list", list2);
			req.getRequestDispatcher("Accounts.jsp").include(req, resp);
			
		}
	}

}
