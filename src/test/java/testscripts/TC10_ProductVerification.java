package testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.MonteCarloPage;
import pom.QuickBuyDrawer;

public class TC10_ProductVerification extends BaseClass {
	@Test
	public void verifyProduct() throws EncryptedDocumentException, IOException, InterruptedException {
		Header header = new Header(driver);
		header.clickLoginSignInButton();
		LoginPage loginPage = new LoginPage(driver);
//		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
//		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
//		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		Assert.assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		header.clickMonteCarloLink();

		MonteCarloPage monteCarloPage = new MonteCarloPage(driver);
		String monteCarloPageTitle = monteCarloPage.getMonteCarloTitle(driver);
		System.out.println("---------------");
		System.out.println(monteCarloPageTitle);
		System.out.println("--------------------");
		System.out.println(datautilities.readDataPropertyFile("monteCarloPage"));
//		Assert.assertEquals(monteCarloPage, datautilities.readDataPropertyFile("monteCarloPage"));

		webDriverUtilities.scrollToElement(monteCarloPage.getShopTrendsText(), driver);
//		Thread.sleep(2000);
		monteCarloPage.clickOnNewArrivalBtn();
//		Thread.sleep(2000);
		WebElement ele = monteCarloPage.getNewArrivalProductElement(4);
		webDriverUtilities.mouseHover(ele, driver);
//		Thread.sleep(2000);
		WebElement scrollNextBtn = monteCarloPage.getNextBtn();
		scrollNextBtn.click();
//		Thread.sleep(2000);
		monteCarloPage.hoverAndClickNewArrivalProduct(6, driver, webDriverUtilities);
		QuickBuyDrawer quickBuyDrawer = new QuickBuyDrawer(driver);
		quickBuyDrawer.selectAnySize();
		quickBuyDrawer.clickIncreaseCountBtn();
		quickBuyDrawer.clickViewDetailsBtn();

	}
}
