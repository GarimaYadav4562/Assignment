package com.base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import com.base.utility.DataFaker;
import com.base.utility.User.Result;

public class PayBillPage extends BasePage{

	public PayBillPage(WebDriver driver) {
		super(driver);
	}
	//locators
	private By billPayLink = By.linkText("Bill Pay");
	private By payeeName = By.xpath("//input[@ng-model='payee.name']");
	private By address = By.xpath("//input[@ng-model='payee.address.street']");
	private By city = By.xpath("//input[@ng-model='payee.address.city']");
	private By state = By.xpath("//input[@ng-model='payee.address.state']");
	private By zipCode = By.xpath("//input[@ng-model='payee.address.zipCode']");
	private By phoneNumber = By.xpath("//input[@ng-model='payee.phoneNumber']");
	private By accountNumber = By.xpath("//input[@ng-model='payee.accountNumber']");
	private By verifyAccountNumber = By.xpath("//input[@ng-model='verifyAccount']");
	private By fromAccountNumber = By.xpath("//select[@ng-model='accountId']/option");
	private By amount = By.xpath("//input[@ng-model='amount']");
	private By sendPayment = By.xpath("//input[@value='Send Payment']");
	private By result = By.xpath("//div[@ng-show='showResult']");
	
	//Methods
	
	public void navigateToPayBill() {
		//Click on pay bill link
		log.info("Click on pay bill link ...");
		getElement(billPayLink).click();
		Assert.assertEquals(driver.getTitle(), "ParaBank | Bill Pay");
	}
	
	public void fillDetails(Result res, Double amt) {
		getElement(payeeName).sendKeys(res.getName().getFirst()+' '+res.getName().getLast());
		getElement(address).sendKeys(res.getLocation().getStreet().getName());
		getElement(city).sendKeys(res.getLocation().getCity());
		getElement(state).sendKeys(res.getLocation().getState());
		getElement(zipCode).sendKeys(res.getLocation().getPostcode());
		getElement(phoneNumber).sendKeys(res.getPhone());
		String account_number = DataFaker.generateRandomNumber(8);
		getElement(accountNumber).sendKeys(account_number);
		getElement(verifyAccountNumber).sendKeys(account_number);
		getElement(amount).sendKeys(amt.toString());
	}
	
	public void validateSuccess(String msg) {
		Assert.assertEquals(driver.getTitle(), "ParaBank | Bill Payment Complete");
		String message = getElement(result).getText();
		System.out.println(message);
		System.out.println(msg);
		Assert.assertTrue(message.contains(msg));
	}
	
	public void payBill(Result res) throws InterruptedException {
		//Navigate to Pay Bill page
		log.info("Navigating to pay bill page...");
		navigateToPayBill();
		log.info("Filling the payee details...");
		//Capture from Account number details
		String fromAccountId = getElement(fromAccountNumber).getText();
		System.out.println(fromAccountId.toString());
		//Fill in the payee details
		double amt = Double.parseDouble(DataFaker.generateRandomNumber(3))/100;
		fillDetails(res,amt);
		//Click on send payment
		log.info("Sending the payment...");
		getElement(sendPayment).click();
		Thread.sleep(1000);
		String payee_name = res.getName().getFirst()+' '+res.getName().getLast();
		String message = "Bill Payment to "+payee_name+" in the amount of $"+amt+" from account "+fromAccountId+" was successful.";
		//Validate success message
		validateSuccess(message);
	}
}
