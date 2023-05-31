package com.tests; 

import java.util.ArrayList; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class LoginTest {

	WebDriver driver=null;
	
	LoginPage lp=null;
	
	DashBoardPage dp=null;
	
    @BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Myallownloads\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("file:///D:/selenium_softwar/Offline%20Website/index.html");
    }
		@Test
		public void test01() {
			
		 lp=new LoginPage(driver);
		 
		 dp = lp.validLogin();
		 
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
		
		
		@Test
		public void test02() {
			
		ArrayList<String>expectedCourses=new ArrayList<String>();
		
			expectedCourses.add("Selenium");
			expectedCourses.add("Java / J2EE");
			expectedCourses.add("Python");
			expectedCourses.add("Php");

		ArrayList<String>actualcourses=dp.verifyCourses();
		
		Assert.assertEquals(actualcourses, expectedCourses);
		
		}
		
		
		
	
}
