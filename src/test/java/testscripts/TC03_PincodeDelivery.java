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

public class TC03_PincodeDelivery extends BaseClass {
	@Test
	public void checkPincodeAndDelivery() throws EncryptedDocumentException, IOException, InterruptedException {
		Header header = new Header(driver);
		header.clickLoginSignInButton();

		LoginPage loginPage = new LoginPage(driver);
//		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 1, 0));
//		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
//		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
//		assertEquals(false, null);
		NavigationBar navigationBar = new NavigationBar(driver);
		WebElement mens = navigationBar.menSection();
		webDriverUtilities.mouseHover(mens, driver);
		navigationBar.clickRoundNeckSweaters();

		ProductsPage productsPage = new ProductsPage(driver);
		WebElement sizeBtn = productsPage.getSize();
		webDriverUtilities.waitElement(sizeBtn, driver);
		sizeBtn.click();
//		Thread.sleep(2000);
		WebElement menSizeOption = productsPage.selectMenSize();
		webDriverUtilities.waitElement(menSizeOption, driver);
		menSizeOption.click();
//		Thread.sleep(1000);
		WebElement brandBtn = productsPage.getBrand();
		webDriverUtilities.waitElementClick(brandBtn, driver);
		brandBtn.click();
//		Thread.sleep(1000);
		WebElement brandRockItOption = productsPage.selectBrandRockit();
		webDriverUtilities.waitElement(brandRockItOption, driver);
		brandRockItOption.click();	
//		Thread.sleep(1000);
		WebElement sleeveBtn = productsPage.sleeveBtn();
		webDriverUtilities.waitElement(sleeveBtn, driver);
		sleeveBtn.click();
		
		WebElement fullSleeveOption = productsPage.fullSleeveOption();
		webDriverUtilities.waitElement(fullSleeveOption, driver);
		fullSleeveOption.click();
		
		WebElement thirdProduct = productsPage.clickThirdProduct();
		System.out.println("worinking : "+thirdProduct.getTagName());
		System.out.println(thirdProduct.getText());
		webDriverUtilities.waitElementClick(thirdProduct, driver);
		thirdProduct.click();

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.enterPincode(datautilities.readDataPropertyFile("zipCode"));
		productDetailsPage.clickCheckPincodeBtn();

	}
}
