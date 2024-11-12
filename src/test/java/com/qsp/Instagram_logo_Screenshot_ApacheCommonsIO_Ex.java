package com.qsp;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instagram_logo_Screenshot_ApacheCommonsIO_Ex {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.instagram.com/");

		WebElement InstaImg = driver.findElement(By.cssSelector("div.xamitd3"));

		File temp = InstaImg.getScreenshotAs(OutputType.FILE);

		File dest = new File("./Screenshots/Instagram.png");

		FileUtils.copyFile(temp, dest);

		driver.quit();

	}

}
