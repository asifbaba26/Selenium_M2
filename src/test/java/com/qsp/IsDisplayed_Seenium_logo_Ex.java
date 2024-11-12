package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IsDisplayed_Seenium_logo_Ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/");
		WebElement logo = driver.findElement(By.cssSelector("svg#Layer_1"));

		if (logo.isDisplayed()) {
			System.out.println("Displayed");
		} else {
			System.out.println("Not Displayed");
		}

		driver.quit();

	}

}
