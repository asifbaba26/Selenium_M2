package com.qsp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicitly_wait_ex {

	public static void main(String[] args) {
		//fetching top restaurants in hyderabad from swiggy
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.swiggy.com/");
		
	    List<WebElement> topRestaurants = driver.findElements(By.xpath("//h2[text()='Top restaurant chains in Hyderabad']/ancestor::div[@class='sc-fzQBhs jExwBk']/descendant::div[@class='sc-aXZVg kVQudY']"));
	    
	    for (WebElement restaurant : topRestaurants) {
			System.out.println(restaurant.getText());
		}
		driver.quit();

	}

}
