package LastAssessmentTask2;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzPage {
    WebDriver driver;
    public BuzzPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Buzz']")
    public WebElement buzz;
    @FindBy(xpath="//textarea[@placeholder=\"What's on your mind?\"]")
    public WebElement mindText;
    @FindBy(xpath = "//button[normalize-space()='Post']")
    public WebElement post;

    public void getBuzz(){
        buzz.click();
    }
    public void getMindText(String value){
        mindText.sendKeys(value);
    }
    public void getPost(){
        post.click();
    }
    //Don't hardcode Hello World! in the locator. Use a dynamic By inside the method:
    public boolean verifyRecentPost(String value){
        WebElement recentPost=driver.findElement(By.xpath("//p[normalize-space()='"+value+"']"));
        return recentPost.isDisplayed();
    }
}