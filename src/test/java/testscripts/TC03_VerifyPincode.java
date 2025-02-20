package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.NavigationBar;
import pom.ProductDetailsPage;
import pom.ProductsPage;


public class TC03_VerifyPincode extends BaseClass {
	@Test
	public void checkPincodeAndDelivery() throws EncryptedDocumentException, IOException, InterruptedException {
		logger = LogManager.getLogger(TC03_VerifyPincode.class);
		// 1.Open the browser
		// 2.Maximize the browser
		// 3.Enter the URL
		Header header = new Header(driver);
		// 4.Click Login/Signup
		header.clickLoginSignInButton();
		logger.info("clicked on login button");
		LoginPage loginPage = new LoginPage(driver);
		// 5.Enter Username and password
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		logger.info("entered email");
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		logger.info("entered password");
		// 6.Click Login
		loginPage.clickLoginBtn();
		logger.info("clicked on login button");
		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		// 7.Verify the Account page
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		logger.info("on account page verified");

		NavigationBar navigationBar = new NavigationBar(driver);
		WebElement mens = navigationBar.menSection(webDriverUtilities, driver);
		// 8.MouseOver on Mens section
		webDriverUtilities.mouseHover(mens, driver);
		logger.info("hovered on mens section");
		// 9.Click on Round Neck Sweaters
		navigationBar.clickRoundNeckSweaters(webDriverUtilities, driver);
		logger.info("clicked on round necked sweaters");
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.getSize(webDriverUtilities, driver);
		logger.info("clicked on size button");

		WebElement menSizeOption = productsPage.selectMenSize(webDriverUtilities, driver);
		menSizeOption.click();
		logger.info("men size option clicked");

		productsPage.clickBrand(webDriverUtilities, driver);
		logger.info("brand button clicked");

		WebElement brandRockItOption = productsPage.selectBrandRockit(webDriverUtilities, driver);
		brandRockItOption.click();
		logger.info("brand option selected");

		productsPage.sleeveBtn(webDriverUtilities, driver);
		logger.info("full sleeve button clicked");

		WebElement fullSleeveOption = productsPage.fullSleeveOption(webDriverUtilities, driver);
		fullSleeveOption.click();
		logger.info("full sleeve option selected");

		productsPage.clickOnProduct(1, webDriverUtilities, driver);
		logger.info("clicked on first product");

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.enterPincode(datautilities.readDataPropertyFile("zipCode"));
		logger.info("pindoe entered successfully");
		productDetailsPage.clickCheckPincodeBtn();
		logger.info("clicked on pincode");

	}
}
