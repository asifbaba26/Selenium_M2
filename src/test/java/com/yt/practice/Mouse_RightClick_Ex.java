package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_RightClick_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/slider/#colorpicker");

		driver.switchTo().frame(0); // switches to the 1st Iframe

		WebElement rectangle = driver.findElement(By.xpath("//div[@id='swatch']"));

		Actions action = new Actions(driver);

		action.contextClick(rectangle).perform();

		Thread.sleep(2000);

		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		driver.quit();

	}

}
