package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	@FindBy(xpath = "//button[text()='Size'] ")
	private WebElement size;

	@FindBy(xpath = "(//label[@class=\"block-swatch__item\"])[3]")
	private WebElement menSize;

	@FindBy(xpath = "//label[contains(text(),'Single')] ")
	private WebElement sizeOption;

	@FindBy(xpath = "//button[text()='Color']")
	private WebElement color;

	@FindBy(xpath = "(//label[@class=\"color-swatch__item\"])[2]")
	private WebElement colorOption;

	@FindBy(xpath = "//button[text()='Brand']")
	private WebElement brand;

	@FindBy(xpath = "//label[contains(text(),'Monte Carlo')]")
	private WebElement brandOption;

	@FindBy(xpath = "//label[contains(text(),'Rock.it')]")
	private WebElement brandOptionRockIt;

	@FindBy(xpath = "//button[text()='Sleeve'] ")
	private WebElement sleeve;

	@FindBy(css = "input[id='filter.p.m.custom.sleeve_id-1']")
	private WebElement fullSleeveOption;

	@FindBy(xpath = "//button[text()='Availability']")
	private WebElement availability;

	@FindBy(xpath = "//label[contains(text(),'In stock') or input[@class='checkbox']]")
	private WebElement instockOption;

	@FindBy(xpath = "(//div[@class='title-wish'])[1]")
	private WebElement firstProduct;

	@FindBy(xpath = "(//product-item[@class=\"product-item  hhh Byee\"]//div[@class=\"product-item__info  text--small\"]//a)[3]")
	private WebElement thirdProdut;

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement selectSize() {
		return sizeOption;
	}

	public WebElement getColor() {
		return color;
	}

	public WebElement selectColor() {
		return colorOption;
	}

	public WebElement getBrand() {
		return brand;
	}

	public WebElement selectBrand() {
		return brandOption;
	}

	public WebElement getAvailability() {
		return availability;
	}

	public WebElement selectAvailability() {
		return instockOption;
	}

	public WebElement sleeveBtn() {
		return sleeve;
	}

	public void clickOnProduct() {
		firstProduct.click();
	}

	public String getTitleProductsPage(WebDriver driver) {
		return driver.getTitle();
	}

	public WebElement selectMenSize() {
		return menSize;
	}

	public WebElement getBrandElement() {
		return brand;
	}

	public WebElement selectBrandRockit() {
		return brandOptionRockIt;
	}

	public WebElement fullSleeveOption() {
		return fullSleeveOption;
	}

	public WebElement clickThirdProduct() {
		  return thirdProdut;
	}
}
