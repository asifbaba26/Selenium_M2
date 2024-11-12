package com.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Skillrary_LoginPage {

	// https://demoapp.skillrary.com/login.php?type=login

	// Declaration
	@FindBy(name = "email")
	private WebElement emailTF;

	@FindBy(id = "password")
	private WebElement passwordTF;

	@FindBy(css = "[type='checkbox']")
	private WebElement keepMeLoggedInCheckBox;

	@FindBy(xpath = "//a[text()='Forgot your password?']")
	private WebElement forgotPWDLink;

	@FindBy(className = "login_Btn")
	private WebElement loginBTN;

	// Initialization
	public Skillrary_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public void setEmail(String email) {
		emailTF.sendKeys(email);
	}

	public void setPassword(String password) {
		passwordTF.sendKeys(password);
	}

	public void clickKeepMeLoggedIn() {
		keepMeLoggedInCheckBox.click();
	}

	public void clickLogInBtn() {
		loginBTN.click();
	}

}
