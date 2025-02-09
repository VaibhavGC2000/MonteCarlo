package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
	@FindBy(xpath = "//a[contains(@class,'product-item-meta__title hidden-phone')]")
	private WebElement cartItem;

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getCartItem() {
		return cartItem.getText();
	}

	public String getTitleCartPage(WebDriver driver) {
		return driver.getTitle();
	}

	
}
