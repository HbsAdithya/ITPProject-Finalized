package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import helper.SupplierOrderHelper;
import model.SupplierOrder;
import javax.servlet.http.Part;


	@WebServlet("/AddSupplierOrderController")
	public class AddSupplierOrderController extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	   public AddSupplierOrderController() {
		   
		   super();
	   }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try (PrintWriter out = response.getWriter()) {
				
				
			//Add Supplier
			
				SupplierOrder supplierOrder = new SupplierOrder();
				InputStream inputStream = null;
				
				
				//supplierOrder.setSupOrd_id(Integer.parseInt(request.getParameter("supOrd_id")));
				supplierOrder.setSupplier_name(request.getParameter("supplier_name"));
				supplierOrder.setProduct_name(request.getParameter("product_name"));
				supplierOrder.setPro_quantity(Integer.parseInt(request.getParameter("pro_quantity")));
				supplierOrder.setPro_category(request.getParameter("pro_category"));
				supplierOrder.setDate_supplied(request.getParameter("date_supplied"));
				supplierOrder.setPro_cost(Integer.parseInt(request.getParameter("pro_cost")));
				supplierOrder.setCredit_limit(Integer.parseInt(request.getParameter("credit_limit")));
				
				
				
				

				
			
				try {
				
					boolean executionStatus = SupplierOrderHelper.AddSupplierOrder(supplierOrder);
					
					if(executionStatus) 
						response.sendRedirect(request.getContextPath()+"/SupplyProduct.jsp?add=true");
					else
						out.print(false);
				
				
				} catch (ClassNotFoundException cnfe) {
					out.print(cnfe);
				} catch (SQLException se) {
					out.print(se);
				}
				
				// End Add Supplier
				
			}
			
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}


}
