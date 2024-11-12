package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IsEnabled_Insta_loginBtn_Ex {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit_wait
		driver.get("https://www.instagram.com/");

		WebElement loginBTN = driver.findElement(By.xpath("//button[.='Log in']"));

		if (loginBTN.isEnabled()) {
			loginBTN.click();
		} else {
			System.out.println("Disabled");
		}

		driver.findElement(By.name("username")).sendKeys("edref4efreewr");
		driver.findElement(By.name("password")).sendKeys("dwer2fer3v324f");

		if (loginBTN.isEnabled()) {
			System.out.println("After credentials entered Enabled");
			loginBTN.click();
		} else {
			System.out.println("Disabled");
		}

		driver.quit();

	}

}
