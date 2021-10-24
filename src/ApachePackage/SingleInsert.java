package ApachePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SingleInsert {

	public static void main(String[] args) throws Exception {
		String s = "update usercreds set user_id = 100003 where user_id = 3";
		String constrng = "jdbc:mysql://Localhost:3306/selenium?autoReconnect=true&useSSL=false";
		Connection conn = DriverManager.getConnection(constrng,"root","Ravi@2018");
		PreparedStatement st = conn.prepareStatement(s);
		int count = st.executeUpdate();
		System.out.println(count + " rows affected");
		}

}
