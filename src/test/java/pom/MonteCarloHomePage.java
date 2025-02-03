package pom;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class MonteCarloHomePage {
	@FindBy(xpath = "//a[normalize-space()='SHOP Blankets']")
	private WebElement shopBlanketButton;

	@FindBy(xpath = "//a[normalize-space()='Our Stores']")
	private WebElement outStoresLink;

	public MonteCarloHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickShopBlanketsButton(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElement(shopBlanketButton, driver);
		shopBlanketButton.click();
	}

	public void clickOnOurStores(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementClick(outStoresLink, driver);
		outStoresLink.click();
	}

}
