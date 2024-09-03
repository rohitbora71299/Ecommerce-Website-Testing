package pageobjects;

import absCom.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponent {
    WebDriver driver;
    public ConfirmationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="hero-primary")
    WebElement actualMsg;

    By msgEle = By.className("hero-primary");

    public String getConfirmationPage(){
        waitForElementToAppear(msgEle);
        return actualMsg.getText().strip();
    }
}
