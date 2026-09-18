package AssessmentDay10;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomLoginpage {
	WebDriver driver;
    public pomLoginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    public void getUser(String value) {
        username.sendKeys(value);
    }
    public void getPass(String value) {
        password.sendKeys(value);
    }
    public void getLoginBtn() {
        loginBtn.click();
    }
		
		
}
