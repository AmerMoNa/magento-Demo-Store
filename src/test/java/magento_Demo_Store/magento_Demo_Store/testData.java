package magento_Demo_Store.magento_Demo_Store;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.EmailableReporter2;

import com.github.javafaker.Faker;

public class testData {

	WebDriver driver = new ChromeDriver();
	String theWebsite = "https://magento.softwaretestingboard.com/";

	Faker faker = new Faker();
	Random rand = new Random();
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String email = faker.internet().emailAddress();

	String company = faker.company().name();
	String phone = faker.phoneNumber().phoneNumber();
	String streetAddress = faker.address().streetAddress();
	String streetAddress2 = faker.address().streetPrefix();
	String streetAddress3 = faker.address().streetSuffix();
	String city = faker.address().city();
	String zipCode = faker.address().zipCode();
	String country = faker.country().name();

	String upper = faker.letterify("?").toUpperCase();
	String lower = faker.letterify("?").toLowerCase();
	String digit = faker.numerify("#");
	String special = "!@#%&*";
	char symbol = special.charAt(faker.random().nextInt(special.length()));
	String password = upper + lower + digit + symbol + faker.lorem().characters(7);
	String newPassword = upper + lower + digit + symbol + faker.lorem().characters(7);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    
    Actions action = new Actions(driver);
    



	public void setUp() {

		driver.get(theWebsite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

}
