package com.qsp;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_herokuapp_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit_wait

		driver.findElement(By.xpath("//button[contains(.,'Prompt')]")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Asif");
		alert.accept();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("result")).getText());

		driver.quit();

	}

}
