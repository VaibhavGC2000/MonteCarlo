package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.NavigationBar;
import pom.ProductDetailsPage;
import pom.ProductsPage;
import pom.SearchDrawer;
import pom.WishListPage;

public class TC02_HandTowelProductAdding extends BaseClass {
	@Test
	public void addToWishlist() throws EncryptedDocumentException, IOException, InterruptedException {
		logger = LogManager.getLogger(TC02_HandTowelProductAdding.class);
		// 1.Open the browser
		// 2.Maximize the browser
		// 3.Enter the URL
		Header header = new Header(driver);
		// 4.Click on Login
		header.clickLoginSignInButton();
		logger.info("clicked login button");
		LoginPage loginPage = new LoginPage(driver);
		// 5.Enter Username and password
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		logger.info("email entered");
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		logger.info("password entered");
		loginPage.clickLoginBtn();
		logger.info("login button clicked");

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		// 6.Verify the AccountPage
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		logger.info("account page verified");

		NavigationBar navigationBar = new NavigationBar(driver);
		// 7.Click on Searchbox
		navigationBar.clickOnSearchBox();
		logger.info("clicked on search box");

		SearchDrawer searchDrawer = new SearchDrawer(driver);
		// 8.Search for Hand Towels
		searchDrawer.enterSearchDrawer("Hand Towels");
		logger.info("enterd hand towels in search box");

		WebElement selectedProduct = searchDrawer.selectProductFromList(3);
		String selectedProductText = selectedProduct.getText();
		// 9.Scrolldown upto fourth product
		selectedProduct.click();
		logger.info("selected product clicked");
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		// 11.Add to Wishlist
		productDetailsPage.addToWishList();
		logger.info("product added to wishlist");
		// WebElement selectedProductDetail = productDetailsPage.getProductInfo();

		// 12.Click on Wishlist
		navigationBar.clickWishlist();
		logger.info("clicked on wishlist");

		WishListPage wishListPage = new WishListPage(driver);
		String wishListedProduct = wishListPage.getWishlistedProduct(webDriverUtilities, driver);
		webDriverUtilities.waitElement(wishListPage.productDisplay(), driver);
		webDriverUtilities.mouseHover(wishListPage.productDisplay(), driver);

		// 13.Verify if the product is added to the wishlist
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(selectedProductText, wishListedProduct);
		logger.info("wishlist product verifed");

		List<WebElement> totalWishListedItems = wishListPage.getWishListedItems();
		WebElement removeFromWishList = wishListPage.removeFromWishlist();
//		webDriverUtilities.waitElementClick(selectedProductDetail, driver);

		// 14.Click on the close button
		removeFromWishList.click();
		logger.info("clicked on close button and removed item from wishlist");
		List<WebElement> totalWishListedItemsAfterRemove = wishListPage.getWishListedItems();

		// 15.Verify if the product is removed or not
		assertEquals(totalWishListedItems.size(), totalWishListedItemsAfterRemove.size());
		logger.info("no product in wishlist verfied");
	}
}
