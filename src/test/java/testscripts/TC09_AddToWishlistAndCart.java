package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;

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
		Header header = new Header(driver);
		// 4.Click on Login
		header.clickLoginSignInButton();
		LoginPage loginPage = new LoginPage(driver);
		// 5.Enter Username and password
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		loginPage.clickLoginBtn();
		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		// 6.Verify the accountPage
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));

		CartDrawer cartdrawer = new CartDrawer(driver);
		NavigationBar navigationBar = new NavigationBar(driver);
		// 7.Click on cart
		navigationBar.clickCartButton();
		cartdrawer.getEmptyCartText();
		// 8.Click on start Shopping
		cartdrawer.startShopping();

		Collections collections = new Collections(driver);
		collections.clickSortBy();
		// 9.Select Filters : Date Old to New
		collections.clickOldToNewOption();

		WebElement secondProduct = collections.getProduct(1);
		webDriverUtilities.waitElement(secondProduct, driver);
		// 10.Click on the Product

		WebElement quickViewBtn = collections.getQuickViewBtn(webDriverUtilities, driver);
		quickViewBtn.click();
		System.out.println("------------543-----");
		// 11.Click on add to cart
		WebElement addToCartBtn = collections.getAddToCartBtn(webDriverUtilities, driver);
		addToCartBtn.click();
		System.out.println("-----------2345------");
		WebElement closeCartBtn = collections.getCloseCartBtn(webDriverUtilities, driver);
		// 12.Click on Close Button.
		closeCartBtn.click();

	}
}
