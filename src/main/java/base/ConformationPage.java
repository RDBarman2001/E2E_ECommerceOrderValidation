package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.Abstractcomp;

public class ConformationPage extends Abstractcomp {
	WebDriver driver;

	public ConformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='hero-primary']")
	WebElement heading;
	By header = By.xpath("//h1[@class='hero-primary']");

	public String getconformationMessage()

	{
		waitForElement(header);

		return heading.getText();

	}

}
