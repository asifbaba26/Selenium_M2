package com.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Chrome2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/live-cricket-scores");
		driver.findElement(By.id("cb-plus-user-icon")).click();
		driver.findElement(By.id("cb-user-email-input")).sendKeys("9390252634");
		System.out.println(driver.getTitle());
		driver.close();

	}

}
 