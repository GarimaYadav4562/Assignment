package com.base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {
	 return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement el = null;
		try {
		waitForElementPresent(locator);
		el= driver.findElement(locator);
		}catch(Exception e) {
			log.info("Unable to find element with locator " + locator.toString());
			e.printStackTrace();
		}
		return el;
	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}catch(Exception e) {
			log.info("Some exception/error occurred while waiting for an element" + locator.toString());
			e.printStackTrace();
		}
		
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e) {
			log.info("Some exception/error occurred while waiting for the title" +title);
		}
		
	}

}
