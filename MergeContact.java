package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.graphbuilder.struc.LinkedList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		WebElement eleUserName=driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		System.out.println(driver.getTitle());
		//1st icon * 7. Click on Widget of From Contact
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow=new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
		Thread.sleep(2000);
		//		 8. Click on First Resulting Contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(newWindow.get(0));
		//		//1st icon * 9. Click on Widget of To Contact
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> newWindow1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(newWindow1.get(1));
		//    * 10. Click on Second Resulting Contact
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[2]")).click();
		driver.switchTo().window(newWindow1.get(0));
		//		 * 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		//		 * 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		System.out.println(title);

	}
}