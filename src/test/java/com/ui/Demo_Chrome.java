package com.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_Chrome {

	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Drivers\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/live-cricket-scores");
		driver.findElement(By.id("cb-plus-user-icon")).click();
		driver.findElement(By.id("cb-user-email-input")).sendKeys("9390252634");
		System.out.println(driver.getTitle());
//		driver.wait(10);
		driver.close();

	}

}
 