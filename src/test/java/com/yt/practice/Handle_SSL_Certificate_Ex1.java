package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_SSL_Certificate_Ex1 {
	
//	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
//		//Global profile 	
//		DesiredCapabilities dc = new DesiredCapabilities();
////		dc.setAcceptInsecureCerts(true);
//		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		
//		//accepting DesiredCapabilities in Chrome Options
		ChromeOptions coptions = new ChromeOptions();
//		coptions.merge(dc); //merge extraCapabilites from DesiredCapabilities
		coptions.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(coptions);
//		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://expired.badssl.com/");
		// wantedly navigating expired badssl to handle
		//will not navigate not using desired capabilities in this case
		
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle()); //prints Privacy Error
 
		driver.quit();

	}

}
