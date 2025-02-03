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

//9-click on  AC Comforter
//10.click on size and select the size
//11-Scroll down click on color and select the colour
//12-Scroll down click on brand and select the brand of item
//13-Scroll down click on availability and choose in stock
//14-Click on any product and click add to wishlist.
//15-click on wishlist button
//16-verify you are in wishlist page
//17-Verify the item is added to wishlist or not.
//18-if the item present in the wishlist,click on add to cart.
//19-click on add to cart icon
//20-verify the item is  added  to cart 
//21-close the application.

public class TC01_AddProductToCart extends BaseClass {

	static Logger logger = LogManager.getLogger(TC01_AddProductToCart.class);

	@Test
	public void addToCart() throws EncryptedDocumentException, IOException, InterruptedException {

		try {
			Header header = new Header(driver);
			// 1-launch browser
			// 2-enter application url-https://www.montecarlo.in/
			DataUtilities dataUtilities = new DataUtilities();
			WebDriverUtilities webDriverUtilities = new WebDriverUtilities();
			AccountPage accountPage = new AccountPage(driver);
			assertEquals(driver.getTitle(), datautilities.readDataPropertyFile("homepageTitle"));
			// 3-click on Login icon
			header.clickLoginSignInButton();
			logger.info("loginbtn clicked");
			LoginPage login = new LoginPage(driver);

			// 4-enter email address
			login.enterEmail(dataUtilities.readDataExcelFile("Sheet1", 0, 1));
			logger.info("email entered");
			// 5-enter password
			login.enterPassword(dataUtilities.readDataExcelFile("Sheet1", 1, 1));
			logger.info("pass entered");
//			 6-click on login
			login.clickLoginBtn();
			logger.info("loginbtn clicked");
			String accountTitle = accountPage.getTitleAccount(driver);
//		 7-verify you are in AccountPage.
			assertEquals(accountTitle, dataUtilities.readDataPropertyFile("accountPageTitle"));

			NavigationBar navigation = new NavigationBar(driver);
			// 8-Mouse over on Home Furnishing
//		WebElement homeFurniture = 
			webDriverUtilities.mouseHover(navigation.getOnHomeFurniture(), driver);
			navigation.clickAcComforts(webDriverUtilities, driver);

			ProductsPage page = new ProductsPage(driver);
			System.out.println("---------------------------");
			System.out.println(page.getTitleProductsPage(driver));
			System.out.println(dataUtilities.readDataPropertyFile("acComfortorPageTitle"));
			System.out.println("---------------------------");
			assertEquals(page.getTitleProductsPage(driver), dataUtilities.readDataPropertyFile("acComfortorPageTitle"));

			WebElement sizeBtn = page.getSize(webDriverUtilities, driver);
			sizeBtn.click();

			WebElement sizeOption = page.selectSize(webDriverUtilities, driver);
			sizeOption.click();

			WebElement colorBtn = page.getColor(webDriverUtilities, driver);
			colorBtn.click();

			WebElement colorOption = page.selectColor(webDriverUtilities, driver);
			colorOption.click();

			page.clickBrand(webDriverUtilities ,driver);
//			brandBtn.click();

			WebElement brandOption = page.selectBrand(webDriverUtilities, driver);
			brandOption.click();

			WebElement availabilityBtn = page.getAvailability(webDriverUtilities, driver);
			availabilityBtn.click();

			WebElement availabilityOption = page.selectAvailability(webDriverUtilities, driver);
			availabilityOption.click();

			ProductsPage products = new ProductsPage(driver);
			products.clickOnProduct(1, webDriverUtilities, driver);

			ProductDetailsPage productDetails = new ProductDetailsPage(driver);
//			WebElement selectedProduct = productDetails.getProductInfo(webDriverUtilities, driver);
//			webDriverUtilities.waitElementClick(selectedProduct, driver);
			productDetails.addToWishList();
			header.clickWishListButton();
			
			WishListPage wishListPage = new WishListPage(driver);
			WebElement wishListedProduct = wishListPage.getWishlistedProduct();
//		System.out.println("---------------------------------------");
//		System.out.println(selectedProduct.getText());
//		System.out.println(wishListedProduct.getText());
//		System.out.println("---------------------------------------");
//		System.out.println(dataUtilities.readDataExcelFile("Sheet1", 5, 1));
//		assertEquals(selectedProduct.getText(), wishListedProduct.getText());
//		assertEquals(dataUtilities.readDataExcelFile("Sheet1", 5, 1), wishListPage.getTitleWishListPage(driver));
			wishListPage.addToCart();
			CartPage cartPage = new CartPage(driver);
			WebElement cartItem = cartPage.getCartItem();
//		System.out.println("------------------------");
//		System.out.println(wishListedProduct.getText());
//		System.out.println(cartItem.getText());
//		System.out.println("---------------------------");
//		assertEquals(wishListedProduct.getText(), cartItem.getText());
		} catch (Exception e) {
			logger.error("An error occured " + e);
			throw e;
		}
	}
}
