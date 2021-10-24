package ApachePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcelLib {

	public static void main(String[] args) throws Exception {
		String fp = "C:\\Users\\vrt999\\Desktop\\ExcelData\\ExcelData.xlsx";
		ExcelLib excel = new ExcelLib(fp);
		String username = excel.getData(0, 0, 0);
		String password = excel.getData(0, 0, 1);
		System.out.println("User name fetched from excel sheet:" + username);
		System.out.println("User name fetched from excel sheet:" + password);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vrt999\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://onecognizant.cognizant.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("https://onecognizant.cognizant.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id = 'PasswordInternal']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id = 'Log_On1']")).click();
	}

}
