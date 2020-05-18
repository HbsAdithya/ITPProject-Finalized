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

@WebServlet(urlPatterns = {"/addAttendance"})
public class addAttendance extends HttpServlet {


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
        String name =  request.getParameter("name");        
        String date =  request.getParameter("date");
        String atd =  request.getParameter("atd");
        
        try{
			
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy","root","");			

                String q1 = "insert into attendance values (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(q1);
                ps.setString(1, null);
                ps.setString(2, name);
                ps.setString(3, date);		
                ps.setString(4, atd);		



                ps.executeUpdate();

                //response.sendRedirect("CreateAccount_home.jsp"); 
                response.sendRedirect("index.jsp"); 
			
		}catch(Exception ex) {
			out.println(ex);
		}
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
