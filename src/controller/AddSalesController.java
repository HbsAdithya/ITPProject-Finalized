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
 * Servlet implementation class AddAgentController
 */
@WebServlet("/AddSalesController")
public class AddSalesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddSalesController() {
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

		sales.setProdID(request.getParameter("prodID"));
		sales.setProdName(request.getParameter("prodName"));
		double price = Double.parseDouble(request.getParameter("price"));
		sales.setPrice(price);
		int qty = Integer.parseInt(request.getParameter("qty"));
		sales.setQty(qty);
		double total = qty * price;
		sales.setTotal(total);
		// sales.setTotal(total);

		try {
			boolean executionStatus = SalesHelper.addSingleSale(sales);
			response.sendRedirect(request.getContextPath()+"/AddSales.jsp");

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
