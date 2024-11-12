package com.qsp;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disable_geolocation_popup_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions coption = new ChromeOptions();
//		coption.addArguments("--incognito");  //to open browser in incognito mode
		coption.addArguments("--disable-notifications");
		coption.addArguments("--disable-geolocation");

		ChromeDriver driver = new ChromeDriver(coption);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://browserleaks.com/geo");

		Thread.sleep(2000);

		driver.quit();

	}

}
