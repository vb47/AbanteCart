package Login;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class page {
	public WebDriver driver;
	private String url = "http://10.44.11.219/abantecart-src-master/abantecart-src-master/public_html/ ";
	
	@FindBy(id = "customer_menu_top")
	public WebElement menubar;
	
	@FindBy(id = "loginFrm_loginname")
	public WebElement loginname;
	
	@FindBy(id = "loginFrm_password")
	public WebElement loginpassword;
	
	@FindBy(xpath = "//*[@id='loginFrm']/fieldset/button")
	public WebElement loginbutton;
	
	@FindBy(xpath = "//*[@id='main_menu_top']/li[2]/a/span")
	public WebElement logoutmenu;
	
	@FindBy(xpath = "//*[@id='maincontainer']/div/div[2]/div[1]/div/ul/li[10]/a")
	public WebElement logoutbutton;
	
	page(WebDriver driver) throws InterruptedException{
		this.driver = driver;
		driver.get(url);
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	public void login(String username, String password) {

		menubar.click();
		
		loginname.sendKeys(username);
		loginpassword.sendKeys(password);
		loginbutton.click();
	}
	
	public void login(String path) throws CsvValidationException, IOException {
		CSVReader reader = new CSVReader(new FileReader(path));
		  String[] nextLine;
		  String username = "", password = "";
		  while ((nextLine = reader.readNext()) != null) {
		         if (nextLine != null) {
		        	 username = nextLine[0];
		             password = nextLine[1];
		             this.login(username, password);
		             this.logout();
		             
		         }
		  }
	}
	
	public void logout() {
		logoutmenu.click();
		logoutbutton.click();
	}
	
	public void tearDown() {
		driver.quit();
	}

}

