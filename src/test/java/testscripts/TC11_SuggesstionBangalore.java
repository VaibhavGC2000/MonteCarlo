package testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.CartDrawer;
import pom.Header;
import pom.LoginPage;
import pom.NavigationBar;
import pom.ProductsPage;

//14. click on wishlist
//15. verify if product got added to wishlist
//16. add that item to cart
//17. enter text in 'add order note' 
//18. initiate checkout click
//19. enter text bangalore and select second suggesstion
//20.close the application

public class TC11_SuggesstionBangalore extends BaseClass {
	@Test
	public void suggesstionBangalore() throws EncryptedDocumentException, IOException, InterruptedException {
		Header header = new Header(driver);
		// 04. click on login/sign up
		header.clickLoginSignInButton();

		// 05. enter username
		// 06. enter password
		// 07. click login

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("SHeet1", 1, 1));
		loginPage.clickLoginBtn();

		// 08. click on cart
		// 09. make sure "Your cart is empty" text is displaying
		// 10. click start shopping.

		NavigationBar navigationBar = new NavigationBar(driver);
		navigationBar.clickCartButton();

		CartDrawer cartDrawer = new CartDrawer(driver);
		cartDrawer.startShopping();

		// 11 click on sort by
		// 12. select 'high to low'

		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.clickSortBybtn(webDriverUtilities, driver);
		productsPage.clickHighToLow(webDriverUtilities, driver);
		Thread.sleep(2000);
		// 13. add any product to wishlist
		productsPage.clickWishListProduct(1);
		

	}
}
