
//Testcase: 
//1.Navigate to the facebook application.
//2.Click on create new account button.
//3.Verify that fistname and surname textfields are aligned in same line or not.
package assessments;

import java.time.Duration; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_AssessmentTestcase1 {
	public static void main(String[] args) {
		WebDriver  d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		d.get("https://www.facebook.com/");
		d.findElement(By.xpath("//span[text()='Create new account']")).click();
		
		WebElement Fname = d.findElement(By.id("_R_1cl2p4jikacppb6amH1_"));
		WebElement Surname = d.findElement(By.id("_R_1kl2p4jikacppb6amH1_"));
		int fLoc=Fname.getLocation().getY();
		int surnameLoc=Surname.getLocation().getY();
		if(fLoc==surnameLoc)
			System.out.println("Both are aligned in same line");
		else
			System.out.println("Not");	
	}
}
