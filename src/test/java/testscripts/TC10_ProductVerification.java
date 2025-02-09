package testscripts;

import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
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
		// 1. Launch the browser
		// 2. enter url - https://www.montecarlo.in/
		logger = LogManager.getLogger(TC10_ProductVerification.class);
		Header header = new Header(driver);
		// 3. Click on Login
		header.clickLoginSignInButton();
		logger.info("Clicked Login/Sign-In button.");

		LoginPage loginPage = new LoginPage(driver);
		// 4. Enter the email
		String email = datautilities.readDataExcelFile("Sheet1", 0, 1);
		loginPage.enterEmail(email);
		logger.info("Entered email: " + email);

		// 5. Enter the password
		String password = datautilities.readDataExcelFile("Sheet1", 1, 1);
		loginPage.enterPassword(password);
		logger.info("Entered password.");

		// 6. Click on login
		loginPage.clickLoginBtn();
		logger.info("Clicked login button.");

		AccountPage accountPage = new AccountPage(driver);
		String accountPageTitle = accountPage.getTitleAccount(driver);
		// 7. Verify you are in account page
		Assert.assertEquals(accountPageTitle, datautilities.readDataPropertyFile("accountPageTitle"));
		logger.info("Verified Account Page Title: " + accountPageTitle);

		// 8. Click on Monte Carlo logo at the top left corner of the page.
		header.clickMonteCarloLink();
		logger.info("Clicked Monte Carlo logo.");

		MonteCarloPage monteCarloPage = new MonteCarloPage(driver);
		String monteCarloPageTitle = monteCarloPage.getMonteCarloTitle(driver);
		Assert.assertEquals(monteCarloPageTitle, datautilities.readDataPropertyFile("monteCarloPage"));
		logger.info("Verified Monte Carlo Page Title: " + monteCarloPageTitle);

		// 10. Scroll down till New Arrival under Shop Trends section.
		webDriverUtilities.scrollToElement(monteCarloPage.getShopTrendsText(), driver);
		logger.info("Scrolled to New Arrival under Shop Trends section.");

		// 11. Click on NEW Arrival.
		monteCarloPage.clickOnNewArrivalBtn();
		logger.info("Clicked on NEW Arrival.");

		WebElement ele = monteCarloPage.getNewArrivalProductElement(4, webDriverUtilities, driver);
		webDriverUtilities.mouseHover(ele, driver);
		logger.info("Mouse hovered over the 4th New Arrival product.");

		WebElement scrollNextBtn = monteCarloPage.getNextBtn();
		webDriverUtilities.waitElementClick(scrollNextBtn, driver);
		scrollNextBtn.click();
		logger.info("Clicked Next button.");

		monteCarloPage.hoverAndClickNewArrivalProduct(6, driver, webDriverUtilities);
		logger.info("Hovered and clicked on the 6th New Arrival product.");

		QuickBuyDrawer quickBuyDrawer = new QuickBuyDrawer(driver);

		quickBuyDrawer.selectAnySize();
		logger.info("Selected any size for the product.");

		quickBuyDrawer.clickIncreaseCountBtn();
		logger.info("Clicked Increase Count button.");

		quickBuyDrawer.clickViewDetailsBtn();
		logger.info("Clicked View Details button.");

	}
}
