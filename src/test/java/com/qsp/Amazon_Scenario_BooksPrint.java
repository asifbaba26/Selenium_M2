package com.qsp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Scenario_BooksPrint {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/");

		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();

		driver.findElement(By.xpath("//a[@class='hmenu-item']/div[text()='Audible Audiobooks']"));

		List<WebElement> links = driver.findElements(By.xpath("//ul[contains(@class,'hmenu-visible')]/li/a"));

		for (WebElement link : links) {
			System.out.println(link.getText());

		}

		driver.quit();

	}

}
