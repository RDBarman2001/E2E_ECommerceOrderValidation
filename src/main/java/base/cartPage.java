package base;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponent.Abstractcomp;

public class cartPage extends Abstractcomp {
	WebDriver driver ;
	
	public cartPage(WebDriver driver ){
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class ='cartSection']/h3")
	private List<WebElement> cartProducts ;
	

	@FindBy(xpath="// button[text()='Checkout']")
	private WebElement CheckoutButton ;
	
	public boolean verifyProductDisplay(String productName) {
		
		boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		CheckoutButton.click();
		CheckoutPage page = new CheckoutPage(driver);
		return page;
	}


}
