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

public class TC09_AddToWishlistAndCart extends BaseClass {
	@Test
	public void addToCart() throws EncryptedDocumentException, IOException, InterruptedException {
		Header header = new Header(driver);
		header.clickLoginSignInButton();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		loginPage.clickLoginBtn();
		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		CartDrawer cartdrawer = new CartDrawer(driver);
		NavigationBar navigationBar = new NavigationBar(driver);
		navigationBar.clickCartButton();
		cartdrawer.getEmptyCartText();
		cartdrawer.startShopping();

		Collections collections = new Collections(driver);
		collections.clickSortBy();
		collections.clickOldToNewOption();
		WebElement secondProduct = collections.getProduct(2);
		webDriverUtilities.mouseHover(secondProduct, driver);
		collections.clickQuickViewBtn();
		Thread.sleep(3000);
		collections.clickAddToCartBtn();
		collections.clickCloseCartBtn();
		Thread.sleep(2000);
		navigationBar.clickCartButton();
		Thread.sleep(2000);
		cartdrawer.clickAddOrderNote();
		Thread.sleep(2000);
		cartdrawer.enterTextOrderNote("hello");
		Thread.sleep(2000);
		cartdrawer.clickSaveBtn();
		Thread.sleep(2000);
		cartdrawer.clickCloseCart();

	}
}
