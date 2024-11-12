package com.qsp;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zomato_logo_Screenshot_FileHandler_Ex {
	public static void main(String[] args) throws  IOException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.zomato.com/");

		WebElement zomatoImg = driver.findElement(By.cssSelector("div.sc-jHZirH"));

		File temp = zomatoImg.getScreenshotAs(OutputType.FILE);

		File dest = new File("./Screenshots/Zomato.png");

		FileHandler.copy(temp, dest);

		driver.quit();

	}

}
