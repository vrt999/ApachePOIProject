package ApachePackage;

import java.util.List;

 

public class DBConnect {
	public static void main(String args[]) throws Exception {
		String s2 = "Select * from usercreds";
		int n1 = 5;
		List<FetchMultipleRows> l = FetchMultipleRows.BindList(s2);
		System.out.println("First Name: " + l.get(n1).firstname);
	}
	

}

	


