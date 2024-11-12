package com.yt.practice;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle_ArrayList_Salesforce {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.salesforce.com/in/");
		driver.findElement(By.partialLinkText("Start free trial")).click();
		Thread.sleep(2000);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs);

		driver.switchTo().window(tabs.get(1));
        
		System.out.println(driver.getTitle());
		driver.findElement(By.name("UserFirstName")).sendKeys("Asif");
		driver.findElement(By.name("UserLastName")).sendKeys("MD");
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		driver.quit();

	}

}
