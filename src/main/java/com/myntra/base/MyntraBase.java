package com.myntra.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyntraBase {
	public static WebDriver driver;

	public static WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ELCOT\\eclipse-workspace\\Cowin\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("There is no available browser ");
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void urlLaunch(String value) throws InterruptedException {
		driver.get(value);
		sleep();
		driver.manage().deleteAllCookies();
	}

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void clickElement(WebElement element) {
		element.click();
	}

	public static String getingText(WebElement element) {
		String text = element.getText();
		System.out.println("The get text is : " + text);
		return text;
	}

	public static void clearElement(WebElement element) {
		element.clear();
	}

	public static void isSelect(WebElement element) {
		element.isSelected();
	}

	public static void isEnable(WebElement element) {
		element.isEnabled();
	}

	public static void isDisplay(WebElement element) {
		element.isDisplayed();
	}

	public static void placeHolder(WebElement element, String value) {
		element.getAttribute(value);
	}

	public static void titleGetting() {
		String title = driver.getTitle();
		System.out.println("Page Title is : " + title);
	}

	public static void urlGetting() {
		String url = driver.getCurrentUrl();
		System.out.println("The page url is : " + url);
	}

	public static void navTo(String value) {
		driver.navigate().to(value);
	}

	public static void navBack() {
		driver.navigate().back();
	}

	public static void navForward() {
		driver.navigate().forward();
	}

	public static void navRefresh() {
		driver.navigate().refresh();
	}

	public static void fullScreenWindow() {
		driver.manage().window().fullscreen();
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void sleep() throws InterruptedException {
		Thread.sleep(3000);
	}

	public static void implicitLoad() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void explicitLoad(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void screenShot(String value) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		File ff = new File("C:\\Users\\ELCOT\\eclipse-workspace\\FaceBook\\target\\" + value + ".png");
		FileUtils.copyFile(ss, ff);
	}

	public static void alertAccept() {
		driver.switchTo().alert().accept();
	}

	public static void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}

	public static void alertText() {
		String text = driver.switchTo().alert().getText();
		System.out.println("Alert text is : " + text);
	}

	public static void alertSendValue(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public static void mouseAction(WebElement element, String value) {
		Actions a = new Actions(driver);
		try {
			if (value.equalsIgnoreCase("click")) {
				a.click(element).perform();
			} else if (value.equalsIgnoreCase("Doubleclick")) {
				a.doubleClick(element).perform();
			} else if (value.equalsIgnoreCase("RightClick")) {
				a.contextClick(element).perform();
			} else if (value.equalsIgnoreCase("clickAndHold")) {
				a.clickAndHold(element).perform();
			} else if (value.equalsIgnoreCase("Release")) {
				a.release(element).perform();
			} else if (value.equalsIgnoreCase("moveToElement")) {
				a.moveToElement(element).perform();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void dragDrop(WebElement element1, WebElement element2) {
		Actions a = new Actions(driver);
		a.dragAndDrop(element1, element2).perform();
	}

	public static void robotKey(String key) throws AWTException {
		Robot r = new Robot();
		if (key.equalsIgnoreCase("Enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} else if (key.equalsIgnoreCase("Down")) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		} else if (key.equalsIgnoreCase("Up")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		} else if (key.equalsIgnoreCase("Left")) {
			r.keyPress(KeyEvent.VK_LEFT);
			r.keyRelease(KeyEvent.VK_LEFT);
		} else if (key.equalsIgnoreCase("Right")) {
			r.keyPress(KeyEvent.VK_RIGHT);
			r.keyRelease(KeyEvent.VK_RIGHT);
		}
	}

	public static void dropDownSelect(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		} else if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);
		}
	}

	public static void dropDownDeselect(WebElement element, String option, String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("index")) {
			s.deselectByIndex(Integer.parseInt(value));
		} else if (option.equalsIgnoreCase("value")) {
			s.deselectByValue(value);
		} else if (option.equalsIgnoreCase("text")) {
			s.deselectByVisibleText(value);
		}
	}

	public static void javaScript(String value, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (value.equalsIgnoreCase("click")) {
			js.executeScript("arguments[0].click()", element);
		}
	}

	public static void jScriptScroll(int v1, int v2) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + v1 + "," + v2 + ")");
	}


}
