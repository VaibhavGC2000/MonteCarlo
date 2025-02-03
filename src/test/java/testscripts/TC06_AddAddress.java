package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.WebDriverUtilities;
import io.opentelemetry.semconv.SemanticAttributes.FaasTriggerValues;
import pom.AccountPage;
import pom.AddressDrawer;
import pom.AddressPage;
import pom.Header;
import pom.LoginPage;

public class TC06_AddAddress extends BaseClass {
	@Test
	public void addAddress() throws EncryptedDocumentException, IOException {
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
		WebElement addAddressBtn = addressPage.getAddNewAddressBtn(webDriverUtilities, driver);
		addAddressBtn.click();

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

		List<WebElement> allAddressText = addressPage.getAllAddressesTextsElements();
		String addressText = allAddressText.get(0).getText();
		String[] lines = addressText.split("\n");
		System.out.println(Arrays.toString(lines));

//		Assert.assertTrue(isAddressMatch(fname, lName, companyName, phoneNo, addressOne, addressTwo, zipcode, cityName,
//				addressPage));

	}
}
