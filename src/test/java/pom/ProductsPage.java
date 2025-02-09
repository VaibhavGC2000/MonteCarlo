package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtilities;

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

	@FindBy(xpath = "(//div[@class='title-wish'])")
	private List<WebElement> productsList;

	@FindBy(xpath = "//button[@class='popover-button hidden-pocket']")
	private WebElement sortByBtn;

	@FindBy(xpath = "//span[normalize-space()='Price, high to low']")
	private WebElement highToLow;

	@FindBy(xpath = "(//product-item[@class=\"product-item  hhh Byee\"]/div/a[@data-tippy-content=\"Add to Wishlist\"])")
	private List<WebElement> addToWishList;

	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getSize(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElement(size, driver);
		size.click();
	}

	public void selectSize(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(sizeOption, driver);
		sizeOption.click();
	}

	public void getColor(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(color, driver);
		color.click();
	}

	public void selectColor(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(colorOption, driver);
		colorOption.click();
		;
	}

	public void clickBrand(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(brand, driver);
		brand.click();
	}

	public void selectBrand(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(brandOption, driver);
		brandOption.click();
	}

	public void getAvailability(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(availability, driver);
		availability.click();
		;
	}

	public void selectAvailability(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(instockOption, driver);
		instockOption.click();
	}

	public void sleeveBtn(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(sleeve, driver);
		sleeve.click();
	}

	public void clickOnProduct(int index, WebDriverUtilities webDriverUtilities, WebDriver driver) {
		WebElement product = driver
				.findElement(By.xpath("(//div[@id='facet-main']//product-item[@class='product-item  hhh Byee'])["
						+ index + "]//div[@class='title-wish']/a"));
		webDriverUtilities.scrollToElement(product, driver);
		webDriverUtilities.waitElement(product, driver);
		product.click();
	}

	public String getTitleProductsPage(WebDriver driver) {
		return driver.getTitle();
	}

	public WebElement selectMenSize(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementClick(menSize, driver);
		return menSize;
	}

	public WebElement getBrandElement(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementClick(brand, driver);
		return brand;
	}

	public WebElement selectBrandRockit(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(brandOptionRockIt, driver);
		return brandOptionRockIt;
	}

	public WebElement fullSleeveOption(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementClick(fullSleeveOption, driver);
		return fullSleeveOption;
	}

	public void clickSortBybtn(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElementClick(sortByBtn, driver);
		sortByBtn.click();
	}

	public void clickHighToLow(WebDriverUtilities webDriverUtilities, WebDriver driver) {
		webDriverUtilities.waitElement(highToLow, driver);
		highToLow.click();
	}

	public List<WebElement> getProductToWishList(List<WebElement> list, WebDriverUtilities webDriverUtilities,
			WebDriver driver) {
		webDriverUtilities.waitElementRefreshed(addToWishList, driver);
		return addToWishList;
	}

	public void clickWishListProduct(int index) {
		addToWishList.get(1).click();
	}
}
