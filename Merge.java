package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Merge {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Create userName
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		//Create password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//login
		driver.findElement(By.className("decorativeSubmit")).click();
		//Get the name of header and print the valuue
		String text =driver.findElement(By.tagName("h2")).getText();
		System.out.println(text);
		//click the link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.linkText("Merge Contacts")).click();
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windowsOne=new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowsOne.get(1));
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		driver.switchTo().window(windowsOne.get(0));
		//driver.close();
		//Click on Widget of To Contact
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		Set<String> windowHandlesTwo = driver.getWindowHandles();
		List<String>windowsTwo=new ArrayList<String>(windowHandlesTwo);
		driver.switchTo().window(windowsTwo.get(1));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		driver.switchTo().window(windowsTwo.get(0));
		//driver.close();
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());
		
		}


	}


