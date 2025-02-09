package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.Collections;
import pom.LoginPage;
import pom.NavigationBar;
import pom.ProductDetailsPage;
import pom.ProductsPage;
import pom.WishListPage;

public class TC08_ResetFilterAddToWishlist extends BaseClass {
	@Test
	public void addToWishList() throws InterruptedException, EncryptedDocumentException, IOException {
		logger = LogManager.getLogger(TC08_ResetFilterAddToWishlist.class);
		NavigationBar navigationBar = new NavigationBar(driver);
		navigationBar.clickOnWomenSection();
		logger.info("Clicked on Women section in the navigation bar.");

		Collections collections = new Collections(driver);
		collections.clickOnStole();
		logger.info("Clicked on 'Stole' collection.");

		collections.enterMinAmtInputBox("0");
		collections.enterMaxAmtInputBox("500");
		logger.info("Entered min amount 0 and max amount 500.");
		assertTrue(collections.noResults());
		logger.info("No results found for price range 0-500.");

		collections.enterMinAmtInputBox("299");
		collections.enterMaxAmtInputBox("2000");
		logger.info("Entered min amount 299 and max amount 2000.");

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.clickOnProduct(2, webDriverUtilities, driver);
		logger.info("Clicked on the second product in the list.");

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.addToWishList();
		logger.info("Added product to wishlist.");
		assertTrue(collections.isEmailPopup());
		logger.info("Email popup displayed.");

		collections.enterEmailPopup(datautilities.readDataExcelFile("Sheet1", 0, 1));
		collections.clickAddToWishListPopup();
		collections.clickLoginPopup();
		logger.info("Entered email, added to wishlist popup, and clicked login popup.");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		loginPage.clickLoginBtn();
		logger.info("Entered email and password, and clicked login button.");

		navigationBar.clickWishlist();
		logger.info("Clicked on Wishlist.");

		WebElement selectedProduct = productDetailsPage.getProductInfo(webDriverUtilities, driver);
		logger.info("Selected product: " + selectedProduct.getText());

		WishListPage wishListPage = new WishListPage(driver);
		List<WebElement> wishListedProducts = wishListPage.getWishListedItems();
		WebElement wishListedProductElement = wishListedProducts.get(0);
		WebElement wishListedProduct = wishListedProductElement.findElement(
				By.xpath("//div[contains(@class,'flits-box')]//p[contains(@class,\"flits-product-name\")]"));
		logger.info("Wishlist product: " + wishListedProduct.getText());

	}
}
