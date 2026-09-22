package LastAssessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
1.Navigate to demoAppsQspiders draganddrop multiple page
2.drag and drop the accessories accordingly.
3.Click on Place order button.
4.Verify that order is placed.*/

public class DemoQspiderDragandDrop {
	 public static void main(String[] args) throws InterruptedException {
       WebDriver d=new ChromeDriver();
       d.manage().window().maximize();
       d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       d.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");

       WebElement laptopCharger = d.findElement(By.id("dragElement1"));
       WebElement mobileCover = d.findElement(By.id("dragElement2"));
       WebElement laptopCover = d.findElement(By.id("dragElement3"));
       WebElement mobileCharger = d.findElement(By.id("dragElement4"));

       WebElement mobileAccessories = d.findElement(By.id("dropZone1"));
       WebElement laptopAccessories = d.findElement(By.id("dropZone2"));

       Actions actions=new Actions(d);
       // Mobile Cover, Mobile Charger -> Mobile Accessories
       actions.keyDown(Keys.CONTROL).click(mobileCover).click(mobileCharger).keyUp(Keys.CONTROL).perform();
       Thread.sleep(2000);
       // draging to Mobile Accessories
       actions.clickAndHold(mobileCover).moveToElement(mobileAccessories).release().perform();
       Thread.sleep(2000);

       // Mobile Cover, Mobile Charger -> Mobile Accessories
       actions.keyDown(Keys.CONTROL).click(laptopCover).click(laptopCharger).keyUp(Keys.CONTROL).perform();
       Thread.sleep(2000);

       // draging to Mobile Accessories
       actions.clickAndHold(laptopCover).moveToElement(laptopAccessories).release().perform();
       Thread.sleep(2000);
       
       d.quit();
     
	 }
	

}
