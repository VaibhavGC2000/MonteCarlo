package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.AddressDrawer;
import pom.AddressPage;
import pom.Header;
import pom.LoginPage;

public class TC06_AddAddress extends BaseClass {
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException {
		logger = LogManager.getLogger(TC06_AddAddress.class);
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

		accountPage.clickAddressBtn();
		logger.info("Clicked Address button on Account Page.");

		AddressPage addressPage = new AddressPage(driver);
		WebElement addAddressBtn = addressPage.getAddNewAddressBtn(webDriverUtilities, driver);
		addAddressBtn.click();
		logger.info("Clicked Add New Address button.");

		AddressDrawer addressDrawer = new AddressDrawer(driver);

		String fname = datautilities.readDataPropertyFile("firstName");
		String lName = datautilities.readDataPropertyFile("lastName");
		String companyName = datautilities.readDataPropertyFile("companyName");
		String phoneNo = datautilities.readDataPropertyFile("phoneNum");
		String addressOne = datautilities.readDataPropertyFile("add1");
		String addressTwo = datautilities.readDataPropertyFile("add2");
		String zipcode = datautilities.readDataPropertyFile("zipCode");
		String cityName = datautilities.readDataPropertyFile("cityName");

		addressDrawer.enterFirstName(fname);
		addressDrawer.enterLastName(lName);
		addressDrawer.enterCompany(companyName);
		addressDrawer.enterPhone(phoneNo);
		addressDrawer.enterAddressOne(addressOne);
		addressDrawer.enterAddressTwo(addressTwo);
		addressDrawer.enterZip(zipcode);
		addressDrawer.enterCity(cityName);
		addressDrawer.clickAddAddressBtn();
		logger.info("Entered address details and clicked Add Address button.");

		List<WebElement> allAddressText = addressPage.getAllAddressesTextsElements();
		String addressText = allAddressText.get(0).getText();
		String[] lines = addressText.split("\n");
		logger.info("Address Text: " + addressText);
		logger.info("Address Lines: " + Arrays.toString(lines));
//		if( Arrays.toString(lines).contains(lines))


//		Assert.assertTrue(isAddressMatch(fname, lName, companyName, phoneNo, addressOne, addressTwo, zipcode, cityName,
//				addressPage));

	}
}
