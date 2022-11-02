package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshot {
	WebDriver driver;
	File screenshot;
	
	public screenshot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void takeScreenshot(String fileName) {
		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
        	FileUtils.copyFile(screenshot, new File("./data/screenshots/products/" + fileName + ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
}
