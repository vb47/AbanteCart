package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class mainPage {
	WebDriver driver;
	String url = "https://demo.abantecart.com/";
	
	public void openWebsite() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get(url);
		Thread.sleep(5000);
		
		driver.close();
		
	}
}
