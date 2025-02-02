package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class MonteCarloPage {

	@FindBy(xpath = "//h3[text()='SHOP TRENDS']")
	private WebElement shopTrendsText;

	@FindBy(xpath = "//button[normalize-space()='New Arrival']")
	private WebElement newArrivalBtn;

	@FindBy(xpath = "(//div[@class=\"featured-collections \"]//span[.='Next']/parent::button)[2]")
	private WebElement nextButton;

	@FindBy(xpath = "(*//product-list[2]//product-item/div[2])")
	private List<WebElement> allNewArrivalProducts;

	@FindBy(xpath = "(*//product-list[2]//div[@class=\"product-item__image-wrapper product-item__image-wrapper--multiple\"])[6]/following::a")
	private WebElement newArrivalProductInfo;

	@FindBy(xpath = "*//product-list[2]//product-item/div[2]/div[1]/button[1]")
	private List<WebElement> newAllArrivalProductQuickViewListBtn;

	// ---------------------------------
	public MonteCarloPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// ---------------------------------

	public String getMonteCarloTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public WebElement getShopTrendsText() {
		return shopTrendsText;
	}

	public void clickOnNewArrivalBtn() {
		newArrivalBtn.click();
	}

	public WebElement getNextBtn() {
		return nextButton;
	}

	public List<WebElement> getAllNewArrivalProducts() {
		return allNewArrivalProducts;
	}

	public WebElement getNewArrivalProductElement(int index) {
		return allNewArrivalProducts.get(index);
	}

	public WebElement getNewArrivalProductInfo() {
		return newArrivalProductInfo;
	}

	public List<WebElement> getNewArrivalProductQuickViewBtn(int index) {
		return newAllArrivalProductQuickViewListBtn;
	}

	public void hoverAndClickNewArrivalProduct(int index, WebDriver driver, WebDriverUtilities webDriverUtilities) {
		WebElement product = getNewArrivalProductElement(index);
		webDriverUtilities.mouseHover(product, driver);
		newAllArrivalProductQuickViewListBtn.get(index).click();
	}

}
