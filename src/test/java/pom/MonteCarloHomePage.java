package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarloHomePage {
	@FindBy(xpath = "//a[normalize-space()='SHOP Blankets']")
	private WebElement shopBlanketButton;

	@FindBy(xpath = "//a[normalize-space()='Our Stores']")
	private WebElement outStoresLink;

	public MonteCarloHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickShopBlanketsButton() {
		shopBlanketButton.click();
	}

	public void clickOnOurStores() {
		outStoresLink.click();
	}
	
	
}
