package pageobjects;

import absCom.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "card")
    List<WebElement> products;

    By productsBy = By.className("card");
    By addToCart = By.cssSelector(".card button:nth-of-type(2)");
    By pageEle = By.partialLinkText("Automation Practice");

    public List<WebElement> getProductList(){
        waitForElementToAppear(productsBy);
        return products;
    }

    public WebElement getProductName(String prodName){
        WebElement product = getProductList().stream().filter(productTitle->productTitle
                .findElement(By.tagName("h5")).getText().equalsIgnoreCase(prodName))
                .findFirst().orElse(null);
        return product;
    }

    public void addToCart(String prodName){
        waitForElementToAppear(pageEle);
        WebElement prod = getProductName(prodName);
        prod.findElement(addToCart).click();
        System.out.println("Added to Cart");

    }
}
