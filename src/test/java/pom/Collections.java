package pom;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Collections {
	@FindBy(xpath = "//div[@class='popover-container']/button") // button[@class='popover-button hidden-pocket']
	private WebElement clickSortByBtn;

	@FindBy(xpath = "//label[@class='popover__choice-item']/span[text()='Date, old to new']")
	private WebElement oldToNew;

	@FindBy(xpath = "(//div[@class='product-list__inner']/product-item)")
	private List<WebElement> allProducts;

	@FindBy(xpath = "//span/span[text()='Quick view']/ancestor::button")
	private List<WebElement> quickViewBtn;

	@FindBy(css = "button[id='AddToCart'] span[class='loader-button__text']")
	private WebElement addToCartBtn;

	@FindBy(xpath = "(//button[contains(@title,'Close')])[3]")
	private WebElement closeCartBtn;

	@FindBy(xpath = "(//div[@class=\"slick-track\"]/div/a)[5]")
	private WebElement stole;

	@FindBy(xpath = "//input[@id='filter.v.price.gte']")
	private WebElement minAmountInputBox;

	@FindBy(css = "input[id='filter.v.price.lte']")
	private WebElement maxAmountInputBox;

	@FindBy(xpath = "//div[@class='empty-state']")
	private WebElement noResult;

	@FindBy(xpath = "//div[@class=\"flits-tingle-modal-box-content\"]//input")
	private WebElement emailPopup;

	@FindBy(xpath = "//input[@class=\"flits-input flits-tingle-input\"]")
	private WebElement enterEmailPopup;

	@FindBy(xpath = "//button[normalize-space()='Add to Wishlist']")
	private WebElement addToWishList;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement loginBtnPopup;

	public Collections(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSortBy() {
		clickSortByBtn.click();
	}

	public void clickOldToNewOption() {
		oldToNew.click();
	}

	public List<WebElement> allProductList() {
		return allProducts;
	}

	public WebElement getProduct(int productIndex) {
		return allProducts.get(productIndex);
	}

	public void clickQuickViewBtn() {
		quickViewBtn.get(1).click();
	}

	public void clickAddToCartBtn() {
		addToCartBtn.click();
	}

	public void clickCloseCartBtn() {
		closeCartBtn.click();
	}

	public void clickOnStole() {
		stole.click();
	}

	public boolean isEmailPopup() {
		return emailPopup.isDisplayed();
	}

	public void enterEmailPopup(String email) {
		emailPopup.sendKeys(email);
	}

	public void enterMinAmtInputBox(String min) {
		minAmountInputBox.sendKeys(min);
	}

	public void enterMaxAmtInputBox(String max) {
		maxAmountInputBox.sendKeys(max);
	}

	public void clickAddToWishListPopup() {
		addToWishList.click();
	}

	public void clickLoginPopup() {
		loginBtnPopup.click();
	}

	public boolean noResults() {
		if (noResult.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

}
