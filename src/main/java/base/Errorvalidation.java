package base;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import testComponent.BaseSetup;
import testComponent.Retry;

class Errorvalidation extends BaseSetup {
	@Test(groups= {"Errorvalidation"})
	
	public void Loginvalidation() throws IOException, InterruptedException {

		
		
		// log in into account
		loginPage.login("rupakdebbarman11@gmail.com", "Rupak@2001");
		// adding the product to cart
		Assert.assertEquals("Incorrect email or password.",loginPage.getError());
		
		
	}
	
@Test(retryAnalyzer= Retry.class)
public void Productvalidation() throws IOException, InterruptedException {

		
		
	String productname = "ADIDAS ORIGINAL";
	// Launching the Web Site
	
	// log in into account
	ProductCatalog productcatalogue = loginPage.login("rupakdebbarman111@gmail.com", "Rupak@2001");
	// adding the product to cart
	productcatalogue.addProductTocart(productname);
	// going to cart page
	cartPage cart = productcatalogue.gotocart();
	// Validating the product is not present
	boolean match = cart.verifyProductDisplay("tsset");
	Assert.assertFalse(match);
		
	}

}
