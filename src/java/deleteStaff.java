package java;

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
 * @author deleteStaff
 */
@WebServlet(urlPatterns = {"/deleteStaff"})
public class deleteStaff extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","");			

            String q1 = "delete from staff where id="+id;
            PreparedStatement ps = con.prepareStatement(q1);
            ps.executeUpdate();
            response.sendRedirect("viewStaff.jsp");
		} catch (Exception e) {
			out.print(e);
		}
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
