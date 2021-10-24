package com.Testng.check;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DataProv{
	@FindBy(xpath = "//input[@aria-label = 'Email or phone']")
	WebElement emailtext;
	 
 }