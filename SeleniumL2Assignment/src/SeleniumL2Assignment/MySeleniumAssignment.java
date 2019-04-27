package SeleniumL2Assignment;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class MySeleniumAssignment {

	WebDriver driver;
	public void Addmax() throws Exception {
		WebDriver driver = new ChromeDriver();
		//HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		
		driver.get("http://addmaxpromoters.com/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");

		Thread.sleep(2000);
		String username = "ADDMAX58680143";  //""   250341      462781
		WebElement login = driver.findElement(By.id("userid"));
		login.click();
		login.clear();
		login.sendKeys(username);
		WebElement password = driver.findElement(By.id("password"));
		password.click();
		password.sendKeys("078200"); //""

		driver.findElement(By.xpath(".//input[@name='login' and @class='btn btn-1 btn-big animation']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Earn By Ads')]")).click();
		Thread.sleep(2000);

		// Searching Click Here Link
		WebElement linkTable = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']"));

		int rowCount = linkTable.findElements(By.tagName("tr")).size();
		System.out.println("Row Count is : " + rowCount);

		for (int i = 1 ; i <= rowCount; i++) {
			
			System.out.println("Table Row No : " + i);
			
			String cellPath = "//table[@class='table table-striped table-bordered']/tbody/tr[1]/td[4]/a";
			driver.findElement(By.xpath(cellPath)).click();
			
			// Clicking on Adds
			System.out.println("Now came into Click here link");
			System.out.println(" Title is : " + driver.getTitle());
			Set<String> allWindows = driver.getWindowHandles();
			// System.out.println("We are in new tab1");
			ArrayList<String> tabs = new ArrayList<>(allWindows);
			driver.switchTo().window(tabs.get(2));
			System.out.println(" Title is : " + driver.getTitle());
			Thread.sleep(50000);
			driver.switchTo().window(tabs.get(0));
			System.out.println("Came to original Tab");
			driver.navigate().refresh();
			System.out.println("Main tab is being refreshed");
			Thread.sleep(2000);
		}
		System.out.println("Task Completed !!!!!");

	}

	public static void main(String[] args) throws Exception {
		MySeleniumAssignment m = new MySeleniumAssignment();
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");

		m.Addmax();
	}

}
