package base;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponent.BaseSetup;
import testComponent.Retry;

class BaseTest extends BaseSetup {

	@Test(dataProvider ="getData",groups= {"buy"},retryAnalyzer= Retry.class)
	public void submitOrder(HashMap <String,String> input) throws IOException, InterruptedException {
				// Launching the Web Site
		
		// log in into account
		ProductCatalog productcatalogue = loginPage.login(input.get("email"), input.get("password"));
		// adding the product to cart
		productcatalogue.addProductTocart(input.get("product"));
		// going to cart page
		cartPage cart = productcatalogue.gotocart();
		// Validating the product is present
		boolean match = cart.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		// going to checkout page
		CheckoutPage checkout = cart.goToCheckout();
		// Adding the details and Submit the order
		checkout.selectcountry("india");
		ConformationPage Conformationpage = checkout.submitOrder();
		// Validating the order confirmation message
		String confirmmsg = Conformationpage.getconformationMessage();
		Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order."));
		// Closing the Browser
		
	}
	
	@Test(dependsOnMethods = {"submitOrder"},dataProvider ="getData")
	public void orderHistorytest(HashMap <String,String> input) {
		ProductCatalog productcatalogue = loginPage.login(input.get("email"), input.get("password"));
		orderPage order = productcatalogue.gotoOrderPage();
		Assert.assertTrue(order.verifyorderDisplay(input.get("product")));
	}

	@DataProvider 
	public Object[][] getData() throws IOException {

		List<HashMap<String,String>> data= getjsoDataToMap("C:\\Users\\RB00993323\\Desktop\\Rupak Java\\Zoho_project\\src\\main\\java\\base\\details.json");
		
		return new Object [] [] {{data.get(0)},{data.get(1)}};
		
//		HashMap <String,String> map= new HashMap<String,String>();
//		map.put("email", "rupakdebbarman111@gmail.com");
//		map.put("password", "Rupak@2001");
//		map.put("product", "ADIDAS ORIGINAL");
//		
//		HashMap <String,String> map1= new HashMap<String,String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "ZARA COAT 3");

	}
	
}
