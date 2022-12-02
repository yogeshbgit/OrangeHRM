package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageObject {

WebDriver driver;
String nametext;
String passtext;
public loginPageObject(WebDriver driver)
{
	this.driver=driver;
}

By name = By.xpath("//p[@class='oxd-text oxd-text--p'][1]");
By pass = By.xpath("//p[@class='oxd-text oxd-text--p'][2]");
By username =  By.xpath("//input[@placeholder='Username']");
By password = By.xpath("//input[@placeholder='Password']");
By loginbutton = By.xpath("//button[@type='submit']");
By logintitle=By.xpath("//h5[text()='Login']");
By alllinks=By.tagName("a");
By forgotpass = By.cssSelector(".orangehrm-login-forgot-header");
By resetPasstext = By.cssSelector(".orangehrm-forgot-password-title");
By resetPassmess = By.xpath("//p[@class='oxd-text oxd-text--p']");
By resetsuccesstext = By.cssSelector(".orangehrm-forgot-password-title");



public void getusername()
{
	String nm=driver.findElement(name).getText();
	nametext=nm.split(": ")[1];
	driver.findElement(username).sendKeys(nametext);
}

public void getpassword()
{
	String pas = driver.findElement(pass).getText();
	passtext= pas.split(": ")[1];
	driver.findElement(password).sendKeys(passtext);
}

public void getloginbutton()
{
	driver.findElement(loginbutton).click();
}

public String getlogintitle()
{
	return driver.findElement(logintitle).getText();
	
}

public List<WebElement> getallinks()
{
	return driver.findElements(alllinks);
}

public String getforgotpasstext()
{
	return driver.findElement(forgotpass).getText();
}

public void getforgetpasslink()
{
	driver.findElement(forgotpass).click();
}

public String getresetpasstext()
{
	return driver.findElement(resetPasstext).getText();
}

public String getresetpassmess()
{
	return driver.findElement(resetPassmess).getText();
}


public String getresetsuccesstext()
{
	return driver.findElement(resetsuccesstext).getText();
}


}
