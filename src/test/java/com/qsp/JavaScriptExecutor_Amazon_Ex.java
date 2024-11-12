package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor_Amazon_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.location=arguments[0]", "https://www.amazon.in/");
		
		System.out.println(js.executeScript("return document.title"));
		System.out.println(js.executeScript("return document.URL"));
		
		
		WebElement searchTF = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
		
		js.executeScript("arguments[0].value=arguments[1]", searchTF,"Tshirts");
		js.executeScript("arguments[0].click()", searchBtn);

		Thread.sleep(3000);
		js.executeScript("history.go(0)");
		Thread.sleep(3000);
	
		
		driver.quit();
	}

}
