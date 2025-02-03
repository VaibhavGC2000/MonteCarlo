package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

public class CartDrawer {

	@FindBy(xpath = "//cart-drawer[@id='mini-cart']/descendant::p[.='Your cart is empty']")
	private WebElement cartIsEmpty;

	@FindBy(xpath = "//*[@id=\"mini-cart\"]/div/div/a")
	private WebElement startShopping;

	@FindBy(xpath = "//button[@id='order-note-toggle']")
	private WebElement addOrderNote;

	@FindBy(css = "textarea[id='cart[note]']")
	private WebElement textAreaInput;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveBtn;

	@FindBy(xpath = "//button[contains(@title,'Close')]")
	private WebElement closeCartBtn;

	@FindBy(xpath = "//button[@name='checkout']")
	private WebElement initiateCheckoutBtn;

	// ------------------------------------

	public CartDrawer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// -------------------------------------

	public String getEmptyCartText() {
		return cartIsEmpty.getText();
	}

	public void startShopping() {
		startShopping.click();
	}

	public WebElement getAddOrderNote(WebDriverUtilities webDriverUtilities,WebDriver driver) {
		webDriverUtilities.waitElementClick(addOrderNote, driver);
		return addOrderNote;
	}

	public void enterTextOrderNote(String note) {
		textAreaInput.sendKeys(note);
	}

	public void clickSaveBtn() {
		saveBtn.click();
	}

	public void clickInitiateCheckoutBtn() {
		initiateCheckoutBtn.click();
	}

	public void clickCloseCart() {
		closeCartBtn.click();
	}
}
