package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEvents_Ex_TextCompare {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://extendsclass.com/text-compare.html");
		// To copy the text from 1st file and paste to 2nd file through keyboard events
		// (ctrlA + ctrlC + ctrlV )

		WebElement srcTextArea = driver
				.findElement(By.xpath("//div[@id='dropZone']/descendant::span[contains(text(),'File comparison')]"));

		WebElement destTextArea = driver
				.findElement(By.xpath("//div[@id='dropZone2']/descendant::span[contains(text(),'File comparison')]"));

		WebElement result = driver.findElement(By.xpath("//div[@id='result']/div[@id='nb-diff']"));

		System.out.println("Before : " + result.getText());

		Actions action = new Actions(driver);

		Thread.sleep(2000);
		action.keyDown(srcTextArea, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform(); // selecting all the
																									// text and copying
		Thread.sleep(2000);       
		action.keyDown(destTextArea, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform(); // pasting the
																									// selected content

		System.out.println("After : " + result.getText());

		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		driver.quit();

	}

}
