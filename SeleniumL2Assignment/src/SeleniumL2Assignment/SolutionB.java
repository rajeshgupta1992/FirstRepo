package SeleniumL2Assignment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class SolutionB {

	WebDriver driver;

	public void login(String username, String pass) throws Exception {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.get("http://automationpractice.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("URL Opened sucessfully");

		
		//clicking on login button
		driver.findElement(By.className("login")).click();
		//providing username and paasword
		WebElement login = driver.findElement(By.id("email"));
		login.sendKeys(username);
		
		WebElement password = driver.findElement(By.id("passwd"));
		password.sendKeys(pass); 
		
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		System.out.println("Login sucessfully");
		
	}

	public void selectCategory(String cat) throws Exception {
		String catXpath = "";
		System.out.println("Selected Category is : " + cat);
		if(cat.equalsIgnoreCase("women"))		{
			catXpath = "//a[@title='Women']";
		}
		else if(cat.contains("dress"))		{
			catXpath = "//a[@title='Dresses']";
		}
		else		{
			catXpath = "//a[@title='T-shirts']";
		}
		
		//opening category
		WebElement category = driver.findElement(By.xpath(catXpath));
		category.click();
		
	}
	
	public void selectProduct(String product) throws Exception {
		String currentUrl = driver.getCurrentUrl();

		String productXpath = "//img[contains(@title,'" + product + "')]";
		
		System.out.println("Selected Product is  : " + product);
		
		//opening category
		WebElement productImg = driver.findElement(By.xpath(productXpath));
		productImg.click();
		
		//Adding to cart
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[@name='Submit']")).click();
		System.out.println("Product added to cart");
		driver.findElement(By.xpath("//span[@title='Continue shopping']")).click();

		Thread.sleep(2000);
		driver.get(currentUrl);
	
	}

	
	public void checkout() throws Exception {		
		WebElement shoppingCart = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
		shoppingCart.click();
		System.out.println("Shopping Cart checking");
		
		WebElement proceedCheckout = driver.findElement(By.xpath("//a[@title='Proceed to checkout' and @class='button btn btn-default standard-checkout button-medium']"));
		proceedCheckout.click();
		
		WebElement processAddress = driver.findElement(By.xpath("//button[@name='processAddress']"));
		processAddress.click();

	}
	
	//$x("//img[contains(@title,'Short')]")
	public static void main(String[] args) throws Exception {
		SolutionB obj = new SolutionB();
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		obj.login("nidhisharma4742@gmail.com","Temp@1234");
		obj.selectCategory("women");

		//Selecting product to add to Cart 
		obj.selectProduct("Short");
		obj.selectProduct("Blouse");
		//we can add multiple products to cart just by calling this method again with new value
		
		obj.checkout();
		
	}

}
