package com.cengage.webassign.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import com.cengage.webassign.BaseUtils.WebDriverFactory;
import com.cengage.webassign.framework.core.BasePageFactory;
import com.cengage.webassign.framework.core.WebAssignException;

public class LoginPage extends BasePageFactory {
	private By loginPageLogo = By.cssSelector("[aria-label='Return to WebAssign']");
	private By emailInput = By.id("email");
	private By passwordInput = By.id("cengagePassword");
	private By signInButton = By.name("Login");

	public LoginPage(WebDriver driver, String testURL) {
		super(driver);
		driver.get(testURL);
	}

	public LoginPage(int implicitWait, String browser, String browserOptions, String url) throws WebAssignException {
		this.driver = WebDriverFactory.composeWebDriver(browser, browserOptions, implicitWait);
		driver.get(url);
		return;
	}
	
	public boolean verifyLoginPageLogo() {
		return findElement(loginPageLogo).isDisplayed();
	}
	
	public HomePage login(String uid, String pwd) {
		findElement(emailInput).sendKeys(uid);
		findElement(passwordInput).sendKeys(pwd);
		clickSignIn();
		return new HomePage(driver);
	}
	
	protected void clickSignIn() {
		findElement(signInButton).click();
	}
}