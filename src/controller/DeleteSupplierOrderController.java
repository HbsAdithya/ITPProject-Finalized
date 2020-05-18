package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.SupplierOrderHelper;

import model.SupplierOrder;


@WebServlet("/DeleteSupplierOrderController")



	public class DeleteSupplierOrderController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public DeleteSupplierOrderController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			try (PrintWriter out = response.getWriter()) {
				
				
				
				SupplierOrder supplierOrder = new SupplierOrder();
				
				supplierOrder.setSupOrd_id(Integer.parseInt(request.getParameter("supOrd_id")));
			
				try {
				
					boolean executionStatus = SupplierOrderHelper.deleteSupplierOrder(supplierOrder);
					
					if(executionStatus) 
						response.sendRedirect(request.getContextPath()+"/ManageSupplyDetails.jsp?add=true");
					else
						out.print(false);
				
				
				} catch (ClassNotFoundException cnfe) {
					out.print(cnfe);
				} catch (SQLException se) {
					out.print(se);
				}
			
				
				
					
			}

		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}


