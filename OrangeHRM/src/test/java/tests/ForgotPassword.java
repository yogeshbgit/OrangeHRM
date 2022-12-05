package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Resource.BaseRepository;
import pageObject.loginPageObject;

public class ForgotPassword extends BaseRepository{
	
	public WebDriver driver;
	public loginPageObject lp;
	
	@BeforeTest
	public void initializer() throws IOException
	{
		driver=initialize();
		lp = new loginPageObject(driver);
	}
	
	@Test(priority=1)
	public void validateForgotPasswordText()
	{
		String text = lp.getforgotpasstext();
		Assert.assertEquals(text, "Forgot your password?","forgot password validation failed...");
		System.out.println("forget password text:"+text);
	
	}
	
	@Test(priority=2)
	public void validateForgotPasswordLink() 
	{
		lp.getname();
		lp.getforgetpasslink();
		Assert.assertEquals(lp.getresetpasstext(), "Reset Password","Reset password validation failed...");
		String resetmess = "Please enter your username to identify your account to reset your password";
		Assert.assertEquals(lp.getresetpassmess(), resetmess,"Reset Message validation failed...");
		lp.getusername();
		lp.getloginbutton();
		Assert.assertEquals(lp.getresetsuccesstext(), "Reset Password link sent successfully","Reset Successful validation failed");
		Assert.assertEquals(lp.getresetemailmsg(), "A reset password link has been sent to you via email.","Reset Email Messsege validation failed");
		Assert.assertEquals(lp.getresetNewPassMsg(), "You can follow that link and select a new password.","Reset New Password Messege validation failed");
		Assert.assertEquals(lp.getresetNote(), "Note:","Reset Note validation failed");
		Assert.assertEquals(lp.getresetNoteMsg(), "If the email does not arrive, please contact your OrangeHRM Administrator.","Reset Note Messege validation failed");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	
}
