package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.ReturnHelper;
import model.ReturnTransaction;

/**
 * Servlet implementation class AddAgentController
 */
@WebServlet("/AddReturnController")
public class AddReturnController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddReturnController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ReturnTransaction return1 = new ReturnTransaction();

		
		//return1.setReturn_id(request.getParameter("Return ID"));
		return1.setName(request.getParameter("customer_name"));
		return1.setProduct(request.getParameter("product"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		return1.setQuantity(quantity);
		double amount = Double.parseDouble(request.getParameter("amount"));
		return1.setAmount(amount);
		double total = quantity * amount;
		return1.setTotal(total);
		

		try {
			boolean executionStatus = ReturnHelper.addSingleReturn(return1);
			

			if (executionStatus)
				response.sendRedirect(request.getContextPath()+"/CustomerReturn.jsp");
			else
				out.print(false);

		} catch (ClassNotFoundException cnfe) {
			out.println(cnfe);
		} catch (SQLException se) {
			out.print(se);
		}
	}

}
