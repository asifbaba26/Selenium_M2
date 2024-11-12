package com.yt.practice;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenshot_Ebay_Ex {

	public static void main(String[] args) throws InterruptedException, IOException {
		Date currentDate = new Date();
		System.out.println(currentDate);
		//replacing spaces and : from the date with "-"
		String screenshotfilename = currentDate.toString().replace(' ', '-').replace(':', '-');
		System.out.println(screenshotfilename);
		
		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.ebay.com.au/");

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//Screenshots/ebay_"+screenshotfilename+".png"));
		Thread.sleep(2000);

		driver.quit();

	}

}
