package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_KEYS_Scenario {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("asif" + Keys.TAB + "baba" + Keys.ENTER);
		/*In sendkeys we have selenium keys operations, by cicking 'TAB' we go to password 
		 "baba" is password and clicking "ENTER" clicks login button
		 
		 here provided wrong username and password
		 */
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
