package com.qsp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor_Amazon_ScrollBy_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.location=arguments[0]", "https://www.amazon.in/");

		js.executeScript("window.scrollBy(0,2000)");

		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,1000)"); // it starts scrolling from 2000 to 3000

		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,-3000)");

		Thread.sleep(3000);

		driver.quit();
	}

}
