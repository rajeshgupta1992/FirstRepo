package SeleniumL2Assignment;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MySeleniumAssignment3 {

	WebDriver driver;

	@Test
	@Parameters({ "username", "pwd", "start" })
	public void Addmax(String username, String pwd, int start) throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://addmaxpromoters.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");

		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("userid"));
		login.click();
		login.sendKeys(username);
		WebElement password = driver.findElement(By.id("password"));
		password.click();
		password.sendKeys(pwd);

		driver.findElement(By.xpath(".//input[@name='login' and @class='btn btn-1 btn-big animation']")).click();

		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[contains(text(),'Earn By Ads')]")).click();
		Thread.sleep(2000);

		// Searching Click Link
		/*WebElement linkTable = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']"));

		int rowCount = linkTable.findElements(By.tagName("tr")).size();
		System.out.println("Row Count is : " + rowCount);*/
		
		//String cellPath = "//table[@class='table table-striped table-bordered']/tbody/tr["+ start +"]/td[4]/a";
		//driver.findElement(By.xpath(cellPath)).click();

		for (int i = 1; i <= start; i++) 
		//while(start<rowCount)
		{
			String currentUrl = "http://addmaxpromoters.com/showad1?ads=VFZFOVBRPT0="; //http://addmaxpromoters.com/showad1?ads=VFZFOVBRPT0=
			//String currentUrl = driver.getCurrentUrl();
			/*Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);*/
			
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");		
			driver.get(currentUrl);
			System.out.println(" Title is : " + driver.getTitle());
			Thread.sleep(30000);
		}
		System.out.println("Task Completed !!!!!");

	}

}
