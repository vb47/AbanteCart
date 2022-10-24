package testModules;

import org.testng.annotations.Test;

import modules.mainPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class mainPageTest {
  @Test
  public void f() throws InterruptedException {
	  mainPage page = new mainPage();
	  page.openWebsite();
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
