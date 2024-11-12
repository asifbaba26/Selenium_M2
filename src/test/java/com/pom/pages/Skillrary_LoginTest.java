package com.pom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Skillrary_LoginTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/login.php?type=login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Skillrary_LoginPage login = new Skillrary_LoginPage(driver);

		login.setEmail("admin");
		login.setPassword("admin");
		login.clickKeepMeLoggedIn();
		login.clickLogInBtn();

		Thread.sleep(3000);

		driver.quit();

	}

}
