package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.SalesHelper;
import model.SalesTransaction;

import java.util.Date;;

/**
 * Servlet implementation class UpdateSaleController
 */
@WebServlet("/UpdateSaleController")
public class UpdateSaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSaleController() {
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

		// End Update Member

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Update DeliveryAgent

		PrintWriter out = response.getWriter();
		out.print("Done ");
		SalesTransaction sales = new SalesTransaction();
		String prod = request.getParameter("prodID");
		sales.setProdID(prod);
				
		try {
			boolean executionStatus = SalesHelper.updateMember(sales);

			if (executionStatus) {
				out.print(true);
				response.sendRedirect(request.getContextPath() + "/AddSales.jsp?add=true");

			} else {
				out.print(SalesHelper.updateMember(sales));
			}

		} catch (ClassNotFoundException cnfe) {
			out.print(cnfe);
		} catch (SQLException se) {
			out.print(se);
		}
		//
	}

}
