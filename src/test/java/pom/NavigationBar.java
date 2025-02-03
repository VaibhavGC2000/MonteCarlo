package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class NavigationBar {

	@FindBy(xpath = "//li[@data-item-title=\"HOME FURNISHING\"]")
	private WebElement homeFurninshing;

	@FindBy(xpath = "//li[@data-item-title='MEN']")
	private WebElement menSection;

	@FindBy(xpath = "//li[@data-item-title='WOMEN']")
	private WebElement womenSection;

	@FindBy(xpath = "//li[@class=\"linklist__item\"]/a[contains(text(),'AC Comforter')]")
	private WebElement acComforts;

	@FindBy(xpath = "//li[@class=\"linklist__item\"]/a[contains(text(),'Round Neck Sweaters')]")
	private WebElement roundNeckSweaters;

	@FindBy(xpath = "(//a[@aria-label='Cart'])[2]")
	private WebElement cartButton;

	@FindBy(xpath = "//span[contains(text(), 'Wishlist')]")
	private WebElement addToWishListIcon;

	@FindBy(xpath = "(//a[contains(@class,'header__icon-wrapper')])[1]")
	private WebElement searchBox;

	public NavigationBar(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOnHomeFurniture() {
		return homeFurninshing;
	}

	public WebElement menSection(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementClick(menSection, driver);
		return menSection;
	}

	public void clickAcComforts(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementClick(acComforts, driver);
		acComforts.click();
	}

	public void clickRoundNeckSweaters(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElement(roundNeckSweaters, driver);
		roundNeckSweaters.click();
	}

	public void clickCartButton() {
		cartButton.click();
	}

	public void clickWishlist() {
		addToWishListIcon.click();
	}

	public void clickOnWomenSection() {
		womenSection.click();
	}

	public void clickOnSearchBox() {
		searchBox.click();
	}

}
