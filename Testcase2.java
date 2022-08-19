package marathon3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase2 extends projectcommethod {
	/*01) Launch https://login.salesforce.com/ 
02) Login to Salesforce with your username and password
03) Click on the App Launcher (dots)
04) Click View All
05) Type Individuals on the Search box
06) Click Individuals Link
07) Click New
08) Select Salutation with data (coming from excel) 
09) Type Last Name 
10) Click Save
11) Click on the App Launcher (dots)
12) Click View All
13) Type Customers on the Search box
14) Click Customers Link
15) Click New
16) Type the same name provided in step 8 and confirm it appears
17) Close the browser*/
	@BeforeMethod
	public void setup()
	{
		excelFileName="Salutations";
	}
	
	@Test(dataProvider = "fetch")
	public void runTestcase2(String Salutations) throws InterruptedException {
		// TODO Auto-generated method stub
		/**/
		
Set<String> totalwindowHandles = driver.getWindowHandles();
/*System.out.println("total wh"+totalwindowHandles.size());
 List<String> abc =new ArrayList<String>(totalwindowHandles);
String firwh = abc.get(0);
driver.switchTo().window(firwh);
*/
driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Individuals");
driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//div[@title='New']")).click();
System.out.println("total wh"+totalwindowHandles.size());
List<String> abc =new ArrayList<String>(totalwindowHandles);
String firwh = abc.get(0);
driver.switchTo().window(firwh);
Thread.sleep(2000);
//driver.findElement(By.xpath("(//a[@aria-disabled='false'])[3]")).sendKeys("Mrs.");
//08) Select Salutation with data (coming from excel) 
driver.findElement(By.xpath("//a[@class='select']")).click();
//String salutation = "Ms.";
driver.findElement(By.xpath("//a[text()='"+Salutations+"']")).click();
WebElement element = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
element.sendKeys("bhai");
String text = element.getText();
System.out.println(text);
driver.findElement(By.xpath("(//span[@dir='ltr'])[5]")).click();
driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
driver.findElement(By.xpath("//button[text()='View All']")).click();
driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Customers");
driver.findElement(By.xpath("//mark[text()='Customers']")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//div[@title='New']")).click();
Set<String> totalwindowHandles1 = driver.getWindowHandles();
System.out.println("total wh"+totalwindowHandles1.size());
 List<String> abc1 =new ArrayList<String>(totalwindowHandles1);
String firwh1 = abc1.get(0);
driver.switchTo().window(firwh1);
driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys(text);
String text2 = driver.findElement(By.xpath("(//div[@title='bhai'])[2]")).getText();
System.out.println(text2);


	}

}
