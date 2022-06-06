package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
		System.out.println("the first window :"+parentWindow);
		//		Click button to open home page in New Window
		driver.findElement(By.id("home")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow1.get(1));
		driver.switchTo().window(newWindow1.get(0));
		//    	Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> newWindow2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(newWindow2.get(2));
		driver.switchTo().window(newWindow2.get(3));
		System.out.println("no of windows:"+newWindow2.size());

		//Close all except this window

		driver.switchTo().window(newWindow1.get(1));
		driver.close();
		driver.switchTo().window(newWindow1.get(0));
		driver.close();
		driver.switchTo().window(newWindow2.get(2));
		System.out.println("3rd unclosed window  :"+driver.getTitle()); 
		driver.switchTo().window(newWindow2.get(3));
		System.out.println("4th  unclosed window  :"+driver.getTitle()); 

		//Wait for 2 new Windows to open
		Thread.sleep(5000);
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Set<String> windowHandles4= driver.getWindowHandles();
		List<String> newWindow4= new ArrayList<String>(windowHandles4);
		driver.switchTo().window(newWindow4.get(1));
		driver.switchTo().window(newWindow4.get(2));
		System.out.println("no of windows:"+newWindow4.size());



	}
}
