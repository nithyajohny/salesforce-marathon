package marathon3;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class projectcommethod {
	 
		// TODO Auto-generated method stub
		RemoteWebDriver driver;
	    String excelFileName="";

		WebDriverWait wait;
		@Parameters({"browsername","url","username","password"})
		@BeforeMethod
		public  void setup(String browsername, String url,String username,String password)
		{
			// TODO Auto-generated method stub
			if(browsername.contains("chrome"))
			{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			 options.addArguments("--disable-notifications");
			 driver= new ChromeDriver(options);
			}
			else if(browsername.contains("edge"))
			{
				WebDriverManager.edgedriver().setup();
				EdgeOptions options = new EdgeOptions();
		        options.addArguments("--disable-notifications");
		        driver= new EdgeDriver(options);

			}
			driver.get(url); 
			driver.manage().window().maximize();
			wait=new WebDriverWait(driver,Duration.ofSeconds(30));
			//Enter UserName and Password Using Id Locator
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("Login")).click();
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();


		}
	@AfterMethod
		public void teardown()
		{
			driver.quit();
		}
	@DataProvider(name="fetch")
	public String[][] fetchData() throws IOException
	{
		String[][] data=ReadExcelData2.readData(excelFileName);
		return data;

	}

}
