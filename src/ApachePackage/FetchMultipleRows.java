package ApachePackage;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FetchMultipleRows {
	public int userid;
	public String firstname;
	public String lastname;
	public String pswrd;
	public String s ;
	
	public FetchMultipleRows() {}
	public FetchMultipleRows(int _userid,String _firstname,String _lastname,String _pswrd) {
		this.userid = _userid;
		this.firstname = _firstname;
		this.lastname = _lastname;
		this.pswrd = _pswrd;

	}
	public int getId() {
		return userid;
	}
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public String getPswd() {
		return pswrd;
	}
//	public static Connection getConnection() {
//		Connection cn;
//		try {
//			cn = DriverManager.getConnection("jdbc:mysql://Localhost:3306/selenium","root","Ravi@2018");
//			return cn;
//		}
//		catch(Exception ex){
//		ex.printStackTrace();	
//		return null;
//		}
//	}
		
		public static List<FetchMultipleRows> BindList(String s){
			try {
//				String constrng = "jdbc:mysql://Localhost:3306/selenium?autoReconnect=true&useSSL=false";
//				Connection conn = DriverManager.getConnection(constrng,"root","Ravi@2018");
				Connection conn = DBConnectLib.getConnection("selenium");
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(s);
				
				List<FetchMultipleRows> list = new ArrayList<FetchMultipleRows>();
				while(rs.next())
				{
					FetchMultipleRows u = new FetchMultipleRows(Integer.parseInt(rs.getString("userid")),rs.getString("firstname"),rs.getString("lastname"),rs.getString("pswd"));
					list.add(u);		
					}
				
				System.out.println("The result string: \n" + list);
				
				return list;
		}
			catch(Exception ex) {
				ex.printStackTrace();
				return null;
			}
		
	}
	public static void main(String[] args) throws Exception {
		
		String l = "select * from usercreds";
		
		List<FetchMultipleRows> check = BindList(l);
			
		String s1 = Integer.toString(check.get(2).userid);
		String s2 = check.get(2).pswrd;
		
		System.out.println("The output is: " + s1+ " " + s2);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vrt999\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://onecognizant.cognizant.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://onecognizant.cognizant.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(s1);
		driver.findElement(By.xpath("//input[@id = 'PasswordInternal']")).sendKeys(s2);
		driver.findElement(By.xpath("//input[@id = 'Log_On1']")).click();
		Thread.sleep(3000);
				
	}

}
