package com.qsp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_upload_popup_robotclass_naukri {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/registration/createAccount?othersrcp=22636");
		
		driver.findElement(By.xpath("//h2[contains(text(),'experienced')]")).click();
		driver.findElement(By.className("uploadResume")).click();

		Thread.sleep(3000);

	    StringSelection str = new StringSelection("C:\\Users\\HP\\OneDrive\\Desktop\\Mohammad-Asif-Baba-QA-Resume.pdf");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);  //copying the resume path in system clipboard (stand alone application)
	    
	    
	    Robot robot = new Robot();
	    
	    robot.keyPress(KeyEvent.VK_CONTROL); //pasting the path in filename ctrl+V
	    robot.keyPress(KeyEvent.VK_V);
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    
	    robot.keyPress(KeyEvent.VK_ENTER);  //click Enter to upload
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    
	    Thread.sleep(5000);
	    
	    System.out.println(driver.findElement(By.className("file-name")).getText());
	    

		driver.quit();

	}

}
