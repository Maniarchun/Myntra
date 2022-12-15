package com.myntra.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePom {
	
	public static WebDriver driver;
	 

	@FindBy(xpath = "//nav[@class='desktop-navbar']//ancestor::a[@href='/shop/kids']")
	 private WebElement kid;
	 
	@FindBy(xpath = "//div[@data-reactid='334']//ancestor::a[@data-reactid='345']") 
	private WebElement Tshit;
	
	public HomePagePom(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getKid() {
		return kid;
	}

	public WebElement getTshit() {
		return Tshit;
	}

}
