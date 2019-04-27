//Running the automation on PhantomJS Browser

package SeleniumL2Assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class MySeleniumAssignment4 {

	@Test
	public void Addmax() throws Exception {

		/*
		 * File src = new File("C:\\chromedriver\\phantomjs.exe");
		 * System.setProperty("phantomjs.binary.path", src.getAbsolutePath()); WebDriver
		 * driver = new PhantomJSDriver();
		 */

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"C:\\chromedriver\\phantomjs.exe");
		WebDriver driver = new PhantomJSDriver(capabilities);
		// HtmlUnitDriver driver = new HtmlUnitDriver();

		driver.manage().window().maximize();
		driver.get("http://addmaxpromoters.com/circle8/login");
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");

		try {
			Thread.sleep(2000);
			String username = "456129"; // "" 456129
			WebElement login = driver.findElement(By.id("login"));
			login.click();
			login.clear();
			login.sendKeys(username);
			WebElement password = driver.findElement(By.id("password"));
			password.click();
			password.sendKeys("642531"); // "" 642531

			driver.findElement(By.xpath(".//*[@id='formContent']/form/input[4]")).click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Click Advertise')]")).click();
			Thread.sleep(2000);

			// Searching Click Here Link
			WebElement linkTable = driver
					.findElement(By.xpath("//table[@class='table table-striped table-bordered table-hover']"));

			int rowCount = linkTable.findElements(By.tagName("tr")).size();
			System.out.println("Row Count is : " + rowCount);

			for (int i = 1; i < rowCount; i++) {

				System.out.println("Table Row No : " + i);

				String cellPath = "//table[@class='table table-striped table-bordered table-hover']/tbody/tr[" + i
						+ "]/td[3]";

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
		} catch (Exception e) {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("C:\\chromedriver\\SS\\test.png");
			FileUtils.copyFile(SrcFile, DestFile);
		}
	}

	public void clickAdd(WebDriver driver) throws Exception {
		System.out.println("Now came into Click here link");
		Thread.sleep(2000);
		try {
			System.out.println(" Title is : " + driver.getTitle());

			Set<String> allWindows = driver.getWindowHandles();
			// System.out.println("We are in new tab1");
			ArrayList<String> tabs = new ArrayList<>(allWindows);
			driver.switchTo().window(tabs.get(1));
			System.out.println(" Title is : " + driver.getTitle());
			for (int i = 0; i < 24; i++) {
				if (driver.findElements(By.xpath(".//*[@id='prnato_reload_page']")).size() > 0) {
					i = 0;
				}
				Thread.sleep(1000);
			}
			// Thread.sleep(24000);
			System.out.println("Waited for enough seconds");
			// prnato_reload_page
			// Getting input values
			String num1 = driver.findElement(By.xpath(".//*[@id='cap_number_1']")).getAttribute("value");
			System.out.println("Number 1 : " + num1);
			String num2 = driver.findElement(By.xpath(".//*[@id='cap_number_2']")).getAttribute("value");
			System.out.println("Number 2 : " + num2);
			Integer result = Integer.parseInt(num1) + Integer.parseInt(num2);
			System.out.println("Result : " + result);
			// @SuppressWarnings("deprecation")
			// String resultAsString = new Integer(result).toString();
			String resultAsString = result.toString();
			System.out.println("Result resultAsString : " + resultAsString);
			driver.findElement(By.xpath(".//*[@id='cap_result']")).sendKeys(resultAsString);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='cap_submit_btn']")).click();
			System.out.println("Submit Button clicked successfully");
			System.out.println(" Title is : " + driver.getTitle());
			driver.switchTo().window(tabs.get(0));
			// System.out.println("Title is : " + driver.getTitle());
			System.out.println("Came to original Tab");
			driver.navigate().refresh();
			System.out.println("Main tab is being refreshed");
			Thread.sleep(5000);
		} catch (Exception e) {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("C:\\chromedriver\\SS\\test.png");
			FileUtils.copyFile(SrcFile, DestFile);
		}
		// 140,156
	}

}
