package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseRepository {
	
	
	WebDriver driver;
	Properties prop;
	public WebDriver initialize() throws IOException
	{
		
		
		
		prop = new Properties();
		//FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\OrangeHRM\\src\\main\\java\\Resource\\data.properties");
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resource\\data.properties");		
		prop.load(file);
		String brower = prop.getProperty("browser");
		if(brower.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}
		return driver;
	}
	public String getScreenshotPath(String methodname,WebDriver driver) throws IOException
	{
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     String  destinationfile = System.getProperty("user.dir")+"\\ExtentReports\\"+methodname+".png";
	     FileUtils.copyFile(scrFile, new File(destinationfile));
	     
		 return destinationfile;
	}

}
