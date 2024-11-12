package com.datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadFromProperties_SkillraryLogin {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		FileInputStream fis = new FileInputStream("./src/test/resources/properties/data.properties");

		Properties property = new Properties();

		property.load(fis);

		String browser = property.getProperty("browser");

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			System.out.println("provide 'edge/chrome' in data");
			break;
		}

		driver.manage().window().maximize();

		long time = Long.parseLong(property.getProperty("time")); // converting string to long to give implicit wait
																	// time

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

		driver.get(property.getProperty("url"));

		driver.findElement(By.id("email"))
				.sendKeys(property.getProperty("username") + Keys.TAB + property.getProperty("password") + Keys.ENTER);

		Thread.sleep(2000);

		driver.quit();

	}

}
