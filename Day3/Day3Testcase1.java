//1.Navigate EaseMyTrip and handle the notification popup.  
//2.Select One Way.
//3.Enter any state  in the From field and select a valid suggestion.
//4.Enter another state  in the To field and select a valid suggestion.
//5.Click the Departure Date field.
//6.Select any available future date from the calendar.
//7.Click Traveller & Class.
//8.Select 2 Adults and keep the class as Economy.
//9.Click Search.
//10.Verify that the flight-results page is displayed.

package assessments;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day3Testcase1 {

	public static void main(String[] args) throws InterruptedException {
		// Create an object of ChromeOptions
		ChromeOptions option = new ChromeOptions();

		// Disable browser notification pop-ups
		option.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(option);

		// Maximize the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.easemytrip.com/");
		Thread.sleep(2000);

		
		driver.findElement(By.id("oway")).click();
		// Find the From Sector element and store it 
		WebElement state = driver.findElement(By.id("FromSector_show"));
		state.click();

		// dropdown
		driver.findElement(By.id("spn2")).click();
		Thread.sleep(2000);

		// Locate the element with id "ptt"
		// NOTE: This line only finds the element. 
		driver.findElement(By.id("ptt"));
		// Enter "kolkata" in the airport/city input field
		driver.findElement(By.id("a_Editbox13_show")).sendKeys("kolkata");
		// Click on Kolkata 
		driver.findElement(By.id("spnKolkata")).click();
		Thread.sleep(2000);

		// Locate the date field
		// NOTE: This line only finds the element. 
		driver.findElement(By.id("ddate"));
		driver.findElement(By.id("trd_6_19/09/2026")).click();
		Thread.sleep(2000);
		// Click on the Traveller field
		driver.findElement(By.id("spnTraveller")).click();
		driver.findElement(By.id("add")).click();
		driver.findElement(By.cssSelector("[value='Search']")).click();
		String result = driver.getTitle();

		// Check whether the page title contains the expected text
		if (result.contains("EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com")) {

		    // Print this message if the expected title is found
		    System.out.println("flight result is displayrd");

		}
		else {

		    // Print this message if the expected title is not found
		    System.out.println("flight result is not displayed");

		}


	}

}
