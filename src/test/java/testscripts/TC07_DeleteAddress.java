package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.AddressPage;
import pom.Header;
import pom.LoginPage;

public class TC07_DeleteAddress extends BaseClass {
	@Test
	public void deleteAddress() throws EncryptedDocumentException, IOException {
		Header header = new Header(driver);
		header.clickLoginSignInButton();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));

		accountPage.clickAddressBtn();
		AddressPage addressPage = new AddressPage(driver);
		addressPage.deleteDefaultAddress(addressPage, driver, webDriverUtilities);

	}
}
