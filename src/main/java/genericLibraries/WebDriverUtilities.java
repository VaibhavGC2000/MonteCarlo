package genericLibraries;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WebDriverUtilities {

	public void mouseHover(WebElement ele, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
	}

	public void doubleClick(WebElement ele, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(ele).perform();
	}

	public void rightClick(WebElement ele, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(ele).perform();
	}

	public void doubleClick1(WebElement ele, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(ele);
	}

	public void dropDown(WebElement ele, String text, WebDriver driver) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

	public void frameWithWebElementAddress(WebElement ele, WebDriver driver) {
		driver.switchTo().frame(ele);
	}

	public void frameWithIndex(int index, WebDriver driver) {
		driver.switchTo().frame(index);
	}

	public void alertAcceptPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void alertDismissPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void alertPopupText(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		Reporter.log(alert.getText());
	}

	public void scrollbarTopToBottom(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,5000)");
	}

	public void scrollbarBottomToTop(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,-5000)");
	}

	public void scrollToElement(WebElement element, WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	public void switchChildWindow(WebDriver driver) {

		Set<String> child = driver.getWindowHandles();

		for (String string : child) {
			driver.switchTo().window(string);
		}
	}

	public void multipleTabs(int index, WebDriver driver) {
		Set<String> child = driver.getWindowHandles();
		ArrayList<String> arrayList = new ArrayList<String>(child);
		driver.switchTo().window(arrayList.get(index));
	}

	public void swicthDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void waitElement(WebElement ele, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitElements(List<WebElement> list, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}

	public void waitElementClick(WebElement ele, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public void waitElementRefreshed(WebElement ele, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(ele)));
	}
	
	public void waitElementRefreshed(List<WebElement> list, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(list)));
	}
	
	

}
