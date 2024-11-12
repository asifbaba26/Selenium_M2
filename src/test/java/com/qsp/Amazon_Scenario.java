package com.qsp;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_Scenario {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

//		driver.findElement(By.xpath("//span[text()='Account & Lists']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.name("email")).sendKeys("919390252634");
//		driver.findElement(By.id("continue")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.name("password")).sendKeys("Asif@2627");
//		driver.findElement(By.id("signInSubmit")).click();

		List<WebElement> dropdowns = driver.findElements(By.xpath("//select[@id='searchDropdownBox']/option"));
		Thread.sleep(2000);

		for (WebElement dropdown : dropdowns) {
			System.out.println(dropdown.getText());
		}

//		driver.findElement(By.id("searchDropdownBox")).click();
//		driver.findElement(By.xpath("//select[@id='searchDropdownBox']/option[text()='Watches']")).click();

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select ddselect = new Select(dropdown);
		ddselect.selectByVisibleText("Watches");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-text")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//input[@id='apb-browse-refinements-checkbox_3']/following::i[@class='a-icon a-icon-checkbox'][1]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Fossil']/ancestor::a/descendant::i")).click();
		Thread.sleep(2000);
		WebElement price1 = driver.findElement(By.xpath(
				"//span[text()='Analog Black dial men Watch FS5164 Stainless Steel, Multicolor Strap']/ancestor::div[contains(@class,'a-spacing-small')]/descendant::span[@class='a-price-whole']"));
		System.out.println("PRICE 1 = " + price1.getText());
		String s1=price1.getText();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='Analog Black dial men Watch FS5164 Stainless Steel, Multicolor Strap']"))
				.click();
		Thread.sleep(2000);
//		String parentId = driver.getWindowHandle();
//		Set<String> WindowIDs = driver.getWindowHandles();
//		System.out.println(parentId);
//		System.out.println(WindowIDs);
//		for (String s : WindowIDs) {
//			driver.switchTo().window(s);
//		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		driver.findElement(By.name("submit.add-to-cart")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='attachSiNoCoverage']/descendant::input[@class='a-button-input']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[1]")).click();
		Thread.sleep(2000);
		WebElement price2 = driver.findElement(By.xpath(
				"//span[contains(@class,'sc-product-price a-text-bold') and text()='8,997.00']"));
		System.out.println("PRICE 2 = " + price2.getText());
		String s2 = price2.getText();
		Thread.sleep(2000);
		if(s2.contains(s1)) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		driver.close();
		driver.switchTo().window(tabs.get(0));
		driver.quit();

	}

}
