//package base;
//
//import java.time.Duration;
//import java.util.List;
//import org.testng.Assert;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//public class BaseTest2 {
//
//	public static void main(String[] args) {
//		String productname = "ADIDAS ORIGINAL";
//		ChromeDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////		driver.get("https://rahulshettyacademy.com/client");
//		driver.manage().window().maximize();
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.goTo();
//		/*
//		driver.findElement(By.id("userEmail")).sendKeys("rupakdebbarman111@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Rupak@2001");
//		
//		driver.findElement(By.id("login")).click();
//		*/
//		
//	loginPage.login("rupakdebbarman111@gmail.com","Rupak@2001");
//	
//		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//		WebElement prod = products.stream()
//				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productname)).findAny()
//				.orElse(null);
//		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement((By.cssSelector(".ng-animating")))));
//		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
//
//		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class ='cartSection']/h3"));
//		boolean match = cartProducts.stream()
//				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productname));
//		Assert.assertTrue(match);
//		driver.findElement(By.xpath("// button[text()='Checkout']")).click();
//		
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"india").build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		
//		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
//		WebElement submit = driver.findElement(By.className("action__submit"));
//		a.scrollToElement(submit).build().perform();
//		submit.click();
//		
//		String confirmmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(confirmmsg.equalsIgnoreCase("Thankyou for the order."));
//		
//		driver.close();
//	}
//
//}
package base;


