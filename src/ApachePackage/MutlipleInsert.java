package ApachePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MutlipleInsert {

	public static void main(String[] args) throws Exception {
		int id[] = {000001,000002,000003};
		String fn[] = {"Sally","Ken","David"};
		String ln[] = {"Crawford","Gregerson","Morrison"};
		String ps[] = {"Sally123","Ken123","David123"};
		String s = "insert into usercreds values(?,?,?,?)";
//		Class.forName("com.mysql.jdbc.Driver");
		String constrng = "jdbc:mysql://Localhost:3306/selenium?autoReconnect=true&useSSL=false";
		Connection conn = DriverManager.getConnection(constrng,"root","Ravi@2020");
		PreparedStatement st = conn.prepareStatement(s);
		
		for (int i =0;i<3;i++) {
			
			st.setInt(1, id[i]);
			st.setString(2, fn[i]);
			st.setString(3, ln[i]);
			st.setString(4, ps[i]);
			int count = st.executeUpdate();
			System.out.println("Iteration " + i + ": " + count +"row/s affected");
		}
		
	}

}
