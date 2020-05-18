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
 * Servlet implementation class DeleteSaleController
 */
@WebServlet("/DeleteSaleController")
public class DeleteSaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteSaleController() {
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

		try (PrintWriter out = response.getWriter()) {

			SalesTransaction sales = new SalesTransaction();
			String prod = request.getParameter("prodID");
			sales.setProdID(prod);

			try {

				boolean executionStatus = SalesHelper.deleteRecord(sales);

				if (executionStatus) {
					out.print("DONE");
					response.sendRedirect(request.getContextPath() + "/AddSales.jsp?add=true");

				} else
					out.print(false);

			} catch (ClassNotFoundException cnfe) {
				out.print(cnfe);
			} catch (SQLException se) {
				out.print(se);

			}

		}
	}
}
