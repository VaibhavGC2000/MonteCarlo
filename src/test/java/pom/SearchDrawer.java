package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchDrawer {
	@FindBy(xpath = "//input[contains(@placeholder,'What are you looking for?')]")
	private WebElement searchDrawerInput;

	@FindBy(xpath = "(//div[@class=\"drawer__content\"]//ul[@data-type=\"products\"]/li)")
	private List<WebElement> searchedProductList;

	@FindBy(xpath = "//button[normalize-space()='View all results']")
	private WebElement viewAllResultsBtn;

	public SearchDrawer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterSearchDrawer(String search) {
		searchDrawerInput.sendKeys(search);
	}

	public List<WebElement> listOfProducts() {
		return searchedProductList;
	}

	public WebElement selectProductFromList(int productIndex) {
		return searchedProductList.get(productIndex);
	}

	public void clickViewAllResultsBtn() {
		viewAllResultsBtn.click();
	}
}
