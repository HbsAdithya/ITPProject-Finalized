package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.SalesHelper;
import model.SalesTransaction;

/**
 * Servlet implementation class ResetSalesController
 */
@WebServlet("/ResetSalesController")
public class ResetSalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetSalesController() {
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
		// TODO Auto-generated method stub
		// Add Member
		PrintWriter out = response.getWriter();
		SalesTransaction sales = new SalesTransaction();

		try {
			boolean executionStatus = SalesHelper.deleteSale(sales);
			response.sendRedirect(request.getContextPath() + "/AddSales.jsp");

			if (executionStatus)
				;
			else
				out.print(false);

		} catch (ClassNotFoundException cnfe) {
			out.println(cnfe);
		} catch (SQLException se) {
			out.print(se);
		}
	}
}
