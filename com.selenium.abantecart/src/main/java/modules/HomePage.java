package modules;

import java.io.*;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import utilities.screenshot;

/*
 * Class: HomePage
 * Parameters: driver (WebDriver)
 * Parent Class: AbanteCart
 * Description: Child class to handle operations related to homepage of AbanteCart.
 */
public class HomePage extends AbanteCart{
	WebDriver driver;
	String datasetFilePath = "./data/datasets/productList.csv";
	
	/*
	 * Page Objects for Home Page
	 */
	@FindBy(xpath="//*[@id='categorymenu']/nav/ul/li[1]/a")
	WebElement categoryMenuElement;
	
	@FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[2]/a")
	WebElement categoryApparelElement;
	
	@FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[3]/a")
	WebElement categoryMakeupElement;
	
	@FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[4]/a")
	WebElement categorySkincareElement;
	
	@FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[5]/a")
	WebElement categoryFragranceElement;
	
	@FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[6]/a")
	WebElement categoryMenElement;
	
	@FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[7]/a")
	WebElement categoryHairCareElement;
	
	@FindBy(xpath = "//*[@id='categorymenu']/nav/ul/li[8]/a")
	WebElement categoryBooksElement;
	
	@FindBy(id = "filter_keyword")
	private WebElement searchElement;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Function name: getProductList()
	 * Input: (int) categoryIndex: category index in main menu. Index - 0 for Main Page.
	 * 		  (int) subcategoryIndex: sub category for category provided. Provide 0 to visit only categoryIndex.
	 * Description: Utility function to get product list and product href via category provided.
	 * Return: (String[]) list containing all product list with it's href links.
	 */
	public String[] getProductList(int categoryIndex, int subcategoryIndex) {
		Actions actions = new Actions(driver);
		int i=0;
		List<WebElement> productsOnPage;
		String[] list;
		String link;
		super.openWebsite();
		
		switch(categoryIndex) {
		case 0:
			// get product names at current Page
			productsOnPage = driver.findElements(By.className("prdocutname"));
			list = new String[2*productsOnPage.size()];
			
			for(WebElement product: productsOnPage) {
				list[i++] = product.getText();
				link = product.getAttribute("href");
				System.out.println(link);
				list[i++] = link;
				list[i++] = link.substring(link.lastIndexOf("=") + 1);
			}
		break;
		
		case 1:
			actions.moveToElement(categoryApparelElement).click().perform();
			switch(subcategoryIndex) {
			case 1:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Shoes']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='T-shirts']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			}
		break;
		
		case 2:
			actions.moveToElement(categoryMakeupElement).click().perform();
			switch(subcategoryIndex) {
			
			case 1:
				actions.moveToElement(categoryMakeupElement).click().perform();
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Cheeks']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Eyes']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 3:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Face']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			case 4:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Lips']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			case 5:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Nails']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			case 6:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Value Sets']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			}
		break;
		
