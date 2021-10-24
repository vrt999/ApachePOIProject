package com.Testng.check;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class sampleTestNG {
	public static WebDriver driver;
	@DataProvider(name = "Data")
	public static Object[][] getData(){
		return new Object[][] {{"ravi4a4@gmail.com","vrt_9999"}};
	}
	
	@BeforeTest
	public WebDriver launchURL() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\vrt999\\Desktop\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.gmail.com");
	driver.manage().window().maximize();
	System.out.println("BeforeTest finished");
	return driver;
	}
	@Test(dataProvider = "Data",groups = "fasak")
	public void enterCrdeds(String User,String pass) throws Exception {
	//enter email

	driver.findElement(By.xpath("//input[@aria-label = 'Email or phone']")).sendKeys(User);
	//click Next
	driver.findElement(By.xpath("//span[text() = 'Next']")).click();
	Thread.sleep(2000);
	//enter password
	driver.findElement(By.xpath("//input[@aria-label = 'Enter your password']")).sendKeys(pass);
	//click Next
	driver.findElement(By.xpath("//span[text() = 'Next']")).click();
//	update sec settings
//	driver.findElement(By.xpath("//span[text() = 'Done']")).click();
	Thread.sleep(10000);
	//account click
	driver.findElement(By.xpath("//a[@class = 'gb_b gb_hb gb_R']")).click();
	//signout click
	driver.findElement(By.xpath("//a[text() = 'Sign out']")).click();
	System.out.println("Test finished");
	}
	@AfterTest
	public void quitdriver() {
//		driver.close();
		System.out.println("AfterTest finished");
		
	}
}
	


