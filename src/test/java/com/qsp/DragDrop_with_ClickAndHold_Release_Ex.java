package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop_with_ClickAndHold_Release_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");

		WebElement Block1 = driver.findElement(By.xpath("//h1[text()='Block 1']"));

		WebElement Block4 = driver.findElement(By.xpath("//h1[text()='Block 4']"));

		Actions action = new Actions(driver);

		action.clickAndHold(Block1).release(Block4).build().perform();

		Thread.sleep(2000);

		driver.quit();
	}

}
