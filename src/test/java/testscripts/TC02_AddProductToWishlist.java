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
import pom.SearchDrawer;
import pom.WishListPage;

public class TC02_AddProductToWishlist extends BaseClass {
	@Test
	public void addToWishlist() throws EncryptedDocumentException, IOException, InterruptedException {
		Header header = new Header(driver);
		header.clickLoginSignInButton();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		// compare afterwards and verify

		NavigationBar navigationBar = new NavigationBar(driver);
		navigationBar.clickOnSearchBox();

		SearchDrawer searchDrawer = new SearchDrawer(driver);
		searchDrawer.enterSearchDrawer("Hand Towels");

		WebElement selectedProduct = searchDrawer.selectProductFromList(3);
		selectedProduct.click();

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.addToWishList();
//		WebElement selectedProductDetail = productDetailsPage.getProductInfo();
		navigationBar.clickWishlist();

		WishListPage wishListPage = new WishListPage(driver);
		WebElement wishListedProduct = wishListPage.getWishlistedProduct();
		webDriverUtilities.waitElement(wishListPage.productDisplay(), driver);
		webDriverUtilities.mouseHover(wishListPage.productDisplay(), driver);

//		assertEquals(selectedProductDetail.getText(), wishListedProduct.getText());
		List<WebElement> totalWishListedItems = wishListPage.getWishListedItems();
		WebElement removeFromWishList = wishListPage.removeFromWishlist();
//		webDriverUtilities.waitElementClick(selectedProductDetail, driver);
		System.out.println(removeFromWishList.getText());
		removeFromWishList.click();

		List<WebElement> totalWishListedItemsAfterRemove = wishListPage.getWishListedItems();
		assertEquals(totalWishListedItems.size(), totalWishListedItemsAfterRemove.size());

	}
}
