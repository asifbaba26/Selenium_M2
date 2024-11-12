package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Hovering_Ebay_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com/");

		WebElement sports = driver.findElement(By.xpath("(//a[text()='Sports'])[1]"));

		Actions action = new Actions(driver);

		action.moveToElement(sports).perform();

		Thread.sleep(2000);

		driver.findElement(By.linkText("Cycling")).click();
		
		System.out.println(driver.getTitle() );

		Thread.sleep(2000);

		driver.quit();

	}

}
