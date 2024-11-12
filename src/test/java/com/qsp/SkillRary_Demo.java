package com.qsp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SkillRary_Demo {
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapp.skillrary.com/login.php?type=login");

		driver.findElement(By.name("email")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//span[text()='Courses']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space(text())='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[normalize-space(text())='New']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#name")).sendKeys("Cat026");
		driver.findElement(By.name("add")).click();
		Thread.sleep(2000);
		
		List<WebElement> categories = driver.findElements(By.className("sorting_1"));
		for (WebElement category : categories) {
			String cat = category.getText();
			if(cat.equals("Cat026")) {
				driver.findElement(By.xpath("//td[text()='"+cat+"']/following-sibling::td/button[normalize-space(text()='Delete') and contains(@class,'delete')]")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("delete")).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}

