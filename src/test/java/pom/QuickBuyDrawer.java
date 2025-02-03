package pom;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickBuyDrawer {
	@FindBy(xpath = "//div[@class='block-swatch-list']//input[@type='radio']")
	private List<WebElement> allSizes;

	@FindBy(xpath = "//div[@class='product-form__quantity']//span[text()='Decrease quantity']/parent::button")
	private WebElement decreaseCountBtn;

	@FindBy(xpath = "//div[@class='product-form__quantity']//span[text()='Increase quantity']/parent::button")
	private WebElement increaseCountBtn;

	@FindBy(xpath = "//a[normalize-space()='View details']")
	private WebElement viewDetailsBtn;

	// ----------------------------------------
	public QuickBuyDrawer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ----------------------------------------
	public List<WebElement> getAllSizes() {
		return allSizes;
	}

	public void selectAnySize() {
		for (WebElement size : allSizes) {
			@Nullable
			WebElement parentElement = size.findElement(By.xpath("./.."));
			@Nullable
			String sizeOption = parentElement.getDomAttribute("class");
			System.out.println(sizeOption);
			if (!sizeOption.contains("is-Disabled")) {
				size.click();
				break;
			}
		}
	}

	public void selectSize(int index) {
		WebElement size = allSizes.get(index);
		size.findElement(By.xpath("./.."));
		@Nullable
		String parent = size.getDomAttribute("class");
		if(!parent.contains("is-disabled")) {
			size.click();
		}else {
			System.out.println("Selected size is disbaled");
		}
	}

	public void clickIncreaseCountBtn() {
		increaseCountBtn.click();
	}

	public void clickViewDetailsBtn() {
		viewDetailsBtn.click();
	}
}
