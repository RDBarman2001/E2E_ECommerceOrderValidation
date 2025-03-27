package base;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.Abstractcomp;

public class LoginPage extends Abstractcomp {
	WebDriver driver ;
	
	public LoginPage(WebDriver driver ){
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")

	private WebElement username ;

	
	@FindBy(id="userPassword")

	private WebElement passwordele ;
	
	@FindBy(id="login")

	private WebElement Login ;
	@FindBy (css="[class*='flyInOut']")

	private WebElement errorMessage;

	private By error = By.cssSelector("[class*='flyInOut']");
	public ProductCatalog login(String email,String password) {
		username.sendKeys(email);
		passwordele.sendKeys(password);
		
		Login.click();
		ProductCatalog productcatalogue = new ProductCatalog(driver);
		return productcatalogue;
	}
	public String getError() {
		waitForElement(error);
		return errorMessage.getText();
	}
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	

}
