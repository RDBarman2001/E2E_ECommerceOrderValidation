package base;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import abstractComponent.Abstractcomp;

public class orderPage extends Abstractcomp {
	WebDriver driver ;
	
	public orderPage(WebDriver driver ){
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="tr td:nth-child(3)")
 
	private List<WebElement> orderName ;
	
	
	public boolean verifyorderDisplay(String productName) {
		
		boolean match = orderName.stream()
				.anyMatch(orderName -> orderName.getText().equalsIgnoreCase(productName));
		return match;
	}
	


}
