package com.myntra.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPagePom {
	public static WebDriver driver;
	

	@FindBy(xpath = "//li[@class='product-base']")
	private List<WebElement> NoOfProduct;
	
	@FindBy(xpath = "//li[@class='product-base']//ancestor::span[@class='product-discountedPrice']")
	private List<WebElement> allPrice;
	
	@FindBy(xpath = "//li[@class='product-base']//ancestor::span[text()='\"+ miniPrice + \"']//ancestor::div[@class='product-productMetaInfo']/h3")
	private WebElement miniPriceBrand;
	
	@FindBy(xpath = "//li[@class='product-base']//ancestor::span[text()='\"+miniPrice+\"']//ancestor::div[@class='product-productMetaInfo']//h3[text()='\"+brandName+\"']/following-sibling::h4[1]")
	private WebElement miniBrandTitle;
	
	public ResultPagePom(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getNoOfProduct() {
		return NoOfProduct;
	}

	public List<WebElement> getAllPrice() {
		return allPrice;
	}

	public WebElement getMiniPriceBrand() {
		return miniPriceBrand;
	}

	public WebElement getMiniBrandTitle() {
		return miniBrandTitle;
	}
}
