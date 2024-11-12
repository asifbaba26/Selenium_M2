package com.qsp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_Scenario {
	public static void main(String[] args) throws InterruptedException {

		// to verify the number of search results

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		Thread.sleep(2000);
		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.className("_2iLD__")).click();

		int sum = 0;
		for (;;) { // using infinite for loop as we do not know how many pages the data is present
			Thread.sleep(3000);
			List<WebElement> list = driver.findElements(By.className("KzDlHZ"));
			sum = sum + list.size(); // in each iteration adding the no of results size
			try {
				driver.findElement(By.xpath("//span[text()='Next']")).click(); // clicking the next button to go to next
																				// page
			} catch (Exception e) {
				break; // if No next button is present
			}
		}

		String header = driver.findElement(By.className("BUOuZu")).getText();
		String[] str = header.split(" "); // to get "Showing 1 – 24 of 557 results for"
		int actual_result = Integer.parseInt(str[5]); // to get "557" to integer form

		if (sum == actual_result) {
			System.out.println("No of Products matched");
		} else {
			System.out.println("Not matched");
		}
		driver.quit();

	}
}
