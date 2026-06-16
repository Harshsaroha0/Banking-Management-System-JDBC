package BankingManagment.DB;
import java.sql.*;

public class DbConnection {
	
	static String url = "jdbc:mysql://127.0.0.1:3306/bank";
	static String root = "root";
	static String pass ="harsh123";
	
	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url , root , pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
