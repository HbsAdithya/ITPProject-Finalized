package java;

import java.sql.Date;
import java.sql.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author staffAdd
 */
@WebServlet(urlPatterns = { "/staffAdd" })
public class staffAdd extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String designation = request.getParameter("designation");
		String dob = request.getParameter("dateofbirth");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String nic = request.getParameter("nic");
		String phone = request.getParameter("phone");

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "");

			String q1 = "insert into staff values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(q1);
			ps.setString(1, null);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, designation);
			ps.setString(5, dob);
			ps.setInt(6, age);
			ps.setString(7, gender);
			ps.setString(8, nic);
			ps.setString(9, phone);
			ps.executeUpdate();

			// response.sendRedirect("CreateAccount_home.jsp");
			response.sendRedirect("addStaff.jsp");

		} catch (Exception ex) {
			out.println(ex);
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
