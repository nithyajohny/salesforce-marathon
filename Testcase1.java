package marathon3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase1 extends projectcommethod{
	
	@BeforeMethod
	public void setup()
	{
		excelFileName="Questions";
	}
	

	@Test(dataProvider = "fetch")
	public void runTestacase1(String Questions,String Details) throws InterruptedException, IOException
	{
		// TODO Auto-generated method stub
/*Test case : 001 (Chrome)

01) Launch https://login.salesforce.com/ 
02) Login to Salesforce with your username and password
03) Click on the App Launcher (dots)
04) Click View All
05) Type Content on the Search box
06) Click Content Link
07) Click on Chatter Tab
08) Verify Chatter title on the page
09) Click Question tab
10) Type Question with data (coming from excel)
11) Type Details with data (coming from excel)
12) Click Ask
13) Confirm the question appears
14) Close the browser
*/
		
Set<String> totalwindowHandles = driver.getWindowHandles();
System.out.println("total wh"+totalwindowHandles.size());
 List<String> abc =new ArrayList<String>(totalwindowHandles);
String firwh = abc.get(0);
driver.switchTo().window(firwh);
driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Content");
driver.findElement(By.xpath("//mark[text()='Content']")).click();
Set<String> totalwindowHandles1 = driver.getWindowHandles();
List<String> abc1 =new ArrayList<String>(totalwindowHandles1);
String firwh1 = abc.get(0);
WebElement element = driver.findElement(By.xpath("//span[text()='Chatter']"));
driver.executeScript("arguments[0].click();", element);
Thread.sleep(5000);
System.out.println(driver.getTitle());
driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys(Questions);
driver.findElement(By.xpath("(//div[@contenteditable='true'])[1]")).sendKeys(Details);
driver.findElement(By.xpath("//button[contains(@title,'Click')]")).click();
////span[@class='uiOutputText']
String text = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
String text1 = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[4]")).getText();
System.out.println("questions:"+text+""+text1);
File ques = driver.getScreenshotAs(OutputType.FILE);
File dest=new File("ques.png");
FileUtils.copyFile(ques, dest);
//driver.quit();

}
}