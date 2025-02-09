package testscripts;

import static org.testng.Assert.assertEquals;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import genericLibraries.BaseClass;
import genericLibraries.DataUtilities;
import genericLibraries.WebDriverUtilities;
import pom.AccountPage;
import pom.CartPage;
import pom.Header;
import pom.LoginPage;
import pom.NavigationBar;
import pom.ProductDetailsPage;
import pom.ProductsPage;
import pom.WishListPage;
import org.apache.logging.log4j.Logger;

public class TC01_AddProductToCart extends BaseClass {

	@Test
	public void addToCart() throws EncryptedDocumentException, IOException, InterruptedException {
		logger = LogManager.getLogger(TC01_AddProductToCart.class);

		logger.info("opened browser");
		logger.info("open monte carlo website");
		Header header = new Header(driver);
		DataUtilities dataUtilities = new DataUtilities();
		WebDriverUtilities webDriverUtilities = new WebDriverUtilities();
		AccountPage accountPage = new AccountPage(driver);
		assertEquals(driver.getTitle(), datautilities.readDataPropertyFile("homepageTitle"));
		header.clickLoginSignInButton();
		logger.info("loginbtn clicked");
		LoginPage login = new LoginPage(driver);

		login.enterEmail(dataUtilities.readDataExcelFile("Sheet1", 0, 1));
		logger.info("email entered");
		login.enterPassword(dataUtilities.readDataExcelFile("Sheet1", 1, 1));
		logger.info("pass entered");
		login.clickLoginBtn();
		logger.info("loginbtn clicked");
		String accountTitle = accountPage.getTitleAccount(driver);
		assertEquals(accountTitle, dataUtilities.readDataPropertyFile("accountPageTitle"));

		NavigationBar navigation = new NavigationBar(driver);
		webDriverUtilities.mouseHover(navigation.getOnHomeFurniture(), driver);
		navigation.clickAcComforts(webDriverUtilities, driver);

		ProductsPage page = new ProductsPage(driver);
		assertEquals(page.getTitleProductsPage(driver), dataUtilities.readDataPropertyFile("acComfortorPageTitle"));
		logger.info("on product page verified");
		page.getSize(webDriverUtilities, driver);
		logger.info("size button clicked");
		page.selectSize(webDriverUtilities, driver);
		logger.info("size option clicked");

		page.getColor(webDriverUtilities, driver);
		logger.info("color button clicked");
		page.selectColor(webDriverUtilities, driver);
		logger.info("size option clicked");
		page.clickBrand(webDriverUtilities, driver);
		logger.info("brand button clicked");
		page.selectBrand(webDriverUtilities, driver);
		logger.info("brand option clicked");
		page.getAvailability(webDriverUtilities, driver);
		logger.info("availability button clicked");
		page.selectAvailability(webDriverUtilities, driver);
		logger.info("availability option clicked");
		ProductsPage products = new ProductsPage(driver);
		products.clickOnProduct(1, webDriverUtilities, driver);

		ProductDetailsPage productDetails = new ProductDetailsPage(driver);
		String selectedProduct = productDetails.getProductInfo(webDriverUtilities, driver).getText();
		logger.info("---------------------------------------");
		logger.info(selectedProduct);
		logger.info("---------------------------------------");
		productDetails.addToWishList();
		logger.info("product added to wishlist");
		header.clickWishListButton();
		logger.info("clicked on wishlist button");

		WishListPage wishListPage = new WishListPage(driver);
		String wishListedProduct = wishListPage.getWishlistedProduct(webDriverUtilities, driver);
		logger.info("---------------------------------------");
		logger.info(selectedProduct);
		logger.info(wishListedProduct);
		logger.info("---------------------------------------");
		assertEquals(selectedProduct, wishListedProduct);
		logger.info("on wishlist page verified");
		logger.info(selectedProduct);
		logger.info(wishListedProduct);
		assertEquals(selectedProduct, wishListedProduct);
		logger.info("correct product is verified on wishlist page");

		wishListPage.addToCart();
		logger.info("on wishlist page item added to cart");
		CartPage cartPage = new CartPage(driver);
		String selectedCartItem = cartPage.getCartItem();
		assertEquals(wishListedProduct, selectedCartItem);
		logger.info("same item is added to cart verified");

	}
}
