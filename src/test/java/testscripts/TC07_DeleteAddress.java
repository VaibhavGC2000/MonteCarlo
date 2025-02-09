package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
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
		logger = LogManager.getLogger(TC07_DeleteAddress.class);
		Header header = new Header(driver);
        header.clickLoginSignInButton();
        logger.info("Clicked Login/Sign-In button.");

        LoginPage loginPage = new LoginPage(driver);
        String email = datautilities.readDataExcelFile("Sheet1", 0, 1);
        String password = datautilities.readDataExcelFile("Sheet1", 1, 1);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginBtn();
        logger.info("Entered email and password, and clicked login button.");

        AccountPage accountPage = new AccountPage(driver);
        String accountPageTitle = accountPage.getTitleAccount(driver);
        logger.info("Account Page Title: " + accountPageTitle);
        assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
        logger.info("Verified Account Page Title.");

        accountPage.clickAddressBtn();
        logger.info("Clicked Address button on Account Page.");

        AddressPage addressPage = new AddressPage(driver);
        addressPage.deleteDefaultAddress(addressPage, driver, webDriverUtilities);
        logger.info("Deleted default address.");
		
	}
}
