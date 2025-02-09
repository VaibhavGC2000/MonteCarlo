package genericLibraries;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import java.time.Duration;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners(Listener.class)
public class BaseClass {
	public static WebDriver driver;

	public DataUtilities datautilities = new DataUtilities();
	public WebDriverUtilities webDriverUtilities = new WebDriverUtilities();
	public static Logger logger;

	@BeforeMethod 
	public void openApp() throws EncryptedDocumentException, IOException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(datautilities.readDataExcelFile("Sheet1", 2, 1));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod	
	public void closeApp() {
		driver.quit();
	}
}
