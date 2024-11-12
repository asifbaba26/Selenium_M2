package com.qsp;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Wait_herokuapp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit_wait

		driver.findElement(By.xpath("//button[text()='Start']")).click();

		WebElement header = null;
		int count = 0;
		while (count < 20) {
			try {
				header = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
				break;
			} catch (NoSuchElementException e) {
				count++;
				Thread.sleep(1000);
			}
		}
		System.out.println(header.getText());
		driver.quit();

	}

}
