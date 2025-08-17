package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import Dao.CustomerDao;
import Dto.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer_signup")
public class Customer_sign_up extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		String mob = req.getParameter("mobile");
		long ph=Long.parseLong(mob);
		
		String email = req.getParameter("email");
		String gender = req.getParameter("gender");
		String dob = req.getParameter("dob");
//		long mob = Long.parseLong("ph");
//		String checkbox = req.getParameter("checkbox");
//		resp.getWriter().print("<h1>"+name+"</h1>"+
//								"<h1>"+password+"</h1>"+
//								"<h1>"+email+"</h1>"+
//								"<h1>"+gender+"</h1>"+
//								"<h1>"+DoB+"</h1>");
		
		
		
		Date date = Date.valueOf(dob); // here it is indecated that we have converted successfully
		Period period = Period.between(date.toLocalDate(), LocalDate.now());
		int age = period.getYears();
		
		
		Customer customer = new Customer();
		CustomerDao customerDao = new CustomerDao();
		
		
		if(age>=18)
		{
				if(customerDao.check1(email).isEmpty()&& customerDao.check2(ph).isEmpty())
				{
				
		
				//resp.getWriter().print("<h1>He is eligible to create bank account</h1>");
				customer.setCname(name);
				customer.setDob(date);
				customer.setEmail(email);
				customer.setGender(gender);
				customer.setPasssword(password);
				customer.setPh(ph);
				
				
				customerDao.save(customer);
//				resp.getWriter().print("<h1>Account has created successful</h1>");
				Customer customer2 = customerDao.check1(email).get(0);
			
				if(customer2.getGender().equals("female"))
					{
					resp.getWriter().print("<h1>Hello madam</h1>");
					}
				else 
					{
					resp.getWriter().print("<h1>Hello sir</h1>");
					}
			
				resp.getWriter().print("<h1>Account has created successfully your customer id is:"+customer2.getCid()+"</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);	
			}
			else
			{
				resp.getWriter().print("<h1>This_email_id:"+email+" "+"and_this_mobile_number:"+" "+ph+" "+"is_already_created");
			}
		}
			
		else 
		{
			resp.getWriter().print("<h1>He is not eligible to create bank account</h1>");
		}
	}
}
		
	
	

