package assessments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

//1.Launch SauceDemo.
//2.Login using the valid credentials provided on the application.
//3.On the Products page, use JavaScript Executor to scroll to the bottom of the page.
//4. Take a screenshot of the page after scrolling.
//5.Save the screenshot with a meaningful name such as products-page.png.
public class Assessment1 {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
		WebElement name = driver.findElement(By.id("user-name"));
		name.sendKeys("standard_user");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("secret_sauce");
		WebElement logbtn = driver.findElement(By.id("login-button"));
		logbtn.click();
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,500)");
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File src = screenShot.getScreenshotAs(OutputType.FILE);
		//File dest=new File("C:\\Users\\HP\\eclipse-workspace\\Basic_Selenium\\photos\\products-page.png");
		File dest = new File("./images/products-page.png");
		FileHandler.copy(src, dest);		
	}

}
