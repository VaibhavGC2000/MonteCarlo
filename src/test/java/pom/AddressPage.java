package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class AddressPage {
	@FindBy(xpath = "(//div[@class=\"account__addresses-list\"]/div)")
	private List<WebElement> totalAddressesList;

	@FindBy(xpath = "//div[@class=\"account__addresses-list\"]//*[normalize-space()='Add a new address']")
	private WebElement clickAddNewAddressBtn;

	@FindBy(xpath = "//div[@class='page-content']//p")
	private List<WebElement> allAddressesTextsElements;

	@FindBy(xpath = "//span[.='Default address']")
	private WebElement defaultAddress;

	// -----------------------------------------
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// -----------------------------------------

	public List<WebElement> getAllAddressList() {
		return totalAddressesList;
	}

	public void clickAddNewAddressBtn() {
		clickAddNewAddressBtn.click();
	}

	public List<WebElement> getAllAddressesTextsElements() {
		return allAddressesTextsElements;
	}

	public void deleteDefaultAddress(AddressPage addressPage, WebDriver driver, WebDriverUtilities webDriverUtilities) {
		WebElement defaultAddress = addressPage.getAddress();
		if ((defaultAddress.getText()).equals("Default Address")) {
			WebElement deleteBtn = defaultAddress
					.findElement(By.xpath("./parent::div/child::div[2]/descendant::button[.='Delete']"));
			System.out.println("...." + deleteBtn.getText());
			deleteBtn.click();
			webDriverUtilities.alertAcceptPopup(driver);
		} else {
			System.out.println("Default Address not present!!");
		}
	}

	public WebElement getAddress() {
		return defaultAddress;
	}
}
