package magento_Demo_Store.magento_Demo_Store;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends testData {

	@BeforeTest
	public void mySetup() {

		setUp();

	}
	


	@Test(priority = 1)
	public void createAnAccount() {
		WebElement creatAccount = driver.findElement(By.linkText("Create an Account"));
		creatAccount.click();

		WebElement FirstName = driver.findElement(By.id("firstname"));
		FirstName.sendKeys(firstName);

		WebElement LirstName = driver.findElement(By.id("lastname"));
		LirstName.sendKeys(lastName);

		WebElement Email = driver.findElement(By.id("email_address"));
		Email.sendKeys(email);

		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(password);

		WebElement PasswordConfirmation = driver.findElement(By.id("password-confirmation"));
		PasswordConfirmation.sendKeys(password);

		WebElement createButton = driver.findElement(By.cssSelector(".action.submit.primary"));
		createButton.click();

	}

	@Test(priority = 2)
	public void address() {

		WebElement addAddress = driver.findElement(By.linkText("Address Book"));
		addAddress.click();
		
		WebElement Company = driver.findElement(By.id("company"));
		Company.sendKeys(company);

		WebElement phoneNumber = driver.findElement(By.id("telephone"));
		phoneNumber.sendKeys(phone);

		WebElement firstStreet = driver.findElement(By.id("street_1"));
		firstStreet.sendKeys(streetAddress);

		WebElement firstStreet2 = driver.findElement(By.id("street_2"));
		firstStreet2.sendKeys(streetAddress2);

		WebElement firstStreet3 = driver.findElement(By.id("street_3"));
		firstStreet3.sendKeys(streetAddress3);

		WebElement City = driver.findElement(By.id("city"));
		City.sendKeys(city);
		
		WebElement ZipCode = driver.findElement(By.id("zip"));
		ZipCode.sendKeys(zipCode);

		WebElement Country = driver.findElement(By.id("country"));
		Country.sendKeys(country);

		WebElement saveAddressButton = driver.findElement(By.cssSelector(".action.save"));
		saveAddressButton.click();
	}

	@Test(priority = 3)
	public void changePassword() {
		WebElement accountInformation = driver.findElement(By.linkText("Account Information"));
		accountInformation.click();

		WebElement changePasswordButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("change-password")));
		changePasswordButton.click();

		WebElement currentPassword = driver.findElement(By.id("current-password"));
		currentPassword.sendKeys(password);

		WebElement NewPassword = driver.findElement(By.id("password"));
		NewPassword.sendKeys(newPassword);

		WebElement confirmNewPassword = driver.findElement(By.id("password-confirmation"));
		confirmNewPassword.sendKeys(newPassword);

		WebElement saveButton = driver.findElement(By.cssSelector(".action.save.primary"));
		saveButton.click();
	}

	@Test(priority = 4)
	public void login() {
		WebElement Email = driver.findElement(By.id("email"));
		Email.sendKeys(email);

		WebElement Password = driver.findElement(By.id("pass"));
		Password.sendKeys(newPassword);

		WebElement signInButton = driver.findElement(By.id("send2"));
		signInButton.click();
	}
	
	@Test(priority = 5)
	public void productNavigation () throws InterruptedException{
		WebElement whatsNewPage = driver.findElement(By.linkText("What's New"));
		whatsNewPage.click();
		
		WebElement categoriesMenu = driver.findElement(By.cssSelector(".categories-menu"));
		List<WebElement> allCategoriesMenu =categoriesMenu.findElements(By.tagName("a"));
		int randomCategoriesMenu = rand.nextInt(allCategoriesMenu.size());
		allCategoriesMenu.get(randomCategoriesMenu).click();
		
		WebElement sortProduct = driver.findElement(By.id("sorter"));
		sortProduct.click();
		Select select = new Select(sortProduct);
		select.selectByVisibleText("Product Name");
		
		List<WebElement> allProduct = driver.findElements(By.cssSelector(".item.product.product-item"));
		int randomProduct = rand.nextInt(allProduct.size());
		WebElement product = allProduct.get(randomProduct);
		action.moveToElement(product).perform();
		
		WebElement addToCart = product.findElement(By.cssSelector(".action.tocart.primary"));
		addToCart.click();
		Thread.sleep(1500);
		List<WebElement> allSize = driver.findElements(By.cssSelector(".swatch-option.text"));
		int randomSize = rand.nextInt(allSize.size());
		allSize.get(randomSize).click();
		
		List<WebElement> allColor = driver.findElements(By.cssSelector(".swatch-option.color"));
		int randomColor = rand.nextInt(allColor.size());
		allColor.get(randomColor).click();
		
		WebElement confirmAddToCart = driver.findElement(By.id("product-addtocart-button"));
		confirmAddToCart.click();

	
	}
	
	@Test(priority = 6)
	public void gearPage() {
		WebElement gear = driver.findElement(By.linkText("Gear"));
		gear.click();
		
		WebElement gearCategory = driver.findElement(By.id("narrow-by-list2"));
		List<WebElement> gearCategoryItem = gearCategory.findElements(By.tagName("a"));
		int randomMenuItem = rand.nextInt(gearCategoryItem.size());
		gearCategoryItem.get(randomMenuItem).click();
		
		WebElement viewMode = driver.findElement(By.id("mode-list"));
		viewMode.click();
		
		
		WebElement sortProduct = driver.findElement(By.id("sorter"));
		sortProduct.click();
		Select select = new Select(sortProduct);
		select.selectByVisibleText("Price");

		
		List<WebElement> allProduct = driver.findElements(By.cssSelector(".item.product.product-item"));
		int randomProduct = rand.nextInt(allProduct.size());
		WebElement product = allProduct.get(randomProduct);
		action.moveToElement(product).perform();
		
		WebElement addToCart = product.findElement(By.cssSelector(".action.tocart.primary"));
		addToCart.click();
	}

}
