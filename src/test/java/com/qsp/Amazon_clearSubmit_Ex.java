package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_clearSubmit_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement searchTF = driver.findElement(By.id("twotabsearchtextbox"));

		searchTF.sendKeys("Cricket bats");
		Thread.sleep(2000);
		searchTF.clear();
		Thread.sleep(2000);
		searchTF.sendKeys("Crickets balls");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-button")).submit();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
