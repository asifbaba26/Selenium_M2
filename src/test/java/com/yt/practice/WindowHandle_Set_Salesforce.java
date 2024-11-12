package com.yt.practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle_Set_Salesforce {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.salesforce.com/in/");
		driver.findElement(By.partialLinkText("Start free trial")).click();
		Thread.sleep(2000);

		Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);
		Iterator<String> iterator = windowhandles.iterator();
		String parentWindow = iterator.next();
		System.out.println(parentWindow);
		String childWindow = iterator.next();
		System.out.println(childWindow);

		driver.switchTo().window(childWindow);

		driver.findElement(By.name("UserFirstName")).sendKeys("Asif");
		driver.findElement(By.name("UserLastName")).sendKeys("MD");
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);

		driver.quit();

	}

}
