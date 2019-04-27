package SeleniumL2Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class MySeleniumAssignment_OLD {

	WebDriver driver;

	public void spicejet() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://book.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("SpiceJet URL Opened sucessfully");

		String sDate1 = "12/12/2018";
		String uMonth = sDate1.substring(3, 5);
		System.out.println("Travel Month is : " + uMonth);
		switch (uMonth) {
		case "01":
			uMonth = "January";
			break;

		case "02":
			uMonth = "February";
			break;

		case "03":
			uMonth = "March";
			break;

		case "04":
			uMonth = "April";
			break;

		case "05":
			uMonth = "May";
			break;

		case "06":
			uMonth = "June";
			break;

		case "07":
			uMonth = "July";
			break;

		case "08":
			uMonth = "August";
			break;

		case "09":
			uMonth = "September";
			break;

		case "10":
			uMonth = "October";
			break;

		case "11":
			uMonth = "November";
			break;

		case "12":
			uMonth = "December";
			break;

		default:
			System.out.println("Invalid Month");
		}
		// Clicking on Date picker
		driver.findElement(By.xpath("//*[@id='marketDate_1']/button")).click();

		// Taking date month from the website date picker
		while (!uMonth.equalsIgnoreCase(
				driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")).getText())) {
			// Click on Next
			driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
		}

		// Taking date of month
		String uDate = sDate1.substring(0, 2);
		System.out.println("User Date is :" + uDate);

		// clicking on desired date
		// creating modified xpath for date
		String datePath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a[text()='" + uDate + "']";
		// System.out.println("Date xpath is :" + datePath);
		driver.findElement(By.xpath(datePath)).click();
		// Creating wait to see the result
		Thread.sleep(5000);
		driver.quit();
	}

	public void yatra() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Directing to URL of Login Page
		driver.get("//https://www.yatra.com/social/common/yatra/signin.htm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Yatra URL Opened sucessfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='login-input']")).sendKeys("XXXXXXX");
		driver.findElement(By.xpath("//*[@id='login-continue-btn']")).click();
		driver.findElement(By.xpath("//*[@id='login-password']")).sendKeys("XXXXXXX");
		driver.findElement(By.xpath("//*[@id='login-submit-btn']")).click();
		// Selecting Buses Category
		driver.findElement(By.xpath("//*[@id='booking_engine_buses']")).click();
		driver.findElement(By.xpath("//*[@id='BE_bus_to_station']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//*[@id='BE_bus_from_station']")).sendKeys("Bangalore");
		driver.quit();
	}

	public void color() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");
		WebElement element = driver.findElement(By.xpath(
				"html/body/div[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]/td[2]"));

		String color = element.getCssValue("color");
		System.out.println(color);
		String hex = Color.fromString(color).asHex();
		System.out.println(hex);

		// Doing mouse hover with with the help of Actions
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		String color2 = element.getCssValue("color");
		System.out.println(color2);
		String hex2 = Color.fromString(color2).asHex();
		System.out.println(hex2);

		driver.quit();
	}

	public void Hdfc() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("HDFC Opened sucessfully");

		WebElement CustomerCare = driver.findElement(By.xpath("//div[1]/div[1]/div[2]/div[3]/ul/li[8]/div[1]/a"));
		CustomerCare.click();
		WebElement CallUs = driver.findElement(By.xpath("//a[contains(text(),'Call us')]"));
		CallUs.click();
		WebElement NRI = driver.findElement(By.xpath("html/body/div[1]/div/div/ul/li[2]/a"));
		NRI.click();
		WebElement UK = driver.findElement(By.xpath("//td[contains(text(),'UK')]"));
		UK.click();
	}

	public void Excelsheet() {

	}

	public void TableFields() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");

		for (WebElement tdata : driver.findElements(By.xpath(
				"//table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[1]/tbody/tr[3]/td/table/tbody/tr/td"))) {
			System.out.println(tdata.getText());
		}
		driver.quit();

	}

	public void Rediff() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://in.rediff.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");

		WebElement searchbox = driver.findElement(By.xpath("//*[@id='srchword']"));
		Actions builder = new Actions(driver);
		Actions seriesOfActions = builder.moveToElement(searchbox).click().sendKeys(searchbox, "h");
		seriesOfActions.perform();
		List<WebElement> products = driver.findElements(By.xpath("//*[@class='suggbox']"));
		int iSize2 = products.size();

		for (int i = 0; i < iSize2; i++) {
			System.out.println(products.get(i).getText());

		}
		driver.quit();
	}

	public void GoogleLink() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Google Home Page Opened sucessfully");

		List<WebElement> all_links_webpage = driver.findElements(By.tagName("a"));
		System.out.println("Total no of links Available: " + all_links_webpage.size());
		int a = all_links_webpage.size();
		System.out.println("List of links Available: ");
		for (int i = 0; i < a; i++) {
			String link = all_links_webpage.get(i).getAttribute("href");
			System.out.println(link);

		}
		driver.quit();
	}

	public void HDFCCard() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("HDFC Opened sucessfully");

		WebElement product = driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(product).build().perform();
		WebElement cards = driver.findElement(
				By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[1]/ul/li[3]/a"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(cards).build().perform();
		driver.findElement(
				By.xpath("html/body/div[1]/div[1]/div[2]/div[3]/ul/li[2]/div[2]/div[2]/div[2]/div[3]/div/ul/li[1]/a"))
				.click();
		driver.quit();
	}

	public void Radiobutton() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");
		List<WebElement> oRadioButton = driver.findElements(By.name("radio1"));

		int iSize = oRadioButton.size();
		System.out.println("Radio button selected for Settings:");
		for (int i = 0; i < iSize; i++) {
			boolean sValue = oRadioButton.get(i).isSelected();

			if (sValue && i == 2) {
				System.out.println("Radio button selected is on position : " + iSize);
			}
		}
		List<WebElement> oRadioButton1 = driver.findElements(By.name("group1"));
		int iSize1 = oRadioButton1.size();
		for (int i = 0; i < iSize1; i++) {

			boolean sValue = oRadioButton1.get(i).isSelected();
			if (sValue) {
				String val1 = oRadioButton1.get(i).getAttribute("value");
				System.out.println("Resulting output of Milk, Butter, Cheese");
				System.out.println(val1 + " button is selected");
			}
		}
		List<WebElement> oRadioButton2 = driver.findElements(By.name("group2"));
		int iSize2 = oRadioButton2.size();
		for (int i = 0; i < iSize2; i++) {
			boolean sValue = oRadioButton2.get(i).isSelected();
			if (sValue) {
				String val2 = oRadioButton2.get(i).getAttribute("value");
				System.out.println("Resulting output of Water, Beer, Wine");
				System.out.println(val2 + " button is selected");
			}
		}
		driver.quit();
	}

	public void Addmax() throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("http://addmaxpromoters.com/circle8/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");

		Thread.sleep(2000);
		String username = "034215";  //""     462781	456129	034215
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		login.clear();
		login.sendKeys(username);
		WebElement password = driver.findElement(By.id("password"));
		password.click();
		password.sendKeys("078200"); //""		078200	642531

		driver.findElement(By.xpath(".//*[@id='formContent']/form/input[4]")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Click Advertise')]")).click();
		Thread.sleep(2000);

		// Searching Click Here Link
		WebElement linkTable = driver.findElement(By.xpath("//table[@class='table table-striped table-bordered table-hover']"));

		int rowCount = linkTable.findElements(By.tagName("tr")).size();
		System.out.println("Row Count is : " + rowCount);

		for (int i = 50; i < rowCount; i++) {
			
			System.out.println("Table Row No : " + i);
			
			String cellPath = "//table[@class='table table-striped table-bordered table-hover']/tbody/tr[" + i+ "]/td[3]";
			
			if (driver.findElement(By.xpath(cellPath)).getText().equalsIgnoreCase("Click Here")) {

				String linkPath = cellPath + "/a";
				driver.findElement(By.xpath(linkPath)).click();
				clickAdd(driver);
			} 
			
			else {
				System.out.println("ELSE Value is : " + driver.findElement(By.xpath(cellPath)).getText());
			}
		}
		System.out.println("Task Completed !!!!!");

	}

	public void clickAdd(WebDriver driver) throws Exception {
		System.out.println("Now came into Click here link");
		Thread.sleep(2000);
		System.out.println(" Title is : " + driver.getTitle());
		Set<String> allWindows = driver.getWindowHandles();
		// System.out.println("We are in new tab1");
		ArrayList<String> tabs = new ArrayList<>(allWindows);
		driver.switchTo().window(tabs.get(2));
		System.out.println("New Title is : " + driver.getTitle());
		
		for(int i=0 ; i<2 ; i++ )
		{
			if(driver.findElements(By.xpath(".//*[@id='prnato_reload_page']")).size()>0)
			{
				i=0;
				System.out.println("Switched to different tab");
				driver.findElement(By.xpath(".//*[@id='prnato_reload_page']")).click();
			}
			Thread.sleep(1000);
			System.out.println((i+1) + "Waiting.....");
		}
		//Thread.sleep(24000);
		System.out.println("Waited for enough seconds");
		// Getting input values
		String num1 = driver.findElement(By.xpath(".//*[@id='cap_number_1']")).getAttribute("value");
		System.out.println("Number 1 : " + num1);
		String num2 = driver.findElement(By.xpath(".//*[@id='cap_number_2']")).getAttribute("value");
		System.out.println("Number 2 : " + num2);
		Integer result = Integer.parseInt(num1) + Integer.parseInt(num2);
		System.out.println("Result : " + result);
		//@SuppressWarnings("deprecation")
		//String resultAsString = new Integer(result).toString();
		String resultAsString = result.toString();
		driver.findElement(By.xpath(".//*[@id='cap_result']")).sendKeys(resultAsString);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='cap_submit_btn']")).click();
		System.out.println("Submit Button clicked successfully");
		System.out.println(" Title is : " + driver.getTitle());
		driver.switchTo().window(tabs.get(0));
		System.out.println(" Title is : " + driver.getTitle());
		System.out.println("Came to original Tab");
		driver.navigate().refresh();
		System.out.println("Main tab is being refreshed");
		Thread.sleep(5000);
		
		//140,156
	}

	public static void main(String[] args) throws Exception {
		MySeleniumAssignment_OLD m = new MySeleniumAssignment_OLD();
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		// m.spicejet();
		// m.yatra();
		// m.color();
		// m.Hdfc();
		// m.Excelsheet
		// m.TableFields();
		// m.Rediff();
		// m.GoogleLink();
		// m.HDFCCard();
		// m.Radiobutton();
		m.Addmax();
	}

}
