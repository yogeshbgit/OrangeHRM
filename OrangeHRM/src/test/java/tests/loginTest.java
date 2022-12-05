package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Resource.BaseRepository;
import pageObject.homePageObject;
import pageObject.loginPageObject;

public class loginTest extends BaseRepository {

	public WebDriver driver;
	
	@BeforeTest
	public WebDriver validateLogin() throws IOException
	{
		driver = initialize();
		loginPageObject lp = new loginPageObject(driver);
		 lp.getname();
			lp.getusername();
			lp.getpassword();
			lp.getloginbutton();
		return driver;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
