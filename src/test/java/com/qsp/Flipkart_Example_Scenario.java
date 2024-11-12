package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Example_Scenario {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
//		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("//span[text()='Electronics']")).click();
		Thread.sleep(2000);
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));

		Actions action = new Actions(driver);

		action.moveToElement(electronics).perform();

		driver.findElement(By.linkText("Gaming")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Gaming Laptops")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='Lenovo']/ancestor::label[@class='tJjCVx _3DvUAf']/descendant::div[@class='XqNaEv']")).click();
		Thread.sleep(2000);

		WebElement checkboxRating = driver
				.findElement(By.xpath("//div[@title='4★ & above']/descendant::div[@class='XqNaEv']"));

		checkboxRating.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='Type']")).click();
		Thread.sleep(2000);

		WebElement checkboxType = driver
				.findElement(By.xpath("//div[@title='Gaming Laptop']/descendant::div[@class='XqNaEv']"));

		checkboxType.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();

		Thread.sleep(2000);

		driver.quit();

	}

}
