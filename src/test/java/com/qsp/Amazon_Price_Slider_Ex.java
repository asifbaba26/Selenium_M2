package com.qsp;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Price_Slider_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles" + Keys.ENTER);

//		WebElement priceslider = driver.findElement(By.cssSelector("form[data-slider-id=\"p_36/range-slider\"]"));
//
//		Actions action = new Actions(driver);
//
//		action.scrollToElement(priceslider).perform();


		WebElement lowerSlider = driver.findElement(By.id("p_36/range-slider_slider-item_lower-bound-slider"));

		WebElement upperSlider = driver.findElement(By.id("p_36/range-slider_slider-item_upper-bound-slider"));

		for (;;) {
			lowerSlider.sendKeys(Keys.ARROW_RIGHT); //sliding through right arrow key
			if (lowerSlider.getAttribute("aria-valuetext").contains("10,"))
				break;
		}

		for (;;) {
			upperSlider.sendKeys(Keys.ARROW_LEFT); //sliding through left arrow key
			if (upperSlider.getAttribute("aria-valuetext").contains("30,"))
				break;
		}

		Thread.sleep(1000);

		driver.findElement(By.className("a-button-input")).click();

		WebElement itemName = driver
				.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));

		WebElement itemPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));

		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.visibilityOf(itemName)); //waiting for 1st element to visible

		System.out.println("Item Name : " + itemName.getText());

		System.out.println("Item Price : " + itemPrice.getText());

		driver.quit();

	}

}
