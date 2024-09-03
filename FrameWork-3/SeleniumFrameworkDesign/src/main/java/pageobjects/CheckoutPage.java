package pageobjects;

import absCom.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    By countryInput = By.cssSelector(".form-group input");
    By dropDownEle = By.className("ta-results");
    By selectCountryEle = By.cssSelector(".ta-results button:nth-of-type(2)");
    By submitEle = By.className("action__submit");

    public ConfirmationPage selectCountry(String country) throws InterruptedException {
        driver.findElement(countryInput).sendKeys(country);
        waitForElementToAppear(dropDownEle);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        waitForElementToClickable(selectCountryEle);
        System.out.println("Country Selected");
        waitForElementToClickable(submitEle);
        System.out.println("Placed Order");
        return new ConfirmationPage(driver);
    }
}