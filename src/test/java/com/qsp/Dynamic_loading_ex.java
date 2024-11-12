package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_loading_ex {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit_wait

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10); //explicit_wait

		WebElement header = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

		String text = wait.until(ExpectedConditions.visibilityOf(header)).getText();

		System.out.println(text);

		driver.quit();

	}

}
