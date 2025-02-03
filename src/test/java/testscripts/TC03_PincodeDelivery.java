package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

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

//10.Click on size filter
//11.Select 38 / M(94)
//12.Scroll down & Click on Brand filter
//13.Select the checkbox of Rock.it
//14.Scroll down & Click on sleeve filter
//15.Select the checkbox of Full Sleeve
//16.Select the third product
//17.Scroll & Enter the pincode in Check Pincode TextBox
//18.Click on Check pincode
//19.Close the window

public class TC03_PincodeDelivery extends BaseClass {
	@Test
	public void checkPincodeAndDelivery() throws EncryptedDocumentException, IOException, InterruptedException {
		// 1.Open the browser
		// 2.Maximize the browser
		// 3.Enter the URL
		Header header = new Header(driver);
		// 4.Click Login/Signup
		header.clickLoginSignInButton();

		LoginPage loginPage = new LoginPage(driver);
		// 5.Enter Username and password
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 1, 0));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		// 6.Click Login
		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		// 7.Verify the Account page
//		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));

		NavigationBar navigationBar = new NavigationBar(driver);
		WebElement mens = navigationBar.menSection(webDriverUtilities, driver);
		// 8.MouseOver on Mens section
		webDriverUtilities.mouseHover(mens, driver);

		// 9.Click on Round Neck Sweaters
		navigationBar.clickRoundNeckSweaters(webDriverUtilities, driver);

		ProductsPage productsPage = new ProductsPage(driver);
		WebElement sizeBtn = productsPage.getSize(webDriverUtilities, driver);
		sizeBtn.click();

		WebElement menSizeOption = productsPage.selectMenSize(webDriverUtilities, driver);
		menSizeOption.click();

		productsPage.clickBrand(webDriverUtilities, driver);

		WebElement brandRockItOption = productsPage.selectBrandRockit(webDriverUtilities, driver);
		brandRockItOption.click();

		WebElement sleeveBtn = productsPage.sleeveBtn(webDriverUtilities, driver);
		sleeveBtn.click();

		WebElement fullSleeveOption = productsPage.fullSleeveOption(webDriverUtilities, driver);
		fullSleeveOption.click();

		productsPage.clickOnProduct(3, webDriverUtilities, driver);

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.enterPincode(datautilities.readDataPropertyFile("zipCode"));
		productDetailsPage.clickCheckPincodeBtn();

	}
}
