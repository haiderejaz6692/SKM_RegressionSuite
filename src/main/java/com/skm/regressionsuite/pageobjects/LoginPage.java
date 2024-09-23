package com.skm.regressionsuite.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skm.regressionsuite.context.ApplicationContext;
import com.skm.regressionsuite.pages.OR_LoginPage;

import java.time.Duration;

import javax.inject.Inject;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Lazy loading of web elements
    @FindBy(id = OR_LoginPage.TXT_USER_CODE)
    private WebElement userCode;
    
    @FindBy(id = OR_LoginPage.LBL_USER_NAME)
    private WebElement userFullName;

    @FindBy(id = OR_LoginPage.TXT_USER_PASSWORD)
    private WebElement userPassword;

    @FindBy(xpath = OR_LoginPage.BTN_SIGN_IN)
    private WebElement signInBtn;

    // Constructor that uses dependency injection to inject WebDriver
    @Inject
    public LoginPage(ApplicationContext applicationContext) {
        // Get WebDriver from ApplicationContext
        this.driver = applicationContext.getContext("driver", WebDriver.class);
        this.wait = new WebDriverWait(driver,  Duration.ofSeconds(10));  // You can configure the timeout based on config
        PageFactory.initElements(driver, this);     // Initialize WebElements with lazy loading
    }

    // Method to enter the username
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(userCode));
        userCode.sendKeys(username);
        userCode.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.visibilityOf(userFullName));
    }

    // Method to enter the password
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(userPassword));
        userPassword.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInBtn.click();
    }

    // Method to perform login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        
        clickLoginButton();
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public String getUserFullName() {
    	wait.until(ExpectedConditions.visibilityOf(userFullName));
    	return userFullName.getText();
    }
}
