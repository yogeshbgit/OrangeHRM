package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class adminPageObject {
	public WebDriver driver;
	public List<String>OptList = new ArrayList<>(); 
	List<String> UserRoleOption = new ArrayList<>();
	
	public adminPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	By clickonAdmin = By.xpath("//span[.='Admin']");
	By tableHeader= By.xpath("(//div[@class='oxd-table-row oxd-table-row--with-border'])[1]/div/following-sibling::div[1]");
	By userNameList =By.xpath("//div[@role='rowgroup'][2]/div/div/div[2]");
	By userRolelist = By.xpath("//div[@role='rowgroup'][2]/div/div/div[3]");
	By empNamelist = By.xpath("//div[@role='rowgroup'][2]/div/div/div[4]");
	By statuslist = By.xpath("//div[@role='rowgroup'][2]/div/div/div[5]");
	By searchEmpname= By.xpath("//input[@placeholder='Type for hints...']");
	By optionList = By.xpath("//div[@role='option']");
	By clickonsubmit = By.cssSelector("button[type='submit']");
	By clickonuserRole=By.xpath("(//div[.='-- Select --'])[1]");
	By userRoleopt=By.xpath("//div[@role='listbox']/div/span");
	
	public void getclickonAdmin()
	{
		driver.findElement(clickonAdmin).click();
	}
	
	public List<String> getheader()
	{
		List<String>listtext = new ArrayList<>(); 
		List<WebElement> lists = driver.findElements(tableHeader);
		for(WebElement list :lists)
		{
			listtext.add(list.getText());
		}
		return listtext;
	}
	
	public List<String> getuserNameList()
	{
		List<String>usernamelist = new ArrayList<>(); 
		List<WebElement> lists = driver.findElements(userNameList);
		for(WebElement list :lists)
		{
			usernamelist.add(list.getText());
		}
		return usernamelist;
	}
	
	public List<String> getuserRoleList()
	{
		List<String>userRoleList = new ArrayList<>(); 
		List<WebElement> lists = driver.findElements(userRolelist);
		for(WebElement list :lists)
		{
			userRoleList.add(list.getText());
		}
		return userRoleList;
	}
	
	public List<String> getempNameList()
	{
		List<String>empNameList = new ArrayList<>(); 
		List<WebElement> lists = driver.findElements(empNamelist);
		for(WebElement list :lists)
		{
			empNameList.add(list.getText());
		}
		return empNameList;
	}
	public List<String> getStatusList()
	{
		List<String>StatusList = new ArrayList<>(); 
		List<WebElement> lists = driver.findElements(statuslist);
		for(WebElement list :lists)
		{
			StatusList.add(list.getText());
		}
		return StatusList;
	}
	
	public void getSearchEmpName(String name)
	{
		driver.findElement(searchEmpname).sendKeys(name);
	}
	
	public List<WebElement> getOptList()
	{
		
		List<WebElement> lists = driver.findElements(optionList);
		for(WebElement list :lists)
		{
			OptList.add(list.getText());
		}
		return lists;
	}
	
	public void getclickonSubmit()
	{
		driver.findElement(clickonsubmit).click();
	}
	public void getclickonUserRole()
	{
		driver.findElement(clickonuserRole).click();
	}
	public List<WebElement> getuserRoleOpt()
	{
		
		List<WebElement> lists = driver.findElements(userRoleopt);
		for(WebElement list:lists)
		{
			UserRoleOption.add(list.getText());
		}
		return lists;
	}
}
