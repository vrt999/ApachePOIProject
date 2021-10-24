package ApachePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleDBConnect {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/selenium","root","Ravi@2018");
		PreparedStatement statement = con.prepareStatement("select * from usercreds");
		ResultSet result = statement.executeQuery();
		result.next();
		System.out.println("Username: " + result.getString(1));
		System.out.println("password: " + result.getString(4));		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vrt999\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://onecognizant.cognizant.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://onecognizant.cognizant.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(result.getString(1));
		driver.findElement(By.xpath("//input[@id = 'PasswordInternal']")).sendKeys(result.getString(4));
		driver.findElement(By.xpath("//input[@id = 'Log_On1']")).click();
		

	}

}
