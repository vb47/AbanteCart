package abantecart.pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class cartBaseClass extends LoginPage{

	
	
//------------------------------------Common xpath for many
		@FindBy(xpath = "//a[@class=\"productcart\"]")
		WebElement addToCartbutton;
		@FindBy(xpath="//*[@id=\"cart\"]/div/table/tbody/tr[2]/td[2]/a")
		WebElement productnameincart;
		@FindBy(xpath="//a[@class='btn cart mb20 col-xs-12 col-lg-6']")
		WebElement addToCartBigButton;
		@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div/div/table/tbody/tr[2]/td[2]/a")
		WebElement productnameinWishlist;
		
	//
	@FindBy(xpath="//span[@class=\"nostock\"]")
	WebElement outOfStockButton;
	
///------------------------Add product from category
	@FindBy(xpath = "//div[@class='thumbnail']/a[@href = 'http://localhost/abantecart-src-master/public_html/index.php?rt=product/product&product_id=68']")
	WebElement product1;	
	@FindBy(xpath= "//*[@id=\"categorymenu\"]/nav/ul/li[5]/a")
	WebElement FragnanceCategory;
	@FindBy(xpath= "//*[@id=\"categorymenu\"]/nav/ul/li[5]/div/ul[1]/li[1]/a")
	WebElement menFragnanceCategory;
	@FindBy(xpath = "//span[@class='menu_text']/following::span[4]")
	WebElement topCartIcon;
	@FindBy(xpath = "//button[@class='close callback-btn']")
	WebElement closeUndefinedErrorAlert;


///-------------------------Add product to Wishlist
	@FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[1]/a")
	WebElement homeButton;
//	@FindBy(xpath = "//*[@id=\"block_frame_bestsellers_1771\"]/div/div[4]/div[1]/div/a")
//	WebElement SeaweedConditioner;
	@FindBy(xpath="//div[@class=\"thumbnail\"]")
	WebElement productThumbnail;
//	@FindBy(xpath="//*[@id=\"product\"]/fieldset/div[6]/a[2]")
//	WebElement addToWishlistButton;
	@FindBy(xpath="//a[@class=\"wishlist_add btn btn-large col-lg-4\"]")
	WebElement addToWishlistButton;
	@FindBy(xpath="//*[@id=\"customer_menu_top\"]/li/a/div")
	WebElement WelcomeBackButton;
	@FindBy(xpath ="//*[@id=\"customer_menu_top\"]/li/ul/li[2]/a" )
	WebElement myWishList;
	@FindBy(xpath="//a[@class=\"wishlist_remove btn btn-large col-lg-4\"]")
	WebElement removefromWishListButton;

	
//--------------------------Add Product From Wishlist
	@FindBy(xpath="//*[@id=\"maincontainer\"]/div/div[1]/div/div/div/table/tbody/tr[2]/td[6]/a[1]/i")
	WebElement addToCartIcon;
	@FindBy(xpath="//*[@id=\"product\"]/fieldset/div[5]/div/a[1]")
	WebElement AddtoCartButton;
	
//--------------------------Remove Product From Wishlist
	@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div[1]/div/div/div/table/tbody/tr[2]/td[6]/a[2]/i")
	WebElement deleteProduct;
	
	
//--------------------------Add Product From Specials
	@FindBy(xpath = "//*[@id=\"main_menu_top\"]/li[1]/a/span")
	WebElement specialsButton;

	@FindBy(xpath = "//*[@id=\"main_menu_top\"]/li[3]/a/span")
	WebElement viewCartIcon;
	
//--------------------------Call to Order Product
	@FindBy(xpath= "//a[@class=\"btn call_to_order\"]")
	WebElement callToOrderButton;
	
	
	
//---------------------------Add Product through Search
	@FindBy(xpath="//input[@id='filter_keyword']")
	WebElement searchKeywords;

	
	
	public cartBaseClass(WebDriver driver) throws InterruptedException {
		super(driver);
	}
	
	public void addProductThroughCategory() throws InterruptedException {
		  login("dhanush1","dhanush");  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(FragnanceCategory).perform();
	//	  driver.findElement(By.xpath("//*[@id=\\\"categorymenu\\\"]/nav/ul/li[5]/div/ul[1]/li[1]/a")).click();
		  menFragnanceCategory.click();
	//	  driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[3]/div[2]/div[3]/a/i")).click();
		  addToCartbutton.click();
	//	  driver.findElement(By.xpath("//*[@id=\"main_menu_top\"]/li[3]/a/span")).click(); 
		  topCartIcon.click();
		  //driver.findElement(By.xpath("//*[@id=\"msgModal\"]/div/div/div[1]/button")).click();
		  closeUndefinedErrorAlert.click();
		  String productName= productnameincart.getText();
		  System.out.println(productName);
		  System.out.println("Product added to cart!");
	//	  driver.findElement(By.xpath("//*[@id=\"cart_checkout1\"]")).click();
		  super.logout();
	}
	
	public void  addProductToWishlist()
	{
		login("dhanush1", "dhanush");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		homeButton.click();
	//	actions.scrollToElement(SeaweedConditioner).perform();
		productThumbnail.click();
	//	SeaweedConditioner.click();
		
		try {
			actions.scrollToElement(addToWishlistButton).perform();
			addToWishlistButton.click();
			//Actions actions1 = new Actions(driver);
			actions.moveToElement(WelcomeBackButton).perform();
			myWishList.click();
			String productName =productnameinWishlist.getText();
			System.out.println(productName);
			System.out.println("Product added to your wishlist!");
		} catch (ElementNotInteractableException e) {
//			actions.scrollToElement(removefromWishListButton).perform();
//			removefromWishListButton.click();
			System.out.println("It is already in your wishlist!");
		}
		
		actions.moveToElement(WelcomeBackButton).perform();
		myWishList.click();
	}
	
	
	public void removeProductFromWishlist()
	{
		login("dhanush1", "dhanush");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		actions.moveToElement(WelcomeBackButton).perform();
		myWishList.click();
		String productName= productnameinWishlist.getText();
		System.out.println(productName);
		deleteProduct.click();
		System.out.println("Product removed from your wishlist!");
	//	homeButton.click();
	}
	
	public void addProductFromWishlist() {
		login("dhanush1", "dhanush");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		actions.moveToElement(WelcomeBackButton).perform();
		myWishList.click();
		addToCartIcon.click();
		closeUndefinedErrorAlert.click();
	//	AddtoCartButton.click();
		String productName= productnameincart.getText();
		System.out.println(productName);
		System.out.println("Product from wishlist added to your cart!");
	}
		
	public void addProductFromSpecials()
	{
		login("dhanush1", "dhanush");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		specialsButton.click();
		addToCartbutton.click();
		viewCartIcon.click();
		String productName= productnameincart.getText();
		System.out.println(productName);
		System.out.println("Product from specials added to cart!");
	}
	
	public void addProductThroughSearch()
	{
		login("dhanush1", "dhanush");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		searchKeywords.sendKeys("Paper Towns");
		driver.findElement(By.xpath("//*[@id=\"search_form\"]/div/div/i")).click();
		addToCartBigButton.click();
		String productName= productnameincart.getText();
		System.out.println(productName);
		System.out.println("The Product is added to the cart!");
	}
	
	//-------------Kind of complete
	public void callToOrderProduct()
	{
		login("dhanush1", "dhanush");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions actions = new Actions(driver);
		homeButton.click();
		callToOrderButton.click();
		System.out.println("The phone number to call is ");
		String number = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div/div[1]/div[2]")).getText();
		System.out.println(number);
	}
	
	
	public void tearDown() {
		super.tearDown();
	}
	
	
	
}
