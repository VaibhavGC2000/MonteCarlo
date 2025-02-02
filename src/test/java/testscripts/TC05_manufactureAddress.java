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

public class TC05_manufactureAddress extends BaseClass {
	@Test
	public void getManufactureAddress() throws EncryptedDocumentException, IOException {
		Header header = new Header(driver);
		header.clickLoginSignInButton();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));

		header.clickHomeCarloHomeLink();

		MonteCarloHomePage monteCarloHomePage = new MonteCarloHomePage(driver);
		monteCarloHomePage.clickShopBlanketsButton();

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.clickOnProduct();

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.clickProductDetailsAndDescriptionBtn();

		WebElement manufacureAddress = productDetailsPage.manufactureAddress();
		String pincode = extractPinCode(manufacureAddress.getText());
		monteCarloHomePage.clickOnOurStores();
		OurStorePage ourStorePage = new OurStorePage(driver);
		ourStorePage.enterInputText(pincode);

		assertTrue(ourStorePage.pincodeVerification(), "Wrong Zipcode!");

		ourStorePage.clickGetDirectionBtn();
//		System.out.println(driver.getTitle());
		webDriverUtilities.switchChildWindow(driver);
		System.out.println("this is title : "+driver.getTitle());
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
