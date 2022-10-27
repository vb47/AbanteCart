package projectpom;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class page {
	private WebDriver driver;
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
	
	//@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div/section/a")
	//private WebElement continue1;
	String url = "http://localhost/abantecart-src-master/abantecart-src-master/public_html/index.php?rt=account/login";
	private CSVReader csvreader;
	String[] csvcell;
	
	page (WebDriver dev)
	{
		
		driver=dev;
		//driver.get(url);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void userRegistration(String path) throws IOException ,  InterruptedException,CsvValidationException {
		 csvreader = new CSVReader(new FileReader(path));
		 
		 while((csvcell = csvreader.readNext())!= null)
		  {
			 driver.get(url);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 radio.click();
			 countinue1.click();
			 agree.click();
			 firstname.sendKeys(csvcell[0]);
			 lastname.sendKeys(csvcell[1]);
			 email.sendKeys(csvcell[2]);
			 address.sendKeys(csvcell[3]);
			 city.sendKeys(csvcell[4]);
			 Select d = new Select(country);
			 d.selectByVisibleText(csvcell[7]);
			// Thread.sleep(3000);
			 Select down = new Select(zone);
			 down.selectByVisibleText(csvcell[5]);
			// Thread.sleep(3000);
			 post.sendKeys(csvcell[6]);
			 loginname.sendKeys(csvcell[8]);
			 password.sendKeys(csvcell[9]);
			 confirm.sendKeys(csvcell[10]);
			
			 register.click();
			 Thread.sleep(1000);
			 System.out.println( error.getText());
			 
			//Thread.sleep(1000);
			// firstname.clear();
			// lastname.clear();
			// email.clear();
			// address.clear();
			//city.clear();
			// post.clear();
			// loginname.clear();
			// password.clear();
			 //confirm.clear();
			// agree.clear();
			 
			 //Thread.sleep(1000);
			 System.out.println(success);
			 if (driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a")).getText().contains("Welcome")) {
				 System.out.println("Bypassing auto login.");
				 driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a")).click();
				// driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div[2]/div[1]/div/ul/li[10]/a")).click();
			 
		  }
		}
		        
		  }
		// System.out.println(success);
		//continue1.click();
	  }
	            	 
	
