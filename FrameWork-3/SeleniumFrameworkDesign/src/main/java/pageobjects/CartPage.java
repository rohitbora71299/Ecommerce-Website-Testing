package pageobjects;

import absCom.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".cartSection button:nth-of-type(1)")
    WebElement checkout;

    @FindBy(css = ".cartWrap h3")
    List<WebElement> prodInCart;

    By checkoutEle = By.cssSelector(".cartSection button:nth-of-type(1)");

    public boolean verifyProductDisplay(String prodName){
        boolean match = prodInCart.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(prodName));
        return match;
    }

    public CheckoutPage goToCheckout(){
        waitForElementToAppear(checkoutEle);
        checkout.click();
        System.out.println("CheckOut Done");
        return new CheckoutPage(driver);
    }

}
