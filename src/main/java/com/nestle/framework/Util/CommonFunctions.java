package com.nestle.framework.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonFunctions{
	
	protected static WebDriver driver;
	//public static WebDriver driver;
	
	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void waitFor(int time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void enter_text(WebElement locator, String value) {
		locator.sendKeys(value);
	}
	
	public static void click(WebElement locator) {
		locator.click();
	}
	
	public static void DD_visiableText(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByVisibleText(value);
	}
}
