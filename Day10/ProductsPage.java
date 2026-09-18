package AssessmentDay10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    WebDriver driver;
    public ProductsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Products']")
    public WebElement prodTitle;
   @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpack;
    @FindBy(className = "shopping_cart_link")
    public WebElement cartCount;
   @FindBy(className = "shopping_cart_link")
   public WebElement cartButton;

   public boolean isProdDisplayed(){
       return prodTitle.isDisplayed();
   }
   public void addBackPack(){
       backpack.click();
   }
   public String getCartCount(){
       return cartCount.getText(); //prints 1 bcz 1 item added
   }
   public void getCartBtn(){
       cartButton.click();
   }
}
