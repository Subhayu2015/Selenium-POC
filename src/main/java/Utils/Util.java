package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseTest.TestBase;

public class Util extends TestBase{
	public static void takeScreenshotAtEndOfTest() throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(SrcFile, new File("/Users/mac/Programming/Java/SeleniumPractice/screenshot/" +  System.currentTimeMillis() + ".png"));
		
	}

}
