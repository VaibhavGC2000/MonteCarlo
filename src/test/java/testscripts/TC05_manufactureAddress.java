package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
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
		// 1) open browser
		// 2) enter url https://www.montecarlo.in/
		Header header = new Header(driver);

		// 3) click on login btn
		header.clickLoginSignInButton();

		LoginPage loginPage = new LoginPage(driver);
		// 4) Enter Email
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		// 5) Enter Password
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		// 6) click on login btn
		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);

		// 7) verify you are in profile page
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));

		// 8) click on monte carlo home link it will redirect you "Homes by Monte Carlo"
		header.clickHomeCarloHomeLink();

		MonteCarloHomePage monteCarloHomePage = new MonteCarloHomePage(driver);

		// 9) scroll down till shop blankets btn element and click shop blankets button
		monteCarloHomePage.clickShopBlanketsButton(webDriverUtilities, driver);

		ProductsPage productsPage = new ProductsPage(driver);
		// 10) Select the product and click on that product
		productsPage.clickOnProduct(1, webDriverUtilities, driver);

		// 11) it will redirect you that product page and then click on product details
		// & description
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.clickProductDetailsAndDescriptionBtn(webDriverUtilities, driver);

		WebElement manufacureAddress = productDetailsPage.manufactureAddress();
		// 12) get the manufacture address text
		String pincode = extractPinCode(manufacureAddress.getText());

		// 13) scroll to end then you will find link Our Stores and then click on it.
		monteCarloHomePage.clickOnOurStores(webDriverUtilities, driver);
		OurStorePage ourStorePage = new OurStorePage(driver);
		ourStorePage.enterInputText(pincode);

//		assertTrue(ourStorePage.pincodeVerification(), "Wrong Zipcode!");

		ourStorePage.clickGetDirectionBtn(webDriverUtilities, driver);
		System.out.println(driver.getTitle());
		webDriverUtilities.switchChildWindow(driver);
		System.out.println("this is title : " + driver.getTitle());
	}

	public static String extractPinCode(String address) {
		String[] parts = address.split("[,\\s-]+");
		for (String part : parts) {
			if (part.length() == 6 && part.matches("\\d{6}")) {
				return part;
			}
		}
		return "Pincode not found";
	}

}
