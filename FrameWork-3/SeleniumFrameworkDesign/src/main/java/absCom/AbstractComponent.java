package absCom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.CartPage;
import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    public AbstractComponent(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@routerlink=\"/dashboard/cart\"]")
    WebElement cartPage;

    By overlaySpinner = By.className("ngx-spinner-overlay");
    By cartPageEle = By.xpath("//button[@routerlink=\"/dashboard/cart\"]");

    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public CartPage goToCartPage(){
        waitForElementToInvisible(overlaySpinner);
        waitForElementToAppear(cartPageEle);
        cartPage.click();
        System.out.println("Cart Page Clicked");
        waitForElementToInvisible(overlaySpinner);
        return new CartPage(driver);
    }

    public void waitForElementToInvisible(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

    public void waitForElementToClickable(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement toClick = wait.until(ExpectedConditions.elementToBeClickable(findBy));
        toClick.click();
    }
}
