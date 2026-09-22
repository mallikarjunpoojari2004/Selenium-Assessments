package LastAssessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//1.Navigate to demoAppsQspiders toggle page
//2.Click on disbaled toggle buttons
//3.Click on Place order button.
//4.Verify that order is placed.
public class DemoQspidertoggle {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		Thread.sleep(2000);
		List<WebElement> toggles=driver.findElements(By.xpath("//input[@type='checkbox']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        for(WebElement toggle:toggles){
            js.executeScript("arguments[0].removeAttribute('disabled');",toggle); //the ele is disabled, so remove that disable attribute
            js.executeScript("arguments[0].click();",toggle);
            Thread.sleep(2000);
        }
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(2000);
        if(driver.findElement(By.xpath("//p[text()='Your Order has been successfully placed!']")).isDisplayed())
        {
            System.out.println("Order is placed");
        }
        else {
            System.out.println("orderis Not placed!");
        }
       // driver.quit();
	}
}
