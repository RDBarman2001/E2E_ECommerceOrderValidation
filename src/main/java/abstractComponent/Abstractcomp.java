package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.cartPage;
import base.orderPage;

public class Abstractcomp {
	WebDriver driver;

	public Abstractcomp(WebDriver driver) {
		this.driver = driver;

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	

	
	@FindBy (xpath ="//button[@routerlink='/dashboard/cart']")
	WebElement carticon;
   By Carticon = By.xpath("//button[@routerlink='/dashboard/cart']");
	@FindBy (xpath ="//button[@routerlink='/dashboard/myorders']")
	WebElement ordericon;
	
	public void waitForElement(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitForElementtohide(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public cartPage gotocart() throws InterruptedException  {
		Thread.sleep(5000);
		carticon.click();
		cartPage cart = new cartPage(driver);
		return cart;
	}
	
	public orderPage gotoOrderPage() {
		ordericon.click();
		orderPage order = new orderPage(driver);
		return order;
	}


	
	
}
