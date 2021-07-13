package carservice.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class mysql_connection {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
        mysql_connection pro = new mysql_connection();
        pro.createConnection();
    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException
    {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carservice", "root","root");
            System.out.println("Database Connection Success");
            return con;

}}
