package AssessmentDay10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "first-name")
    public WebElement firstName;
    @FindBy(id = "last-name")
    public WebElement lastName;
    @FindBy(id = "postal-code")
    public WebElement zip;
    @FindBy(id = "continue")
    public WebElement continueBtn;
    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    public WebElement checkoutOverview;
    @FindBy(id = "finish")
    public WebElement finishBtn;
    @FindBy(className = "complete-header")
    public WebElement successMsg;

    public void getFirstName(String value){
        firstName.sendKeys(value);
    }
    public void getlastName(String value){
        lastName.sendKeys(value);
    }
    public void getZip(String value){
        zip.sendKeys(value);
    }
    public void getContinue(){
        continueBtn.click();
    }
    public boolean isCheckoutOverviewDisplayed(){
        return checkoutOverview.isDisplayed();
    }
    public void getFinish(){
        finishBtn.click();
    }
    public String getSuccessMessage(){
        return successMsg.getText();
    }

}
