package com.base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.utility.DataFaker;
import com.base.utility.User.Result;

public class RegisterPage extends BasePage {
	

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	//page locators
	private By registerLink = By.linkText("Register");
	private By firstName = By.id("customer.firstName");
	private By lastName = By.id("customer.lastName");
	private By address = By.id("customer.address.street");
	private By city = By.id("customer.address.city");
	private By state = By.id("customer.address.state");
	private By zipCode = By.id("customer.address.zipCode");
	private By phoneNumber = By.id("customer.phoneNumber");
	private By ssn = By.id("customer.ssn");
	private By userName = By.id("customer.username");
	private By password = By.id("customer.password");
	private By confirmPassword = By.id("repeatedPassword");
	private By registerButton = By.xpath("//input[@value='Register']");
	private By userNameAlreadyExists = By.xpath("//span[@id='customer.username.errors']");
	
	//methods
	public void navigateToRegisterPage() throws InterruptedException {
		log.info("Click on register link...");
		//Click on register page
		getElement(registerLink).click();
		Thread.sleep(1000);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void fillCompleteDetails(Result res) {
		getElement(firstName).sendKeys(res.getName().getFirst());
		getElement(lastName).sendKeys(res.getName().getLast());
		getElement(address).sendKeys(res.getLocation().getStreet().getName());
		getElement(city).sendKeys(res.getLocation().getCity());
		getElement(state).sendKeys(res.getLocation().getState());
		getElement(zipCode).sendKeys(res.getLocation().getPostcode());
		getElement(phoneNumber).sendKeys(res.getPhone());
		getElement(ssn).sendKeys(res.getId().getValue());
		getElement(userName).sendKeys(res.getLogin().getUsername());
		getElement(password).sendKeys(res.getLogin().getPassword());
		getElement(confirmPassword).sendKeys(res.getLogin().getPassword());	
	}
	
	public void fillUserNameDetails(Result res) throws InterruptedException {
		while(driver.findElements(userNameAlreadyExists).size()!=0)
		{
			log.info("This username is already taken, trying with a new username...");
			String user_name= res.getLogin().getUsername()+"_@*@#"+DataFaker.generateRandomNumber(10);
			getElement(userName).clear();
			getElement(userName).sendKeys(user_name);
			getElement(password).clear();
			getElement(password).sendKeys(res.getLogin().getPassword());
			getElement(confirmPassword).sendKeys(res.getLogin().getPassword());	
			getElement(registerButton).click();
			Thread.sleep(2000);
		}
	}
	
	public void registerUser(Result res) throws InterruptedException {
		//Navigate to register page
		log.info("Navigating to register page...");
		navigateToRegisterPage();
		log.info("Filling the user details for registration...");
		//Fill the register form details
		fillCompleteDetails(res);
		log.info("Clicking on register button to register this user...");
		//click on register button
		getElement(registerButton).click();
		Thread.sleep(500);
		//check if the user name already exists, then change the username
		fillUserNameDetails(res);	
	}
	
	
}
