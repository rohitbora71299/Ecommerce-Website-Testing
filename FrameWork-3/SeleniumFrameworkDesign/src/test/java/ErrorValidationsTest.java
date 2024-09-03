import TestComponents.BaseTest;
import org.junit.Assert;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.ProductCatalogue;
import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {
    @Test
    public void submitOrder() throws InterruptedException, IOException {
        String email = "unknown@gmail.com", password = "@123";
        landingPage.loginApplication(email,password);
        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
    }

    @Test
    public void productErrorValidation(){
        String prodName2 = "Zara";
        ProductCatalogue prodCat = landingPage.loginApplication(email,password);
        prodCat.addToCart(prodName);
        CartPage cartPage = prodCat.goToCartPage();
        boolean match = cartPage.verifyProductDisplay(prodName2);
        Assert.assertFalse(match);
    }
}
