package java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author updateStaff
 */
@WebServlet(urlPatterns = {"/updateStaff"})
public class updateStaff extends HttpServlet {


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
        int id =  Integer.parseInt(request.getParameter("id"));
        String name =  request.getParameter("name"); 
        String address =  request.getParameter("address");
        String designation =  request.getParameter("designation");
        String dob = request.getParameter("dateofbirth");
        int age =  Integer.parseInt(request.getParameter("age"));
        String gender =  request.getParameter("gender");
        String nic =  request.getParameter("nic");
        String phone =  request.getParameter("phone");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionURL = "jdbc:mysql://localhost:3306/pharmacy";
            Connection conn = DriverManager.getConnection(connectionURL,"root","");
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE staff set full_name='"+name+"', address='"+address+"', designation='"+designation+"', dob='"+dob+"', age='"+age+"', gender='"+gender+"', nic='"+nic+"', phone='"+phone+"' WHERE id='"+id+"' ");
            response.sendRedirect("viewStaff.jsp");
            
            } catch (Exception e) {
                    out.print(e);
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
