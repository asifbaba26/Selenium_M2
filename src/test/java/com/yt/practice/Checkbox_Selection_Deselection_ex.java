package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Selection_Deselection_ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://formstone.it/components/checkbox/");
		driver.findElement(By.xpath("//input[@id='checkbox-2']/ancestor::div[@class='fs-checkbox-marker']/descendant::div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='checkbox-1']/ancestor::div[@class='fs-checkbox-marker']/descendant::div")).click();
		Thread.sleep(2000);
		driver.quit();

	}

}
