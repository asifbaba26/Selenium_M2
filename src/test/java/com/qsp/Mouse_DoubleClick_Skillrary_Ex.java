package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_DoubleClick_Skillrary_Ex {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://demoapp.skillrary.com/");

		WebElement courses = driver.findElement(By.xpath("//a[text()='COURSE']"));

		Actions action = new Actions(driver);

		action.moveToElement(courses).perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span/a[text()='Selenium']")).click();

		WebElement quantity = driver.findElement(By.id("quantity"));

		int initialvalue = Integer.parseInt(quantity.getAttribute("value"));

		WebElement plusBTN = driver.findElement(By.id("add"));

		action.doubleClick(plusBTN).perform();

		int finalvalue = Integer.parseInt(quantity.getAttribute("value"));

		if (initialvalue + 1 == finalvalue) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		driver.findElement(By.xpath("//button[text()=' Add to Cart']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		Thread.sleep(2000);

		driver.quit();

	}

}
