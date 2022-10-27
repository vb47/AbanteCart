package modules;

import java.io.*;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/*
 * Class: UserAccount
 * Parent: AbanteCart
 * Parameters: driver (WebDriver)
 * Description: Handles operations like login, logout and user registrations.
 */
public class UserAccount extends AbanteCart{
	WebDriver driver;
	String defaultUsername;
	String defaultPassword;
	private CSVReader csvreader;
	String[] csvcell;
	
	// Essential Page Objects for login and registration page
	@FindBy(id = "accountFrm_accountregister")
	private WebElement radio;
	@FindBy(xpath = "//*[@id=\"accountFrm\"]/fieldset/button")
	private WebElement countinue1;
	@FindBy(id = "AccountFrm_firstname")
	private WebElement firstname;
	@FindBy(id = "AccountFrm_lastname")
	private WebElement lastname;
	@FindBy(id = "AccountFrm_email")
	private WebElement email;
	@FindBy(id = "AccountFrm_address_1")
	private WebElement address;
	@FindBy(id = "AccountFrm_city")
	private WebElement city;
	@FindBy(id = "AccountFrm_country_id")
	private WebElement country;
	@FindBy(id = "AccountFrm_zone_id")
	private WebElement zone;
	@FindBy(id = "AccountFrm_postcode")
	private WebElement post;
	@FindBy(id = "AccountFrm_loginname")
	private WebElement loginname;
	@FindBy(id = "AccountFrm_password")
	private WebElement password;
	@FindBy(id = "AccountFrm_confirm")
	private WebElement confirm;
	@FindBy(id = "AccountFrm_agree")
	private WebElement agree;
	@FindBy(xpath = "//*[@id=\"AccountFrm\"]/div[5]/div/div/button")
	private WebElement register;
	@FindBy(xpath= "//*[@id=\"maincontainer\"]/div/div/div/div[1]")
	private WebElement error;
	@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/h1/span[1]/text()")
	private WebElement success;
	
	public UserAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
		driver.manage().window().maximize();
		this.defaultUsername = "Amya";
		this.defaultPassword = "Kyapata";
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Method: userRegistration
	 * Parameters: filePath (String)
	 * Description: Registers account with credentials given in specified csv file.
	 */
	public List<String> userRegistration(String filePath) throws IOException ,  InterruptedException,CsvValidationException{
		csvreader = new CSVReader(new FileReader(filePath));
		 List<String> response = new ArrayList<String>();
		 while((csvcell = csvreader.readNext())!= null)
		  {
			 super.openWebsite(super.getUrl() + "index.php?rt=account/login");
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(super.ImplicitWaitTime));
			 radio.click();
			 countinue1.click();
			 agree.click();
			 
			 // adding credentials
			 firstname.sendKeys(csvcell[0]);
			 lastname.sendKeys(csvcell[1]);
			 email.sendKeys(csvcell[2]);
			 address.sendKeys(csvcell[3]);
			 city.sendKeys(csvcell[4]);
			 Select d = new Select(country);
			 d.selectByVisibleText(csvcell[7]);
			 Select down = new Select(zone);
			 down.selectByVisibleText(csvcell[5]);
			 post.sendKeys(csvcell[6]);
			 loginname.sendKeys(csvcell[8]);
			 password.sendKeys(csvcell[9]);
			 confirm.sendKeys(csvcell[10]);
			
			 // Submitting form
			 register.click();
			 if(error.getText().length()>1)
				  response.add(error.getText());
			 else
				 response.add(success.getText());
			 
			 if (driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a")).getText().contains("Welcome")) {
				 //System.out.println("Bypassing auto login.");
				 driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a")).click();
				 driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[2]/div[1]/div/ul/li[10]/a")).click();
			 }
			 
		  }
		 return response;
		
	}
	
}
