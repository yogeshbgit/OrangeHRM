package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePageObject {
	
	public WebDriver driver;
	
	public homePageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	By menuList = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");
	
	
	public List<WebElement> getMenuList()
	{
		return driver.findElements(menuList);
	}
}
