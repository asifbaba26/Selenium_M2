package com.yt.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUp_SendKeys_Promot_Ex {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt"); 
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath(" //button[text()='Try it']")).click();
		Alert alertonPage = driver.switchTo().alert();
		String alertText = alertonPage.getText();
		System.out.println(alertText);
		Thread.sleep(2000);
		alertonPage.sendKeys("Asif");
		alertonPage.accept();
		Thread.sleep(2000);
		WebElement promptMessage = driver.findElement(By.xpath("//p[@id='demo']"));
		System.out.println(promptMessage.getText());
		driver.switchTo().parentFrame();
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
