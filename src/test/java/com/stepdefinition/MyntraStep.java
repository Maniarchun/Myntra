package com.stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.myntra.base.MyntraBase;
import com.myntra.pom.SingleTonDesignPatten;
import com.myntra.properties.ConfigHelper;
import com.runner.MyntraRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyntraStep extends MyntraBase {
	public WebDriver driver = MyntraRunner.driver;
	int miniPrice;
	String brandName;

	SingleTonDesignPatten stdp = new SingleTonDesignPatten(driver);

	@Given("user Launch The Application Url")
	public void user_Launch_The_Application_Url() throws InterruptedException, IOException {
		String url = ConfigHelper.getInstance().getUrl();
		urlLaunch(url);

	}

	@When("user Select The Kid")
	public void user_Select_The_Kid() {
		WebElement kid = stdp.getHomePage().getKid();
		mouseAction(kid, "movetoelement");
	}

	@Then("user Select The T-Shirt")
	public void user_Select_The_T_Shirt() {
		stdp.getHomePage().getTshit().click();
	}

	@When("user Find Total Number Of Showing Result")
	public void user_Find_Total_Number_Of_Showing_Result() {
		System.out.println("Total Nuber Of Showing Product : " + stdp.getResultPage().getNoOfProduct().size());
	}

	@When("user Find The Minimum Price Product")
	public void user_Find_The_Minimum_Price_Product() {
		List<Integer> priceList = new ArrayList<>();
		List<WebElement> allPriceElement = stdp.getResultPage().getAllPrice();
		for (WebElement priceElement : allPriceElement) {
			String priceText = priceElement.getText().replaceAll("Rs. ", "");
			Integer price = Integer.valueOf(priceText);
			priceList.add(price);
		}
		miniPrice = Collections.min(priceList);
		System.out.println("Minimum Price Of The Showing Product : " + miniPrice);

	}

	@When("user Find The Minimum Price Product Brand Name")
	public void user_Find_The_Minimum_Price_Product_Brand_Name() {
		WebElement brandNameElement = driver.findElement(By.xpath("//li[@class='product-base']//ancestor::span[text()='"
				+ miniPrice + "']//ancestor::div[@class='product-productMetaInfo']/h3"));
		brandName = getingText(brandNameElement);
		System.out.println("Brand Name Of minimum price : " + brandName);

	}

	@Then("user Find The Minimum Price Product Brand Subtitle")
	public void user_Find_The_Minimum_Price_Product_Brand_Subtitle() {
		WebElement subTitleElement = driver.findElement(By.xpath("//li[@class='product-base']//ancestor::span[text()='"
				+ miniPrice + "']//ancestor::div[@class='product-productMetaInfo']//h3[text()='" + brandName
				+ "']/following-sibling::h4[1]"));
		String subTitle = getingText(subTitleElement);
		System.out.println("Subtitle of minimum price Brand : " + subTitle);
	}

}
