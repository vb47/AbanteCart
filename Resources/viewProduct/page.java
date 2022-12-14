package viewproduct;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.CaseFormat;
import com.opencsv.CSVWriter;

public class page {
	Integer numOfItemsInCart;
	String[] itemsInCart;
	Double totalAmount;
	
	/*
	 * Page Object Models for Categories.
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
	
	
	WebDriver driver;
	String baseUrlString = "https://demo.abantecart.com/";
	
	
	// Constructor for initializing WebDriver and Page Objects
	public page(WebDriver driver) {
		// TODO Auto-generated constructor stub
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
		
		switch(categoryIndex) {
		case 0:
			// get product names at current Page
			productsOnPage = driver.findElements(By.className("prdocutname"));
			list = new String[2*productsOnPage.size()];
			
			for(WebElement product: productsOnPage) {
				list[i++] = product.getText();
				list[i++] = product.getAttribute("href");
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
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='T-shirts']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
			
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
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
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Eyes']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
			
			case 3:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Face']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			case 4:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Lips']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			case 5:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Nails']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			case 6:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Value Sets']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
			
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
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
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Face']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
			
			case 3:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Gift Ideas & Sets']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			case 4:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Hands & Nails']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			case 5:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Sun']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
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
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Women']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
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
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Fragrance Sets']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
			
			case 3:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Pre-Shave & Shaving']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage) {
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			case 4:
				actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/ul/li[4]/div/a"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
				
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
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
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Shampoo']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
			
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
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
				}
				break;
			
			case 2:
				actions.moveToElement(driver.findElement(By.xpath("//a[text()='Paperback']"))).click().perform();
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
				}
				break;
			
			default:
				productsOnPage = driver.findElements(By.className("prdocutname"));
				list = new String[2*productsOnPage.size()];
				
				for(WebElement product: productsOnPage){
					list[i++] = product.getText();
					list[i++] = product.getAttribute("href");
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
	
	public void generateProductList() {
		String filePath = "./data/productList.csv";
		File file = new File(filePath );
		
		  
	    try {
	        // create FileWriter object with file as parameter
	        FileWriter outputfile = new FileWriter(file);
	  
	        // create CSVWriter object filewriter object as parameter
	        CSVWriter writer = new CSVWriter(outputfile);
	  
	        // create a List which contains String array
	        List<String[]> data = new ArrayList<String[]>();
	        //data.add(new String[] { "Name", "Class", "Marks" });
	        //data.add(new String[] { "Aman", "10", "620" });
	        data.add(new String[] { "Category", "Sub-Category", "Product Name", "href" });
	        
	        // inserting data to csv object
	        String productName = "", productHref = "";
	        
	        // Category: (0, 0)
	        String[] productList = this.getProductList(0, 0);
	  	  	for(int i=0;i<productList.length; i++) {
	  	  		productName = productList[i++];
	  	  		productHref = productList[i];
	  	  		if(productName.length() > 1) {
	  	  		System.out.println(productName + " > " + productHref);
	  	  	data.add(new String[] { "0", "0", productName, productHref });
	  	  		}
	  	  	}
	  	  	
	  	  
	  	  	
	  	  	// Category: (1, 1-2)
	  	  System.out.println(" ------------------------------ ");
	  	  	for(int i=1; i<=2; i++) {
	  	  		String[] productList1 = this.getProductList(1, i);
	  	  	for(int i1=0;i1<productList1.length; i1++) {
	  	  		productName = productList1[i1++];
	  	  		productHref = productList1[i1];
	  	  		
	  	  	if(productName.length() > 1) {
	  	  		System.out.println(productName + " > " + productHref);
	  	  	data.add(new String[] { "1", Integer.toString(i), productName, productHref });
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
	  	  		System.out.println(productName + " > " + productHref);
	  	  	data.add(new String[] { "2", Integer.toString(i), productName, productHref });
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
		  	  		System.out.println(productName + " > " + productHref);
		  	  	data.add(new String[] { "3", Integer.toString(i), productName, productHref });
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
		  	  		System.out.println(productName + " > " + productHref);
		  	  	data.add(new String[] { "4", Integer.toString(i), productName, productHref });
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
		  	  		System.out.println(productName + " > " + productHref);
		  	  	data.add(new String[] { "5", Integer.toString(i), productName, productHref });
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
		  	  		System.out.println(productName + " > " + productHref);
		  	  	data.add(new String[] { "6", Integer.toString(i), productName, productHref });
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
		  	  		System.out.println(productName + " > " + productHref);
		  	  	data.add(new String[] { "7", Integer.toString(i), productName, productHref });
		  	  		} 
		  	  	}
	  	  		
		  }
	        // -------------------------- //
	        
	        writer.writeAll(data);
	  
	        // closing writer connection
	        writer.close();
	    }
	    catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	
}