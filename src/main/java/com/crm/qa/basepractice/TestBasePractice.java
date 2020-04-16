package com.crm.qa.basepractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utilpractice.TestUtilPractice;

public class TestBasePractice {
	
	public static Properties prop;
	public static WebDriver driver;
	
public TestBasePractice(){
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:/Selenium Practice/FreeCRMTestPractice/src/main/java/com/crm"
				+ "/qa/configpractice/configuration.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public static void initialization(){
	String browserName = prop.getProperty("browser");
	if (browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if (browserName.equals("browser")){
		System.setProperty("webdriver.gecko.driver", "D:/Selenium/chromedriver_win32/geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(TestUtilPractice.IMPLICT_WAIT, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(TestUtilPractice.PAGE_LOAD_TIME, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
}
}

