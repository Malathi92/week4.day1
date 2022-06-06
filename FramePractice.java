package week4.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePractice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
//		inside frame1
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frameEle);
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("not a friendly topic");
//		inside fram2
		WebElement frame2=driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//input[@id='a']")).click();
//		out of 2 frames
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
//		inside 3 frame
		WebElement frame3=driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame3);
		WebElement e=driver.findElement(By.id("animals"));
		Select dd=new Select(e);
		dd.selectByIndex(3);
		

	}

}
