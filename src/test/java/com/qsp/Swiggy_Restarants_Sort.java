package com.qsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Swiggy_Restarants_Sort {

	public static void main(String[] args) {
		// fetching top restaurants in hyderabad from swiggy

		List<String> restaurants = new ArrayList<String>();

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.swiggy.com/");

		List<WebElement> topRestaurants = driver.findElements(By.xpath(
				"//h2[text()='Top restaurant chains in Hyderabad']/ancestor::div[@class='sc-fzQBhs jExwBk']/descendant::div[@class='sc-aXZVg kVQudY']"));

		for (WebElement restaurant : topRestaurants) {
			restaurants.add(restaurant.getText());
		}

		for (String res : restaurants) {
			System.out.println(res);

		}

		System.out.println("************************************");

		Collections.sort(restaurants);

		System.out.println("After sorting : " + restaurants);

		System.out.println("************************************ ");

		for (String res : restaurants) {
			System.out.println(res);

		}

		driver.quit();

	}

}
