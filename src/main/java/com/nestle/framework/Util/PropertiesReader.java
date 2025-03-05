package com.nestle.framework.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	public static String getPropertyvaluebyKey(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\durga\\eclipse-workspace\\SeleniumJavaCucumber\\src\\main\\resources\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String value = prop.get(key).toString();
		if(value.isBlank()) {
			try {
				throw new Exception("Value is not specified for key: "+key+ "in properties file.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return value;
		
	}
}
