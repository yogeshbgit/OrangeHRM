package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resource.BaseRepository;
import pageObject.loginPageObject;

public class loginPage extends BaseRepository {
	
	WebDriver driver;
	loginPageObject lp;
	String parendwindow;
	@BeforeTest
	public void initializer() throws IOException
	{
		driver=initialize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		parendwindow=driver.getWindowHandle();
		lp = new loginPageObject(driver);
	}
	@Test(priority=1)
	public void validateLoginTittle()
	{
		
		Assert.assertEquals(lp.getlogintitle(), "Login","Login Title validation failed...");
	}
	
	
	@Test(priority=2)
	public void validatefogotpassword()
	{
		String text = lp.getforgotpasstext();
		Assert.assertEquals(text, "Forgot your password?","forgot password validation failed...");
		System.out.println("forget password text:"+text);
	/*	lp.getforgetpasslink();
		Assert.assertEquals(lp.getresetpasstext(), "Reset Password","Reset password validation failed...");
		String resetmess = "Please enter your username to identify your account to reset your password";
		Assert.assertEquals(lp.getresetpassmess(), resetmess,"Reset Message validation failed...");
		lp.getusername();
		lp.getloginbutton();
		Assert.assertEquals(lp.getresetsuccesstext(), "Reset Password link sent successfully","Reset Successful validation failed");*/
	}
	
	@Test(priority=3)
	public void validateAllLinksTittle()
	{
		List<WebElement> alllinks = lp.getallinks();
		for(WebElement link:alllinks)
		{
			String ctr = Keys.chord(Keys.CONTROL,Keys.ENTER);
			link.sendKeys(ctr);
		}
	Set<String> windowhandles = driver.getWindowHandles();
	Iterator<String> it = windowhandles.iterator();
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println("titles : "+driver.getTitle());
		}
		
		driver.switchTo().window(parendwindow);
	}
	
	@Test(priority=4)
	public void validateLogin()
	{
		lp.getusername();
		lp.getpassword();
		lp.getloginbutton();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

	


}
