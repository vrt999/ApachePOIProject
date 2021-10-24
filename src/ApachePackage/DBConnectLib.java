package ApachePackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectLib {
	public static Connection getConnection(String s) throws Exception {
		String s1 = "jdbc:mysql://Localhost:3306/" + s;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(s1,"root","Ravi@2020");
		return(con);
		}
}
