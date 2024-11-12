package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element_Clickable_Exception_Insta {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit_wait
		driver.get("https://www.instagram.com/");

		WebElement loginBTN = driver.findElement(By.xpath("//button[.='Log in']"));

		WebDriverWait wait = new WebDriverWait(driver, 5); // explicit_wait

		wait.until(ExpectedConditions.elementToBeClickable(loginBTN)); //trying to click login without un and pwd

		driver.quit();

	}

}
