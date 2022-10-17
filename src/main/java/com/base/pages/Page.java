package com.base.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	WebDriver driver;
	WebDriverWait wait;
	Logger log = Logger.getLogger(BasePage.class);

	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,15);
	}
	
	//abstract methods :
	
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator);
	public abstract void waitForPageTitle(String title);
	
}
