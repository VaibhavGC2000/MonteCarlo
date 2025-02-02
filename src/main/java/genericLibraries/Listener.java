package genericLibraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot screenshot = (TakesScreenshot) BaseClass.driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(AutoConstant.photoPath + result.getMethod() + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
