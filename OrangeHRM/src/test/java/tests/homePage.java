package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import Resource.BaseRepository;
import pageObject.homePageObject;

public class homePage extends BaseRepository {
	public WebDriver driver;
	public homePageObject hp ;
	
	@BeforeTest
	public void validateinitialize() throws IOException
	{
		
		loginTest lt = new loginTest();
		driver=lt.validateLogin();
		hp = new homePageObject(driver);
		 
		
	}
	
	@Test(priority=1)
	public void validateMenuList()
	{
		List<String> expmenuListText = new ArrayList<>(Arrays.asList("Admin","PIM","Leave","Time","Recruitment","My Info","Performance","Dashboard","Directory","Maintenance","Buzz"));
		List<String> actmenuListText = new ArrayList<>();
		List<WebElement> menuList = hp.getMenuList();
		for(WebElement list :menuList)
		{
			System.out.println("menu list : "+list.getText());
			actmenuListText.add(list.getText());
			
		}
		Collections.sort(expmenuListText);
		Collections.sort(actmenuListText);
		Assert.assertEquals(actmenuListText, expmenuListText,"Menu List validation failed");
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

	

}
