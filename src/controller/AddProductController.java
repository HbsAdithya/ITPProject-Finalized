package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import helper.ProductHelper;
import model.Product;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddHotelController
 */
@MultipartConfig
@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (PrintWriter out = response.getWriter()) {

			// Add product

			Product product = new Product();
			InputStream inputStream = null;
			out.println("hello");
			product.setProduct_name(request.getParameter("product_name"));
			product.setProduct_description(request.getParameter("product_description"));
			out.println("hello1");
			product.setProduct_image(request.getParameter("product_name") + ".png");
			product.setProduct_quantity(Integer.parseInt(request.getParameter("product_quantity")));
			out.println("hello2");
			product.setProduct_category(request.getParameter("product_category"));
			product.setProduct_expiredate(request.getParameter("product_expiredate"));
			product.setProduct_generic(request.getParameter("product_generic"));
			product.setProduct_code(request.getParameter("product_code"));
			product.setProduct_cost(Double.parseDouble(request.getParameter("product_cost")));
			product.setProduct_retailprice(Double.parseDouble(request.getParameter("product_retailprice")));
			product.setSupplier_name(request.getParameter("supplier_name"));
			out.println("hello3");
			// obtains the upload file part in this multipart request
			Part filePart = request.getPart("product_image");
			out.println("hello4");
			// obtains input stream of the upload file
			inputStream = filePart.getInputStream();
			out.println("hello5");
			// Change the output path accordingly
			out.println("hello6");
			OutputStream output = new FileOutputStream("C:\\Users\\User\\eclipse-workspace\\inventroy_managment\\WebContent\\public\\uploads\\"+ product.getProduct_name() + ".png");
			byte[] buffer = new byte[1024];
			while (inputStream.read(buffer) > 0) {
				output.write(buffer);
				out.println("hello6");
			}
			out.println("hello7");
			try {
				out.println("hello8");
				boolean executionStatus = ProductHelper.addProduct(product);

				if (executionStatus) {
					response.sendRedirect(request.getContextPath() + "/AddProduct.jsp");
				} else
					response.sendRedirect(request.getContextPath() + "/AddProduct.jsp");

			} catch (ClassNotFoundException cnfe) {
				out.print(cnfe);
			} catch (SQLException se) {
				out.print(se);
			}

		}

	}
}