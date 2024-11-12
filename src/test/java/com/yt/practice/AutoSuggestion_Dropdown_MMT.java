package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion_Dropdown_MMT {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		WebElement from = driver.findElement(By.xpath("//span[text()='From']"));
		from.click();
		WebElement from1 = driver.findElement(By.xpath("//input[@placeholder='From']"));
		from1.sendKeys("Hyderabad");
		Thread.sleep(2000);
		from1.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		from1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.quit();

	}

}
