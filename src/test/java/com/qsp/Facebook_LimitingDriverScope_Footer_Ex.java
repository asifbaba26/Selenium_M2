package com.qsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_LimitingDriverScope_Footer_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<String> linkText = new ArrayList<String>();

		WebElement footer = driver.findElement(By.cssSelector("div#pageFooter"));

		List<WebElement> links = footer.findElements(By.tagName("a"));

		for (WebElement link : links) {
			linkText.add(link.getText());
			System.out.print(link.getText()+ ", ");

		}
		System.out.println(" ");
		
		Collections.sort(linkText);
		System.out.println(linkText);

		Thread.sleep(2000);
		driver.quit();

	}

}
