package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(username.equals("admin") && password.equals("123456"))
			{
				
				HttpSession session = request.getSession(); 
				session.setAttribute("user",username);
				response.sendRedirect(request.getContextPath()+"/Dashboard.jsp");
				
			
				
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
			
		

		}
}
