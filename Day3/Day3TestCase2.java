package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3TestCase2 {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		 //click on calender
		driver.findElement(By.cssSelector("[type='text']")).click(); 
		//For selecting next month
		driver.findElement(By.cssSelector("[aria-label='Next Month']")).click(); 
		//For selecting date
		driver.findElement(By.cssSelector("[aria-label='Choose Friday, October 2nd, 2026']")).click(); 
		WebElement result=  driver.findElement(By.cssSelector("[type='text']"));  
		result.getDomAttribute("value");
		if(result.getDomAttribute("value").contains("02/10/2026")) {
			System.out.println("Date is displayed Correctly");
			
		}else {
			System.out.println("Date is not displayed Correctly");
		}

	}

}
