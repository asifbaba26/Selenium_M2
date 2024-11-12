package com.qsp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick_RobotClass_NewWindow_Facebook_Ex {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");

		WebElement forgotPwd = driver.findElement(By.linkText("Forgotten password?"));

		Actions action = new Actions(driver);

		action.contextClick(forgotPwd).perform(); // right click on forgot password

		Robot robot = new Robot(); // it comes from awt( abstract window toolkit )

		robot.keyPress(KeyEvent.VK_RIGHT); // press right arrow
		robot.keyRelease(KeyEvent.VK_RIGHT);

		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_DOWN); // press down arrow
		robot.keyRelease(KeyEvent.VK_DOWN);

		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER); // press enter
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(4000);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switching to new window

		System.out.println(driver.getTitle());

		driver.quit();

	}

}
