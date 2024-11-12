package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_BasicAuth_PopUp_HerokuApp_Ex {
	
	public static String un = "admin"; //Username
	public static String pwd = "admin"; //Password

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		driver.get("https://the-internet.herokuapp.com/basic_auth");
		//here we need to provide 'un' and 'pwd' in popup
		
		//to overcome this we provide 'un' and 'pwd' in the "url" itself
		
		driver.get("https://"+un+":"+pwd+"@the-internet.herokuapp.com/basic_auth");
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/descendant::p")).getText());
		

		driver.quit();

	}

}
