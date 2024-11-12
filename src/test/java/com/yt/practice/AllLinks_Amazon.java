package com.yt.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinks_Amazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");

		List<WebElement> allTags = driver.findElements(By.tagName("a"));
		for (int i = 0; i < allTags.size(); i++) {
			System.out.println("Links : " + allTags.get(i).getAttribute("href"));
			System.out.println("LinkText : " + allTags.get(i).getText());

		}
		driver.quit();

	}

}
