package com.nestle.framework.Factory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	// to initialize the ThreadLocal driver on the basis of given browser
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("Browser name: "+ browser);
		if(browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")){
//			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		}
		else {
			System.out.println("please pass correct  browser value");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();	
	}
	
	// to get driver with ThreadLocal
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
