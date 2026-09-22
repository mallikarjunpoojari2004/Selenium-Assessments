package LastAssessment;
//task2
//1.Navigate to demoAppsQspiders slider page
//2.slide the bar till men cotton jacket and verify.

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoQspiderSlide {
	public static void main(String[] args) throws InterruptedException {
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		 WebElement ele=d.findElement(By.id("slide"));
	        Actions act=new Actions(d);
	        act.clickAndHold(ele).moveByOffset(200,0).release().perform();
	        Thread.sleep(2000);
	        WebElement jacket=d.findElement(By.xpath("//h3[contains(text(),'Mens Cotton Jacket')]"));
	        System.out.println("Product: "+jacket.getText());		
	}

}
