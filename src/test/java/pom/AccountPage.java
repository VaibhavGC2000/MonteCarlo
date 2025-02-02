package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	@FindBy(xpath = "//ul[@data-type='products']/li")
	private List<WebElement> listOfProducts;

	@FindBy(xpath = "//li[@class=\"block_link\"]//a[text()=\"Addresses\"]")
	private WebElement addressBtn;

	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getTitleAccount(WebDriver driver) {
		return driver.getTitle();
	}

	public void clickOnSelectedProduct() {
		listOfProducts.get(3).click();
	}

	public void clickAddressBtn() {
		addressBtn.click();
	}

}
