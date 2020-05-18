package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.SupplierHelper;

import model.Supplier;


@WebServlet("/DeleteSupplierController")



	public class DeleteSupplierController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public DeleteSupplierController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			try (PrintWriter out = response.getWriter()) {
				
				
				
				Supplier supplier = new Supplier();
				
				supplier.setSupplier_id(Integer.parseInt(request.getParameter("supplier_id")));
			
				try {
				
					boolean executionStatus = SupplierHelper.deleteSupplier(supplier);
					
					if(executionStatus) 
						response.sendRedirect(request.getContextPath()+"/ManageSupplier.jsp?add=true");
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


