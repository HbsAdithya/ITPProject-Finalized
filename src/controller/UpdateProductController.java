package controller;




import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.ProductHelper;
import model.Product;

/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (PrintWriter out = response.getWriter()) {
			
			// Update product
			
			Product product = new Product();
			
			product.setProduct_name(request.getParameter("product_name"));
			
			product.setProduct_description(request.getParameter("product_description"));
		
			product.setProduct_image(request.getParameter("product_image"));
            product.setProduct_quantity(Integer.parseInt(request.getParameter("product_quantity")));
			
			product.setProduct_category(request.getParameter("product_category"));
			product.setProduct_expiredate(request.getParameter("product_expiredate"));
			product.setProduct_generic(request.getParameter("product_generic"));
			product.setProduct_code(request.getParameter("product_code"));
			product.setProduct_cost(Double.parseDouble(request.getParameter("product_cost")));
			product.setProduct_retailprice(Double.parseDouble(request.getParameter("product_retailprice")));
			product.setSupplier_name(request.getParameter("supplier_name"));
			
			product.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
			
			try {
			
				boolean executionStatus = ProductHelper.updateProduct(product);
				
				if(executionStatus) 
					response.sendRedirect(request.getContextPath()+"/Admin/products.jsp?update=true");
				else
					response.sendRedirect(request.getContextPath()+"/Admin/products.jsp?update=false");
			
			
			} catch (ClassNotFoundException cnfe) {
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
