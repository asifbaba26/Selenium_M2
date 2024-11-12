package com.qsp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender_MakemyTrip_Popup_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit_wait

		driver.findElement(By.className("commonModal__close")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[@for='departure']")).click();

		driver.findElement(By.xpath("//div[@aria-label='Mon Nov 18 2024']")).click();

		Thread.sleep(2000);

		driver.quit();

	}

}
