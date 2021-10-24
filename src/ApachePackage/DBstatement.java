package ApachePackage;

import java.sql.*;

public class DBstatement {

	public static void main(String[] args) throws Exception {
		Connection con = DBConnectLib.getConnection("selenium");
		PreparedStatement s = con.prepareStatement("select * from selenium.usercreds where userid = 455504");
		ResultSet rs = s.executeQuery();
		
		

	}

}
