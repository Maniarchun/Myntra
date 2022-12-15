package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.myntra.base.MyntraBase;
import com.myntra.properties.ConfigHelper;
import com.myntra.properties.ConfigReader;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\ELCOT\\eclipse-workspace\\Myntra\\src\\test\\java\\com\\feature\\Myntra.feature",
					glue = "com.stepdefinition",
					monochrome = true,
					plugin = {"pretty",
							"html:Report/myntra.html",
							"json:Report/myntra.json",
							"junit:Report/myntra.xml"})
public class MyntraRunner {
	public static WebDriver driver;
	@BeforeClass
	public static void browerLaunch() throws IOException {
		String browser = ConfigHelper.getInstance().getBrowser();
		driver= MyntraBase.browserLaunch(browser);
	}
	@AfterClass
	public static void browserClose() {
		driver.close();
	}

}
