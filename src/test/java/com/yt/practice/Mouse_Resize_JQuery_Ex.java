package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Resize_JQuery_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resizable/");

		driver.switchTo().frame(0); // switches to the 1st Iframe

		WebElement resize = driver.findElement(By.xpath(
				"//h3[text()='Resizable']/ancestor::div/descendant::div[contains(@class,'ui-icon-gripsmall-diagonal')]"));

		Actions action = new Actions(driver);

		action.dragAndDropBy(resize, 108, 11).perform();

		Thread.sleep(2000);

		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		driver.quit();

	}

}
