package com.myntra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SingleTonDesignPatten {
	public static WebDriver driver;

	public SingleTonDesignPatten(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	public HomePagePom getHomePage() {
		HomePagePom hp = new HomePagePom(driver);
		return hp;
	}
	public ResultPagePom getResultPage() {
		ResultPagePom rp = new ResultPagePom(driver);
		return rp;
	}

}
