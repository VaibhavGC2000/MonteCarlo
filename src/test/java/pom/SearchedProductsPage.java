package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedProductsPage {
	@FindBy(xpath = "//button[normalize-space()='Price']")
	private WebElement selectPriceBtn;

	@FindBy(xpath = "(//product-item[@class=\"product-item  hhh Byee\"])")
	private List<WebElement> allSearchedProductsList;

	public SearchedProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> allSearchedProductList() {
		return allSearchedProductsList;
	}

	public WebElement selectProduct(int productIndex) {
		return allSearchedProductsList.get(productIndex);
	}

	public WebElement getSelectPriceBtn() {
		return selectPriceBtn;
	}

}
