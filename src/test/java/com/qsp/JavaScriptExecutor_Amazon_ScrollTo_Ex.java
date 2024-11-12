package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor_Amazon_ScrollTo_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.location=arguments[0]", "https://www.amazon.in/");

		WebElement blockbusterDeals = driver.findElement(
				By.xpath("//div[@class='dcl-container-inner' and contains(.,'Blockbuster Deals | Ends Oct 29')]"));

		int x = blockbusterDeals.getLocation().getX();
		int y = blockbusterDeals.getLocation().getY();

		js.executeScript("window.scrollTo(" + x + "," + y + ")");

		Thread.sleep(3000);

		driver.quit();
	}

}
