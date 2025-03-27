package StepDefinations;

import java.io.IOException;

import org.testng.Assert;

import base.CheckoutPage;
import base.ConformationPage;
import base.LoginPage;
import base.ProductCatalog;
import base.cartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import testComponent.BaseSetup;

public class StepDefinationImp extends BaseSetup {
	public LoginPage loginPage;
	public ProductCatalog productcatalogue;
	public cartPage cart;
	public CheckoutPage checkout;
	public ConformationPage Conformationpage;

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException  {

		loginPage = launchApp();
	}

	@Given("^Logged in with(.+)and(.+)$")
	public void Logged_in_with_username_and_password(String username, String password){

		productcatalogue = loginPage.login(username,"Iamking@000");

	}

	@And("^I add (.+) into cart$")
	public void I_add_product_into_cart(String product) {

		productcatalogue.addProductTocart(product);
	}

	@And("^Checkout(.+)and submit the order$")
	public void Checkout_product_and_submit_the_order(String product) throws InterruptedException {
		cart = productcatalogue.gotocart();
		boolean match = cart.verifyProductDisplay("ADIDAS ORIGINAL");
		Assert.assertTrue(match);
		checkout = cart.goToCheckout();
		checkout.selectcountry("india");
		Conformationpage = checkout.submitOrder();
	}

	@Then("{string} message is displayed on corformationPage")
	public void message_is_displayed_on_corformation_page(String string) {
		String confirmmsg = Conformationpage.getconformationMessage();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase(string));
		driver.close();
	}
}
