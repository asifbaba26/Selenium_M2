package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHovering_Myntra_Ex {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.myntra.com/");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions action = new Actions(driver);

		WebElement Men = driver.findElement(By.xpath("//a[text()='Men' and @class='desktop-main']"));

		action.moveToElement(Men).perform();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Formal Shirts' and @class='desktop-categoryLink']")).click();

		String header = driver.findElement(By.cssSelector("h1.title-title")).getText();

		if (header.equalsIgnoreCase("Formal Shirts For Men")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}

		driver.quit();

	}

}
