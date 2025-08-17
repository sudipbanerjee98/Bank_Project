package Controller;

import java.io.IOException;
import Dao.CustomerDao;
import Dto.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customerLogin")
public class CustomerLogin extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

		String cid =arg0.getParameter("custid");
		int customerid =Integer.parseInt(cid);
		
		String password =arg0.getParameter("pwd");
		
		CustomerDao customerDao = new CustomerDao();
		
		Customer customer = customerDao.login(customerid);
		
		if (customer == null) 
		{
			arg1.getWriter().print("<h1>Invalid customer id</h1>");
			arg0.getRequestDispatcher("Home.html").include(arg0, arg1);
				
		} 
		else 
		{
			if(customer.getPasssword().equals(password))
			{
				arg1.getWriter().print("<h1>Login success</h1>");
				arg0.getSession().setAttribute("customer", customer );
				arg0.getRequestDispatcher("Customer_home.html").include(arg0, arg1);
			}
			else {
				arg1.getWriter().print("<h1>invalid password</h1>");
				arg0.getRequestDispatcher("Home.html").include(arg0, arg1);		
			}

		}
		
		
	}
}
