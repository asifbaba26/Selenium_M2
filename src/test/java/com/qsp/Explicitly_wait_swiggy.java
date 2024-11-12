package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicitly_wait_swiggy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.swiggy.com/");
		WebElement logo = driver.findElement(By.cssSelector("svg.VXJlj"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(logo));
		
		WebElement dosa = driver.findElement(By.xpath("//img[@alt='restaurants curated for dosa']"));
		wait.until(ExpectedConditions.visibilityOf(dosa)).click();
		System.out.println(driver.getCurrentUrl());
		
		driver.quit();

	}

}
