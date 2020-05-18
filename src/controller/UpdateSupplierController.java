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


@WebServlet("/UpdateSupplierController")
public class UpdateSupplierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try (PrintWriter out = response.getWriter()){
			
			Supplier supplier=new Supplier();
			
			
			
			supplier.setSupplier_name(request.getParameter("supplier_name"));
			supplier.setSupplier_addr(request.getParameter("supplier_addr"));
			supplier.setSupplier_city(request.getParameter("supplier_city"));
			supplier.setSupplier_phone(Integer.parseInt(request.getParameter("supplier_phone")));
			supplier.setSupplier_email(request.getParameter("supplier_email"));
			supplier.setSupplier_id(Integer.parseInt(request.getParameter("supplier_id")));
			
			try {
				
				
				
				boolean executionStatus = SupplierHelper.updateSupplier(supplier);
				
				
				if(executionStatus) 
				{
					response.sendRedirect(request.getContextPath()+"/ManageSupplier.jsp?add=true");
				}else
					out.print(false);
			}
			catch(ClassNotFoundException cnfe) {
				out.print(cnfe);
			} catch (SQLException se) {
				out.print(se);
			}
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
