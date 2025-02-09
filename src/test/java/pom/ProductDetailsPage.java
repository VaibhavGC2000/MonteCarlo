package pom;

import java.util.List;

import org.apache.poi.hssf.eventusermodel.dummyrecord.LastCellOfRowDummyRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.DataUtilities;
import genericLibraries.WebDriverUtilities;

public class ProductDetailsPage {

	@FindBy(xpath = "//div[@class='product_wishlist']//a")
	private WebElement addToWishlist;

	@FindBy(xpath = "//div[@class=\"product__info\"]//h1")
	private WebElement selectedProduct;

	@FindBy(xpath = "//div[@class='product-page-tabs-cts-y']//button[1]")
	private WebElement productDetailsAndDescriptionBtn;

	@FindBy(xpath = "//div[@class=\"block-swatch-list\"]/div")
	private List<WebElement> allSizes;

	@FindBy(xpath = "//div[@class='product-form__quantity']//button[normalize-space()='Increase quantity']")
	private WebElement increaseQuantityBtn;

	@FindBy(xpath = "//div[@class='product-form__quantity']//button[normalize-space()='Decrease quantity']")
	private WebElement decreaseQuantityBtn;

	@FindBy(xpath = "//button[@id='AddToCart']")
	private WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class='yash-blog-text shreyh']/h2[text()='Manufacturer Address']/following::p")
	private WebElement manuFactureAddress;

	@FindBy(xpath = "//div[@class='flits-wls-snackbar-header']")
	private WebElement wishListPopup;

	@FindBy(xpath = "//input[@id='pincode']")
	private WebElement pincode;

	@FindBy(xpath = "//button[@id='check-pincode']")
	private WebElement checkPincode;

	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void addToWishList() {
		addToWishlist.click();
	}

	public WebElement getProductInfo(WebDriverUtilities webDriverUtilities,WebDriver driver) {
		webDriverUtilities.waitElement(selectedProduct, driver);
		return selectedProduct;
	}

	public void clickProductDetailsAndDescriptionBtn(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(productDetailsAndDescriptionBtn, driver);
		productDetailsAndDescriptionBtn.click();
	}

	public List<WebElement> getAllSizes() {
		return allSizes;
	}

	public WebElement selectSize(int size) {
		return allSizes.get(size);
	}

	public void clickAddToCartBtn() {
		addToCartBtn.click();
	}

	public String manufactureAddress(WebDriverUtilities webDriverUtilities,WebDriver driver) {
		webDriverUtilities.waitElement(manuFactureAddress, driver);
		return manuFactureAddress.getText();
	}

	public void enterPincode(String pincode) {
		this.pincode.sendKeys(pincode);
	}

	public void clickCheckPincodeBtn() {
		checkPincode.click();
	}

	public void increaseProductQuantity() {
		increaseQuantityBtn.click();
	}

	public void decreaseProductQuantity() {
		decreaseQuantityBtn.click();
	}

	public boolean isVerifyPopup() {
		if (wishListPopup.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

}
