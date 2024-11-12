package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TitleContains_wait_shopperssatck {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.shoppersstack.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit_wait

		WebDriverWait wait = new WebDriverWait(driver, 10); // explicit_wait

		boolean status = wait.until(ExpectedConditions.titleContains("ShoppersStack"));

		System.out.println(status);

		driver.quit();

	}

}
