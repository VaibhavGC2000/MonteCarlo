package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

	@FindBy(xpath = "//li[@class='wishlist']//a")
	private WebElement wishListButton;

	@FindBy(xpath = "//li[@class='login']/a")
	private WebElement loginSignupButton;

	@FindBy(xpath = "(//ul[@class='logo-flex']/li/span[@class=\"header__logo\"]/a)[1]")
	private WebElement monteCarloLink;

	@FindBy(xpath = "(//ul[@class='logo-flex']/li/span[@class=\"header__logo\"]/a)[3]")
	private WebElement homeCarloHomeLink;

	public Header(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickWishListButton() {
		wishListButton.click();
	}

	public void clickLoginSignInButton() {
		loginSignupButton.click();
	}

	public void clickMonteCarloLink() {
		monteCarloLink.click();
	}

	public void clickHomeCarloHomeLink() {
		homeCarloHomeLink.click();
	}

}
