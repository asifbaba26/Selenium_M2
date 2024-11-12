package com.qsp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Allow_MediaStream_popup_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions coption = new ChromeOptions();
		coption.addArguments("--use-fake-ui-for-media-stream"); // to allow media like camera

		ChromeDriver driver = new ChromeDriver(coption);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://webcamtests.com/");

		driver.findElement(By.id("webcam-launcher")).click();

		Thread.sleep(7000);

		driver.quit();

	}

}
