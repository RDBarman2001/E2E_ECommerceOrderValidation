package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponent.Abstractcomp;

public class CheckoutPage extends  Abstractcomp {
	WebDriver driver ;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	private WebElement countryfiled;

	@FindBy(css=".ta-item:nth-of-type(2)")
	private WebElement countrySelect;
	
	@FindBy(xpath ="//a[ text() ='Place Order ']")
	private WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	

public void selectcountry(String countryName) {
	
	Actions a = new Actions(driver);
	a.sendKeys(countryfiled, countryName).build().perform();
	waitForElement(results);
	countrySelect.click();
	a.scrollToElement(submit).build().perform();
}

public ConformationPage submitOrder() {
	
	submit.click();
	ConformationPage page = new ConformationPage (driver);
	return page;

}
	
	

}
