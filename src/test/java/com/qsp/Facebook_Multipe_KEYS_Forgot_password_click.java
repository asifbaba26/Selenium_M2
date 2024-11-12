package com.qsp;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_Multipe_KEYS_Forgot_password_click {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Forgotten password?")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

		// 'chord' used to press multiple keys at the same time

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.id("identify_email")).sendKeys("asif");
		driver.findElement(By.id("did_submit")).submit();
//		System.out.println(driver.findElement(By.xpath("//h3[text()='You’re Temporarily Blocked']")).getText());
		driver.close();

		Thread.sleep(2000);
		driver.quit();

	}

}
