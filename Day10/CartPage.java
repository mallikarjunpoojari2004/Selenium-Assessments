package AssessmentDay10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	 WebDriver driver;
	    public CartPage(WebDriver driver) {
	        this.driver=driver;
	        PageFactory.initElements(driver,this);
	    }
	    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	    public WebElement backPackName;
	    @FindBy(id = "checkout")
	    public WebElement checkout;

	    public boolean isBackpackDisplayed(){
	        return backPackName.isDisplayed();
	    }
	    public void getCheckOut(){
	        checkout.click();
	    }

}
