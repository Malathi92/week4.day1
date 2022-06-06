package week4.day1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		//		2.search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		//		3.Get the price of the first product
		WebElement e=driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println("the price of first product: "+e.getText());
		//		4. Print the number of customer ratings for the first displayed product
		Thread.sleep(2000);
		WebElement f=driver.findElement(By.xpath("(//span[@class='a-size-base s-light-weight-text'])[1]"));
		System.out.println("the no of customer ratings for the first product:"+f.getText());
		//		5. Click the first text link of the first image
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Samsung Galaxy S21 FE 5G (Graphite, 8GB, 128GB Storage)']")).click();
		Set<String> windowHandles= driver.getWindowHandles();
		List<String> newWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
//6. Take a screen shot of the product displayed
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshots/img.png");
		FileUtils.copyFile(source, destination);
//		7. Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
//		8. Get the cart subtotal and verify if it is correct.
		Thread.sleep(2000);
		WebElement cartSubTotal=driver.findElement(By.id("attach-accessory-cart-subtotal"));
		System.out.println("the cart sub total is :"+cartSubTotal.getText());
		Thread.sleep(2000);
//		9.close the browser
		driver.quit();
		
}

}
