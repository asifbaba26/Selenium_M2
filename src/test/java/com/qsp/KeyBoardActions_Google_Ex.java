package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActions_Google_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");

		WebElement SearchTF = driver.findElement(By.name("q"));

		Actions action = new Actions(driver);

		action.keyDown(Keys.SHIFT).sendKeys(SearchTF, "Rohit sharma").keyUp(Keys.SHIFT).sendKeys(Keys.ENTER).build()
				.perform();

		Thread.sleep(2000);

		driver.quit();
	}

}
