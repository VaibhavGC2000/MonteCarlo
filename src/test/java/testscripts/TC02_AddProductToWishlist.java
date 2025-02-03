package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.NavigationBar;
import pom.ProductDetailsPage;
import pom.ProductsPage;
import pom.SearchDrawer;
import pom.WishListPage;

public class TC02_AddProductToWishlist extends BaseClass {
	@Test
	public void addToWishlist() throws EncryptedDocumentException, IOException, InterruptedException {
		// 1.Open the browser
		// 2.Maximize the browser
		// 3.Enter the URL
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
		// 6.Verify the AccountPage
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		// compare afterwards and verify

		NavigationBar navigationBar = new NavigationBar(driver);
		// 7.Click on Searchbox
		navigationBar.clickOnSearchBox();

		SearchDrawer searchDrawer = new SearchDrawer(driver);
		// 8.Search for Hand Towels
		searchDrawer.enterSearchDrawer("Hand Towels");

		WebElement selectedProduct = searchDrawer.selectProductFromList(3);
		// 9.Scrolldown upto fourth product
		selectedProduct.click();

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		// 11.Add to Wishlist
		productDetailsPage.addToWishList();
		// WebElement selectedProductDetail = productDetailsPage.getProductInfo();

		// 12.Click on Wishlist
		navigationBar.clickWishlist();

		WishListPage wishListPage = new WishListPage(driver);
		WebElement wishListedProduct = wishListPage.getWishlistedProduct();
		webDriverUtilities.waitElement(wishListPage.productDisplay(), driver);
		webDriverUtilities.mouseHover(wishListPage.productDisplay(), driver);
		System.out.println("---------------------------");
//		System.out.println(selectedProductDetail.getText());
//		System.out.println( wishListedProduct.getText());

		// 13.Verify if the product is added to the wishlist
//		assertEquals(selectedProductDetail.getText(), wishListedProduct.getText());
		
		List<WebElement> totalWishListedItems = wishListPage.getWishListedItems();
		WebElement removeFromWishList = wishListPage.removeFromWishlist();
//		webDriverUtilities.waitElementClick(selectedProductDetail, driver);
		System.out.println(removeFromWishList.getText());
		
		// 14.Click on the close button
		removeFromWishList.click();
		List<WebElement> totalWishListedItemsAfterRemove = wishListPage.getWishListedItems();
		
		// 15.Verify if the product is removed or not
		assertEquals(totalWishListedItems.size(), totalWishListedItemsAfterRemove.size());
	}
}
