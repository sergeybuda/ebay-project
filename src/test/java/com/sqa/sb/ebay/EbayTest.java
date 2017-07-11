package com.sqa.sb.ebay;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.sqa.sb.auto.*;

public class EbayTest extends AbstractLoginTest {

	public EbayTest() {
		super("http://ebay.com");
	}

	@BeforeMethod
	public void emptyCart() {
		getLog().info("Emptying shopping cart...");
		getDriver().get(getBaseURL());
		WebElement cartButton = getDriver().findElement(By.id("gh-cart-i"));
		cartButton.click();
		while (isPresent(By.linkText("Remove"))) {
			WebElement removeLink = getDriver().findElement(By.cssSelector(".action:nth-child(1)"));
			removeLink.click();
		}
	}

	@Override
	public void login(String username, String password) {
		getLog().info("Logging into " + this.getBaseURL());
		getDriver().get(getBaseURL());
		WebElement signInButton = getDriver().findElement(By.cssSelector("#gh-ug > a"));
		signInButton.click();
		WebElement usernameField = getDriver().findElement(By.cssSelector("#pri_signin *[type='text']"));
		WebElement passwordField = getDriver().findElement(By.cssSelector("#pri_signin *[type='password']"));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		passwordField.submit();
	}

	@Override
	public void logout() {
		getLog().info("Logging out of " + this.getBaseURL());
		getDriver().get(getBaseURL());
		WebElement accountLoginButton = getDriver().findElement(By.className("gh-eb-arw"));
		accountLoginButton.click();
		WebElement signOutButton = getDriver().findElement(By.cssSelector("#gh-uo > a"));// *[href^='https://signin']
		signOutButton.click();
	}
}
