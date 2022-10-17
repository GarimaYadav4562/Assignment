package stepDefinitions;

import com.base.pages.PayBillPage;
import com.base.pages.RegisterPage;
import com.base.utility.RandomUser;
import com.base.utility.User;

import org.junit.Assert;
import com.base.factory.DriverFactory;
import io.cucumber.java.en.*;

public class BankStepDefinition {
	
	private RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());
	private PayBillPage billPage = new PayBillPage(DriverFactory.getDriver());
	private static String title;
	private static User user;
	
	@Given("user is on register page")
	public void user_is_on_register_page() throws InterruptedException {
	    DriverFactory.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
	    registerPage.navigateToRegisterPage();  
	}
	
	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		title = registerPage.getTitle();
		Assert.assertTrue(title.contains(expectedTitleName));   
	}

	@When("user is registered")
	public void user_is_registered() throws InterruptedException {
		//log.info("Getting user details from randomUser.me API call...");
		//Get user details
		user = RandomUser.generateRandomeUser(2);
		//log.info("Registering a new user...");
		//Register new User
		registerPage.registerUser(user.getResults().get(0));
	}

	@Then("user pays bill succesfully")
	public void user_pays_bill_succesfully() throws InterruptedException {
		//log.info("Making the bill payment...");
		//Pay Bill
		billPage.payBill(user.getResults().get(1));	
	}
}
