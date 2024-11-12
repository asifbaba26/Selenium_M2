package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor_Demo_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

		JavascriptExecutor jsexec = (JavascriptExecutor) driver;

		// print the title of the page
		String script = "return document.title;";
		String title = (String) jsexec.executeScript(script);
		System.out.println("Title : " + title);

		// click button
		driver.switchTo().frame("iframeResult");
		jsexec.executeScript("myFunction()");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		// highlighting the 'try it' button
		WebElement button = driver.findElement(By.xpath(" //button[text()='Try it']"));  
		jsexec.executeScript("arguments[0].style.border='4px solid blue'", button);
		Thread.sleep(2000);

		// scrolling the page by switching to w3Schools
		driver.navigate().to("https://www.w3schools.com/");
		WebElement getStartedBtn = driver.findElement(By.linkText("Get started"));
		jsexec.executeScript("arguments[0].scrollIntoView(true);", getStartedBtn);
		Thread.sleep(3000);

		driver.quit();

	}

}
