package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToElement_Amazon_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");

		WebElement blockbuster = driver.findElement(By.xpath("//span[text()='Blockbuster deals']/ancestor::div[@class='dcl-container-inner']"));
		
		Actions action = new Actions(driver);

//		action.scrollToElement(blockbuster);  In selenium4 it is available
		
	
		
		driver.quit();
	}

}
