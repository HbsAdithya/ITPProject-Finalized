package helper;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBHelper {
	
	private static DBHelper sc;
    private static Connection con;
    private static String url = "jdbc:mysql://localhost:3306/pharmacy";
    private static String username = "root";
    private static String password = "";

    private DBHelper() throws  SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
    }

    public static DBHelper getInstance() throws ClassNotFoundException, SQLException {
        if (sc == null) {
        	sc = new DBHelper();
        	return sc;
        } else {
            return sc;
        }
    }

    public static Connection getConnection(){
        return con;
    } 
}
    