package SeleniumL2Assignment;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MySeleniumAssignment2 {

	WebDriver driver;

	@Test
	@Parameters({ "username", "pwd", "start" })
	public void Addmax(String username, String pwd, int start) throws Exception {
		
		/*for(int i=0;i<10;i++)
		{
			Thread.sleep(60000);
			System.out.println("Waiting for counter : " + i + " minutes, for User : " + username);
		}*/
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
		driver.findElement(By.xpath("//*[contains(text(),'Earn By Ads')]")).click();
		Thread.sleep(2000);

		// Searching Click Link
		WebElement linkTable = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']"));

		int rowCount = linkTable.findElements(By.tagName("tr")).size();
		System.out.println("Row Count is : " + rowCount);

		int remainAdds = remainingAdds(driver, username);
		//for (int i = start; i <= rowCount; i++) 
		while(remainAdds>0)
		{
			linkTable = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered']"));

			rowCount = linkTable.findElements(By.tagName("tr")).size();
			//System.out.println("Row Count is : " + rowCount);

			//System.out.println("Table Row No : " + i);

			String cellPath = "//table[@class='table table-striped table-bordered']/tbody/tr["+ start +"]/td[4]/a";
			driver.findElement(By.xpath(cellPath)).click();

			// Clicking on Adds
			System.out.println("Now came into Click here link");
			System.out.println(" Title is : " + driver.getTitle());
			//Set<String> allWindows = driver.getWindowHandles();
			// System.out.println("We are in new tab1");
			//ArrayList<String> tabs = new ArrayList<>(allWindows);
			//driver.switchTo().window(tabs.get(2));
			//System.out.println(" Title is : " + driver.getTitle());
			Thread.sleep(25000);
			//driver.switchTo().window(tabs.get(0));
			System.out.println("Came to original Tab");
			//driver.navigate().refresh();
			//System.out.println("Main tab is being refreshed");
			//driver.findElement(By.xpath("//*[contains(text(),'Earn By Ads')]")).click();
			Thread.sleep(2000);
			remainAdds = remainingAdds(driver,username);
		}
		System.out.println("Task Completed !!!!!");

	}
	
	
	public int remainingAdds(WebDriver driver,String username)
	{
		String remain = driver.findElement(By.xpath("//div[@class='col-md-9 col-sm-12']/div[@style='color: #d41515;font-size: 18px;']")).getText().trim();
		System.out.println("Remaining add text : " + remain + " for user : " + username);
		remain = remain.substring(0, remain.indexOf(' '));
		System.out.println("Remaining add text only No.s : " + remain);
		Integer remainInt = Integer.parseInt(remain);
		return remainInt;
	}

}
