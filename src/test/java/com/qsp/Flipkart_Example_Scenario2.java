package com.qsp;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Example_Scenario2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");

		driver.findElement(By.name("q")).sendKeys("iphone" + Keys.ENTER);

		driver.findElement(By.xpath("//div[text()='Apple iPhone 15 (Black, 128 GB)']")).click();

		String parentHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String id : windowHandles) {
			driver.switchTo().window(id);
			if (driver.getTitle().contains("Apple iPhone"))
				break;

		}

		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		Thread.sleep(2000);
		driver.close();

		driver.switchTo().window(parentHandle);
		driver.navigate().refresh();

		System.out.println(driver.findElement(By.className("ZuSA--")).getText()); // verifying the cart count

		Thread.sleep(2000);

		driver.quit();

	}

}
