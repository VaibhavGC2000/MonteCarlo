package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.CartDrawer;
import pom.Collections;
import pom.Header;
import pom.LoginPage;
import pom.NavigationBar;
import pom.ProductDetailsPage;

public class TC09_AddToWishlistAndCart extends BaseClass {
	@Test
	public void addToCart() throws EncryptedDocumentException, IOException, InterruptedException {
		// 1.Open the browser
		// 2.Maximize the browser
		// 3.Enter the Url
		logger = LogManager.getLogger(TC09_AddToWishlistAndCart.class);
		Header header = new Header(driver);
		// 4. Click on Login
		header.clickLoginSignInButton();
		logger.info("Clicked Login/Sign-In button.");

		LoginPage loginPage = new LoginPage(driver);
		// 5. Enter Username and password
		String email = datautilities.readDataExcelFile("Sheet1", 0, 1);
		String password = datautilities.readDataExcelFile("Sheet1", 1, 1);
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLoginBtn();
		logger.info("Entered email and password, and clicked login button.");

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		// 6. Verify the accountPage
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		logger.info("Verified Account Page Title: " + accountPageTitle);

		CartDrawer cartdrawer = new CartDrawer(driver);
		NavigationBar navigationBar = new NavigationBar(driver);
		// 7. Click on cart
		navigationBar.clickCartButton();
		logger.info("Clicked Cart button.");

		String emptyCartText = cartdrawer.getEmptyCartText();
		logger.info("Empty Cart Text: " + emptyCartText);
		// 8. Click on start Shopping
		cartdrawer.startShopping();
		logger.info("Clicked Start Shopping button.");

		Collections collections = new Collections(driver);
		collections.clickSortBy();
		logger.info("Clicked Sort By.");

		// 9. Select Filters : Date Old to New
		collections.clickOldToNewOption();
		logger.info("Selected Date Old to New option.");

		WebElement secondProduct = collections.getProduct(1);
		webDriverUtilities.waitElement(secondProduct, driver);
		logger.info("Waited for the second product element.");

		// 10. Click on the Product
		WebElement quickViewBtn = collections.getQuickViewBtn(webDriverUtilities, driver);
		quickViewBtn.click();
		logger.info("Clicked Quick View button.");

		// 11. Click on add to cart
		WebElement addToCartBtn = collections.getAddToCartBtn(webDriverUtilities, driver);
		addToCartBtn.click();
		logger.info("Clicked Add to Cart button.");

		WebElement closeCartBtn = collections.getCloseCartBtn(webDriverUtilities, driver);
		// 12. Click on Close Button
		closeCartBtn.click();
		logger.info("Clicked Close button.");

	}
}
