package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
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
import pom.SearchDrawer;
import pom.SearchedProductsPage;

public class TC04_InitiateCheckout extends BaseClass { 
	@Test
	public void addToCartAndCheckout() throws EncryptedDocumentException, IOException, InterruptedException {
		logger = LogManager.getLogger(TC04_InitiateCheckout.class);
		Header header = new Header(driver);
		header.clickLoginSignInButton();
		logger.info("clicked login button");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		logger.info("email entered");
		
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		logger.info("password entered");
		
		loginPage.clickLoginBtn();
		logger.info("login button clicked");
		
		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		logger.info("account page verified");
		
		NavigationBar navigationBar = new NavigationBar(driver);
		navigationBar.clickOnSearchBox();
		logger.info("clicked on search box");

		SearchDrawer searchDrawer = new SearchDrawer(driver);
		searchDrawer.enterSearchDrawer("women hooded jackets");
		logger.info("entered 'women hooded jackets' in searchbox drawer");
		searchDrawer.clickViewAllResultsBtn();
		logger.info("clicked on 'Veiw All Results' button");

		SearchedProductsPage searchProductPage = new SearchedProductsPage(driver);
		webDriverUtilities.scrollToElement(searchProductPage.getSelectPriceBtn(), driver);
		logger.info("scrolled to pincode");
		List<WebElement> listOfAllProd = searchProductPage.allSearchedProductList();

		WebElement selectedProduct = searchProductPage.selectProduct(3);
		selectedProduct.click();
		logger.info("third product clicked");

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.selectSize(0);
		logger.info("size selected");
		productDetailsPage.increaseProductQuantity();
		logger.info("increased quantity to 2");
		productDetailsPage.clickAddToCartBtn();
		logger.info("clicked to add to cart button");
		CartDrawer cartDrawer = new CartDrawer(driver);
		cartDrawer.clickInitiateCheckoutBtn();
		logger.info("clicked on initiate checkout button");
	}
}
