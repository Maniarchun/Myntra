package com.myntra.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties p;
	public ConfigReader() throws IOException {
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\Myntra\\src\\main\\java\\com\\myntra\\properties\\Myntra.properties");
		FileInputStream fi = new FileInputStream(f);
		p = new Properties();
		p.load(fi);
	}
	
	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}
	public String getUrl() {
		String url = p.getProperty("url");
		return url;
	}

}
