package ApachePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateDBTable {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/selenium", "root", "Ravi@2018");
		Statement query = conn.createStatement();
		
		int update = query.executeUpdate("insert into selenium.usercreds(user_id,user_firstname,user_lastname,userpswd) values(12345,'Colin','McCormick','CYBG@2017')");
		System.out.println(update + "Row inserted");
		
		//exceuteQuery won't work for Data manipulation statements
//		PreparedStatement query1 = conn.prepareStatement("insert into selenium.usercreds(user_id,user_firstname,user_lastname,userpswd) values(12346,'Sally','Crawford','CYBG@2017')");
//		ResultSet check = query1.executeQuery();
//		System.out.println("Row inserted: " + check.rowInserted());
	}

}
