package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Radiobox_Selection_ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.singaporeair.com/en_UK/in/home#/book/bookflight");
		WebElement radio1 = driver.findElement(By.id("bookFlights"));
		radio1.click();
		System.out.println(radio1.isSelected());
		Thread.sleep(2000);
		WebElement radio2 = driver.findElement(By.id("redeemFlights"));
		radio2.click();
		System.out.println(radio2.isSelected());
		System.out.println(radio1.isSelected());
		driver.quit();

	}

}
