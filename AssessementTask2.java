package assessments;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TestCase-2
//1.Navigate to myntra application
//2.Search for any product
//3.Add the product to the wishlist
//4.Verify whether it is added or not
public class AssessementTask2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		WebElement ref = driver.findElement(By.className("desktop-searchBar"));
		Thread.sleep(2000);
		ref.sendKeys("shoes",Keys.ENTER);
		WebElement ref1 = driver.findElement(By.xpath("(//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']) [1]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",ref1);
		Thread.sleep(4000);
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		if(url.equals("https://www.myntra.com/login?referer=https://www.myntra.com/shoes?rawQuery=shoes")) {
			System.out.println("product added wishlist");
		}else {
			System.out.println("product isnot added");
		}
	}

}
