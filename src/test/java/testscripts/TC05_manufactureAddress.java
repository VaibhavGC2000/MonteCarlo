package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.DataUtilities;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.MonteCarloHomePage;
import pom.OurStorePage;
import pom.ProductDetailsPage;
import pom.ProductsPage;

//14) verify your page through title  that you are in our stores page
//15) you will find search box you can search (by city,state or zip) then send keys zip code 
//16) you will find store located in that location in that pincode
//17) click on getDirections btn that is visible on the store card
//18) it should navigates you google map.                                                                                 19)Close the application.

public class TC05_manufactureAddress extends BaseClass {

	@Test
	public void getManufactureAddress() throws EncryptedDocumentException, IOException {
		logger = LogManager.getLogger(TC05_manufactureAddress.class);
		// 1) open browser
		// 2) enter url https://www.montecarlo.in/
		Header header = new Header(driver);

		// 3) click on login btn
		header.clickLoginSignInButton();
		logger.info("clicked login button");
		LoginPage loginPage = new LoginPage(driver);

		// 4) Enter Email
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		// 5) Enter Password
		logger.info("email entered");

		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		// 6) click on login btn
		logger.info("password entered");
		loginPage.clickLoginBtn();
		logger.info("clicked login button");

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);

		// 7) verify you are in profile page
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		logger.info("account page verified");
		// 8) click on monte carlo home link it will redirect you "Homes by Monte Carlo"
		header.clickHomeCarloHomeLink();
		logger.info("clicked on 'Monte carlo home' logo");
		MonteCarloHomePage monteCarloHomePage = new MonteCarloHomePage(driver);

		// 9) scroll down till shop blankets btn element and click shop blankets button
		monteCarloHomePage.clickShopBlanketsButton(webDriverUtilities, driver);
		logger.info("clicked on 'Shop Blankets' button");
		ProductsPage productsPage = new ProductsPage(driver);
		// 10) Select the product and click on that product
		productsPage.clickOnProduct(1, webDriverUtilities, driver);
		logger.info("clicked on first product");
		// 11) it will redirect you that product page and then click on product details
		// & description
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.clickProductDetailsAndDescriptionBtn(webDriverUtilities, driver);
		logger.info("clicked on 'product details and description' button");
		String manufacureAddress = productDetailsPage.manufactureAddress(webDriverUtilities, driver);
		// 12) get the manufacture address text
		String pincode = extractPinCode(manufacureAddress);

		// 13) scroll to end then you will find link Our Stores and then click on it.
		monteCarloHomePage.clickOnOurStores(webDriverUtilities, driver);
		logger.info("clicked on 'our stores' link");
		OurStorePage ourStorePage = new OurStorePage(driver);
		ourStorePage.enterInputText(pincode);
		logger.info("pincode entered in inputbox");
//		assertTrue(ourStorePage.pincodeVerification(), "Wrong Zipcode!");

		ourStorePage.clickGetDirectionBtn(webDriverUtilities, driver);
		logger.info("clicked on 'Get Directions' button");
		webDriverUtilities.switchChildWindow(driver);

	}

	public static String extractPinCode(String address) {
		String[] parts = address.split("[,\\s-]+");
		for (String part : parts) {
			if (part.length() == 6 && part.matches("\\d{6}")) {
				return part;
			}
		}
		return "not found";
	}

}
