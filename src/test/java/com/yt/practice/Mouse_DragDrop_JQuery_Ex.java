package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_DragDrop_JQuery_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0); // switches to the 1st Iframe

		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));

		System.out.println(drag.getText());

		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));

		System.out.println(drop.getText());

		Actions action = new Actions(driver);

		action.dragAndDrop(drag, drop).perform();

		Thread.sleep(2000);

		System.out.println(drop.getText());  

		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		driver.quit();

	}

}
