package testscripts;

import static org.testng.Assert.assertEquals;

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

public class TC01_AddProductToCart extends BaseClass {
	@Test
	public void addToCart() throws EncryptedDocumentException, IOException, InterruptedException {
		Header header = new Header(driver);
		DataUtilities dataUtilities = new DataUtilities();
		WebDriverUtilities webDriverUtilities = new WebDriverUtilities();
		AccountPage accountPage = new AccountPage(driver);
		assertEquals(driver.getTitle(), datautilities.readDataPropertyFile("homepageTitle"));
		header.clickLoginSignInButton();

		LoginPage login = new LoginPage(driver);
//		login.enterEmail(dataUtilities.readDataExcelFile("Sheet1", 0, 1));
//		login.enterPassword(dataUtilities.readDataExcelFile("Sheet1", 1, 1));
//		login.clickLoginBtn();
//		String accountTitle = accountPage.getTitleAccount(driver);
//		assertEquals(accountTitle, dataUtilities.readDataPropertyFile("accountPageTitle"));

		NavigationBar navigation = new NavigationBar(driver);
		WebElement homeFurniture = navigation.hoverOnHomeFurniture();
//		webDriverUtilities.waitElement(homeFurniture, driver);
		webDriverUtilities.mouseHover(homeFurniture, driver);
		navigation.clickAcComforts();
		
		ProductsPage page = new ProductsPage(driver);
		System.out.println("---------------------------");
		System.out.println(page.getTitleProductsPage(driver));
		System.out.println(dataUtilities.readDataPropertyFile("acComfortorPageTitle"));
		System.out.println("---------------------------");
		assertEquals(page.getTitleProductsPage(driver), dataUtilities.readDataPropertyFile("acComfortorPageTitle"));

//		WebElement sizeBtn = page.getSize();
//		webDriverUtilities.waitElementClick(sizeBtn, driver);
//		sizeBtn.click();
//
//		WebElement sizeOption = page.selectSize();
//		webDriverUtilities.waitElementClick(sizeOption, driver);
//		sizeOption.click();
//
//		WebElement colorBtn = page.getColor();
//		webDriverUtilities.waitElementClick(colorBtn, driver);
//		colorBtn.click();
//
//		WebElement colorOption = page.selectColor();
//		webDriverUtilities.waitElementClick(colorOption, driver);
//		colorOption.click();
//
//		WebElement brandBtn = page.getBrand();
//		webDriverUtilities.waitElementClick(brandBtn, driver);
//		brandBtn.click();
//
//		WebElement brandOption = page.selectBrand();
//		webDriverUtilities.waitElementClick(brandOption, driver);
//		brandBtn.click();
//
//		WebElement availabilityBtn = page.getAvailability();
//		webDriverUtilities.waitElementClick(availabilityBtn, driver);
//		availabilityBtn.click();
//
//		WebElement availabilityOption = page.selectAvailability();
//		webDriverUtilities.waitElementClick(availabilityOption, driver);
//		availabilityOption.click();
//
//		ProductDetailsPage productDetails = new ProductDetailsPage(driver);
//		WebElement selectedProduct = productDetails.getProductInfo();
//		webDriverUtilities.waitElementClick(selectedProduct, driver);
//		productDetails.addToWishList();
//
//		header.clickWishListButton();
//
//		WishListPage wishListPage = new WishListPage(driver);
//		WebElement wishListedProduct = wishListPage.getWishlistedProduct();
//		assertEquals(selectedProduct.getText(), wishListedProduct.getText());
//		assertEquals(dataUtilities.readDataExcelFile("Sheet1", 5, 1), wishListPage.getTitleWishListPage(driver));
//		wishListPage.addToCart();
//		CartPage cartPage = new CartPage(driver);
//		WebElement cartItem = cartPage.getCartItem();
//		assertEquals(wishListedProduct.getText(), cartItem.getText());
	}
}
