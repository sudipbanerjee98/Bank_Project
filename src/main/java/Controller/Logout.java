package Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class Logout extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.getSession().invalidate();// it is use to destroy or kill the session which hasbeen created
		arg1.getWriter().print("<h1>Logout successful</h1>");
		
		arg0.getRequestDispatcher("Home.html").include(arg0, arg1);
	}

}
