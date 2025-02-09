package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class WishListPage {
	@FindBy(xpath = "//div[contains(@class,'flits-box-card')]//div[contains(@class,'flits-product-item-card')]//p[contains(@class,'flits-product-name')]")
	private WebElement wishListedItem;

	@FindBy(xpath = "//div[contains(@class,'flits-box')]//div//div//div//button[text()='Add to Cart']")
	private WebElement addToCart;

	@FindBy(xpath = "(//div[@class='flits-product-item-main'])[1]//button[contains(@class,'flits-remove-product')]")
	private WebElement removeFromWishlist;

	@FindBy(xpath = "//div[@class='flits-wishlist-product-list list']")
	private List<WebElement> wishListedItems;

	@FindBy(xpath = "//div[contains(@class,'flits-box')]//div[contains(@class,'flits-product-item-card')]")
	private WebElement productDisplay;

	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getWishlistedProduct(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElement(wishListedItem, driver);
		return wishListedItem.getText();
	}

	public void addToCart() {
		addToCart.click();
	}

	public String getTitleWishListPage(WebDriver driver) {
		return driver.getTitle();
	}

	public WebElement removeFromWishlist() {
		return removeFromWishlist;
	}

	public List<WebElement> getWishListedItems() {
		return wishListedItems;
	}

	public WebElement productDisplay() {
		return productDisplay;
	}

}
