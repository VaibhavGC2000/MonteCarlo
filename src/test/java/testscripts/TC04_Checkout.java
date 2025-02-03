package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

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

public class TC04_Checkout extends BaseClass { 
	@Test
	public void addToCartAndCheckout() throws EncryptedDocumentException, IOException, InterruptedException {
		Header header = new Header(driver);
		header.clickLoginSignInButton();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));

		NavigationBar navigationBar = new NavigationBar(driver);
		navigationBar.clickOnSearchBox();

		SearchDrawer searchDrawer = new SearchDrawer(driver);
		searchDrawer.enterSearchDrawer("women hooded jackets");
		searchDrawer.clickViewAllResultsBtn();

		SearchedProductsPage searchProductPage = new SearchedProductsPage(driver);
		webDriverUtilities.scrollToElement(searchProductPage.getSelectPriceBtn(), driver);
		Thread.sleep(3000);
		List<WebElement> listOfAllProd = searchProductPage.allSearchedProductList();
		System.out.println("Size  : " + listOfAllProd.size());
		WebElement selectedProduct = searchProductPage.selectProduct(3);
		selectedProduct.click();

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.selectSize(0);
		productDetailsPage.increaseProductQuantity();
		productDetailsPage.clickAddToCartBtn();

		CartDrawer cartDrawer = new CartDrawer(driver);
		cartDrawer.clickInitiateCheckoutBtn();
	}
}
