package genericLibraries;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentTest;

@Listeners(Listeners1.class)
//Listeners in testng is used to listen to your execution we use OnTestFailure() method and write the code to take 
//screenshot of failed TCs
public class BaseClass {
	public static WebDriver driver;

	public DataUtilities datautilities = new DataUtilities();
	public WebDriverUtilities webDriverUtilities = new WebDriverUtilities();

	@BeforeMethod 
	public void openApp() throws EncryptedDocumentException, IOException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(datautilities.readDataExcelFile("Sheet1", 2, 1));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod	
	public void closeApp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
