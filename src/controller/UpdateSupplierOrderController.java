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


@WebServlet("/UpdateSupplierOrderController")
public class UpdateSupplierOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSupplierOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try (PrintWriter out = response.getWriter()){
			
			SupplierOrder supplierOrder=new SupplierOrder();
			
			
			
			supplierOrder.setSupplier_name(request.getParameter("sup_name"));
			supplierOrder.setProduct_name(request.getParameter("pro_name"));
			supplierOrder.setPro_quantity(Integer.parseInt(request.getParameter("pro_quantity")));
			supplierOrder.setPro_category(request.getParameter("pro_category"));
			supplierOrder.setDate_supplied(request.getParameter("date_supplied"));
			supplierOrder.setPro_cost(Integer.parseInt(request.getParameter("pro_cost")));
			supplierOrder.setCredit_limit(Integer.parseInt(request.getParameter("credit_limit")));
			supplierOrder.setSupOrd_id(Integer.parseInt(request.getParameter("supOrd_id")));
			
		
			
			try {
				
				
				
				boolean executionStatus = SupplierOrderHelper.updateSupplierOrder(supplierOrder);
				
				
				if(executionStatus) 
				{
					response.sendRedirect(request.getContextPath()+"/ManageSupplyDetails.jsp?add=true");
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
