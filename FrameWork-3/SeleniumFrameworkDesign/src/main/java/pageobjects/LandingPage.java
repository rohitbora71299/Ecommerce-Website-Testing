package pageobjects;
import absCom.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // PageFactory
    @FindBy(id = "userEmail")
    WebElement email;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    By errorMsgEle = By.cssSelector("[class*='flyInOut']");

    public ProductCatalogue loginApplication(String userEmail,String userPassword){
        email.sendKeys(userEmail);
        password.sendKeys(userPassword);
        submit.click();
        return new ProductCatalogue(driver);
    }

    public String getErrorMessage(){
        waitForElementToAppear(errorMsgEle);
        return errorMessage.getText();
    }

    public void goTo() {
        String url = "https://rahulshettyacademy.com/client";
        driver.get(url);
    }
}
