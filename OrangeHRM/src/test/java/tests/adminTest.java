package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import pageObject.adminPageObject;

public class adminTest {
	
	public WebDriver driver;
	public adminPageObject adm ;
	
	@BeforeTest
	public void validateinitialize() throws IOException
	{
		
		loginTest lt = new loginTest();
		driver=lt.validateLogin();
		adm = new adminPageObject(driver);
		
	}
	
	@Test(priority=1)
	public void validateHeader()
	{
		adm.getclickonAdmin();
		List<String> extheader = new ArrayList<>(Arrays.asList("User Role","Employee Name","Status","Actions","Username"));
		List<String> actheader = adm.getheader();
		Collections.sort(extheader);
		Collections.sort(actheader);
		System.out.println("exp : "+extheader);
		System.out.println("act : "+actheader);
		Assert.assertEquals(actheader, extheader,"Header validation failed");
		
		
	}
	
	@Test(priority=2,enabled=false)
	public void validateSearchFilterByEmpName() throws InterruptedException
	{
		String nm=adm.getempNameList().get(4);
		System.out.println("serch emp:"+nm);
		adm.getSearchEmpName(nm);
		Thread.sleep(2000);
		for(int i=0;i<adm.getOptList().size();i++)
		{
			//System.out.println("inside for:"+adm.getOptList().get(i).getText());
			if(adm.getOptList().get(i).getText().contains(nm))
			{
				adm.getOptList().get(i).click();
				System.out.println("***Employee option clicked***");
				break;
			}
			else
			{
				Assert.assertEquals(adm.getOptList().get(i).getText(), "No Records Found","Error msg validation failed");
			}
		}
		adm.getclickonSubmit();
		Thread.sleep(2000);
		List<String> actnmlist = adm.getempNameList();
		for(String acnm:actnmlist)
		{
			if(nm.contentEquals(acnm))
			{
				System.out.println("after search emp:"+acnm);
				System.out.println("search emp matched");
			}
		}
		
	}
	@Test(priority=3)
	public void validateSearchFilterByuserRole() throws InterruptedException
	{
		String userroleopt = "ESS";
		adm.getclickonUserRole();
		for(int i=0;i<adm.getuserRoleOpt().size();i++)
		{
			if(adm.getuserRoleOpt().get(i).getText().contentEquals(userroleopt))
			{
				adm.getuserRoleOpt().get(i).click();
				System.out.println("**user Role option clicked***");
			}
		}
		Thread.sleep(2000);
		adm.getclickonSubmit();
		Thread.sleep(2000);
		List<String> actrollist = adm.getuserRoleList();
		for(String rol :actrollist)
		{
			if(!rol.contentEquals(userroleopt))
			{
				System.out.println("User role not matched");
			}
			else
			{
				//System.out.println("User matched");
			}
		}
	}

}
