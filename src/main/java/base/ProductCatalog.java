package base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.Abstractcomp;

public class ProductCatalog extends Abstractcomp {
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	

	@FindBy(css = ".ng-animating")
	WebElement spinner;
	

	By productsby = By.cssSelector(".mb-3");
	By addtoCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.id("toast-container");

	public List<WebElement> getProductlist() {
		waitForElement(productsby);

		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductlist().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findAny()
				.orElse(null);

		return prod;
	}

	public void addProductTocart(String productName) {

		WebElement prod = getProductByName(productName);
		prod.findElement(addtoCart).click();
		waitForElement(toastMessage);
		waitForElementtohide(spinner);
	}
}
