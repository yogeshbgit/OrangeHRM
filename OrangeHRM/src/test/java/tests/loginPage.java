package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resource.BaseRepository;
import pageObject.loginPageObject;

public class loginPage extends BaseRepository {
	
	public WebDriver driver;
	public loginPageObject lp;
	public String parendwindow;
	@BeforeTest
	public void initializer() throws IOException
	{
		
		driver=initialize();
		parendwindow=driver.getWindowHandle();
		lp = new loginPageObject(driver);
	}
	@Test(priority=1)
	public void validateLoginTittle()
	{
		
		Assert.assertEquals(lp.getlogintitle(), "Login","Login Title validation failed");
	}
	
	
	@Test(priority=2)
	public void validateAllLinksTittle()
	{
		List<WebElement> alllinks = lp.getallinks();
		
		for(WebElement link:alllinks)
		{
			String ctr = Keys.chord(Keys.CONTROL,Keys.ENTER);
			link.sendKeys(ctr);
		}
		List<String> explinkstext = new ArrayList<>();
		explinkstext.add("OrangeHRM");
		explinkstext.add("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM");
		explinkstext.add("OrangeHRM (@orangehrm) / Twitter");
		explinkstext.add("OrangeHRM - World's Most Popular Opensource HRIS | Secaucus NJ | Facebook");
		explinkstext.add("Sign In | LinkedIn");
		explinkstext.add("OrangeHRM Inc - YouTube");
		
		List<String> actlinkstext = new ArrayList<>();
		
	Set<String> windowhandles = driver.getWindowHandles();
	Iterator<String> it = windowhandles.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			actlinkstext.add(driver.getTitle());
			System.out.println("titles : "+driver.getTitle());
			
		}
		
		driver.switchTo().window(parendwindow);
		Collections.sort(explinkstext);
		Collections.sort(actlinkstext);
		System.out.println("Actual link list : "+actlinkstext);
		System.out.println("Expected link list : "+explinkstext);
		//Assert.assertEquals(actlinkstext, explinkstext,"Links text validation failed");
	}
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

	


}
