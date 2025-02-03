package testscripts;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import genericLibraries.BaseClass;
import genericLibraries.WebDriverUtilities;
import pom.AccountPage;
import pom.Header;
import pom.LoginPage;
import pom.MonteCarloPage;
import pom.QuickBuyDrawer;




public class TC10_ProductVerification extends BaseClass {
	@Test
	public void verifyProduct() throws EncryptedDocumentException, IOException, InterruptedException {
		//1. Launch the browser 
		//2. enter url - https://www.montecarlo.in/
		Header header = new Header(driver);
		//3.click on Login
		header.clickLoginSignInButton();
		LoginPage loginPage = new LoginPage(driver);
		//4. enter the email
		loginPage.enterEmail(datautilities.readDataExcelFile("Sheet1", 0, 1));
		//5. enter the password
		loginPage.enterPassword(datautilities.readDataExcelFile("Sheet1", 1, 1));
		//6. click on login
		loginPage.clickLoginBtn();

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		//7. verify you are in account page
		Assert.assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		//8. Click on Monte Carlo logo at the top left corner of the page.
		header.clickMonteCarloLink();

		MonteCarloPage monteCarloPage = new MonteCarloPage(driver);
		String monteCarloPageTitle = monteCarloPage.getMonteCarloTitle(driver);
		System.out.println("---------------");
		System.out.println(monteCarloPageTitle);
		System.out.println("--------------------");
		System.out.println(datautilities.readDataPropertyFile("monteCarloPage"));
		//9. Verify whether you are in Home Page
//		Assert.assertEquals(monteCarloPage, datautilities.readDataPropertyFile("monteCarloPage"));

		//10. Scroll down till New Arrival under Shop Trends section.
		webDriverUtilities.scrollToElement(monteCarloPage.getShopTrendsText(), driver);
		//11. Click on NEW Arrival.
		monteCarloPage.clickOnNewArrivalBtn();
		WebElement ele = monteCarloPage.getNewArrivalProductElement(4,webDriverUtilities,driver);
		webDriverUtilities.mouseHover(ele, driver);
		
		WebElement scrollNextBtn = monteCarloPage.getNextBtn();
		webDriverUtilities.waitElementClick(scrollNextBtn, driver);
		scrollNextBtn.click();
		
		monteCarloPage.hoverAndClickNewArrivalProduct(6, driver, webDriverUtilities);
		QuickBuyDrawer quickBuyDrawer = new QuickBuyDrawer(driver);
		
		quickBuyDrawer.selectAnySize();
		quickBuyDrawer.clickIncreaseCountBtn();
		quickBuyDrawer.clickViewDetailsBtn();

	}
}
