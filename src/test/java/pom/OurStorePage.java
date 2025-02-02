package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OurStorePage {
	@FindBy(id = "searchInput")
	private WebElement searchInputBox;

	@FindBy(xpath = "//div[@class='store-card']")
		private List<WebElement> addressList;

	@FindBy(xpath = "//a[normalize-space()='Get Directions']")
	private WebElement clickGetDirectionBtn;

	public OurStorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterInputText(String zipcode) {
		searchInputBox.sendKeys(zipcode);
	}

	public boolean pincodeVerification() {
		return addressList.size() == 1;
	}

	public void clickGetDirectionBtn() {
		clickGetDirectionBtn.click();
	}

}
