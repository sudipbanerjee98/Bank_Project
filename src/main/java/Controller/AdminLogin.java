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

@WebServlet("/adminlogin")
public class AdminLogin extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		BankDao bankDao = new BankDao();
		if(email.equals("admin@gmail.com")&& name.equals("admin"))
		{
			resp.getWriter().print("<h1>Admin_login_success</h1>");
			
			List<Bank_account> list =bankDao.fetchAll();
					
			//session tracking
				
			req.getSession().setAttribute("list", list);
			req.getRequestDispatcher("Admin_home_page.jsp").include(req, resp);			
					
		}
		else 
		{
			resp.getWriter().print("<h1>Invalid_credential</h1>");
		}
	}
}
