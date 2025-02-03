package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

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

public class TC08_VerifyPopup extends BaseClass {
	@Test
	public void addToWishList() throws InterruptedException, EncryptedDocumentException, IOException {
		NavigationBar navigationBar = new NavigationBar(driver);
		navigationBar.clickOnWomenSection();
		Collections collections = new Collections(driver);
		collections.clickOnStole();
		collections.enterMinAmtInputBox("0");
		collections.enterMaxAmtInputBox("500");
		assertTrue(collections.noResults());
		collections.enterMinAmtInputBox("299");
		collections.enterMaxAmtInputBox("2000");
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.clickOnProduct(2,webDriverUtilities,driver);
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.addToWishList();
		assertTrue(collections.isEmailPopup());

		collections.enterEmailPopup(datautilities.readDataExcelFile("Sheet1", 0, 1));
		collections.clickAddToWishListPopup();
		collections.clickLoginPopup();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		loginPage.clickLoginBtn();

		navigationBar.clickWishlist();
//		WebElement selectedProduct = productDetailsPage.getProductInfo();
		WishListPage wishListPage = new WishListPage(driver);
		List<WebElement> wishLisedProducts = wishListPage.getWishListedItems();
		WebElement wishListedProductElement = wishLisedProducts.get(0);
		WebElement wishListedProduct = wishListedProductElement.findElement(
				By.xpath("//div[contains(@class,'flits-box')]//p[contains(@class,\"flits-product-name\")]"));
//		System.out.println("Selected product : " + selectedProduct.getText());
//		System.out.println("wishListed product : " + wishListedProduct.getText());
//		assertEquals(selectedProduct.getText(), wishListedProduct.getText());
	}
}
