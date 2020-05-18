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
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentController() {
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

		sales.setStaffID(request.getParameter("staffID"));
		String method = request.getParameter("paymentmethod");
		double cash;
		try {
			double gross = SalesHelper.grossTotal(sales);
			sales.setGrossTot(gross);
			int count = SalesHelper.itemCount(sales);
			sales.setNoOfItems(count);
			if (method.equals("cash")) {
				cash = Double.parseDouble(request.getParameter("cash"));
				sales.setAmountpayed(cash);
				sales.setCardtype(null);
				sales.setCardname(null);
				sales.setCustID(null);
				double balance = cash - gross;
				sales.setBalance(balance);

			} else if (method.equals("card")) {
				cash = 0.00;
				sales.setAmountpayed(gross);
				sales.setCardtype(request.getParameter("cardlist"));
				sales.setCardname(request.getParameter("card"));
				sales.setCustID(null);
				double balance = cash - gross;
				sales.setBalance(balance);
			} else if (method.equals("credit")) {
				cash = 0.00;
				sales.setAmountpayed(gross);
				sales.setCardtype(null);
				sales.setCardname(null);
				sales.setCustID(request.getParameter("customerID"));
				double balance = cash - gross;
				sales.setBalance(balance);
			}
			sales.setPaymethod(method);
			boolean executionStatus = SalesHelper.addSale(sales);
			response.sendRedirect(request.getContextPath() + "/AddSales.jsp");

			if (executionStatus) {
				out.print("Success");
				boolean exec = SalesHelper.deleteSale(sales);
				if (exec) {
					out.print(true);
				} else {
					out.print(false);
				}
				;
			} else
				out.print("Failure");

		} catch (ClassNotFoundException cnfe) {
			out.println(cnfe);
		} catch (SQLException se) {
			out.print(se);
			out.print("Done");
		}
	}

}
