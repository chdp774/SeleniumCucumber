package com.nestle.framework.Hooks;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.nestle.framework.Factory.DriverFactory;
import com.nestle.framework.Util.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
//	private PropertiesReader propertyFileReader;
	Properties prop;
	
	@Before(value = "@skip_scenario", order = 0)
	public void skip_scenario(Scenario scenario) {
		System.out.println("Skipped scenario is: " +scenario.getName());
		Assume.assumeTrue(false);
	}
	
	@Before(order = 1)
	public void getProperty() {
//		propertyFileReader = new PropertiesReader();
//		prop = PropertiesReader.init_prop();
	}
	
	@Before(order = 2)
	public void launchBrowser() {
		String browserName = PropertiesReader.getPropertyvaluebyKey("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);	
	}
	
	@Before(order = 3)
	public void launchURL() {
		String M2FE_URL = PropertiesReader.getPropertyvaluebyKey("magento_frontend_url");
		driver.get(M2FE_URL);
		System.out.println(M2FE_URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot for failed scenarios
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}