		case 3:
			actions.moveToElement(categorySkincareElement).click().perform();
			switch(subcategoryIndex) {
			case 1:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Eyes']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Face']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 3:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Gift Ideas & Sets']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			case 4:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Hands & Nails']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			case 5:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Sun']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			}
		break;
		
		case 4:
			actions.moveToElement(categoryFragranceElement).click().perform();
			switch(subcategoryIndex) {
			case 1:
				actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[1]/div/a"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Women']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			}
		break;
		
		case 5:
			actions.moveToElement(categoryMenElement).click().perform();
			switch(subcategoryIndex) {
			case 1:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Body & Shower']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Fragrance Sets']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 3:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Pre-Shave & Shaving']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			case 4:
				actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[4]/div/a"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
				
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			}
		break;
		
		case 6:
			actions.moveToElement(categoryHairCareElement).click().perform();
			switch(subcategoryIndex) {
			case 1:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Conditioner']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Shampoo']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			}
		break;
		
		case 7:
			actions.moveToElement(categoryBooksElement).click().perform();
			switch(subcategoryIndex) {
			case 1:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Audio CD']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Paperback']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
					link = product.getAttribute("href");
					list[i++] = link;
					list[i++] = link.substring(link.lastIndexOf("=") + 1);
				}
				break;
			}
		break;
		
		default:
			list = new String[0];
			break;
		}
		return list;
	}
	
	/*
	 * Method: generateProductList
	 * Description: It generates a productList.csv dataset file that contains category index, subcategory index, title and links of all products in AbanteCart.
	 */
	public void generateProductList() {
		File file = new File(datasetFilePath);
		// Exception Handling for IOException, if file path is invalid.
	    try {
	        // FileWriter object with file as parameter
	        FileWriter outputfile = new FileWriter(file);
	  
	        // CSVWriter object with filewriter object as parameter
	        CSVWriter writer = new CSVWriter(outputfile);
	  
	        // List which contains String array to add data row-wise to csv file
	        List<String[]> data = new ArrayList<String[]>();
	        data.add(new String[] { "Category Index", "Sub-Category Index", "Product Name", "href link", "Product Id" });
	        
	        // inserting data to csv object
	        String productName = "", productHref = "", productId = "";
	        
	        // Category: (0, 0)
	        String[] productList = this.getProductList(0, 0);
	  	  	for(int i=0;i<productList.length; i++) {
	  	  		productName = productList[i++];
	  	  		productHref = productList[i++];
	  	  		productId = productList[i];
	  	  		if(productName.length() > 1) {
	  	  		//System.out.println(productName + " > " + productHref);
	  	  		data.add(new String[] { "0", "0", productName, productHref, productId });
//	  	  		ss.takeScreenshot("Product_" + "0" + "0" + i);
	  	  		}
	  	  	}
	  	  	
	  	  	// Category: (1, 1-2)
	  	  	for(int i=1; i<=2; i++) {
	  	  		String[] productList1 = this.getProductList(1, i);
		  	  	for(int i1=0;i1<productList1.length; i1++) {
		  	  		productName = productList1[i1++];
		  	  		productHref = productList1[i1];
		  	  		
		  	  	if(productName.length() > 1) {
		  	  		//System.out.println(productName + " > " + productHref);
		  	  		data.add(new String[] { "1", Integer.toString(i), productName, productHref });
//		  	  		ss.takeScreenshot("Product_" + "1" + Integer.toString(i) + i);
		  	  		}
		  	  	}
	  	  	}
	  	  
	  	  	// Category: (2, 1-6)
	  	  	for(int i=1; i<=6; i++) {
	  	  		String[] productList1 = this.getProductList(2, i);
		  		for(int i1=0;i1<productList1.length; i1++) {
		  	  		productName = productList1[i1++];
		  	  		productHref = productList1[i1];
			  	  	if(productName.length() > 1) {
			  	  		//System.out.println(productName + " > " + productHref);
			  	  		data.add(new String[] { "2", Integer.toString(i), productName, productHref });
//			  	  	ss.takeScreenshot("Product_" + "2" + Integer.toString(i) + i);
		  	  		}
		  	  	}
	  		}
	  	  
	  	  	// Category: (3, 1-5)
	  	  	for(int i=1; i<=5; i++) {
		  		String[] productList1 = this.getProductList(3, i);
		  		for(int i1=0;i1<productList1.length; i1++) {
		  	  		productName = productList1[i1++];
		  	  		productHref = productList1[i1];
			  	  	if(productName.length() > 1) {
			  	  		//System.out.println(productName + " > " + productHref);
			  	  		data.add(new String[] { "3", Integer.toString(i), productName, productHref });
//			  	  	ss.takeScreenshot("Product_" + "3" + Integer.toString(i) + i);
			  	  	}
		  	  	}
	  	  	}
	  	
		  	// Category: (4, 1-2)
		  	for(int i=1; i<=2; i++) {
		  		String[] productList1 = this.getProductList(4, i);
		  		for(int i1=0;i1<productList1.length; i1++) {
		  	  		productName = productList1[i1++];
		  	  		productHref = productList1[i1];
			  	  	if(productName.length() > 1) {
			  	  		//System.out.println(productName + " > " + productHref);
			  	  		data.add(new String[] { "4", Integer.toString(i), productName, productHref });
//			  	  	ss.takeScreenshot("Product_" + "4" + Integer.toString(i) + i);
			  	  	}
	  	  		}	
		  	}
	  	
		  	// Category: (5, 1-4)
		  	for(int i=1; i<=4; i++) {
		  		String[] productList1 = this.getProductList(5, i);
				for(int i1=0;i1<productList1.length; i1++) {
			  	  	productName = productList1[i1++];
			  	  	productHref = productList1[i1];
			  	  	if(productName.length() > 1) {
			  	  		//System.out.println(productName + " > " + productHref);
			  	  		data.add(new String[] { "5", Integer.toString(i), productName, productHref });
//			  	  	ss.takeScreenshot("Product_" + "5" + Integer.toString(i) + i);
			  	  	}
			  	 }	
			  }
	  	
		  	// Category: (6, 1-2)
		  	for(int i=1; i<=2; i++) {
				String[] productList1 = this.getProductList(6, i);
				for(int i1=0;i1<productList1.length; i1++) {
			  		productName = productList1[i1++];
			  		productHref = productList1[i1];
			  	  	if(productName.length() > 1) {
			  	  		//System.out.println(productName + " > " + productHref);
			  	  		data.add(new String[] { "6", Integer.toString(i), productName, productHref });
//			  	  	ss.takeScreenshot("Product_" + "6" + Integer.toString(i) + i);
			  	  	}
			  	}
			}
	  	
		  	// Category: (7, 1-2)
		  	for(int i=1; i<=2; i++) {
				String[] productList1 = this.getProductList(7, i);
				for(int i1=0;i1<productList1.length; i1++) {
			  	  	productName = productList1[i1++];
			  	  	productHref = productList1[i1];
				  	if(productName.length() > 1) {
				  		//System.out.println(productName + " > " + productHref);
				  	  	data.add(new String[] { "7", Integer.toString(i), productName, productHref });
//				  	  ss.takeScreenshot("Product_" + "7" + Integer.toString(i) + i);
				  	} 
				}	
		  	}
	        
	        writer.writeAll(data);
	  
	        // closing writer connection
	        writer.close();
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	/*
	 * Method: searchProductByName
	 * Parameters: productName (String)
	 * Description: Visits the product link.
	 */
	public void searchProductByName(String productName) {
		if(!searchElement.isDisplayed())
			super.openWebsite();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(super.ImplicitWaitTime));
		driver.findElement(By.id("filter_keyword")).sendKeys(productName);
		
		driver.findElement(By.xpath("//*[@id='search_form']/div/div/i")).click();
		driver.findElement(By.xpath("//a[contains(text(), '"+productName+"')]")).click();
	}
	
	public String getProductDetails(String productName) {
		this.searchProductByName(productName);
		driver.findElement(By.xpath("//a[contains(text(),\""+productName+"\")]")).click();
		String priceOfProduct = driver.findElement(By.className("productfilneprice")).getText();
		String title = driver.findElement(By.xpath("//h1")).getText();
		Double price = Double.parseDouble(priceOfProduct.substring(1));
		String availability;
		
		if (driver.findElement(By.xpath("//*[contains(@class, 'productpagecart')]")).getText().contains("Add"))
			availability = "In Stock";
		else if(driver.findElement(By.xpath("//*[contains(@class, 'productpagecart')]")).getText().contains("Call")) 
			availability = "Make a call";
		else
			availability = "Out of Stock";
		
		return String.format("Product Name: %s\nProduct Price %f\nProduct Availability: %s", title, price, availability);
	}
	
	/*
	 * Method: getPriceOfProduct
	 * Parameters: productName (String)
	 * Return: (Double) price of product
	 * Description: Visits the product link, returns product price.
	 */
	public Double getPriceOfProduct(String productName){
		this.searchProductByName(productName);
		driver.findElement(By.xpath("//a[contains(text(),\""+productName+"\")]")).click();
		String priceOfProduct = driver.findElement(By.className("productfilneprice")).getText();
		return Double.parseDouble(priceOfProduct.substring(1));
	}
	
	public void getScreenshotOfAllProducts() {
		screenshot ss = new screenshot(driver);
		try {
			  
	        // Create an object of filereader
	        // class with CSV file as a parameter.
	        FileReader filereader = new FileReader("./data/datasets/productList.csv");
	  
	        // create csvReader object passing
	        // file reader as a parameter
	        CSVReader csvReader = new CSVReader(filereader);
	        String[] nextRecord;
	        String link;
	        int count = 0;
	        // skipping headers
	        nextRecord = csvReader.readNext();
	        // we are going to read data line by line
	        while ((nextRecord = csvReader.readNext()) != null) {
	            link = nextRecord[3];
	            System.out.println(count + link);
	            driver.get(link);
	            Thread.sleep(3000);
	            ss.takeScreenshot("product_"+nextRecord[0] + nextRecord[1] + count++);
	        }
	        csvReader.close();
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	// TODO: testSocialMediaIcons baki reh gaya maa. 
}
