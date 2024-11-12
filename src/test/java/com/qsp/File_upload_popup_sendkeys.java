package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_upload_popup_sendkeys {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/upload");
		// we can directly use send keys when we have tags like <input id="file-upload"
		// type="file" />

		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\HP\\OneDrive\\Desktop\\xpaths_selenium.txt");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@value='Upload']")).click();

		String filename = driver.findElement(By.cssSelector("div#uploaded-files")).getText();

		System.out.println(filename);

		driver.quit();

	}

}
